import java.util.Arrays;
import java.util.Scanner;
public class Week5Main {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean five = false;
		int sum = 0;
		
		int[] arr = new int[10];
		int[] reverse = new int[10];
		int[] shift = new int[10];
		int[] hash = new int[12];
		boolean seq = false;
		boolean[] hashSeq = new boolean[12];

		for (int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10);
			reverse[i] = arr[i];
			if (arr[i]==5) five = true;
			sum = sum + arr[i];
			hash[arr[i]]++;
			if (i>0 && arr[i]==arr[i-1]) seq = true;
		}
		System.out.println("Your random array is " + Arrays.toString(arr));
		
		if (!five) System.out.println("There is no 5 in the array");
		else System.out.println("There is 5 in the array");
		
		for (int i=0; i<(arr.length/2); i++) {
			int mid = reverse[i];
			reverse[i] = reverse[arr.length-1-i];
			reverse[arr.length-1-i] = mid;
		}
		
		System.out.println("Your reverse array is " + Arrays.toString(reverse));
		System.out.println("The sum of the array is "+ sum);
		
		for (int i=0; i<=10; i++) {
			if (hash[i]>1) System.out.println(i + " is duplicated");
			else if (hash[i]==0) System.out.println("There is no " + i);
		}
		
		//extra credit
		for (int i=0; i<arr.length; i++) {
			if (i+3<arr.length) shift[i+3] = arr[i];
			else shift[i+3-arr.length] = arr[i];
		}
		
		System.out.println("The shifted array is " + Arrays.toString(shift));
		
		if (!seq) System.out.println("There is no sequence in this array");
		else {			
			System.out.println("The sequence in the array is ");
			for (int i=0; i<arr.length-1; i++) {
				if (arr[i]==arr[i+1]) {
					System.out.print(arr[i] + ", ");
					hashSeq[arr[i]] = true;
				}
				if (arr[i]!=arr[i+1] && hashSeq[arr[i]] == true) {
					System.out.print(arr[i]);
					hashSeq[arr[i]] = false;
					System.out.println();
				}
			}
			if (arr[arr.length-1] == arr[arr.length-2]) System.out.println(arr[arr.length-1]);
	
		}
	}
}
