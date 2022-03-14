package getHttpRequest;

import baseUrl.HerOkuBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookinDatesPojo;
import pojos.HerOkuPojo;
import pojos.HerOkuResponsePojo;

import java.util.HashMap;

public class HerOkuPojo01 extends HerOkuBaseUrl {
    /**
     https://restful-booker.herokuapp.com/booking
     { "firstname": "Ali",
     "lastname": "Can",
     "totalprice": 500,
     "depositpaid": true,
     "bookingdates": {
     "checkin": "2022-03-01",
     "checkout": "2022-03-11"
     }
     }
     gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,

     */



    @Test
    public void test01() {

        spec.pathParam("parametre1","booking");



        /**  expected data olusturmaliyim  */


        BookinDatesPojo bookingdates = new BookinDatesPojo("2022-03-01","2022-03-11");

        HerOkuPojo expectedData = new HerOkuPojo("Ali","Can",500,true,bookingdates);

        System.out.println("expectedData = " + expectedData);

        Response response = RestAssured.given().
                            contentType(ContentType.JSON).
                            spec(spec).
                            body(expectedData).
                            when().
                            post("/{parametre1}");


        response.prettyPrint();


        HerOkuResponsePojo actualData = response.as(HerOkuResponsePojo.class); // De- Serialization islemi


       System.out.println("actualData = " + actualData);


        Assert.assertEquals(    expectedData.getFirstname(),    actualData.getBooking().getFirstname());
        Assert.assertEquals(    expectedData.getLastname(),     actualData.getBooking().getLastname());
        Assert.assertEquals(    expectedData.getTotalprice(),   actualData.getBooking().getTotalprice());
        Assert.assertEquals(    expectedData.isDepositpaid(),   actualData.getBooking().isDepositpaid());

        Assert.assertEquals(    expectedData.getBookingdates().getCheckin(),    actualData.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(    expectedData.getBookingdates().getCheckout(),   actualData.getBooking().getBookingdates().getCheckout());










    }
}
