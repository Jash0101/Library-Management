import java.util.ArrayList;

public class User {
    String name;
    ArrayList<Book> issuedBooks;

    public User(String name) {
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public void issueBook(Book book) {
        issuedBooks.add(book);
        book.issueBook();
        System.out.println(name + " issued: " + book.title);
    }

    public void returnBook(Book book) {
        if (issuedBooks.remove(book)) {
            book.returnBook();
            System.out.println(name + " returned: " + book.title);
        } else {
            System.out.println("This book was not issued by " + name);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
