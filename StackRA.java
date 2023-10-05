public class StackRA<T> implements StackInterface<T>{

	private T[] items;
	private int top;

	public StackRA() {
		items = (T[])new Object[3]; //hand picked value of 3
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void popAll() {
		items = (T[])new Object[3]; //see StackRA()
		top = -1;
	}

	/**
	 * Assumes that the array is not empty & is full
	 */
	private void resize() { // testing must reach 4 items in stack
		int lenItems = items.length;
		T[] temp = (T[])new Object[lenItems*2];
		System.arraycopy(items, 0, temp, 0, lenItems);
		this.items = temp;
	}

	public void push(T newItem) throws StackException{
		if(top == items.length-1)
			resize();
		items[++top] = newItem;
	}

	public T pop() throws StackException{
		if(top == -1)
			throw new StackException("pop(): stack is empty");
		T result = items[top];
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