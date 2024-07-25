import java.util.*;
class DB{
	static final int initialCapacity=3;
	private int[] arr;
	private int size;
	private int capacity;
	
	
	DB(){
		size=0;
		arr=new int[initialCapacity];
		capacity=initialCapacity;
	}
	
	public void add(int val) {
		if(size==capacity) {
			expandArray();
		}
		arr[size++]=val;
	}
	
	private void expandArray() {
		capacity*=2;
		arr=Arrays.copyOf(arr, capacity);
	}
	
	public void display() {
		for(int i=0;i<size;i++)
			System.out.print(arr[i]+" ");
	}
	
	public void insertAtPos(int pos,int val) {
		if(size==capacity) expandArray();
		for(int i=size-1;i>=pos;i--) {
			arr[i+1]=arr[i];
		}
		arr[pos]=val;
		size++;
	}
	
	public void deleteAtPos(int pos) {
		for(int i=pos+1;i<size;i++) {
			arr[i-1]=arr[i];
		}
		size--;
		if(capacity>initialCapacity && capacity>3*size) {
			shrinkArray();
		}
	}
	
	private void shrinkArray() {
		capacity/=2;
		arr=Arrays.copyOf(arr, capacity);
	}
	
	public void deleteAtEnd() {
		size--;
	}
	
	public void deleteAtBegin() {
		for(int i=1;i<size;i++)
			arr[i-1]=arr[i];
		size--;
	}
	
	public void insertAtBegin(int val) {
		if(size==capacity)
			expandArray();
		for(int i=size+1;i>0;i--)
			arr[i]=arr[i-1];
		arr[0]=val;
		size++;
	}
	
	public int sizeOfArray() {
		System.out.println("Capacity: "+capacity);
		System.out.print("Size of Array: ");
		return size;
	}
	
	public int getIndex(int index) {
		return arr[index];
	}
	
	public void update(int index,int val) {
		arr[index]=val;
	}
	
	public int searchIndex(int val) {
		for(int i=0;i<size;i++) {
			if(arr[i]==val) return i;
		}
		System.out.print("The given value is not in the List(displayed as -1): ");
		return -1;
	}
	
	public boolean contains(int val) {
		for(int i=0;i<size;i++) {
			if(arr[i]==val) return true;
		}
		return false;
	}
	
	public void clear() {
		size=0;
	}
}
public class DynamicArray {

	public static void main(String[] args) {
		int val,pos,index;
		DB list=new DB();
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("\n--------List Menu--------");
			System.out.println("1.Insert at End");
			System.out.println("2.Display the List");
			System.out.println("3.Insert at Specified position");
			System.out.println("4.Delete from Specified position");
			System.out.println("5.Delete at End");
			System.out.println("6.Delete at Beginning");
			System.out.println("7.Insert at Beginning");
			System.out.println("8.Size of Array");
			System.out.println("9.Get value in an array");
			System.out.println("10.Update index");
			System.out.println("11.Check if the value is in the List");
			System.out.println("12.Clear the List");
			System.out.println("13.Exit");
			System.out.println("-------------------------");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:System.out.println("Enter the data: ");
				   val=scan.nextInt();
				   list.add(val);
				   break;
			case 2:list.display();
				   break;
			case 3:System.out.println("Enter the position(starts from 0): ");
				   pos=scan.nextInt();
				   System.out.println("Enter the data: ");
				   val=scan.nextInt();
				   list.insertAtPos(pos,val);
				   break;
			case 4:System.out.println("Enter the position(starts from 0): ");
				   pos=scan.nextInt();
				   list.deleteAtPos(pos);
				   break;
			case 5:list.deleteAtEnd();
				   break;
			case 6:list.deleteAtBegin();
				   break;
			case 7:System.out.println("Enter the data: ");
				   val=scan.nextInt();
				   list.insertAtBegin(val);
				   break;
			case 8:System.out.println(list.sizeOfArray());
				   break;
			case 9:System.out.println("Enter the index(starts from 0):");
				   index=scan.nextInt();
				   if(index<0) {
					   System.out.println("Invalid index");
					   break;
				   }
				   System.out.println(list.getIndex(index));
				   break;
			case 10:System.out.println("Enter index:");
				    index=scan.nextInt();
				    System.out.println("Enter value:");
				    val=scan.nextInt();
				    list.update(index, val);
				    break;
			case 11:System.out.println("Enter the value:");
				    val=scan.nextInt();
				    System.out.println(list.contains(val));
				    break;
			case 12:list.clear();
				    break;
			case 13:System.exit(0);	   
			}
		}
	}

}
