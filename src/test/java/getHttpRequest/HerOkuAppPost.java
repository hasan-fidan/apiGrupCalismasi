package getHttpRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testData.HerOkuAppTestData;

import java.util.HashMap;
import java.util.List;

public class HerOkuAppPost  {

    /*
   https://restful-booker.herokuapp.com/booking/47
          {
              "firstname": "Ali",
              "lastname": "Can",
              "totalprice": 700,
              "depositpaid": true,
              "bookingdates": {
                                "checkin": "2022-02-01",
                                    "checkout": "2022-02-11"
             }
          }
   1) JsonPhat
   2) De-Serialization
   */



    @Test(invocationCount = 500)
    public void post() {



        HerOkuAppTestData testDataObje = new HerOkuAppTestData();

        HashMap<String,Object> postDataMap = testDataObje.setupExpectedData();


        Response response = RestAssured.given().contentType(ContentType.JSON).body(postDataMap).when().post("https://restful-booker.herokuapp.com/booking");

       Response yaz = RestAssured.given().contentType(ContentType.JSON).when().get("https://restful-booker.herokuapp.com/booking");

       //yaz.prettyPrint();

        JsonPath jsonPath = yaz.jsonPath();

        List<Integer> idler = jsonPath.getList("bookingid");

        System.out.println("idler.size() = " + idler.size());


    }







}
