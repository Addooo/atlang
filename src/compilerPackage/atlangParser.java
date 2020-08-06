// $ANTLR 3.4 atlang.g 2020-08-06 17:00:04

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BEGIN", "END", "FILE", "MOVEMENT", "NEWLINE", "SEPARATOR", "STATE", "STATE_FIN", "STATE_INIZ", "SYMBOL", "WS"
    };

    public static final int EOF=-1;
    public static final int BEGIN=4;
    public static final int END=5;
    public static final int FILE=6;
    public static final int MOVEMENT=7;
    public static final int NEWLINE=8;
    public static final int SEPARATOR=9;
    public static final int STATE=10;
    public static final int STATE_FIN=11;
    public static final int STATE_INIZ=12;
    public static final int SYMBOL=13;
    public static final int WS=14;

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




    // $ANTLR start "start"
    // atlang.g:89:1: start : BEGIN NEWLINE file= FILE NEWLINE rule_z ( rule_z | rule )* ( rule_f )+ END ( NEWLINE )* ;
    public final void start() throws RecognitionException {
        Token file=null;

         init (); 
        try {
            // atlang.g:91:5: ( BEGIN NEWLINE file= FILE NEWLINE rule_z ( rule_z | rule )* ( rule_f )+ END ( NEWLINE )* )
            // atlang.g:91:7: BEGIN NEWLINE file= FILE NEWLINE rule_z ( rule_z | rule )* ( rule_f )+ END ( NEWLINE )*
            {
            match(input,BEGIN,FOLLOW_BEGIN_in_start57); 

            match(input,NEWLINE,FOLLOW_NEWLINE_in_start59); 

            file=(Token)match(input,FILE,FOLLOW_FILE_in_start69); 

             handler.evaluateFile(file); 

            match(input,NEWLINE,FOLLOW_NEWLINE_in_start78); 

            pushFollow(FOLLOW_rule_z_in_start80);
            rule_z();

            state._fsp--;


            // atlang.g:96:2: ( rule_z | rule )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==STATE_INIZ) ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==SEPARATOR) ) {
                        int LA1_3 = input.LA(3);

                        if ( (LA1_3==SYMBOL) ) {
                            int LA1_5 = input.LA(4);

                            if ( (LA1_5==SEPARATOR) ) {
                                int LA1_7 = input.LA(5);

                                if ( (LA1_7==MOVEMENT) ) {
                                    int LA1_9 = input.LA(6);

                                    if ( (LA1_9==SEPARATOR) ) {
                                        int LA1_11 = input.LA(7);

                                        if ( (LA1_11==STATE) ) {
                                            alt1=1;
                                        }


                                    }


                                }


                            }


                        }


                    }


                }
                else if ( (LA1_0==STATE) ) {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==SEPARATOR) ) {
                        int LA1_4 = input.LA(3);

                        if ( (LA1_4==SYMBOL) ) {
                            int LA1_6 = input.LA(4);

                            if ( (LA1_6==SEPARATOR) ) {
                                int LA1_8 = input.LA(5);

                                if ( (LA1_8==MOVEMENT) ) {
                                    int LA1_10 = input.LA(6);

                                    if ( (LA1_10==SEPARATOR) ) {
                                        int LA1_12 = input.LA(7);

                                        if ( (LA1_12==STATE) ) {
                                            alt1=2;
                                        }


                                    }


                                }


                            }


                        }


                    }


                }


                switch (alt1) {
            	case 1 :
            	    // atlang.g:96:4: rule_z
            	    {
            	    pushFollow(FOLLOW_rule_z_in_start86);
            	    rule_z();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // atlang.g:96:13: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_start90);
            	    rule();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            // atlang.g:99:2: ( rule_f )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==STATE||LA2_0==STATE_INIZ) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // atlang.g:99:3: rule_f
            	    {
            	    pushFollow(FOLLOW_rule_f_in_start100);
            	    rule_f();

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


            match(input,END,FOLLOW_END_in_start109); 

            // atlang.g:100:10: ( NEWLINE )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==NEWLINE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // atlang.g:100:10: NEWLINE
            	    {
            	    match(input,NEWLINE,FOLLOW_NEWLINE_in_start111); 

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



    // $ANTLR start "rule_z"
    // atlang.g:104:1: rule_z : stato= STATE_INIZ SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= STATE SEPARATOR sym_write= SYMBOL NEWLINE ;
    public final void rule_z() throws RecognitionException {
        Token stato=null;
        Token sym_read=null;
        Token mov=null;
        Token newstate=null;
        Token sym_write=null;

        try {
            // atlang.g:104:7: (stato= STATE_INIZ SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= STATE SEPARATOR sym_write= SYMBOL NEWLINE )
            // atlang.g:104:9: stato= STATE_INIZ SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= STATE SEPARATOR sym_write= SYMBOL NEWLINE
            {
            stato=(Token)match(input,STATE_INIZ,FOLLOW_STATE_INIZ_in_rule_z128); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule_z130); 

            sym_read=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_rule_z142); 

             verificaStatoSim(stato, sym_read); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule_z154); 

            mov=(Token)match(input,MOVEMENT,FOLLOW_MOVEMENT_in_rule_z166); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule_z168); 

            newstate=(Token)match(input,STATE,FOLLOW_STATE_in_rule_z180); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule_z182); 

            sym_write=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_rule_z194); 


                    	handler.evaluateRule(stato, sym_read, mov, newstate, sym_write);	
                    

            match(input,NEWLINE,FOLLOW_NEWLINE_in_rule_z208); 

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
    // $ANTLR end "rule_z"



    // $ANTLR start "rule"
    // atlang.g:117:1: rule : stato= STATE SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= STATE SEPARATOR sym_write= SYMBOL NEWLINE ;
    public final void rule() throws RecognitionException {
        Token stato=null;
        Token sym_read=null;
        Token mov=null;
        Token newstate=null;
        Token sym_write=null;

        try {
            // atlang.g:117:6: (stato= STATE SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= STATE SEPARATOR sym_write= SYMBOL NEWLINE )
            // atlang.g:117:9: stato= STATE SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= STATE SEPARATOR sym_write= SYMBOL NEWLINE
            {
            stato=(Token)match(input,STATE,FOLLOW_STATE_in_rule230); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule232); 

            sym_read=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_rule237); 

             verificaStatoSim(stato, sym_read); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule242); 

            mov=(Token)match(input,MOVEMENT,FOLLOW_MOVEMENT_in_rule247); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule249); 

            newstate=(Token)match(input,STATE,FOLLOW_STATE_in_rule254); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule256); 

            sym_write=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_rule261); 


            		handler.evaluateRule(stato, sym_read, mov, newstate, sym_write);	
            	

            match(input,NEWLINE,FOLLOW_NEWLINE_in_rule268); 

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



    // $ANTLR start "rule_f"
    // atlang.g:129:1: rule_f : stato= ( STATE | STATE_INIZ ) SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= STATE_FIN SEPARATOR sym_write= SYMBOL NEWLINE ;
    public final void rule_f() throws RecognitionException {
        Token stato=null;
        Token sym_read=null;
        Token mov=null;
        Token newstate=null;
        Token sym_write=null;

        try {
            // atlang.g:129:8: (stato= ( STATE | STATE_INIZ ) SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= STATE_FIN SEPARATOR sym_write= SYMBOL NEWLINE )
            // atlang.g:129:10: stato= ( STATE | STATE_INIZ ) SEPARATOR sym_read= SYMBOL SEPARATOR mov= MOVEMENT SEPARATOR newstate= STATE_FIN SEPARATOR sym_write= SYMBOL NEWLINE
            {
            stato=(Token)input.LT(1);

            if ( input.LA(1)==STATE||input.LA(1)==STATE_INIZ ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule_f289); 

            sym_read=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_rule_f295); 

             verificaStatoSim(stato, sym_read); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule_f301); 

            mov=(Token)match(input,MOVEMENT,FOLLOW_MOVEMENT_in_rule_f307); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule_f309); 

            newstate=(Token)match(input,STATE_FIN,FOLLOW_STATE_FIN_in_rule_f315); 

            match(input,SEPARATOR,FOLLOW_SEPARATOR_in_rule_f317); 

            sym_write=(Token)match(input,SYMBOL,FOLLOW_SYMBOL_in_rule_f323); 


             		handler.evaluateRule(stato, sym_read, mov, newstate, sym_write);	
             	

            match(input,NEWLINE,FOLLOW_NEWLINE_in_rule_f331); 

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
    // $ANTLR end "rule_f"

    // Delegated rules


 

    public static final BitSet FOLLOW_BEGIN_in_start57 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NEWLINE_in_start59 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_FILE_in_start69 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NEWLINE_in_start78 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule_z_in_start80 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_rule_z_in_start86 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_rule_in_start90 = new BitSet(new long[]{0x0000000000001400L});
    public static final BitSet FOLLOW_rule_f_in_start100 = new BitSet(new long[]{0x0000000000001420L});
    public static final BitSet FOLLOW_END_in_start109 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_NEWLINE_in_start111 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_STATE_INIZ_in_rule_z128 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule_z130 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SYMBOL_in_rule_z142 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule_z154 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_MOVEMENT_in_rule_z166 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule_z168 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_STATE_in_rule_z180 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule_z182 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SYMBOL_in_rule_z194 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NEWLINE_in_rule_z208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATE_in_rule230 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule232 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SYMBOL_in_rule237 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule242 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_MOVEMENT_in_rule247 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule249 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_STATE_in_rule254 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule256 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SYMBOL_in_rule261 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NEWLINE_in_rule268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_rule_f280 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule_f289 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SYMBOL_in_rule_f295 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule_f301 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_MOVEMENT_in_rule_f307 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule_f309 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_STATE_FIN_in_rule_f315 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SEPARATOR_in_rule_f317 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_SYMBOL_in_rule_f323 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_NEWLINE_in_rule_f331 = new BitSet(new long[]{0x0000000000000002L});

}