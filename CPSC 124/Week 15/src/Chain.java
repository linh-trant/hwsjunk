
public class Chain {
	Node head;
	
	public Chain() {
		head = null;
	}
	
	public void add(int v) {
		Node n  = new Node(v);
		this.add(n);
	}
	public void add(Node n) {
		if (head == null) {
			head = n;
			return;
		}
		Node iterator = head;
		while (iterator.next != null) {
			iterator = iterator.next;
		}
		iterator.next= n;
		n.prev = iterator;
	}
	public void insert(Node prev, Node next, Node n) {
		prev.next = n;
		n.next = next;
		n.prev = prev;
	}
	public void remove(int v) {
		if (head == null) return;
		Node iterator = head;
		while (iterator != null && iterator.value != v) {
			iterator = iterator.next;
		}
		if (iterator != null) {
			if (iterator == head) {
				head=  iterator.next;
				if (head != null) head.prev = null;
			} else {
				iterator.prev.next= iterator.next;
			}
		}
	}
	
	public Node search(int v) {
		if (head == null) return null;
		Node iterator = head;
		while (iterator != null && iterator.value != v) {
			iterator = iterator.next;
		}
		return iterator;
	}
	
	public Node findMin() {
		Node min = head;
		Node iterator = head;
		while (iterator != null) {
			if (iterator.value < min.value) {
				min = iterator;
			}
			iterator = iterator.next;
		}
		return min;
	}
	
	public Node findMax() {
		Node min = head;
		Node iterator = head;
		while (iterator != null) {
			if (iterator.value > min.value) {
				min = iterator;
			}
			iterator = iterator.next;
		}
		return min;
	}
	
	public boolean duplicate() {
		if (head == null) return false;
		for (Node i = head; i != null; i = i.next) {
			for (Node j = i.next; j!= null; j = j.next) {
				if (i.value == j.value) return true;
			}
		}
		return false;
	}
	//The following questions have to be done without modifying the Linked List
	//a. Given value v, Return the number of nodes that has value v. 
	//For example 3-1-2-1-5 has two nodes with value 1
	
	public int numberOf(int v) {
		int answer = 0;
		for (Node i = head; i!= null; i=i.next) {
			if (i.value == v) {
				answer++;
			}
		}
		return answer;
	}
	
	//b. Return whether there are consecutive nodes with the same value
	//For example 3-1-1-2 should return true because there are consecutive nodes with value 1
	
	
	public boolean consecutiveNode() {
		boolean answer = false;
		for (Node i = head; i.next!= null; i=i.next) {
			if (i.value == i.next.value) answer = true;
		}
		return answer;
	}
	
	//c. Return whether the list is strictly increasing
	//For example 1-4-6-7-9 should return true. 1-4-5-2-7 should return false
	
	public boolean increasing() {
		boolean answer = true;
		for (Node i = head; i.next!= null; i=i.next) {
			if (i.value >= i.next.value) answer = false;
		}
		return answer;
	}
	
	//d. Given value v, return whether two nodes sum to v
	
	public Node[] sumOf(int v) {
		Node[] answer = new Node[2];
		for (Node i = head; i.next!=null; i=i.next) {
			for (Node j = i.next; j!=null; j=j.next) {
				if (i.value + j.value == v) {
					answer[0] = i;
					answer[1] = j;
				}
			}
		}
		return answer;
	}
	
	//e. Return whether the list have a circular structure by mistake
	//For example 1-2-3-4-5, but if 5's node.next = node 2 instead of null, then return true;''
	
	public boolean circularStructure() {
		boolean answer = false;
		for (Node i = head; i!=null; i=i.next) {
			for (Node j = head; j!=i; j=j.next) {
				if (i.next == j) {
					answer = true;
					break;
				}
			}
		}
		return answer;
	}
	
	
	//The following question can be done by modifying the Linked List
	//f. Sort the chain from low to high
	
	public void sort() {
		for (Node i = head; i.next!=null; i=i.next) {
			for (Node j = i.next; j!=null; j=j.next) {
				if (i.value > j.value) {
					int mid = i.value;
					i.value = j.value;
					j.value = mid;
				}
			}
		}
	}
	
	
	
	
	
	
	
	public String toString() {
		if (head == null) return "empty";
		String output = "";
		
		for (Node iterator = head; iterator != null; iterator = iterator.next) {
			if (iterator.next == null) output += iterator.value;
			else output += iterator.value+"-";
		}
		return output;
	}
}
