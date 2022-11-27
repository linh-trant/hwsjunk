import java.util.Scanner;
public class test {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
			System.out.println("input:");
			String text = input.nextLine();
			int num = Integer.parseInt(text);
			if ((num%2 == 0 && num%3 != 0) || (num%3 == 0 && num%2 != 0)){
				System.out.println("hello");
			} else if (num%2 == 0 && num%3 == 0){
				System.out.println("world");
			}
	}
}
