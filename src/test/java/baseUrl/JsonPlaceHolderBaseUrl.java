package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    //https://jsonplaceholder.typicode.com


    protected RequestSpecification spec;

    @Before
    public void baseUrlSetup() {

        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();



    }



}
