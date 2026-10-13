package Assignment.model;
abstract class LibraryItem {

    private static int counter = 1001;

    private int id;
    private String title;
    private int year;
    private boolean available;

    public LibraryItem(String title, int year, boolean available) {
        if (year < 1900 || year > 2026) {
            throw new IllegalArgumentException(
                    "Year must be between 1900 and 2026"
            );
        }

        this.id = counter++;
        this.title = title;
        this.year = year;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

