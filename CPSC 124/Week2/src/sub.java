import java.util.Scanner;
public class sub {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// TODO Auto-generated method stub
		int slashIndex = birthdayText.lastIndexOf('/');
		String birthyearText = birthdayText.substring(slashIndex+1);
		System.out.println(birthyearText);
		int birthyear = Integer.parseInt(birthyearText);
		int age = 2022-birthyear;
	}

}
