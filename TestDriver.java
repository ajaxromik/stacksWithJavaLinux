public class TestDriver {

	public static void main(String[] args) {
		DNode head = new DNode("First");

		DNode second = new DNode("Next", head, head);
		head.setNext(second);
		second.setBack(head);

		DNode third = new DNode("Third", head, second);
		second.setNext(third);
		third.setBack(second);

		DNode last = new DNode("Last", head, third);
		third.setNext(last);
		head.setBack(last);

		DNode current = head;
	    StringBuilder result = new StringBuilder();

	    int numItems = 4;

	    for(int i = 0; i < numItems; i++) {
	      result.append(current.toString());
	      current = current.getNext();
	    }

		System.out.println(result.toString());

		result = new StringBuilder();
		current = head;

		for(int i = numItems-1; i >= 0; i--) {
	      current = current.getBack();
	      result.append(current.toString());
	    }

		System.out.println(result.toString());

	}

}