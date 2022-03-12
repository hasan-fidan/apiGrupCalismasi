package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.HashMap;



public class Authorization {


    public static String tokenOlustur() {

        String endPoint = "https://www.gmibank.com/api/authenticate";

        String username="Batch44Api";
        String password="Batch44+";

        HashMap<String,Object> loginBilgileri = new HashMap<>();
        loginBilgileri.put("username", username);
        loginBilgileri.put("password", password);


        Response response = RestAssured.given().contentType(ContentType.JSON).body(loginBilgileri).when().post(endPoint);

        JsonPath token = response.jsonPath();


    return token.getString("id_token");


    }
















}
