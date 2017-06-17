import java.util.HashMap;
import java.util.Map;
import parsii.eval.Expression;
import parsii.eval.Parser;
import parsii.eval.Scope;
import parsii.eval.Variable;
import parsii.tokenizer.ParseException;


public class Translator {
	/*
	 * General Separators
	 */
	private String andSeparator = " and";
	private String decimalSeparator = "point";
	private String expSeparator = "exp";
	
	/*
	 * Math Separators
	 */
	private String addSeparator = "plus";
	private String subSeparator = "minus";
	private String multSeparator = "times";
	private String dvdSeparator = "over";

	private String powerSeparator = "power";
	private String squaredSeparator = "squared";
	private String cubedSeparator = "cubed";
	
	/*
	 * Delimiters and Number Bases
	 */
	private final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
	private final String[] NUMBER_BASES = { "tens", "hundred", "thousand" };
	
	/*
	 * Global Variables
	 */
	private double Result;
	private String parsedExpression;
	private Scope scope;
	
	/**
	 * Creates a new translator
	 * 
	 * The constructor initializes the result, Math parser and variables 
	 */
	public Translator() {//constructer translator class
		Result = 0.0;
		parsedExpression = "";
		scope = Scope.create();
	}

	
	
	/**
	 * Get the last value calculated
	 * 
	 * @return result of the last calculation
	 */
	public String getResult() { //return the result's text version 
		return String.valueOf(Result);
	}

	
	/**
	 * Get the last value calculated
	 * 
	 * @return result of the last calculation
	 */
	public String getParsedExpression() { //return the parsed expression's text version
		return parsedExpression;
	}


	/**
	 * Evaluate a mathematical expression and calculates its value
	 * 
	 * @param expression
	 *            the string to evaluate
	 * @return result of the calculation
	 */
	public void calculateExpression(String expression) throws ParseException {//Calculate the expression
		expression = numberFormat(expression);
		String[] terms = expression.split(String.format(WITH_DELIMITER,"-|\\+|\\*|\\/"));
		parsedExpression = termsParser(terms, NUMBER_BASES);
		Expression expr = Parser.parse(parsedExpression, scope);
		Result = expr.evaluate();
	}


	/**
	 * Format string from words to numbers and symbols
	 * 
	 * @param expression
	 *            the string to format
	 * @return result of the formating
	 */
	public String numberFormat(String expression) { 
		expression = expression.toLowerCase();
		expression = expression.replace(addSeparator, "+");
		expression = expression.replace(subSeparator, "-");
		expression = expression.replace(multSeparator, "*");
		expression = expression.replace(dvdSeparator, "/");
		expression = expression.replace(powerSeparator, "^");
		expression = expression.replace(squaredSeparator, "^2");
		expression = expression.replace(cubedSeparator, "^3");
		expression = expression.replace(decimalSeparator, ".");
		expression = expression.replaceAll(andSeparator, "");
		expression = expression.replaceAll("\\s+", "");
		return expression;
	}

	/**
	 * Split an expression into terms, formating each based on the base
	 * 
	 * @param terms
	 *            the list of terms
	 * @param bases
	 *            the list of bases
	 * @return result of parsing
	 */
	public String termsParser(String[] terms, String[] bases) { //d
		String expression = "";
		for (String term : terms) {
			if (term.contains(expSeparator)) {
				term = term.replace(expSeparator, "");
				term = expSeparator + "(" + termsParser(term.split(String.format(WITH_DELIMITER, ",")),bases) + ")";
			}
			expression = expression + " " + baseParser(term, bases);
		}

		return expression;
	}

	/**
	 * Parse a term based on it's base
	 * 
	 * @param term
	 *            the string to evaluate
	 * @param bases
	 *            the list of bases
	 * @return result of parsing
	 */
	public String baseParser(String term, String[] bases) {//d
		for (int j = 0; j < bases.length; j++)
			if (term.endsWith(bases[j]))
				term = term.replace(bases[j],new String(new char[j + 1]).replace("\0", "0"));
			else
				term = term.replace(bases[j], "");
		return term;
	}
}


