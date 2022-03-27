package getHttpRequest;

import baseUrl.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyPojo01;
import pojos.DummyResponsePojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyRequestPojo extends DummyBaseUrl {

    /**
     * http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
     * <p>
     * Status kodun 200 olduğunu,
     * <p>
     * 5. Çalışan isminin "Airi Satou" olduğunu,
     * <p>
     * çalışan sayısının 24 olduğunu,
     * <p>
     * Sondan 2. çalışanın maaşının 106450 olduğunu
     * <p>
     * 40,21 ve 19 yaslarında çalışanlar olup olmadığını ve
     * <p>
     * 11. Çalışan bilgilerinin asagidaki gibi oldugunu test edin.
     * <p>
     * {
     * <p>
     * "id": 11,
     * "employee_name": "Jena Gaines",
     * "employee_salary": 90560,
     * "employee_age": 30,
     * "profile_image": ""
     * <p>
     * }
     */


    @Test
    public void test01() {


        spec.pathParams("parametre1", "api", "parametre2", "v1", "parametre3", "employees");


        /** expected data olusturacagiz */

        DummyPojo01 expectedData = new DummyPojo01(11, "Jena Gaines", 90560, 30, "");

        System.out.println("expectedData = " + expectedData);

        Response response = RestAssured.
                given()..
                contentType(ContentType.JSON).
                spec(spec).
                when().
                get("/{parametre1}/{parametre2}/{parametre3}");


        // response.prettyPrint();


        DummyResponsePojo actualData = response.as(DummyResponsePojo.class); // De-Serialization islemi yaptik.

        System.out.println("actualData = " + actualData);

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.getEmployee_name(), actualData.getData().get(10).getEmployee_name());
        Assert.assertEquals(expectedData.getEmployee_salary(), actualData.getData().get(10).getEmployee_salary());
        Assert.assertEquals(expectedData.getEmployee_age(), actualData.getData().get(10).getEmployee_age());
        Assert.assertEquals(expectedData.getProfile_image(), actualData.getData().get(10).getProfile_image());
        Assert.assertEquals(expectedData.getId(), actualData.getData().get(10).getId());


        HashMap<String, Object> actualData02 = response.as(HashMap.class); // De-Serialization islemi yaptik.


        Assert.assertEquals(expectedData.getId(), ((Map) ((List) actualData02.get("data")).get(10)).get("id"));
        Assert.assertEquals(expectedData.getEmployee_age(), ((Map) ((List) actualData02.get("data")).get(10)).get("employee_age"));


        JsonPath jsonPath = response.jsonPath();

        List<Integer> arananYaslar = new ArrayList<>();
        arananYaslar.add(19);
        arananYaslar.add(21);
        arananYaslar.add(40);
        List<Integer> tumYaslar = jsonPath.getList("data.employee_age");


        Assert.assertTrue(tumYaslar.containsAll(arananYaslar));
        Assert.assertEquals(24, jsonPath.getList("data.id").size());
        Assert.assertEquals(106450, jsonPath.getInt("data[-2].employee_salary"));
        Assert.assertEquals("Airi Satou", jsonPath.getString("data[4].employee_name"));


    }
}
