package postfix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import myStack.Stack;

public class Postfix {
	
	private HashMap<String, Integer> precedence;
	
	public Postfix() {
		precedence = new HashMap<String, Integer>();
		precedence.put("+", 1);
		precedence.put("-", 1);
		precedence.put("*", 3);
		precedence.put("/", 4);
		precedence.put("^", 5);
	}
	
	
	public static void main(String[] args) throws Exception {
		
		if (args.length != 1) {
			System.out.println("Usage: java Postfix \"<infix string>\"");
			System.exit(1);
		}
		
		Postfix postfix = new Postfix();
		String pfx = postfix.infixToPostfix(args[0]);
		System.out.println(postfix.evaluate(pfx));
	
	}
	
	public Double evaluate(String pfx) throws Exception {
		ArrayList<String> s = new ArrayList<String>( Arrays.asList( pfx.split(" ") ) );
		Stack<Double> stack = new Stack<Double>(100);
		
		for (String t : s) {
			if (isDouble(t)) {
				stack.push(Double.parseDouble(t));
			} else {
				Double rhs = stack.pop();
				Double lhs = stack.pop();
				stack.push( runOperator(t, lhs, rhs) );
			}
		}
		
		return (Double) stack.pop();
	}
	
	private Double runOperator(String operator, Double left, Double right) throws Exception {
		if (operator.length() > 1) throw new Exception("Invalid operator: "+ operator);
		char o = operator.charAt(0);
		if (o == '+') return left + right;
		if (o == '-') return left - right;
		if (o == '*') return left * right;
		if (o == '/') return left / right;
		if (o == '^') return Math.pow(left, right);
		throw new Exception("Invalid operator: "+ o);
	}
	
	private boolean isDouble(String str) {
	    int size = str.length();
	    for (int i = 0; i < size; i++) {
	        char c = str.charAt(i);
	    	if (!(Character.isDigit(c) || size > 1 && (c == '.' || c == '-'))) {
	            return false;
	        }
	    }
	    return size > 0;
	}	
	
	private boolean isOperator(String str) {
		return precedence.containsKey(str);
	}
	
	
	public String infixToPostfix(String ifx) {
		Stack<String> stack = new Stack<String>(100);
		ArrayList<String> s = new ArrayList<String>( Arrays.asList( ifx.split(" ") ) );
		String pfx = "";
		
		for (String t : s) {
			if (isDouble(t)) {
				pfx += t + " ";
			}
			
			else if (t.equals("(")) {
				stack.push(t);
			}
			
			else if (isOperator(t)) {
				while (!stack.empty()) {
					String top = stack.peek();
					Integer topPrec = precedence.get(top);
					Integer tPrec = precedence.get(t);
					if (!isOperator(top) || topPrec < tPrec) break;
					pfx += stack.pop() + " ";
				}
				stack.push(t);
			}
			
			else if (t.equals(")")) {
				while (!stack.empty() && !(stack.peek()).equals("(")) {
					pfx += stack.pop() + " ";
				}
				stack.pop();
			}
			
		}
		
		while (!stack.empty()) {
			pfx += stack.pop() + " ";
		}
		
		return pfx.trim();
	}
	
}
