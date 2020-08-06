package myPackage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import compilerPackage.atlangLexer;
import compilerPackage.atlangParser;


public class Tester {

	
	static atlangParser parser;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonTokenStream tokens;
		
		String fileIn = "resources/mio_nastro.t";
		String fileOut1 = "resources/file.out";
	  	String fileErr1 = "resources/file.err.txt";
		
		System.out.println("Questo è il main");
		

		try {
			System.out.println ("Parsing con ANTLR lexer");
			System.out.println ("-----------------------");

			atlangLexer lexer = new atlangLexer(new ANTLRReaderStream(new FileReader(fileIn)));
			//SimpleLanguageSemanticLexer lexer = new SimpleLanguageSemanticLexer(new ANTLRReaderStream(new FileReader(fileIn))); 
		    tokens = new CommonTokenStream(lexer);
		    parse (tokens, fileOut1, fileErr1);
		} catch (Exception e) {
			System.out.println ("Parsing con ANTLR abortito\n\n");
			e.printStackTrace();
		}
	}
	static void parse (CommonTokenStream tokens, String fileOut, String fileErr) throws IOException, RecognitionException {
		  FileWriter fOut;
//		  	parser = new SimpleLanguageParser(tokens);
			parser = new atlangParser(tokens);
			parser.start();
			
			if (parser.getErrors().size() == 0) {
				System.out.println ("Parsing completato con successo\n");
				//System.out.println (parser.getPrint());
				System.out.println ("-----------------------");
				System.out.println (parser.getRules());
				fOut = new FileWriter (fileOut);
				fOut.append(parser.getReadableRules());
				fOut.close();
			}
			else {
				System.out.println ("Parsing completato con " + parser.getErrors().size() + " errori\n\n");
			    fOut = new FileWriter (fileErr);
			  	for (int i=0; i<parser.getErrors().size(); i++) {
			  		fOut.append((i+1) + ":" + parser.getErrors().get(i) + "\n");    	
			  		System.out.println ((i+1) + ":" + parser.getErrors().get(i));
			  	}
			    fOut.close();
			}
	}
	
	

}
