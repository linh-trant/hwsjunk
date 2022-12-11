
public class Node {
	int value;
	Node prev;
	Node next;
	
	public Node(int v) {
		this.value = v;
	}
	
	public Node(int v, Node prev, Node next) {
		this.value = v;
		this.prev = prev;
		this.next = next;
	}
	
	public String toString() {
		return "Node:" + value;
	}
}
