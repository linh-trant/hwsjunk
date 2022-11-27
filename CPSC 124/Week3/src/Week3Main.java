import java.util.Scanner;
public class Week3Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your birthday (mm/dd/yyyy)?: ");
		String birthdayText = input.nextLine();
				
		int birthmonth = Integer.parseInt(birthdayText.substring(0, birthdayText.indexOf('/')));
		int birthday = Integer.parseInt(birthdayText.substring((birthdayText.indexOf('/') + 1), birthdayText.lastIndexOf('/')));
		int birthyear = Integer.parseInt(birthdayText.substring(birthdayText.lastIndexOf('/') + 1));
		
		//System.out.println(birthday + " " + birthmonth + " " + birthyear);
		//Today is (9/8/2022)
		
		int age = 2022 - birthyear;
		if (birthmonth > 9) {
			age--;
		} else if (birthmonth == 9 && birthday > 8) {
			age--;
		}
		System.out.println("Your age is " + age);
		
		System.out.println("Rock (r), paper (p) or scissor (s)?: ");
		String player = input.nextLine();
		
		int move = (int)(Math.random()*3);
		
		if (move==0) {
			
			System.out.println("The computer gave rock!");
			if (player.equals("r")) {
				System.out.println("DRAW!");
			} else if (player.equals("p")) {
				System.out.println("YOU WIN!");
			} else System.out.println("YOU LOOSE!");
			
		} else if (move==1) {
			
			System.out.println("The computer gave paper!");
			if (player.equals("r")) {
				System.out.println("YOU LOOSE!");
			} else if (player.equals("p")) {
				System.out.println("DRAW!");
			} else System.out.println("YOU WIN!");
			
		} else if (move==2){
			
			System.out.println("The computer gave scissor!");
			if (player.equals("r")) {
				System.out.println("YOU WIN!");
			} else if (player.equals("p")) {
				System.out.println("YOU LOOSE!");
			} else System.out.println("DRAW!");
			
		}
		
	}
}
