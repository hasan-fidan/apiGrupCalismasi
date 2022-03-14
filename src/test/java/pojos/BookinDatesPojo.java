package pojos;

public class BookinDatesPojo {

    /** "checkin": "2022-03-01",
     "checkout": "2022-03-11"  */




   private String checkin;
   private String checkout;


    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public BookinDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookinDatesPojo() {
    }


    @Override
    public String toString() {
        return "BookinDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
