package Assignment.model;

import java.util.ArrayList;

public class Member {

    private int memberId;
    private String name;
    private ArrayList<LibraryItem> borrowedItems;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        borrowedItems = new ArrayList<>();
    }

    public void borrowItem(LibraryItem item)
            throws BorrowLimitExceededException {

        if (borrowedItems.size() >= 3) {
            throw new BorrowLimitExceededException(
                    "Borrow limit exceeded.");
        }

        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
}
