package BusReserve;
import java.util.*;
import java.text.*;
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter passenger name: ");
		passengerName=scan.nextLine();
		System.out.println("Enter bus no: ");
		busNo=scan.nextInt();
		System.out.println("Enter date dd-mm-yyyy ");
		String dateInput=scan.next();
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean isAvailable(ArrayList<Booking> bookings,ArrayList<Bus> buses) {
		int capacity=0;
		
		for(Bus bus:buses) {
			if(bus.getBusNo() == busNo) capacity=bus.getCapacity();
		}
		
		int Booked=0;
		for(Booking b:bookings) {
			if(b.busNo == busNo && b.date.equals(date)) Booked++;
		}
		
		return Booked < capacity ? true : false;
	}
}
