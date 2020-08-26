package myPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
		String fileIn = null;
		String test = "resources/test.t"; 
		/*String fileIn = "resources/syntax.t";
		String fileIn2 = "resources/non_det.t";
		String fileIn3 = "resources/no_iniz.t";
		String fileIn4 = "resources/no_fin.t";
		String fileIn5 = "resources/ok1.t";
		String fileIn6 = "resources/ok2.t";
		*/
	  	String fileErr1 = "resources/file.err.txt";
	  	
		System.out.println("atlang");
		
		try {
			if(args[0].equals(("-h"))){
				System.out.println("usage: \n");
				System.out.println("java -jar atlang.jar filename.t");
				System.out.println("if you don't specify the file name the software"
						+ "  it will use test.t in resource directory."
						+ "\n"
						+ "After the execution you'll find filename.py in the pyOut/ directory");
				System.exit(0);
			}
			else
				fileIn = args[0];
			
		}catch(Exception e) {
			fileIn = test;
			System.out.println("Non args passed, using the test file\n"
					+ "pass -h for help\n");
		}
		
		try {
			
			System.out.println ("-----------------------");
			String fileInput = fileIn;
			atlangLexer lexer = new atlangLexer(new ANTLRReaderStream(new FileReader(fileInput)));
		    tokens = new CommonTokenStream(lexer);
		    String app = null;
		    String filePy = "pyOut/"  + fileInput.substring(0, fileInput.length() -2).replace("resources/", "") + ".py";
		    System.out.println(filePy);
		    parse (tokens, filePy, fileErr1, app);
		} catch (Exception e) {
			System.out.println ("Aborted\n\n");
			e.printStackTrace();
		}
	}
	static void parse (CommonTokenStream tokens, String filePy, String fileErr, String arg) throws IOException, RecognitionException {
		    FileWriter fOut;

			parser = new atlangParser(tokens);
			parser.start();
			
			if (parser.getErrors().size() == 0) {
				System.out.println ("Parsing completed\n");
				//System.out.println (parser.getPrint());
				System.out.println ("-----------------------");
				System.out.println (parser.getRules());
				//building python file 
				
				String pyPart = parser.getPy();
				//System.out.println(pyPart);
				fOut = new FileWriter(filePy);
				fOut.append(pyPart);
				fOut.close();
				System.out.println(parser.getFinalStates());
				System.out.println("File created: Now you can procede executing " + filePy + " in pyOut/ directory");
				
			}
			else {
				System.out.println ("Parsing completed with " + parser.getErrors().size() + " errors\n\n");
			    fOut = new FileWriter (fileErr);
			  	for (int i=0; i<parser.getErrors().size(); i++) {
			  		fOut.append((i+1) + ":" + parser.getErrors().get(i) + "\n");    	
			  		System.out.println ((i+1) + ":" + parser.getErrors().get(i));
			  	}
			    fOut.close();
			}
	}

}
