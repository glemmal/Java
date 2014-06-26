package myStack;

public class Stack<T> {
	
	private LinkedList<T> stack;
	private int maxSize;
	public int length;
	
	public Stack(int maxSize) {
		this.stack = new LinkedList<T>();
		this.maxSize = maxSize;
		this.length = stack.length;
	}
	
	public void push(T data) {
		if(stack.length < maxSize) {
			stack.add(data);
		} else {
			throw new IndexOutOfBoundsException("Stack overflow!!");
		} 
	}
	
	public T peek() {
		return stack.getLast();
	}
	
	public T pop() {
		return stack.pop();
	}
	
	public boolean empty() {
		return stack.empty();
	}
	
	public String toString() {
		return stack.toString();
	}
	
}
