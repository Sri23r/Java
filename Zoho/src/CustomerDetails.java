import java.util.*;
public class CustomerDetails {
	private static int customerId=0;
	private static int accountNumber=100;
	
	int custId=0;
	int accNo=100;
	String name;
	int balance;
	int previousTransaction;
//	String password;
	String encryptPass;
	
	Scanner sc;
	
	public CustomerDetails(){
		sc=new Scanner(System.in);
		this.custId=++customerId;
		this.accNo=++accountNumber;
//		System.out.println(this.custId+" "+this.accNo);
		System.out.print("Enter your Name : ");
		setName(sc.nextLine());
		setBalance();
		boolean check=true;
		String pass="";
		while(check) {
			System.out.print("Enter your Password : ");
			pass=sc.nextLine();
			System.out.print("Re-Type password : ");
			String rePass=sc.nextLine();
			if(checkPassword(pass,rePass)) {
				check=false;
			}
			System.out.println();
		}
//		setPassword(pass);
		encryptPassword(pass);
	}
	
	public CustomerDetails(int CustId,int AccNo,String name,String password) {
		this.name=name;
		this.encryptPass=password;
		this.custId=CustId;
		this.accNo=AccNo;
		this.balance=10000;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setBalance() {
		this.balance=10000;
	}
	
//	public void setPassword(String password) {
//		this.password=password;
//	}
	
	public boolean checkPassword(String pass,String rePassword) {
		return pass.equals(rePassword);
	}
	
	public void encryptPassword(String Originalpassword) {
		String encrypt="";
		for(char c : Originalpassword.toCharArray()) {
			if(Character.isDigit(c)) {
				if(c=='9')c='0';
				else c++;
			}
			if(Character.isLetter(c)) {
				if(Character.isUpperCase(c)) {
					if(c=='Z')c='A';
					else c++;
				}
				else {
					if(c=='z')c='a';
					else c++;
				}
			}
			encrypt+=c;
		}
		this.encryptPass=encrypt;
	}
	
	public void display() {
		
		String line="+===================================+";
		String format="|%-35s|\n";
		System.out.println(line);
		System.out.printf(format," Customer_Id : "+this.custId);
		System.out.printf(format," Account_Number : "+this.accNo);
		System.out.printf(format," Customer_Name : "+this.name);
		System.out.printf(format," Balance : "+this.balance);
		System.out.println(line);
		System.out.println();
	}
}
