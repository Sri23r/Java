
public class Transaction {
	int balance;
	int previousTransaction;
	
	void deposit(int amount,CustomerDetails cust) {
		cust.balance+=amount;
		cust.previousTransaction=amount;
	}
	
	void withdraw(int amount,CustomerDetails cust) {
		if(amount!=0) {
			cust.balance-=amount;
			cust.previousTransaction=-amount;
		}
	}
	
	void getPreviousTransaction(CustomerDetails cust) {
		if(cust.previousTransaction>0) {
			System.out.println("Deposited "+cust.previousTransaction);
		}
		else if(cust.previousTransaction<0) {
			System.out.println("Withdrawn "+cust.previousTransaction);
		}
		else {
			System.out.println("No Transaction is Occured..!");
		}
	}
	
	
}
