package getHttpRequest;

import baseUrl.GmiBankBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import testData.GmiBankTestData;

import java.util.HashMap;
import java.util.regex.Matcher;

import static org.hamcrest.Matchers.equalTo;

public class GmiBankGetRequest extends GmiBankBaseUrl {
    /*
           http://www.gmibank.com/api/tp-customers/43703

           "firstName": "Alda",
           "lastName": "Monahan",
           "middleInitial": "Nichelle Hermann Kohler",
           "email": "com.github.javafaker.Name@7c011174@gmail.com",
           "mobilePhoneNumber": "909-162-8114",
           "city": "St Louis",
           "ssn": "108-53-6655"

           1) MATCHERS CLASS
           2) JSON PATH
           3) De-Serialization
     */


    @Test
    public void test01() {

        spec.pathParams("parametre1","api","parametre2","tp-customers","parametre3",43703);


        GmiBankTestData expectedDataObje = new GmiBankTestData();

        HashMap<String,Object> expectedDataMap = expectedDataObje.expectedDataSetup();


        Response response = RestAssured.given().
                            contentType(ContentType.JSON).
                            header("Authorization", "Bearer "+tokenOlustur()).
                            spec(spec).when().
                            get("/{parametre1}/{parametre2}/{parametre3}");


        response.prettyPrint();


/*******************************************************MATCHERS CLASS ILE*****************************************************************************/

        response.then().assertThat().body("firstName", equalTo(expectedDataMap.get("firstName")) ,
                                            "lastName",equalTo(expectedDataMap.get("lastName")),
                                            "middleInitial",equalTo(expectedDataMap.get("middleInitial")),
                                            "email",equalTo(expectedDataMap.get("email")),
                                            "mobilePhoneNumber",equalTo(expectedDataMap.get("mobilePhoneNumber")),
                                            "city",equalTo(expectedDataMap.get("city")),
                                            "ssn",equalTo(expectedDataMap.get("ssn")));




/*******************************************************JSONPATH ILE*****************************************************************************/

        JsonPath jsonPath = response.jsonPath();


            Assert.assertEquals(expectedDataMap.get("firstName"), jsonPath.getString("firstName"));
            Assert.assertEquals(expectedDataMap.get("lastName"), jsonPath.getString("lastName"));
            Assert.assertEquals(expectedDataMap.get("middleInitial"), jsonPath.getString("middleInitial"));
            Assert.assertEquals(expectedDataMap.get("email"), jsonPath.getString("email"));
            Assert.assertEquals(expectedDataMap.get("mobilePhoneNumber"), jsonPath.getString("mobilePhoneNumber"));
            Assert.assertEquals(expectedDataMap.get("city"), jsonPath.getString("city"));
            Assert.assertEquals(expectedDataMap.get("ssn"), jsonPath.getString("ssn"));




/******************************************************* De-Serialization *****************************************************************************/
                                /**Json formatindaki datayi java formatina cevirmes islemine denir.*/


        HashMap<String,Object> actualDataMap = response.as(HashMap.class); /** Bu isleme De-Serialization deniliyor. */

            Assert.assertEquals(expectedDataMap.get("firstName"),actualDataMap.get("firstName"));
            Assert.assertEquals(expectedDataMap.get("lastName"),actualDataMap.get("lastName"));
            Assert.assertEquals(expectedDataMap.get("middleInitial"),actualDataMap.get("middleInitial"));
            Assert.assertEquals(expectedDataMap.get("email"),actualDataMap.get("email"));
            Assert.assertEquals(expectedDataMap.get("mobilePhoneNumber"),actualDataMap.get("mobilePhoneNumber"));
            Assert.assertEquals(expectedDataMap.get("city"),actualDataMap.get("city"));
            Assert.assertEquals(expectedDataMap.get("ssn"),actualDataMap.get("ssn"));









    }



}
