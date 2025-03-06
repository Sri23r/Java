import java.util.Scanner;

public class BankAccount {
	int balance;
	int previousTransaction;
	
	String customerName;
	String customerId;
	
	public BankAccount(String cname, String cid) {
		customerName=cname;
		customerId=cid;
	}
	
	void deposit(int amount) {
		if(amount!=0) {
			balance+=amount;
			previousTransaction=amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount!=0) {
			balance-=amount;
			previousTransaction=-amount;
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction>0) {
			System.out.println("Deposited : "+previousTransaction);
		}
		else if(previousTransaction<0){
			System.out.println("Withdrawn : "+Math.abs(previousTransaction));
		}
		else {
			System.out.println("No Transaction is occured!");
		}
	}
	
	void showMenu() {
		char option='\0';
		Scanner sc=new Scanner(System.in);
		
		System.out.println();
		System.out.println("**********************");
		System.out.println("Welcome "+customerName);
		System.out.println("Your ID is "+customerId);
		System.out.println();
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do {
			System.out.println("=============================");
			System.out.println("Enter your Option");
			System.out.println("=============================");
			option=sc.next().toUpperCase().charAt(0);
			
//			Character.toUpperCase(option);
			
			switch(option) {
				case 'A' :
					System.out.println("=============================");
					System.out.println("Balance is "+balance);
					System.out.println("=============================");
					System.out.println();
					showMenu();
					break;
				
				case 'B':
					System.out.println("=============================");
					System.out.println("Enter the amount to deposit");
					System.out.println("=============================");
					int amount1=sc.nextInt();
					deposit(amount1);
					System.out.println();
					showMenu();
					break;
					
				case 'C':
					System.out.println("=============================");
					System.out.println("Enter the amount to get withraw");
					System.out.println("=============================");
					int amount2=sc.nextInt();
					withdraw(amount2);
					System.out.println();
					showMenu();
					break;
					
				case 'D':
					System.out.println("=============================");
					getPreviousTransaction();
					System.out.println("=============================");
					System.out.println();
					showMenu();
					break;
					
				case 'E':
					System.out.println("Application exited..!");
					sc.close();
					System.exit(0);
					
				default:
					System.out.println("Invalid Option! Please Try again..");
					showMenu();
					break;
			}
		}while(true);
	}
}
