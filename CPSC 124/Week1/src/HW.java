
public class HW {

	public static void main(String[] args) {
		
		int num1 = 6;
		int num2 = 4;
		
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		
		double num3= 4.0;
		double a = num2;
		num3 = num1/a; //One of this should be double. If not, it will round up.
		
		System.out.println(num3);
		System.out.println(num1 + num2*num3 - 10);
		System.out.println((num1 + num2)*num3 - 10);
	}

}
