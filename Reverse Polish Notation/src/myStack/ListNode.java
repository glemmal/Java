package myStack;

public class ListNode<T> {
	
	private T data;
	private ListNode<T> next;
	
	public ListNode() {
		data = null;
		next = null;
	}
	
	public ListNode(T data) {
		this.data = data;
		this.next = null;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public ListNode<T> getNext() {
		return this.next;
	}
	
	public void setNext(ListNode<T> next) {
		this.next = next;
	}
	
}
