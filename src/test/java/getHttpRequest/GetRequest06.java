package getHttpRequest;

import baseUrl.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GetRequest06 extends DummyBaseUrl {
    /*
   http://dummy.restapiexample.com/api/v1/employees
   1) Status kodunun 200,
   2) 10’dan büyük tüm id’leri ekrana yazdırın ve 10’dan büyük 14 id olduğunu,
   3) 30’dan küçük tüm yaşları ekrana yazdırın ve bu yaşların içerisinde en büyük yaşın 23 olduğunu
   4) Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın
      ve bunların içerisinde “Charde Marshall” olduğunu test edin
   */

    @Test
    public void test01() {

        spec.pathParams("parametre1","api","parametre2","v1","parametre3","employees");


        Response response = RestAssured.given().accept(ContentType.JSON).spec(spec).when().get("/{parametre1}/{parametre2}/{parametre3}");


        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.statusCode());


        JsonPath jsonPath = response.jsonPath();

        List<Integer> idler = jsonPath.getList("data.id");

        idler.stream().filter(t->t>10).forEach(t-> System.out.print(t+" "));

        long sayi = idler.stream().filter(t->t>10).count();

        System.out.println();
        System.out.println(sayi);

        List<Integer> yaslar = jsonPath.getList("data.employee_age");

        yaslar.stream().filter(t->t<30).forEach(t-> System.out.print(t+" "));

       int max= yaslar.stream().filter(t->t<30).mapToInt(t->t).max().orElseThrow();

        System.out.println("max = " + max);


        //4) Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın

        List<String> isimler = jsonPath.getList("data.findAll{it.employee_salary>350000}.employee_name");

        System.out.println("isimler = " + isimler);


    }



}
