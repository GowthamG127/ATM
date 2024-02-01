package com.atm.function;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FunctionsOfAnAtm {
	Scanner input = new Scanner(System.in);
	long accNo;
	int pinNo,choice;
	protected final double accountBalance = 122715.16;
	double balance = 0;

		void accountNumber() {
		// If a new customer need to set PIN,user must enter the account number to set the PIN
		// If the account number contains any character ,it will terminate the program.
		System.out.println("Enter Your Account Number");
		try {
			accNo = input.nextInt();
			if (accNo<=1000000000) {
				return ;
			}
		} catch (InputMismatchException ime) {
			System.out.println("Account Number must be 10 Digit and contains only Numerical values");
			System.exit(0);
		}	
	}

	public void welcomeMessage() {
		System.out.println();
		System.out.println("Welcome To G Bank");
		System.out.println("=========================================");
		System.out.println("1. Existing Customer" + "\n" + "2. New Customer");
		int customerType = input.nextInt();
		System.out.println("=========================================");
		if (customerType == 1) {
			accountNumber();
			// Getting Pin Number here is only for existing customers
			System.out.println("Enter Your 4 Digit PIN");
			pinNo = input.nextInt();
			if(pinNo<=9999) {
				functionOfAtm();
			}
			else {
				System.out.println("PIN Number must be 4 digit");
				System.exit(0);
			}
			
		} 
		else if (customerType == 2) {
			accountNumber();
			generatePin();
			functionOfAtm();
		} 
		else {
			System.out.println("=========================================");
			System.out.println("Entered Invalid Input");
			System.out.println("Timeout");
			System.exit(0);
		}
	}

	void functionOfAtm() {
		System.out.println("=========================================");
		System.out.println("\n" + "1. Withdraw" + "\n" + "2. Deposit" + "\n" + "3. Balance Enquiry" + "\n"
				+ "4. Generate PIN" + "\n" + "5. Change PIN" + "\n" + "6. Clear Session");
		choice = input.nextInt();
		System.out.println("=========================================");
		switch (choice) {
		case 1:
			withdraw();
			break;
		case 2:
			deposit();
			break;
		case 3:
			balanceEnquiry();
			break;
		case 4:
			//An existing customer cannot generate PIN
			if (accNo == 0 && pinNo == 0) {
				generatePin();
			} 
			else {
				System.out.println("=========================================");
				System.out.println("You cannot regenerate PIN");
				endMessage();
				System.exit(0);
			}
			break;
		case 5:
			changePin();
			break;
		case 6:
			endMessage();
			System.exit(0);
		}
	}

	void withdraw() {
		// Select the account type either Current or Savings 
		System.out.println("=========================================");
		System.out.println("1. Current" + "\n" + "2. Savings");
		int option = input.nextInt();
		System.out.println("=========================================");
		switch (option) {
		case 1:
			current();
			break;
		case 2:
			savings();
			break;
		case 3:
			System.out.println("Invalid Input");
			endMessage();
			System.exit(0);
		}
	}

	void current() {
		// The withdrawn amount should be equal or less than the balance amount.
				// Otherwise it will show the Note message and terminate from the function
		System.out.println("=========================================");
		System.out.println("Enter Money to withdraw");
		double withdrawCurrent = input.nextDouble();
		System.out.println("=========================================");
		if (withdrawCurrent <= accountBalance) {
			balance = accountBalance - withdrawCurrent;
			System.out.println("Withdraw successfull");
			System.out.println("Your Account is debited with " + "Rs." + withdrawCurrent);
			System.out.println("Remaing account balance = " + balance);
			System.out.println("=========================================");
			endMessage();
		} else {
			System.out.println("=========================================");
			System.out.println("Insufficient Balance");
			System.out.println("Account Balance = " + accountBalance);
		}
	}

	void savings() {
		// The withdrawn amount should be equal or less than the balance amount.
		// Otherwise it will show the Note message and terminate from the function
		System.out.println("=========================================");
		System.out.println("Enter Money to withdraw");
		double withdrawSavings = input.nextDouble();
		System.out.println("=========================================");
		if (withdrawSavings <= accountBalance) {
			balance = accountBalance - withdrawSavings;
			System.out.println("Withdraw successfull");
			System.out.println("Your Account is debited with " + "Rs." + withdrawSavings);
			System.out.println("Remaing account balance = " + balance);
			System.out.println("=========================================");
			endMessage();
		} 
		else {
			System.out.println("=========================================");
			System.out.println("Insufficient Balance");
			System.out.println("Account Balance = " + accountBalance);
		}
	}

	void endMessage() {
		// An end message by the Bank
		System.out.println("-----------------------------------------");
		System.out.println("Thanks for using G Bank");
		System.out.println("-----------------------------------------");
		System.exit(0);
	}

	void deposit() {
		// User can deposit money and it will show the overall balance of the account
		System.out.println("=========================================");
		System.out.println("Enter the amount to deposit");
		double depositedAmount = input.nextDouble();
		balance = accountBalance + depositedAmount;
		System.out.println("Deposit Successfull");
		System.out.println("Your Account is credited with " + "Rs." + depositedAmount);
		System.out.println("Account Balance = " + balance);
		System.out.println("=========================================");
		endMessage();
	}

	void balanceEnquiry() {
		//User just use the method to see the initial balance of the account
		System.out.println("=========================================");
		System.out.println("Account Balance = Rs."+accountBalance);
		endMessage();
		System.exit(0);
	}

	void generatePin() {
		// Generate PIN is only for new customers and it should be 4 Digit
		// After generating PIN user must re-insert the function to proceed further 
		System.out.println("=========================================");
		System.out.println("Please Set the PIN");
		System.out.println("1.  Set New PIN"+"\n"+"2. Exit");
		choice = input.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter your 4 Digit New PIN");
			int newPin = input.nextInt();
			System.out.println("Re-enter your PIN");
			int newPin1 = input.nextInt();
			System.out.println("=========================================");
			if (newPin == newPin1 && newPin<=9999 && newPin1<=9999) {
				pinNo = newPin1;
				System.out.println("You have successfully set your PIN");
			} else {
				System.out.println("PIN number mismatched");
				System.out.println("PIN number should be 4 Digit");
				System.out.println("Kindly visit the nearest G Bank");
				System.exit(0);
			}
			break;
		case 2:
			endMessage();
			System.exit(0);
		}
	}

	void changePin() {
		// Existing customer can change their PIN
		// After changing PIN user must re-insert the function to proceed further 
		System.out.println("=========================================");
		System.out.println("Enter your old PIN");
		int oldPin = input.nextInt();
		if (pinNo == oldPin) {
			generatePin();
		} 
		else {
			System.out.println("=========================================");
			System.out.println("PIN number mismatched");
			System.out.println("Kindly visit the nearest G Bank");
			System.out.println("-----------------------------------------");
			endMessage();
			System.exit(0);
		}
	}
}
