package pojos;


public class HerOkuResponsePojo {

    private int bookingid;
    private HerOkuPojo booking;

    public HerOkuResponsePojo(int bookingid, HerOkuPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }


    public HerOkuResponsePojo() {
    }

    public int getBookingid() {
        return bookingid;
    }

    public HerOkuPojo getBooking() {
        return booking;
    }

    @Override
    public String toString() {
        return "HerOkuResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
























