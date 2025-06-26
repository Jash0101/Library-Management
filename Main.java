import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Show Books");
            System.out.println("4. Show Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String username = sc.nextLine();
                    library.addUser(new User(username));
                    break;
                case 3:
                    library.showBooks();
                    break;
                case 4:
                    library.showUsers();
                    break;
                case 5:
                    library.showUsers();
                    System.out.print("Select user index: ");
                    int issueUserIndex = sc.nextInt() - 1;
                    sc.nextLine();
                    User issueUser = library.getUserByIndex(issueUserIndex);

                    System.out.print("Enter book title to issue: ");
                    String bookTitle = sc.nextLine();
                    Book bookToIssue = library.findBookByTitle(bookTitle);

                    if (issueUser != null && bookToIssue != null && !bookToIssue.isIssued) {
                        issueUser.issueBook(bookToIssue);
                    } else {
                        System.out.println("Issue failed. Check book availability or user selection.");
                    }
                    break;
                case 6:
                    library.showUsers();
                    System.out.print("Select user index: ");
                    int returnUserIndex = sc.nextInt() - 1;
                    sc.nextLine();
                    User returnUser = library.getUserByIndex(returnUserIndex);

                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    Book bookToReturn = library.findBookByTitle(returnTitle);

                    if (returnUser != null && bookToReturn != null && bookToReturn.isIssued) {
                        returnUser.returnBook(bookToReturn);
                    } else {
                        System.out.println("Return failed. Book not found or not issued.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
