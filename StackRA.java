public class StackRA<T> implements StackInterface{

	private T[] items;
	private int top;

	public StackRA() {
		items = new T[3]; //hand picked value of 3
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void popAll() {
		StackRA();
	}

	/**
	 * Assumes that the array is not empty & is full
	 */
	private void resize() {
		int lenItems = items.length;
		T[] temp = new T[lenItems*2];
		System.arraycopy(items, 0, temp, 0, lenItems);
		this.items = temp;
	}

	public void push(T newItem) {
		if(top == items.length-1)
			resize();
		items[++top] = newItem;
	}

	public T pop() throws StackException{
		if(top == -1)
			throw new StackException("pop(): stack is empty");
		result = items[top];
		items[top--] = null;
		return result;
	}

	public T peek() throws StackException{
		if(top == -1)
			throw new StackException("peek(): stack is empty");
		return items[top];
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = top; i >= 0; i--) {
			sb.append(items[i] + " ");
		}
		return sb.toString();
	}
}