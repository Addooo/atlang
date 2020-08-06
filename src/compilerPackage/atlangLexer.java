// $ANTLR 3.4 atlang.g 2020-08-06 17:00:04

 //code outside lexer class
  package compilerPackage;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class atlangLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public atlangLexer() {} 
    public atlangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public atlangLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "atlang.g"; }

    // $ANTLR start "STATE"
    public final void mSTATE() throws RecognitionException {
        try {
            int _type = STATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:142:7: ( 's' ( '1' .. '9' ) ( '0' .. '9' )* )
            // atlang.g:142:9: 's' ( '1' .. '9' ) ( '0' .. '9' )*
            {
            match('s'); 

            if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // atlang.g:142:24: ( '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // atlang.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STATE"

    // $ANTLR start "STATE_INIZ"
    public final void mSTATE_INIZ() throws RecognitionException {
        try {
            int _type = STATE_INIZ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:144:12: ( 's0' )
            // atlang.g:144:14: 's0'
            {
            match("s0"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STATE_INIZ"

    // $ANTLR start "STATE_FIN"
    public final void mSTATE_FIN() throws RecognitionException {
        try {
            int _type = STATE_FIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:146:11: ( 'sF' )
            // atlang.g:146:13: 'sF'
            {
            match("sF"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STATE_FIN"

    // $ANTLR start "MOVEMENT"
    public final void mMOVEMENT() throws RecognitionException {
        try {
            int _type = MOVEMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:148:10: ( '<' | '>' | '=' )
            // atlang.g:
            {
            if ( (input.LA(1) >= '<' && input.LA(1) <= '>') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MOVEMENT"

    // $ANTLR start "SYMBOL"
    public final void mSYMBOL() throws RecognitionException {
        try {
            int _type = SYMBOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:150:8: ( ( '0' .. '9' )+ | '!' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                alt3=1;
            }
            else if ( (LA3_0=='!') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // atlang.g:150:10: ( '0' .. '9' )+
                    {
                    // atlang.g:150:10: ( '0' .. '9' )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // atlang.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


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


                    }
                    break;
                case 2 :
                    // atlang.g:150:24: '!'
                    {
                    match('!'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SYMBOL"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:152:9: ( '\\n' )
            // atlang.g:152:11: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "FILE"
    public final void mFILE() throws RecognitionException {
        try {
            int _type = FILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:154:6: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '.t' )
            // atlang.g:154:8: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ '.t'
            {
            // atlang.g:154:8: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // atlang.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(".t"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FILE"

    // $ANTLR start "SEPARATOR"
    public final void mSEPARATOR() throws RecognitionException {
        try {
            int _type = SEPARATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:156:11: ( ',' )
            // atlang.g:156:13: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEPARATOR"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:158:7: ( 'begin' )
            // atlang.g:158:9: 'begin'
            {
            match("begin"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:160:5: ( 'end' )
            // atlang.g:160:7: 'end'
            {
            match("end"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:162:5: ( ( ' ' | '\\t' ) )
            // atlang.g:162:8: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // atlang.g:1:8: ( STATE | STATE_INIZ | STATE_FIN | MOVEMENT | SYMBOL | NEWLINE | FILE | SEPARATOR | BEGIN | END | WS )
        int alt5=11;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // atlang.g:1:10: STATE
                {
                mSTATE(); 


                }
                break;
            case 2 :
                // atlang.g:1:16: STATE_INIZ
                {
                mSTATE_INIZ(); 


                }
                break;
            case 3 :
                // atlang.g:1:27: STATE_FIN
                {
                mSTATE_FIN(); 


                }
                break;
            case 4 :
                // atlang.g:1:37: MOVEMENT
                {
                mMOVEMENT(); 


                }
                break;
            case 5 :
                // atlang.g:1:46: SYMBOL
                {
                mSYMBOL(); 


                }
                break;
            case 6 :
                // atlang.g:1:53: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 7 :
                // atlang.g:1:61: FILE
                {
                mFILE(); 


                }
                break;
            case 8 :
                // atlang.g:1:66: SEPARATOR
                {
                mSEPARATOR(); 


                }
                break;
            case 9 :
                // atlang.g:1:76: BEGIN
                {
                mBEGIN(); 


                }
                break;
            case 10 :
                // atlang.g:1:82: END
                {
                mEND(); 


                }
                break;
            case 11 :
                // atlang.g:1:86: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\3\uffff\1\4\7\uffff\1\21\1\22\1\23\2\uffff\1\21\4\uffff\1\27\2"+
        "\uffff\1\31\1\uffff";
    static final String DFA5_eofS =
        "\32\uffff";
    static final String DFA5_minS =
        "\1\11\1\56\1\uffff\1\56\2\uffff\1\56\1\uffff\1\56\2\uffff\6\56\3"+
        "\uffff\3\56\1\uffff\1\56\1\uffff";
    static final String DFA5_maxS =
        "\2\172\1\uffff\1\172\2\uffff\1\172\1\uffff\1\172\2\uffff\6\172\3"+
        "\uffff\3\172\1\uffff\1\172\1\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\4\1\uffff\1\5\1\6\1\uffff\1\10\1\uffff\1\7\1\13\6\uffff"+
        "\1\1\1\2\1\3\3\uffff\1\12\1\uffff\1\11";
    static final String DFA5_specialS =
        "\32\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\12\1\5\25\uffff\1\12\1\4\12\uffff\1\7\3\uffff\12\3\2\uffff"+
            "\3\2\2\uffff\32\11\4\uffff\1\11\1\uffff\1\11\1\6\2\11\1\10\15"+
            "\11\1\1\7\11",
            "\1\11\1\uffff\1\14\11\13\7\uffff\5\11\1\15\24\11\4\uffff\1"+
            "\11\1\uffff\32\11",
            "",
            "\1\11\1\uffff\12\3\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "",
            "",
            "\1\11\1\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\4\11"+
            "\1\16\25\11",
            "",
            "\1\11\1\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\15\11"+
            "\1\17\14\11",
            "",
            "",
            "\1\11\1\uffff\12\20\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\11\1\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\11\1\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\11\1\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\6\11"+
            "\1\24\23\11",
            "\1\11\1\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\3\11"+
            "\1\25\26\11",
            "\1\11\1\uffff\12\20\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "",
            "",
            "",
            "\1\11\1\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\10\11"+
            "\1\26\21\11",
            "\1\11\1\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            "\1\11\1\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\15\11"+
            "\1\30\14\11",
            "",
            "\1\11\1\uffff\12\11\7\uffff\32\11\4\uffff\1\11\1\uffff\32\11",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( STATE | STATE_INIZ | STATE_FIN | MOVEMENT | SYMBOL | NEWLINE | FILE | SEPARATOR | BEGIN | END | WS );";
        }
    }
 

}