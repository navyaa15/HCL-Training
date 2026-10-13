package Assignment.model;

public class Book extends LibraryItem implements Borrowable {

    private String author;

    public Book(String title, int year, boolean available, String author) {
        super(title, year, available);
        this.author = author;
    }

    @Override
    public void borrow() throws ItemNotAvailableException {
        if (!isAvailable()) {
            throw new ItemNotAvailableException("Book is not available.");
        }
        setAvailable(false);
    }

    @Override
    public void returnItem() {
        setAvailable(true);
    }

    public String getAuthor() {
        return author;
    }
}
