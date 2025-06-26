import java.util.ArrayList;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.title);
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("Added user: " + user.name);
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Books in Library:");
        for (Book b : books) {
            System.out.println("- " + b);
        }
    }

    public void showUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in the system.");
            return;
        }
        System.out.println("Registered Users:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).name);
        }
    }

    public Book findBookByTitle(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public User getUserByIndex(int index) {
        if (index >= 0 && index < users.size()) {
            return users.get(index);
        }
        return null;
    }
}
