package getHttpRequest;


import baseUrl.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequest01 extends DummyBaseUrl {

/*
    http://dummy.restapiexample.com/api/v1/employees  url'ine
    GET request'i yolladigimda gelen response'un

    status kodunun 200 ve content type'inin "application/json"

    ve employees sayisinin 24
    ve employee'lerden birinin "Ashton Cox"
    ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
    */


    @Test
    public void test01() {

        spec.pathParams("parametre1","api","parametre2","v1","parametre3","employees");

        Response response = given().contentType(ContentType.JSON).spec(spec).when().get("/{parametre1}/{parametre2}/{parametre3}");

        response.prettyPrint();

        // headers kisminin testi
        response.then().assertThat().statusCode(200).contentType("application/json"); // header kismindaki status code ve content type testi yapildi.

        response.then().assertThat().body("data", hasSize(24),"data.employee_name" , hasItem("Ashton Cox") ,
                "data.employee_age" , hasItems(21,61,23));




        //body kisminin testi.

        JsonPath jsonPath = response.jsonPath(); // burada sadece body icerigi var.

        Assert.assertEquals(24, jsonPath.getList("data.employee_name").size());

        //     ve employee'lerden birinin "Ashton Cox"

        Assert.assertTrue(jsonPath.getList("data.employee_name").contains("Ashton Cox"));

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("application/json", response.getContentType());




    }



}
