
public class ChainMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chain c = new Chain();
		c.add(3);
		System.out.println(c.toString());
		
		c.add(2);
		System.out.println(c.toString());
		c.add(1);
		//c.add(4, , 3);
		System.out.println(c.toString());
		System.out.println(c.duplicate());
		
		System.out.println(c.numberOf(3));
		System.out.println(c.consecutiveNode());
		System.out.println(c.increasing());
		Node[] a = c.sumOf(5);
		System.out.println(a[0].toString() + " " + a[1].toString());
		System.out.println(c.circularStructure());
		c.sort();
		System.out.println(c.toString());
	}

}
