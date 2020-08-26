// $ANTLR 3.4 atlang.g 2020-08-25 08:54:08

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
            // atlang.g:189:7: ( 's' ( '1' .. '9' ) ( '0' .. '9' )* )
            // atlang.g:189:9: 's' ( '1' .. '9' ) ( '0' .. '9' )*
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


            // atlang.g:189:24: ( '0' .. '9' )*
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
            // atlang.g:191:12: ( 's0' )
            // atlang.g:191:14: 's0'
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

    // $ANTLR start "MOVEMENT"
    public final void mMOVEMENT() throws RecognitionException {
        try {
            int _type = MOVEMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:193:10: ( '<' | '>' | '=' )
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
            // atlang.g:195:8: ( ( '0' .. '9' )+ | '!' )
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
                    // atlang.g:195:10: ( '0' .. '9' )+
                    {
                    // atlang.g:195:10: ( '0' .. '9' )+
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
                    // atlang.g:195:24: '!'
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
            // atlang.g:197:9: ( '\\n' )
            // atlang.g:197:11: '\\n'
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

    // $ANTLR start "SEPARATOR"
    public final void mSEPARATOR() throws RecognitionException {
        try {
            int _type = SEPARATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:199:11: ( ',' )
            // atlang.g:199:13: ','
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
            // atlang.g:201:7: ( 'begin' )
            // atlang.g:201:9: 'begin'
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
            // atlang.g:203:5: ( 'end' )
            // atlang.g:203:7: 'end'
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
            // atlang.g:205:5: ( ( ' ' | '\\t' ) )
            // atlang.g:205:8: ( ' ' | '\\t' )
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

    // $ANTLR start "QUAD_I"
    public final void mQUAD_I() throws RecognitionException {
        try {
            int _type = QUAD_I;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:207:8: ( '[' )
            // atlang.g:207:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUAD_I"

    // $ANTLR start "QUAD_O"
    public final void mQUAD_O() throws RecognitionException {
        try {
            int _type = QUAD_O;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:209:8: ( ']' )
            // atlang.g:209:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUAD_O"

    // $ANTLR start "IS_FINAL"
    public final void mIS_FINAL() throws RecognitionException {
        try {
            int _type = IS_FINAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:211:10: ( 'sF' )
            // atlang.g:211:12: 'sF'
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
    // $ANTLR end "IS_FINAL"

    // $ANTLR start "COMP"
    public final void mCOMP() throws RecognitionException {
        try {
            int _type = COMP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:213:6: ( 'computation' )
            // atlang.g:213:8: 'computation'
            {
            match("computation"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMP"

    // $ANTLR start "TAPE"
    public final void mTAPE() throws RecognitionException {
        try {
            int _type = TAPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // atlang.g:215:6: ( 'tape' )
            // atlang.g:215:8: 'tape'
            {
            match("tape"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TAPE"

    public void mTokens() throws RecognitionException {
        // atlang.g:1:8: ( STATE | STATE_INIZ | MOVEMENT | SYMBOL | NEWLINE | SEPARATOR | BEGIN | END | WS | QUAD_I | QUAD_O | IS_FINAL | COMP | TAPE )
        int alt4=14;
        switch ( input.LA(1) ) {
        case 's':
            {
            switch ( input.LA(2) ) {
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt4=1;
                }
                break;
            case '0':
                {
                alt4=2;
                }
                break;
            case 'F':
                {
                alt4=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 1, input);

                throw nvae;

            }

            }
            break;
        case '<':
        case '=':
        case '>':
            {
            alt4=3;
            }
            break;
        case '!':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt4=4;
            }
            break;
        case '\n':
            {
            alt4=5;
            }
            break;
        case ',':
            {
            alt4=6;
            }
            break;
        case 'b':
            {
            alt4=7;
            }
            break;
        case 'e':
            {
            alt4=8;
            }
            break;
        case '\t':
        case ' ':
            {
            alt4=9;
            }
            break;
        case '[':
            {
            alt4=10;
            }
            break;
        case ']':
            {
            alt4=11;
            }
            break;
        case 'c':
            {
            alt4=13;
            }
            break;
        case 't':
            {
            alt4=14;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;

        }

        switch (alt4) {
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
                // atlang.g:1:27: MOVEMENT
                {
                mMOVEMENT(); 


                }
                break;
            case 4 :
                // atlang.g:1:36: SYMBOL
                {
                mSYMBOL(); 


                }
                break;
            case 5 :
                // atlang.g:1:43: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 6 :
                // atlang.g:1:51: SEPARATOR
                {
                mSEPARATOR(); 


                }
                break;
            case 7 :
                // atlang.g:1:61: BEGIN
                {
                mBEGIN(); 


                }
                break;
            case 8 :
                // atlang.g:1:67: END
                {
                mEND(); 


                }
                break;
            case 9 :
                // atlang.g:1:71: WS
                {
                mWS(); 


                }
                break;
            case 10 :
                // atlang.g:1:74: QUAD_I
                {
                mQUAD_I(); 


                }
                break;
            case 11 :
                // atlang.g:1:81: QUAD_O
                {
                mQUAD_O(); 


                }
                break;
            case 12 :
                // atlang.g:1:88: IS_FINAL
                {
                mIS_FINAL(); 


                }
                break;
            case 13 :
                // atlang.g:1:97: COMP
                {
                mCOMP(); 


                }
                break;
            case 14 :
                // atlang.g:1:102: TAPE
                {
                mTAPE(); 


                }
                break;

        }

    }


 

}