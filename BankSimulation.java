package internTasks;

import java.util.ArrayList;
import java.util.Scanner;

class Account
{
	private String accountHolderName;
	private long accountNumber;
	private double balance;
	private ArrayList<String> transactions;
	
	public Account(String aH, long aN, double initialdeposit)
	{
		accountHolderName = aH;
		accountNumber = aN;
		balance = initialdeposit;
		transactions = new ArrayList<>();
		transactions.add("Account opened with deposit: rs."+ initialdeposit);
	}
	public void deposit(double amount)
	{
		if(amount>0){
			balance+=amount;
			transactions.add("Deposited: Rs."+amount);
			System.out.println("Succesfully Deposited Rs."+amount);
		}else {
			System.out.println("Invalid deposit amount.");
		}
	}
	public void withdraw(double amount)
	{
		if(amount>0 && amount<=balance) {
			balance-=amount;
			transactions.add("withdrawn: Rs."+amount);
			System.out.println("Successfully withdrawn: Rs."+amount);
		}else {
			System.out.println("Insufficient balance or invlaid amount.");
		}
	}
	public void showbalance()
	{
		System.out.println("Current Balance: Rs."+balance);
	}
	public void showtransaction()
	{
		System.out.println("Transaction History:");
		for(String t : transactions)
		{
			System.out.println(" - "+t);
		}
	}
}

public class BankSimulation 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		// Create an account
		System.out.print("Enter account holder name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter account number: ");
		long accNum = sc.nextLong();
		
		System.out.print("Enter initial deposit: ");
		double deposit = sc.nextDouble();
		
		Account acc = new Account(name, accNum, deposit);
		
		int choice;
		do {
			System.out.println("\n ----- Bank Menu -----");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Show Balance");
			System.out.println("4. Show Transactions");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			choice =sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.print("Enter amount to deposit: ");
					double dep = sc.nextDouble();
					acc.deposit(dep);
					break;
				case 2:
					System.out.print("Enter amount to withdraw: ");
					double withdraw = sc.nextDouble();
					acc.withdraw(withdraw);
					break;
				case 3:
					acc.showbalance();
					break;
				case 4:
					acc.showtransaction();
					break;
				case 5:
					System.out.println("Exiting... Thank you!");
					break;
				default:
					System.out.println("Invalid choice.");
			}
		}while(choice !=5);
		sc.close();
	}
}