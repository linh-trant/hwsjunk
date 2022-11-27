import java.util.Scanner;
public class Week4Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Type your string you want to convert: ");
		String text = input.nextLine();
		String pali = "";
		String code = "";
		String ans = "";
		int carry = 0;
		
		for (int i=0; i<text.length(); i++) {
			pali = pali + text.charAt(text.length()-i-1);
			int convert = (int)text.charAt(i) + 3;
			if (convert > 122) {
				convert = convert - 26;
			}
			code = code + (char)convert;
		}
		
		System.out.println("Your Palindrome string is: " + pali);
		System.out.println("Your encode string is: " + code);
		
		System.out.println("Type your number: ");
		String num1 = input.nextLine();
		String num2 = input.nextLine();
		
		if (num1.length() > num2.length()) {
			while (num1.length()>num2.length()) {
				num2 = "0" + num2;
			}
		} else if (num2.length() > num1.length()) {
			while (num2.length()>num1.length()) {
				num1 = "0" + num1;
			}
		}
		
		for (int i=(num1.length()-1); i>=0; i--) {
			int answer = ((int)num1.charAt(i)-48) + ((int)num2.charAt(i)-48) + carry;
			carry = 0;
			if (answer > 9) {
				carry++;
				answer = answer % 10;
			}
			ans = (char)(answer + 48) + ans;
		}
		
		if (carry>0) { 
			ans = "1" + ans;
		}
		
		System.out.println("The sum of two number is: " + ans);
	}
	
}
