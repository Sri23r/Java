import java.util.*;
public class Main {
	Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<CustomerDetails> arr=new ArrayList<>();
		Show show=new Show();
		CustomerDetails fix1=new CustomerDetails(11,11011,"Kumar","ApipNbjm");
		CustomerDetails fix2=new CustomerDetails(22,22022,"Madhu","Cboljoh");
		CustomerDetails fix3=new CustomerDetails(33,22022,"rahul","dbnqvt");
		
		arr.add(fix1);
		arr.add(fix2);
		arr.add(fix3);
		
		for(CustomerDetails cust : arr) {
			cust.display();
		}
		
		CustomerDetails ob1=new CustomerDetails();
		CustomerDetails ob2=new CustomerDetails();
		arr.add(ob1);
		arr.add(ob2);
		for(CustomerDetails cust : arr) {
			cust.display();
		}
		
		show.showMenu(arr);
	}

}
