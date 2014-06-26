package myStack;

public class Run {
	public static void main(String args[]) {
		Stack<String> test = new Stack<String>(5);
		test.push("Dies ist ein Test");
		test.push("Dies ist ein anderer Test");
		test.push("tralalalala");
		test.push("blablablabla");
		System.out.println(test.toString());
		System.out.println(test.pop());
		System.out.println(test.toString());
		System.out.println(test.pop());
		System.out.println(test.toString());
		test.push("test");
		System.out.println(test.toString());
	}
}
