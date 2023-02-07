package project3;

import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * Implementation of an arithmetic expression evaluator. 
 * @author Chi-Ting Lu
 * @version 1.0
 */

public class Expression {
	
	  /**
	   * The String instance variable for the infix.
	   */
	  private String infix;
	  
	  /**
	   * Constructs a Expression without the String infix. 
	   */
	  public Expression() {
	    this.infix = "";
	  }
	  
	  /**
	   * Constructs a Expression with the String infix. 
	   * @param infix A string represents the infix 
	   */
	  public Expression(String infix) {
	    this.infix = infix;
	  }
	  
	  /**
	   * Get the infix of this expression. 
	   * @return A string represents the infix 
	   */
	  public String getInfix() {
	    return this.infix;
	  }
	  
	  /**
	   * Set the infix of this expression. 
	   * @param infix A string represents the infix 
	   */
	  public void setInfix(String infix) {
	    this.infix = infix;
	  }
	  
	  /**
	   * Converts this infix to postfix.
	   * @return A ArrayList<String> contains the postfix as a list of tokens. 
	   */
	  public ArrayList<String> convert() {
		  ArrayList<String> postfix = new ArrayList<String>();
		  GenericStack<String> stack = new GenericStack<String>();
		  StringTokenizer st = new StringTokenizer(this.infix, "+-*/ ()",true);
	      while (st.hasMoreElements()) {
	    	  String token = st.nextToken();
	    
	    	  if (isNumeric(token)) {
	    		  postfix.add(token);
	    	  }
	    	  else if(token.equals(" ")) {
	    		  continue; 
	    	  }
	    	  else if(token.equals("(")) {
	    		  stack.push(token);
	    	  }
	    	  else if(token.equals(")")) {
	    		  while(!stack.isEmpty()) {
	    			  String popOperator = stack.pop();
	    			  if (popOperator.equals("(")) {
	    				  break;
	    			  }
	    			  postfix.add(popOperator);
	    		  }
	    	  }
	    	  else {
	    		  if(stack.isEmpty()) {
	    			  stack.push(token);
	    		  }
	    		  else {
	    			  while(!stack.isEmpty()) {
	    				  String peekOperator = stack.peek();
	    				  if(peekOperator.equals("(")) {
	    					  break;
	    				  }
	    				  else if( (token.equals("*") || token.equals("/")) && (peekOperator.equals("+") || peekOperator.equals("-")) ) {
	    					  break;
	    				  }
	    				  String popOperator = stack.pop();
	    				  postfix.add(popOperator);
	    			  }
	    			  stack.push(token);
	    		  }
	    	  }
	        }
	      
	      while(!stack.isEmpty()) {
	    	  String popOperator = stack.pop();
			  postfix.add(popOperator);
	      }
	       
	      return postfix;
	  }
	  
	  /**
	   * Evaluates this infix and calculates the result.
	   * @return A number representation of the result after calculating.
	   */
	  public double evaluate() {
		  ArrayList<String> postfix = this.convert();
		  GenericStack<Double> stack = new GenericStack<Double>();
		  while(!postfix.isEmpty()) {
	    	  String popToken = postfix.remove(0);
			  if(isNumeric(popToken)) {
				   stack.push(Double.parseDouble(popToken));
			  }else {
				  double operand1 = stack.pop();
				  double operand2 = stack.pop();
				  double result = 0;
				  if(popToken.equals("+")) {
					  result = operand1+operand2;
					  stack.push(result);
				  }
				  else if(popToken.equals("-")) {
					  result = operand1-operand2;
					  stack.push(result);
				  }
				  else if(popToken.equals("*")) {
					  result = operand1*operand2;
					  stack.push(result);
				  }
				  else if(popToken.equals("/")) {
					  result = operand1/operand2;
					  stack.push(result);
				  }
			  }
	      }
		  double answer = stack.peek();
		  return answer;
	  }
	  
	  /**
	   * Returns whether the Expression o equals to this expression.
	   * @param o The other object taken to be compared with this expression
	   * @return A boolean indicates if equals or not
	   */
	  public boolean equals(Expression o) {
	     return this.infix.equals(o.infix);
	  }
	  
	  /**
	   * Returns a string representation of this expression.
	   * @return A string representation of this expression
	   */
	  public String toString() {
		  return getClass().getSimpleName() + ": " + this.infix;
	  }
	  
	  
	  /**
	   * Returns whether the String str is a number or not.
	   * @param str A String token is considered whether it is number or not
	   * @return A boolean indicates if it is number or not
	   */
	  public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}


}
