package myStack;

public class LinkedList<T> {
	
	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	public int length;
	
	public LinkedList() {
		firstNode = new ListNode<T>();
		lastNode = new ListNode<T>();
		length = 0;
	}
	
	public boolean empty() {
		return length == 0;
	}
	
	
	public void add(T inputData) {
		ListNode<T> node = new ListNode<T>(inputData);
		if(this.firstNode.getData() == null) {
			firstNode = node;
			lastNode = node;
		} else {
			lastNode.setNext(node);
			lastNode = node;
		}
		this.length++;
	}
	
	public T getLast() { 
		return lastNode.getData();
	}
	
	public T getFirst() {
		return firstNode.getData();
	}
	
	public T pop() {

        if (length == 0) return null;
        
        if (length == 1) {
        	ListNode<T> res = firstNode;
        	firstNode = new ListNode<T>();
            lastNode = firstNode;
            length--;
            return res.getData();
        }
        
    	ListNode<T> current = firstNode;
    	ListNode<T> next = firstNode.getNext();
    	
    	while ((next.getNext()) != null) {
    		current = next;
    		next = current.getNext();
    	}
    	
    	length--;
    	current.setNext(null);
    	lastNode = current;
    	
    	return next.getData();
	}
	
	public String toString() {
        ListNode<T> currentNode = this.firstNode;
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        for (int i = 0; currentNode != null; i++) {
          if (i > 0) {
            buffer.append(",");
          }
          T dataObject = currentNode.getData();

          buffer.append(dataObject == null ? "" : dataObject);
          currentNode = currentNode.getNext();
        }
        buffer.append("}");
        return buffer.toString();
    }

}
