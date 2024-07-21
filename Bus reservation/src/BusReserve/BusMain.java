package BusReserve;
import java.util.*;
public class BusMain {

	public static void main(String[] args) {
		ArrayList<Bus> buses=new ArrayList<Bus>();
		ArrayList<Booking> bookings=new ArrayList<Booking>();
		
		buses.add(new Bus(1,2));
		buses.add(new Bus(2,2));
		
		Scanner scan=new Scanner(System.in);
		int num=1;
		
		for(Bus b:buses) {
			b.display();
		}
		
		while(num==1) {
			System.out.println("Enter 1 to book or 2 to exit");
			num=scan.nextInt();
			if(num==1) {
				Booking booking=new Booking();
				if(booking.isAvailable(bookings,buses)) {
					bookings.add(booking);
					System.out.println("Your Booking is confirmed.");
				}
				else {
					System.out.println("Booking is full.Try another bus");
				}
			}
			else {
				System.out.println("Exiting....");
			}
		}
	}

}
