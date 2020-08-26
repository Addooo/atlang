package compilerPackage.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;



public class ParserHandler {
	
	/*
	 * syntax error
	 */
	public static final int E0_SYNTAX_ERROR = 0;
	
	/*
	 * State with that symbol to read already exist, trying
	 * to define a non deterministic turin machine
	 */
	public static final int E1_NON_DET_TM = 1;
	
	/*
	 * Initial state not declared
	 */
	public static final int E2_NO_INIT_STATE = 2;
	
	/*
	 * No final state declared
	 */
	public static final int E3_NO_FIN_STATE = 3; 
	
	
	public ArrayList<String> Rules;
	public ArrayList<String> parkedSymbols;
	public ArrayList<String> tapes;
	public ArrayList<String> sf;
	
	public ArrayList<String> errorList;


	public String printPy;
	
	
	public HashMap<String,String> movement;
	
	
	
	public ParserHandler() {
        this.errorList = new ArrayList<String>();
        this.Rules = new ArrayList<String>();
        this.movement = new HashMap<String, String>();
        this.parkedSymbols = new ArrayList<String>();
        this.tapes = new ArrayList<String>();
        this.sf = new ArrayList<String>();
        movement.put(">","r");
        movement.put("<","l");
        movement.put("=","s");
    }
	
	public void evaluateRule(Token state, Token sym_read, Token mov, Token newstate, Token sym_write) {
		
		String r;
		
		r = "('" + sym_read.getText() + "','" + state.getText() + "','"
			+ sym_write.getText() + "','" + newstate.getText() + "','"
			+ movement.get(mov.getText()).toString()
			+ "')";
		
		//add to the rule to Rules array
		Rules.add(r);
	}
	
	
	public void evaluateSym(Token sym){
		
		parkedSymbols.add("'" + sym.getText() + "'");
		
	}
	
	public void evaluateTape() {
		
		System.out.println("SYMBOL: " + parkedSymbols.toString());
		tapes.add(parkedSymbols.toString());
	;	parkedSymbols.clear();
	}
	
	public void compute() {
	

		String file = "";
		
		//import the interpeter 
		file += "from turing import *\n";
		file += "\n\n";
		
		//main declaration
		file += "if __name__ == \"__main__\":\n\n";
		
		int index = 0;
		//tape(s) turing machine
		for(String t: tapes) {
			
			
			t = t.replace("[", "");
			t = t.replace("]", "");
			
			file += "\tmy_tape" + index + " = tape(" + t.toString() + ", tape_name = \"test" + index +
					"\")\n";
			file += "\tmy_tape" + index + ".print_tape()\n\n";
			
			index++;
		}
		
		
		//rules turing machine
		file += "\tlist_tup = " + Rules + "\n";
		file += "\tmy_rules = rules(rules_name = \"rules_test\", tuplist = list_tup)\n\n";	
		file += "\tmy_rules.print_rules()\n\n";
		
		//computation
		index = 0;
		for(String t: tapes) {
			
			file += "\tc = computation(my_rules, [my_tape" + index + "], " + sf.toString() + ")\n";
			
			file += "\tmy_tape" + index + ".print_tape()\n\n";
			
			index++;
		}
		
	
		printPy = file;
		
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
		
		String err = "*** SINTAX ERROR [" + E0_SYNTAX_ERROR + "] in " +
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
			case E1_NON_DET_TM:
				err += "Trying to building a non deterministi turing machine";
				break;
			case E2_NO_INIT_STATE:
				err += "No initial state declared";
				break;
			case E3_NO_FIN_STATE:
				err += "No final state declared";
				break;
		}
			
		errorList.add(err);
		
		
	}
	
	
}
