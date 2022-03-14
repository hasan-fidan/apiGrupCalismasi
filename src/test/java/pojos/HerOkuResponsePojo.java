package pojos;

public class HerOkuResponsePojo {


    private int bookingid;
    private HerOkuPojo booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public HerOkuPojo getBooking() {
        return booking;
    }

    public void setBooking(HerOkuPojo booking) {
        this.booking = booking;
    }


    public HerOkuResponsePojo(int bookingid, HerOkuPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public HerOkuResponsePojo() {
    }


    @Override
    public String toString() {
        return "HerOkuResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
