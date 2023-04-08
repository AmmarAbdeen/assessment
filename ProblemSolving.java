package encryption;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class ProblemSolving {
	
	public static void main (String[] args) throws Exception {
		String s1 = "abd(jnb)asdf";
		String s2 = "abdjnbasdf";
		String s3 = "dd(df)a(ghhh)";
		System.out.println(ProblemSolving.reverseSubStringsBetweenPairOfParentheses(s1));
		System.out.println(ProblemSolving.reverseSubStringsBetweenPairOfParentheses(s2));
		System.out.println(ProblemSolving.reverseSubStringsBetweenPairOfParentheses(s3));
		
	}
	
	public static String reverseSubStringsBetweenPairOfParentheses(String input) throws Exception{
		
		validateInputString(input);
		
		Stack<Integer> stack = new Stack<>();
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < input.length(); i++) {
	    	char c = input.charAt(i);
	    	if(c == '(') {
	    		stack.push(i);
	    	}else if(c == ')') {
	    		if(stack.isEmpty()) {
	    			throw new Exception("Unbalanced parentheses");
	    			}
	    		int start = stack.pop();
 	            String reversed = new StringBuilder(input.substring(start + 1, i)).reverse().toString();
 	            sb.delete(start+1, i);
	            sb.append(reversed);
	    	}
	         sb.append(c);
	        
	    }
	    if (!stack.isEmpty()) 
	        throw new Exception("Unbalanced parentheses");
	    
	    return sb.toString();
	}
	
	public static void validateInputString(String input) throws Exception{
		if(input.length() <1 || input.length()>2000)
			throw new Exception("input length must be at least 1 char and at most 2000 chars");
		if(!ProblemSolving.containsOnlyLowerCaseAndParentheses(input))
			throw new Exception("input only contains lower case English characters and parentheses");
	}
	
	public static boolean containsOnlyLowerCaseAndParentheses(String s) {
	    String pattern = "^[a-z()]*$";
	    return s.matches(pattern);
	}
	

}
