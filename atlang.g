grammar atlang;

options {
  language = Java;
 // k = 1;
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
 
 
  public ArrayList<String> getErrors () {
    return handler.errorList;
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
		System.out.println(e.toString());
	}
	 if(ht.containsKey(state.getText()) && ht.get(state.getText()).contains(sym_read.getText())){
	 	handler.errorList.add("non determinismo");
		System.out.println("Error found");
	}
    	 else
    	 {
		if(!ht.containsKey(state.getText())){
			System.out.println("Fist time state");
			ArrayList<String> app = new ArrayList<String>();
			app.add(sym_read.getText());
			ht.put(state.getText(), app);
    		  }
    		  else{
			System.out.println("Not first time state");
			ht.get(state.getText()).add(sym_read.getText());
		}
    			     		  
    	  }
    }	

}

/*
	This will be the entry point of our parser
*/

start
@init { init (); }
    :	BEGIN NEWLINE 
    	file=FILE { handler.evaluateFile($file); }
	//deve sempre iniziare con una regola con lo stato iniziale
	//per obbligare ad avere uno stato iniziale
	NEWLINE rule_z 
	( rule_z | rule)*
	//deve sempre finire con una regola con lo stato finale
	//per obbligare ad avere uno stato finale
	(rule_f)+
    	END NEWLINE*
     ;


rule_z: stato=STATE_INIZ SEPARATOR
        sym_read=SYMBOL { verificaStatoSim(stato, sym_read); }
        SEPARATOR
        mov=MOVEMENT SEPARATOR
        newstate=STATE SEPARATOR
        sym_write=SYMBOL
        {
        	handler.evaluateRule($stato, $sym_read, $mov, $newstate, $sym_write);	
        } 
	NEWLINE
	;
        

rule : 	stato=STATE SEPARATOR
	sym_read=SYMBOL { verificaStatoSim(stato, sym_read); }
	SEPARATOR
	mov=MOVEMENT SEPARATOR
	newstate=STATE SEPARATOR
	sym_write=SYMBOL
	{
		handler.evaluateRule($stato, $sym_read, $mov, $newstate, $sym_write);	
	} 
	NEWLINE
	;

rule_f : stato=( STATE | STATE_INIZ) SEPARATOR
	 sym_read=SYMBOL { verificaStatoSim(stato, sym_read); }
	 SEPARATOR
	 mov=MOVEMENT SEPARATOR
	 newstate=STATE_FIN SEPARATOR
	 sym_write=SYMBOL
	 {
 		handler.evaluateRule($stato, $sym_read, $mov, $newstate, $sym_write);	
 	} 
	NEWLINE
	;


STATE : 's' ('1'..'9') ('0'..'9')* ;

STATE_INIZ : 's0' ;

STATE_FIN : 'sF' ;

MOVEMENT : '<' | '>' | '=' ;

SYMBOL : ('0'..'9')+ | '!' ;

NEWLINE : '\n' ;

FILE : ('a'..'z'|'A'..'Z'|'0'..'9'|'_')+ '.t';

SEPARATOR : ',';

BEGIN : 'begin';

END : 'end';

WS  :  ( ' ' | '\t') {skip(); } ;

