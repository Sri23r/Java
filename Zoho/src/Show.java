import java.util.*;
public class Show {
	Scanner sc=new Scanner(System.in);
	Transaction transaction=new Transaction();
	void showMenu(ArrayList<CustomerDetails> arr) {
		System.out.print("Enter a name : ");
		String matchName=sc.nextLine().toLowerCase();
		char option='\0';
		boolean change=false;
		for(CustomerDetails cust : arr) {
			if(matchName.equals(cust.name.toLowerCase())) {
				menus();
				change=true;
				while(true) {
					String line="=====================================";
					System.out.println(line);
					System.out.println("Enter a Option : ");
					System.out.println(line);
					option=sc.next().toUpperCase().charAt(0);
					sc.nextLine();
					switch(option) {
					case 'A' :
						System.out.println("=============================");
						System.out.println("Balance is "+cust.balance);
						System.out.println("=============================");
						System.out.println();
						menus();
						break;
					
					case 'B':
						System.out.println("=============================");
						System.out.println("Enter the amount to deposit");
						System.out.println("=============================");
						int amount1=sc.nextInt();
						transaction.deposit(amount1,cust);
						System.out.println();
						menus();
						break;
						
					case 'C':
						System.out.println("=============================");
						System.out.println("Enter the amount to get withraw");
						System.out.println("=============================");
						int amount2=sc.nextInt();
						transaction.withdraw(amount2,cust);
						System.out.println();
						menus();
						break;
						
					case 'D':
						System.out.println("=============================");
						transaction.getPreviousTransaction(cust);
						System.out.println("=============================");
						System.out.println();
						menus();
						break;
						
					case 'E':
						break;
						
					case 'F':
						System.out.println("Application exited..!");
						sc.close();
						System.exit(0);
						
					default:
						System.out.println("Invalid Option! Please Try again..");
						menus();
						break;
					}
					if(option=='E')showMenu(arr);
				}
			}
		}
		if(!change) {
			System.out.println("Name not found! Try Again..");
			showMenu(arr);
		}
	}
	
	void menus() {
		System.out.println("***********************************");
		System.out.println();
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Choose another account");
		System.out.println("F. Exit");
		System.out.println("***********************************");
		System.out.println();
	}
}
