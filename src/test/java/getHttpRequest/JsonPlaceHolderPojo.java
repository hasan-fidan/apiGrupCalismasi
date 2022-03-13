package getHttpRequest;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPojo01;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class JsonPlaceHolderPojo extends JsonPlaceHolderBaseUrl {

    /**{
     "userId": 1,
     "id": 6,
     "title": "qui ullam ratione quibusdam voluptatem quia omnis",
     "completed": false
     }*/


    @Test
    public void test01() {

        spec.pathParams("parametre1","todos","parametre2","6");


        JsonPojo01 expectedData = new JsonPojo01(1, 6, "qui ullam ratione quibusdam voluptatem quia omnis", false);



        System.out.println("expectedData = " + expectedData);

        //  System.out.println("expectedData = " + expectedData);

        Response response = RestAssured.given().
                contentType(ContentType.JSON).
                spec(spec).when().
                get("/{parametre1}/{parametre2}");

        //response.prettyPrint();



        JsonPojo01 actualData = response.as(JsonPojo01.class);

        System.out.println("actualData = " + actualData);


        Assert.assertEquals(    expectedData.getUserId(),       actualData.getUserId() );
        Assert.assertEquals(    expectedData.getId(),           actualData.getId() );
        Assert.assertEquals(    expectedData.getTitle(),        actualData.getTitle() );
        Assert.assertEquals(    expectedData.isCompleted(),     actualData.isCompleted() );







    }
}
