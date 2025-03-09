import java.util.*;
class Book{
	private String title;
	private String author;
	private boolean isAvailable;
	
	public Book(String title,String author) {
		this.title=title;
		this.author=author;
		this.isAvailable=true;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean available) {
		isAvailable=available;
	}
}

class Library{
	ArrayList<Book> books=new ArrayList<>();
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void displayAvailableBooks() {
		System.out.println("Available Books : ");
		for(Book book : books) {
			if(book.isAvailable()) {
				System.out.println(book.getTitle()+" by "+book.getAuthor());
			}
		}
	}
	public void lendBook(String title) {
		for(Book book : books) {
			if(book.getTitle().equals(title) && book.isAvailable()) {
				book.setAvailable(false);
				System.out.println("Book "+title+" has been lend");
				return;
			}
		}
		 System.out.println("Sorry, the requested book is not available.");
	}
	public void returnBook(String title) {
		for(Book book : books) {
			if(book.getTitle().equals(title) && !book.isAvailable()) {
				book.setAvailable(true);
				System.out.println("Book "+title+" has been returned..");
				return;
			}
		}
		System.out.println("Invalid book title or book is already available.");
	}
	
}
public class libproj {
	public static void main(String[] args) {
		Library library=new Library();
		library.addBook(new Book("Harry Potter","J.K.Rowling"));
		library.addBook(new Book("The power of Your Subconscious Mind","joseph Murphy"));
		library.addBook(new Book("YOU CAN WIN","Shiv Khera"));
		
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("-------------------------");
			System.out.println("\n1. Display Available Books");
			System.out.println("2. Lend a Book");
			System.out.println("3. Return a Book");
			System.out.println("4. Exit");
			System.out.print("Enter your choice:");
			int choice=scan.nextInt();
			scan.nextLine();
			
			switch(choice) {
				case 1:
					library.displayAvailableBooks();
					break;
				case 2:
					System.out.println("Enter the title of the book you want to lend: ");
					String lendTitle=scan.nextLine();
					library.lendBook(lendTitle);
					break;
				case 3:
					System.out.println("Enter the title of the book you want return: ");
					String returnTitle=scan.nextLine();
					library.returnBook(returnTitle);
					break;
				case 4:
					System.out.println("Exiting...!");
					System.exit(0);
				default:
					System.out.println("Invalid choice. Please enter a number between 1 to 4");
			}
		}
	}
}
