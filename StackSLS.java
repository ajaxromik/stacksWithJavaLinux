public class StackSLS<T> implements StackInterface<T> {

	Node<T> top;

	public StackSLS() {
		top = null;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public void popAll() {
		top = null;
	}

	public void push(T newItem) throws StackException{
		this.top = new Node<T>(newItem, top);
	}

	public T pop() throws StackException{
		if(top == null)
			throw new StackException("pop(): stack is empty");
		T item = top.getItem();
		this.top = top.getNext();
		return item;
	}

	public T peek() throws StackException{
		if(top == null)
			throw new StackException("pop(): stack is empty");
		return top.getItem();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<T> current = top;
		while(current != null) {
			sb.append(current.getItem()+" ");
			current = current.getNext();
		}
		return sb.toString();
	}

}