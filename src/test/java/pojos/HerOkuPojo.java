package pojos;

public class HerOkuPojo {

    /**
     * { "firstname": "Ali",
     "lastname": "Can",
     "totalprice": 500,
     "depositpaid": true,
     "bookingdates": {
     "checkin": "2022-03-01",
     "checkout": "2022-03-11"
     }
     }*/


  private String firstname;
  private String lastname;
  private int totalprice;
  private boolean depositpaid;
  private BookinDatesPojo bookingdates;



  /** getter ve setter methodlari */


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookinDatesPojo getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookinDatesPojo bookingdates) {
        this.bookingdates = bookingdates;
    }


    public HerOkuPojo(String firstname, String lastname, int totalprice, boolean depositpaid, BookinDatesPojo bookingdates) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
    }


    public HerOkuPojo() {
    }

    @Override
    public String toString() {
        return "HerOkuPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                '}';
    }




}
