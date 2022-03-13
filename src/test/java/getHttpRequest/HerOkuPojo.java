package getHttpRequest;

import baseUrl.HerOkuAppBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.HerOkuPojo01;

public class HerOkuPojo extends HerOkuAppBaseUrl {
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

        spec.pathParam("parametre","booking");


        BookingDatesPojo bookingdates = new BookingDatesPojo("2022-03-01","2022-03-11");

        HerOkuPojo01 expectedData = new HerOkuPojo01("Ali","Can",500, true,bookingdates);

        System.out.println("expectedData = " + expectedData);


        Response response = RestAssured.given().contentType(ContentType.JSON).spec(spec).body(expectedData).when().post("/{parametre}");


        response.prettyPrint();


        JsonPath jsonPath = response.jsonPath();


        Assert.assertEquals(expectedData.getFirstname(),jsonPath.getString("booking.firstname"));
        Assert.assertEquals(expectedData.getLastname(),jsonPath.getString("booking.lastname"));
        Assert.assertEquals(expectedData.getTotalprice(),jsonPath.getInt("booking.totalprice"));
        Assert.assertEquals(expectedData.isDepositpaid(),jsonPath.getBoolean("booking.depositpaid"));

        Assert.assertEquals(expectedData.getBookingdates().getCheckin(),jsonPath.getString("booking.bookingdates.checkin"));
        Assert.assertEquals(expectedData.getBookingdates().getCheckout(),jsonPath.getString("booking.bookingdates.checkout"));







    }
}
