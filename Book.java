public class Book {
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void issueBook() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    public String getStatus() {
        return isIssued ? "Issued" : "Available";
    }

    @Override
    public String toString() {
        return title + " by " + author + " [" + getStatus() + "]";
    }
}
