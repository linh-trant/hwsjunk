import java.util.Scanner;

public class Week2Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("How much you are willing to invest?:");
		String fundText = input.nextLine();
		double fund = Double.parseDouble(fundText);
		
		System.out.println("What is the annual stock return and infaltion (separated by coma) ?");
		String returnInflation = input.nextLine();
		
		int firstPercentIndex = returnInflation.indexOf('%');
		String stockReturnText = returnInflation.substring(0, firstPercentIndex);
		double stockReturn = Double.parseDouble(stockReturnText)/100;
		
		int commaIndex = returnInflation.indexOf(',');
		int secondPercentIndex = returnInflation.lastIndexOf('%');
		String inflationText = returnInflation.substring(commaIndex+1,secondPercentIndex);
		double inflation = Double.parseDouble(inflationText)/100;
		
		System.out.println("Your funds after invested in stocks for 30 years: ");
		double math = Math.pow(1+(stockReturn-inflation), 30);
		System.out.println(fund*math);
		
		//Extra credit: Beside index.Of(), we can use split() to make a substring. 
		//I search string command on 
		//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html.
		
		//Homework
		
		System.out.println("What is your birthday (in MM/DD/YYYY format)?");
		String birthdayText = input.nextLine();
		
		int slashIndex = birthdayText.lastIndexOf('/');
		String birthyearText = birthdayText.substring(slashIndex+1);
		//System.out.println(birthyearText);
		int birthyear = Integer.parseInt(birthyearText);
		int age = 2022-birthyear;
		
		System.out.println("Your age in 2022 is " + age);
		
		int yearRetirement = 65-age;
		System.out.println("Your funds after invested in stocks when you are 65 years old: ");
		math = Math.pow(1+(stockReturn-inflation), yearRetirement);
		System.out.println(fund*math);
		
		System.out.println("What is your total loan amount, down payment, loan length in month, interest rate (seperated by coma)?");
		String answer = input.nextLine();
		
		int firstCommaIndex = answer.indexOf(',');
		String totalLoanText = answer.substring(0,firstCommaIndex);
		double totalLoan = Double.parseDouble(totalLoanText);
		
		String answer2 = answer.substring(firstCommaIndex+1);
		int secondCommaIndex = answer2.indexOf(',');
		String downPaymentText = answer2.substring(0,secondCommaIndex);
		double downPayment = Double.parseDouble(downPaymentText);
		
		String answer3 = answer2.substring(secondCommaIndex+1);
		int thirdCommaIndex = answer3.indexOf(',');
		String lengthText = answer3.substring(0,thirdCommaIndex);
		double length = Double.parseDouble(lengthText);
		
		int percentIndex = answer3.indexOf('%');
		String interestRateText = answer3.substring(thirdCommaIndex+1,percentIndex);
		double interestRate = Double.parseDouble(interestRateText)/100;
		
		//System.out.println(totalLoan + " " + downPayment + " " + length + " " + interestRate);
		//years: 30 years
		
		System.out.println("Your monthly payment is: ");
		double totalOwned = (totalLoan - downPayment)*(1 + interestRate*(length/12));
		double monthlyPayment = totalOwned/length;
		System.out.println(monthlyPayment);
		
		System.out.println("The amount you will own is: ");
		System.out.println(totalOwned);
		
		//Answer of extra questions
		//1: Should take on the loan. The loan gives you $340000
		//while invest is $324339 in 30 years
		//2: Should invest. The invest gives you $324339, while
		//the loan gives you $250000 in 20 years
	}
}
