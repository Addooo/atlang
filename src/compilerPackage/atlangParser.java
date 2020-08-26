// $ANTLR 3.4 atlang.g 2020-08-25 08:54:08

  //code inside parser class
  package compilerPackage;

  import compilerPackage.util.*;
  import java.util.Hashtable;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class atlangParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BEGIN", "COMP", "END", "IS_FINAL", "MOVEMENT", "NEWLINE", "QUAD_I", "QUAD_O", "SEPARATOR", "STATE", "STATE_INIZ", "SYMBOL", "TAPE", "WS"
    };

    public static final int EOF=-1;
    public static final int BEGIN=4;
    public static final int COMP=5;
    public static final int END=6;
    public static final int IS_FINAL=7;
    public static final int MOVEMENT=8;
    public static final int NEWLINE=9;
    public static final int QUAD_I=10;
    public static final int QUAD_O=11;
    public static final int SEPARATOR=12;
    public static final int STATE=13;
    public static final int STATE_INIZ=14;
    public static final int SYMBOL=15;
    public static final int TAPE=16;
    public static final int WS=17;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public atlangParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public atlangParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return atlangParser.tokenNames; }
    public String getGrammarFileName() { return "atlang.g"; }


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




    // $ANTLR start "start"
    // atlang.g:130:1: start : in= BEGIN NEWLINE ( rule )+ ( tape )+ compute END ( NEWLINE )* ;
    public final void start() throws RecognitionException {
        Token in=null;

         init (); 
        try {
            // atlang.g:132:5: (in= BEGIN NEWLINE ( rule )+ ( tape )+ compute END ( NEWLINE )* )
            // atlang.g:132:7: in= BEGIN NEWLINE ( rule )+ ( tape )+ compute END ( NEWLINE )*
            {
            in=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_start66); 

            match(input,NEWLINE,FOLLOW_NEWLINE_in_start70); 

            // atlang.g:134:2: ( rule )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= STATE && LA1_0 <= STATE_INIZ)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // atlang.g:134:3: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_start74);
            	    rule();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);



            		evaluateStateInit(in); // control if exist s0
            		evaluateStateFin(in); // 	control if exist at least one final State
            	

            // atlang.g:139:2: ( tape )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==TAPE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // atlang.g:139:3: tape
            	    {
            	    pushFollow(FOLLOW_tape_in_start83);
            	    tape();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            pushFollow(FOLLOW_compute_in_start90);
            compute();

            state._fsp--;


            match(input,END,FOLLOW_END_in_start97); 

            // atlang.g:141:10: ( NEWLINE )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==NEWLINE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // atlang.g:141:10: NEWLINE
            	    {
            	    match(input,NEWLINE,FOLLOW_NEWLINE_in_start99); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "start"



    // $ANTLR start "rule"
    // atlang.g:146:1: rule : stato= ( STATE | STATE_INIZ ) SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= ( STATE | STATE_INIZ ) SEPARATOR sym_write= SYMBOL ( SEPARATOR state_fin= IS_FINAL )? NEWLINE ;
    public final void rule() throws RecognitionException {
        Token stato=null;
        Token sym_read=null;
        Token mov=null;
        Token newstate=null;
        Token sym_write=null;
        Token state_fin=null;

        try {
            // atlang.g:146:6: (stato= ( STATE | STATE_INIZ ) SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= ( STATE | STATE_INIZ ) SEPARATOR sym_write= SYMBOL ( SEPARATOR state_fin= IS_FINAL )? NEWLINE )
            // atlang.g:146:9: stato= ( STATE | STATE_INIZ ) SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= ( STATE | STATE_INIZ ) SEPARATOR sym_write= SYMBOL ( SEPARATOR state_fin= IS_FINAL )? NEWLINE
            {
            stato=(Token)input.LT(1);

            if ( (input.LA(1) >= STATE && input.LA(1) <= STATE_INIZ) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule132); 

            sym_read=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_rule137); 

             verificaStatoSim(stato, sym_read); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule142); 

            mov=(Token)match(input,MOVEMENT,FOLLOW_MOVEMENT_in_rule147); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule149); 

            newstate=(Token)input.LT(1);

            if ( (input.LA(1) >= STATE && input.LA(1) <= STATE_INIZ) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule162); 

            sym_write=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_rule167); 


            		handler.evaluateRule(stato, sym_read, mov, newstate, sym_write);	
            	

            // atlang.g:155:2: ( SEPARATOR state_fin= IS_FINAL )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==SEPARATOR) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // atlang.g:155:3: SEPARATOR state_fin= IS_FINAL
                    {
                    match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule175); 

                    state_fin=(Token)match(input,IS_FINAL,FOLLOW_IS_FINAL_in_rule179); 


                            	evaluateFin(state_fin, newstate);
                            

                    }
                    break;

            }


            match(input,NEWLINE,FOLLOW_NEWLINE_in_rule189); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "rule"



    // $ANTLR start "tape"
    // atlang.g:163:1: tape : TAPE QUAD_I symbolStart= SYMBOL ( SEPARATOR symbol= SYMBOL )* QUAD_O NEWLINE ;
    public final void tape() throws RecognitionException {
        Token symbolStart=null;
        Token symbol=null;

        try {
            // atlang.g:163:5: ( TAPE QUAD_I symbolStart= SYMBOL ( SEPARATOR symbol= SYMBOL )* QUAD_O NEWLINE )
            // atlang.g:164:7: TAPE QUAD_I symbolStart= SYMBOL ( SEPARATOR symbol= SYMBOL )* QUAD_O NEWLINE
            {
            match(input,TAPE,FOLLOW_TAPE_in_tape206); 

            match(input,QUAD_I,FOLLOW_QUAD_I_in_tape214); 

            symbolStart=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_tape224); 


            		handler.evaluateSym(symbolStart);	
            	

            // atlang.g:170:7: ( SEPARATOR symbol= SYMBOL )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==SEPARATOR) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // atlang.g:171:7: SEPARATOR symbol= SYMBOL
            	    {
            	    match(input,SEPARATOR,FOLLOW_SEPARATOR_in_tape244); 

            	    symbol=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_tape254); 


            	       		handler.evaluateSym(symbol);	
            	           

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match(input,QUAD_O,FOLLOW_QUAD_O_in_tape325); 

            match(input,NEWLINE,FOLLOW_NEWLINE_in_tape333); 


            	handler.evaluateTape();
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "tape"



    // $ANTLR start "compute"
    // atlang.g:184:1: compute : COMP NEWLINE ;
    public final void compute() throws RecognitionException {
        try {
            // atlang.g:184:8: ( COMP NEWLINE )
            // atlang.g:184:10: COMP NEWLINE
            {
            match(input,COMP,FOLLOW_COMP_in_compute355); 

            match(input,NEWLINE,FOLLOW_NEWLINE_in_compute357); 


            		handler.compute();
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "compute"

    // Delegated rules


 

    public static final BitSet FOLLOW_BEGIN_in_start66 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_start70 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule_in_start74 = new BitSet(new long[]{0x0000000000016000L});
    public static final BitSet FOLLOW_tape_in_start83 = new BitSet(new long[]{0x0000000000010020L});
    public static final BitSet FOLLOW_compute_in_start90 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_END_in_start97 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_NEWLINE_in_start99 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_set_in_rule124 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule132 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SYMBOL_in_rule137 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule142 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_MOVEMENT_in_rule147 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule149 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_set_in_rule154 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule162 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SYMBOL_in_rule167 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule175 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_IS_FINAL_in_rule179 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_rule189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAPE_in_tape206 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_QUAD_I_in_tape214 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SYMBOL_in_tape224 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_SEPARATOR_in_tape244 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SYMBOL_in_tape254 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_QUAD_O_in_tape325 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_tape333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMP_in_compute355 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_compute357 = new BitSet(new long[]{0x0000000000000002L});

}