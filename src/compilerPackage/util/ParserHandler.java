package compilerPackage.util;

import java.util.ArrayList;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;



public class ParserHandler {
	
	/*
	 * Error in case filename and value expressed
	 * at start of the program doesn't coincide
	 */
	public static final int E0_FILENAME_MUST_COINCIDE = 0;
	
	/*
	 * syntax error
	 */
	public static final int E1_SYNTAX_ERROR = 1;
	
	/*
	 * State with that symbol to read already exist, trying
	 * to define a non deterministic turin machine
	 */
	public static final int E2_NON_DET_TM = 2;
	
	
	
	public StringBuffer translation;
	public ArrayList<String> Rules;
	
	public ArrayList<String> errorList;


	public String print;
	
	private static Integer numberOfLine;
	
	public ParserHandler() {
        this.translation = new StringBuffer();
        this.errorList = new ArrayList<String>();
        this.Rules = new ArrayList<String>();
        numberOfLine = 1;
    }
	
	public void evaluateFile(Token file) {
		
		boolean fileNameCorrect = true;
		String fileName = file.getText();
		//System.out.println("Controllare che esista il file: [" + fileName + "]");
		
		
		if(!fileNameCorrect)
			semError(file, E0_FILENAME_MUST_COINCIDE);
	}
	
	
	public void evaluateRule(Token state, Token sym_read, Token mov, Token newstate, Token sym_write) {
		
		String r; 
		r = "("+state.getText() + "," + sym_read.getText() + ","  
			 + mov.getText() + "," + newstate.getText() + ","
			 + sym_write.getText() + ")";
		
		//add to the rule to Rules array
		Rules.add(r);
	}
	
	public String readablePrint() {
		
		String ris = "";
		//order by?
		for(String r: Rules) {
			ris += r + "\n";
		}
		
		return ris;
	}
	//per gestire gli errori
	public void handleError(String[] tokenNames, RecognitionException e, String hdr, String msg) {
		// TODO Auto-generated method stub
		
		String err = "*** SINTAX ERROR [" + E1_SYNTAX_ERROR + "] in " +
	               "(" + e.token.getLine() + ", " + e.token.getCharPositionInLine() + ") - " +
	               "Found ";
	    if (e.token.getType() >= 0)
	           err += tokenNames[e.token.getType()];
	    
	    err += " ('" + e.token.getText() + "')" + msg;

	    errorList.add(err);
		
		
	}
	
	public void semError(Token tk, int code) {
		
		String err = "***SEMANTIC ERROR [" + code + "] "
                + "in (" + tk.getLine() + "," + tk.getCharPositionInLine() + ") - ";
		
		switch(code) {
			case E0_FILENAME_MUST_COINCIDE:
				err += "Filename must coincide";
				break;
			case E2_NON_DET_TM:
				err += "Trying to building a non deterministi turing machine";
				break;
		}
			
		errorList.add(err);
		
		
	}
	
}
