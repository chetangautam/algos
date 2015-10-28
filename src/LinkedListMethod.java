
public class LinkedListMethod {

	public LinkedListMethod next;

	public boolean isLooped() {
		if (next == null) {
			return false;
		}
		LinkedListMethod fast = this.next, slow = this;
		while (fast!=null && fast.next!=null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

}
