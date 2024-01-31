package com.atm.function;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FunctionsOfAnAtm {
		Scanner input = new Scanner(System.in);
		long accNo;
		int pinNo,temp1,temp2,choice;
		double accountBalance = 275431.82;
		double balance = 0;
		
			boolean accountDetails() {
			System.out.println("Enter Your Account Number");
			accNo = input.nextInt();
			System.out.println("Enter Your 4 Digit PIN");
			pinNo = input.nextInt();
			
			  try { 
				  accNo = input.nextInt();
			  } 
			  catch(InputMismatchException ime) {
				  System.out.println("Account Number contains only Numerical values");
				  accountDetails(); 
			 }
			 
			return true;
		}
		public void welcomeMessage() {
			System.out.println("Welcome To G Bank");
			accountDetails();
			System.out.println("\n"+"1. Withdraw"+"\n"+"2. Deposit"+"\n"+"3. Balance Enquiry"+"\n"+"4. Generate PIN"+"\n"+"5. Change PIN"+"\n"+"6. Clear Session");
			choice = input.nextInt();
			switch(choice) {
			case 1:
				withdraw();
				break;
			case 2:
				deposit();
				break;
			case 3:
				balanceEnquiry();
				break;
			}
		}
		
		void withdraw() {
			System.out.println("1. Current"+"\n"+"2. Savings");
			int option = input.nextInt();
			switch(option) {
			case 1:
				current();
				break;
			case 2:
				savings();
				break;
			}
		}
		
		void current() {
			System.out.println("Enter Money to withdraw");
			double withdrawCurrent = input.nextDouble();
			if(withdrawCurrent<=accountBalance) {
			balance = accountBalance - withdrawCurrent;
			System.out.println("Withdraw successfull");
			System.out.println("Remaing account balance = "+balance);
			endMessage();
			}
			else {
				System.out.println("Insufficient Balance");
				System.out.println("Account Balance = "+accountBalance);
			}
		}
		
		void savings() {
			System.out.println("Enter Money to withdraw");
			double withdrawSavings = input.nextDouble();
			if(withdrawSavings<=accountBalance) {
			balance = accountBalance - withdrawSavings;
			System.out.println("Withdraw successfull");
			System.out.println("Remaing account balance = "+balance);
			endMessage();
			}
			else {
				System.out.println("Insufficient Balance");
				System.out.println("Account Balance = "+accountBalance);
			}
		}
		
		void endMessage() {
			System.out.println("Thanks for using G Bank");
			System.exit(0);
		}
		
		void deposit() {
			System.out.println("Enter the amount to deposit");
			double depositedAmount = input.nextDouble();
			balance = accountBalance + depositedAmount;
			System.out.println("Your Account is credited with "+"Rs."+depositedAmount);
			System.out.println("Account Balance = "+balance);
			endMessage();
		}
		
		void balanceEnquiry() {
			
		}
}
