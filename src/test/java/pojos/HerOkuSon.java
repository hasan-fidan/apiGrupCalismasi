package pojos;

public class HerOkuSon {


    private int bookingid;
    private HerOkuPojo01 booking;


    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public HerOkuPojo01 getBooking() {
        return booking;
    }

    public void setBooking(HerOkuPojo01 booking) {
        this.booking = booking;
    }

    public HerOkuSon(int bookingid, HerOkuPojo01 booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public HerOkuSon() {
    }

    @Override
    public String toString() {
        return "HerOkuSon{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
