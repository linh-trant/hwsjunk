import java.util.Scanner;
public class Week6main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String[][] player = new String[6][6];
		String[][] cpu = new String[6][6];
		String[][] display = new String[6][6];
		int vertical = 0;
		int horizontal = 0;
		int hitNumberCPU = 9;
		int hitNumberPlayer = 9;
		boolean endCPU = false;
		boolean endPlayer = false;
		
		for (int i=0; i<6; i++) {
			for (int j=0; j<6; j++) {
				player[i][j] = "*";
				cpu[i][j] = "*";
				display[i][j] = "*";
			}
		}
		
		for (int i=0; i<3; i++) {
			int head = (int)(Math.random()*2);
			
			if (head == 0) {
				do {
					vertical = (int)(Math.random()*4);
					horizontal = (int)(Math.random()*6);
				} while (cpu[horizontal][vertical] == "S" || cpu[horizontal][vertical+1] == "S" || cpu[horizontal][vertical+2] == "S");
				cpu[horizontal][vertical] = "S";
				cpu[horizontal][vertical+1] = "S";
				cpu[horizontal][vertical+2] = "S";
			} else {
				do {
					vertical = (int)(Math.random()*6);
					horizontal = (int)(Math.random()*4);
				} while (cpu[horizontal][vertical] == "S" || cpu[horizontal+1][vertical] == "S" || cpu[horizontal+2][vertical] == "S");
				cpu[horizontal][vertical] = "S";
				cpu[horizontal+1][vertical] = "S";
				cpu[horizontal+2][vertical] = "S";
			}
		}
		
		for (int i=0; i<3; i++) {
			int head = (int)(Math.random()*2);
			
			if (head == 0) {
				do {
					vertical = (int)(Math.random()*4);
					horizontal = (int)(Math.random()*6);
				} while (player[horizontal][vertical] == "S" || player[horizontal][vertical+1] == "S" || player[horizontal][vertical+2] == "S");
				player[horizontal][vertical] = "S";
				player[horizontal][vertical+1] = "S";
				player[horizontal][vertical+2] = "S";
			} else {
				do {
					vertical = (int)(Math.random()*6);
					horizontal = (int)(Math.random()*4);
				} while (player[horizontal][vertical] == "S" || player[horizontal+1][vertical] == "S" || player[horizontal+2][vertical] == "S");
				player[horizontal][vertical] = "S";
				player[horizontal+1][vertical] = "S";
				player[horizontal+2][vertical] = "S";
			}
		}
		
		while (!endCPU && !endPlayer) {
			for (int i=0; i<6; i++) {
				for (int j=0; j<6; j++) {
					System.out.print(display[i][j] + " ");
				}
				System.out.print("   ");
				for (int j=0; j<6; j++) {
					System.out.print(player[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.println("Where do you want to hit? ");
			String hit = input.nextLine();
			String[] hitPlace = hit.split(",", 2);
			while (Integer.parseInt(hitPlace[0])<0 || Integer.parseInt(hitPlace[0])>5 || Integer.parseInt(hitPlace[1])<0 || Integer.parseInt(hitPlace[1])>5) {
				System.out.println("Please choose 0 <= row <6 and 0 <= column < 6. Where do you want to hit? ");
				hit = input.nextLine();
				hitPlace = hit.split(",", 2);
			}
			if (cpu[Integer.parseInt(hitPlace[0])][Integer.parseInt(hitPlace[1])].equals("S")) {
				display[Integer.parseInt(hitPlace[0])][Integer.parseInt(hitPlace[1])] = "O";
				hitNumberCPU--;
			} else display[Integer.parseInt(hitPlace[0])][Integer.parseInt(hitPlace[1])] = "X";
			
			do {
				vertical = (int)(Math.random()*6);
				horizontal = (int)(Math.random()*6);
			} while (player[horizontal][vertical].equals("X") || player[horizontal][vertical].equals("O"));
			
			if (player[horizontal][vertical].equals("S")) {
				player[horizontal][vertical] = "O";
				hitNumberPlayer--;
			} else player[horizontal][vertical] = "X";
			
			if (hitNumberCPU == 0) endPlayer = true;
			if (hitNumberPlayer == 0) endCPU = true;
			
			//System.out.println(hitNumberCPU);
		}
		if (endPlayer == true) System.out.println("YOU WIN!");
		if (endCPU == true) System.out.println("YOU LOST!");
	}

}