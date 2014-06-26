package postfix;

public class PostfixTest {
	
	public static void main(String[] args) throws Exception {
		Postfix postFix = new Postfix();
		evaluate(postFix);
		infixToPostfix(postFix);
	}

	private static void evaluate(Postfix postFix) throws Exception {
		System.out.println(postFix.evaluate("1 2 * 3 +"));
		System.out.println(postFix.evaluate("1 2 3 * +"));
		System.out.println(postFix.evaluate("1 2 + 3 4 ^ -"));
		System.out.println(postFix.evaluate("1 2 ^ 3 4 * -"));
		System.out.println(postFix.evaluate("1 2 3 * + 4 5 ^ - 6 +"));
		System.out.println(postFix.evaluate("1 2 + 3 * 4 5 6 - ^ +"));
		System.out.println(postFix.evaluate("1 2 + 3 4 / + 5 + 6 7 8 + * +"));
		System.out.println(postFix.evaluate("9 1 - 2 - 3 2 * - 1 -"));
	}
  
	private static void infixToPostfix(Postfix postFix) {
		System.out.println(postFix.infixToPostfix("1 * 2 + 3"));
		System.out.println(postFix.infixToPostfix("1 + 2 * 3"));
		System.out.println(postFix.infixToPostfix("1 + 2 - 3 ^ 4"));
		System.out.println(postFix.infixToPostfix("1 ^ 2 - 3 * 4"));
		System.out.println(postFix.infixToPostfix("1 + 2 * 3 - 4 ^ 5 + 6"));
		System.out.println(postFix.infixToPostfix("( 1 + 2 ) * 3 + ( 4 ^ ( 5 - 6 ) )"));
		System.out.println(postFix.infixToPostfix("1 + 2 + 3 / 4 + 5 + 6 * ( 7 + 8 )"));
		System.out.println(postFix.infixToPostfix("9 - 1 - 2 - 3 * 2 - 1  "));
	}
}
