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
}