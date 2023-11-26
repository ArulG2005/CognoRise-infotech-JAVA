import java.util.Scanner;
public class Library_Catalog_System {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Books book=new Books();
        int num;
        String title,author;
        int stock;
        outer:
        while (true) {
            System.out.println("--------------------------------------------------------");
            System.out.println("");
            System.out.println("");           
            System.out.println("Add Book - 1");
            System.out.println("Delete Book - 2");
            System.out.println("Search Book - 3");
            System.out.println("Ingress no. of Book - 4");
            System.out.println("Update Book - 5");
            System.out.println("Close - 6");
            System.out.println("--------------------------------------------------------");
            System.out.println("");
            System.out.println("");
            num=sc.nextInt();
            
            switch (num) {
                case 1:
                    System.out.println("Enter Book Title ");
                    title=sc.next();
                    System.out.println("Enter Author Name");
                    author=sc.next();
                    System.out.println("Enter number of books");
                    stock=sc.nextInt();
                    book.Add_book(title, author, stock);
                    break;
                case 2:
                    System.out.println("Enter book name");
                    title=sc.next();
                    book.del(title);
                    break;
                case 3:
                        while (true) {
                            System.out.println("Select search option: 1. Title  2. Author  0. Exit");
                            int choice = sc.nextInt();
                
                            if (choice == 1) {
                                System.out.println("Enter the title to search:");
                                String query = sc.next();
                                book.search(query, "title");
                            } else if (choice == 2) {
                                System.out.println("Enter the author name to search:");
                                String query = sc.next();
                                book.search(query, "author");
                            } else if (choice == 0) {
                                System.out.println("Exiting search.");
                                break;
                            } else {
                                System.out.println("Invalid choice. Please enter 1, 2, or 0.");
                            }
                        }
                        break;
                case 4:
                    System.out.println("Enter Book name");
                    title=sc.next();
                    System.out.println("Enter the Stock");
                    stock=sc.nextInt();
                    book.ingstock(title,stock);
                    break;
                case 5:
                    System.out.println("Enter Book Title");
                    title=sc.next();
                    System.out.println("Enter new book ");
                    String newtitle=sc.next();
                    System.out.println("Enter Authour Name ");
                    author=sc.next();
                    System.out.println("Enetr the Stock");
                    stock=sc.nextInt();
                    book.upgrade(title,newtitle,author,stock);
                    break;
                case 6:
                    break outer;
                default:
                    System.out.println("Enetr the correct option 0 - 6");
                    break;
            }
        }
    }
}
