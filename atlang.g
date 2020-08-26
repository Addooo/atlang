grammar atlang;

options {
  language = Java;
  k = 1;
}

@header{
  //code inside parser class
  package compilerPackage;

  import compilerPackage.util.*;
  import java.util.Hashtable;
}

@lexer::header{
 //code outside lexer class
  package compilerPackage;
}

@members {
  //Code inside Parser class
  ParserHandler handler;
  Hashtable<String, ArrayList<String>> ht;

  void init () {
    handler = new ParserHandler ();
    ht = new Hashtable<String, ArrayList<String>>();
  }
  
  public String getRules () {
    return handler.Rules.toString();
  }
	
 public String getReadableRules(){
	return handler.readablePrint();
 }

 public String getFinalStates(){
	return handler.sf.toString();
 }
 
  public ArrayList<String> getErrors () {
    return handler.errorList;
  }

  public String getPy(){
 	return handler.printPy;
 }
 
  public void displayRecognitionError(String[] tokenNames,
                                       RecognitionException e) {
		String hdr = " * " + getErrorHeader(e);
		String msg = " - " + getErrorMessage(e, tokenNames);
		  
		Token tk = input.LT(1);
		handler.handleError(tokenNames, e, hdr, msg);
  } 

  public void verificaStatoSim(Token state, Token sym_read){

	 System.out.println("Evaluating state-" + state.getText() + "-" + sym_read.getText());
	 try{	
		 System.out.println(ht.containsKey(state.getText().toString()) + " " + ht.get(state.getText()).contains(sym_read.getText()));
		 System.out.println("VALUE HASHTABLE: " + ht.toString());
	}
	catch(Exception e){
//		System.out.println(e.toString());
	}
	 if(ht.containsKey(state.getText()) && ht.get(state.getText()).contains(sym_read.getText())){
//	 	handler.errorList.add("NOT DETERMINISTIC");
		handler.semError(state, 1);
//		System.out.println("Error found");
	}
    	 else
    	 {
		if(!ht.containsKey(state.getText())){
//			System.out.println("Fist time state");
			ArrayList<String> app = new ArrayList<String>();
			app.add(sym_read.getText());
			ht.put(state.getText(), app);
    		  }
    		  else{
//			System.out.println("Not first time state");
			ht.get(state.getText()).add(sym_read.getText());
		}
    			     		  
    	  }
    }	

   public void evaluateFin(Token state_fin, Token newstate){
//	System.out.println("ADDING FINAL STATE");
	try{
		if(state_fin.getText().equals("sF") && !handler.sf.contains("'" + newstate.getText() + "'" )){
			handler.sf.add("'" + newstate.getText() + "'");
			System.out.println("STATO FINALE " + newstate.getText());
		}
	}
	catch(Exception e){
		//System.out.println("È null pointer exc ecc.");
	}

   }


   public void evaluateStateInit(Token in){

	if(!ht.containsKey("s0")){
//		handler.errorList.add("NO INITIAL STATE");
		handler.semError(in, 2);
	}

   }

   public void evaluateStateFin(Token in){

	if(handler.sf.isEmpty()){
//		handler.errorList.add("NO FINAL STATE");
		handler.semError(in, 3);
	}

   }

}

/*
	This will be the entry point of our parser
*/

start
@init { init (); }
    :	in=BEGIN 
	NEWLINE
	(rule)+
	{
		evaluateStateInit($in); // control if exist s0
		evaluateStateFin($in); // 	control if exist at least one final State
	}
	(tape)+		
	compute
    	END NEWLINE*
     ;

     

rule : 	stato=(STATE | STATE_INIZ) SEPARATOR
	sym_read=SYMBOL { verificaStatoSim(stato, sym_read); }
	SEPARATOR
	mov=MOVEMENT SEPARATOR
	newstate=(STATE | STATE_INIZ) SEPARATOR
	sym_write=SYMBOL
	{
		handler.evaluateRule($stato, $sym_read, $mov, $newstate, $sym_write);	
	} 
	(SEPARATOR state_fin=IS_FINAL
	{
        	evaluateFin($state_fin, $newstate);
        }
	)?
	NEWLINE	
	;

tape: 
      TAPE
      QUAD_I
      symbolStart=SYMBOL
	{
		handler.evaluateSym($symbolStart);	
	} 
      (
      SEPARATOR
      symbol=SYMBOL 
      {
   		handler.evaluateSym($symbol);	
       }                                      	
       )*     
      QUAD_O
      NEWLINE
      {
	handler.evaluateTape();
      }
      ;

compute: COMP NEWLINE
	{
		handler.compute();
	};

STATE : 's' ('1'..'9') ('0'..'9')* ;

STATE_INIZ : 's0' ;

MOVEMENT : '<' | '>' | '=' ;

SYMBOL : ('0'..'9')+ | '!' ;

NEWLINE : '\n' ;

SEPARATOR : ',';

BEGIN : 'begin';

END : 'end';

WS  :  ( ' ' | '\t') {skip(); } ;

QUAD_I : '[' ;

QUAD_O : ']' ;

IS_FINAL : 'sF' ; 

COMP : 'computation' ;

TAPE : 'tape' ;
