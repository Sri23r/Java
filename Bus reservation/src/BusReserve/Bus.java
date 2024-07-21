package BusReserve;

public class Bus {
	private int busNo;
	private int capacity;
	
	Bus(int busNo,int cap){
		this.busNo=busNo;
		this.capacity=cap;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int cap) {
		capacity=cap;
	}
	 
	public int getBusNo() {
		return busNo;
	}
	
	public void display() {
		System.out.println("Bus number: "+busNo+" Capacity: "+capacity);
	}
}
