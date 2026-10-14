//package Assignment.model;
//
//public class DVD extends LibraryItem implements Borrowable {
//
//    private int duration;
//
//    public DVD(String title, int year, boolean available, int duration) {
//        super(title, year, available);
//        this.duration = duration;
//    }
//
//    @Override
//    public void borrow() throws ItemNotAvailableException {
//        if (!isAvailable()) {
//            throw new ItemNotAvailableException("DVD is not available.");
//        }
//        setAvailable(false);
//    }
//
//    @Override
//    public void returnItem() {
//        setAvailable(true);
//    }
//
//    public int getDuration() {
//        return duration;
//    }
//}
//`
