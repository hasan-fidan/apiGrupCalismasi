package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilities.Authorization;

public class GmiBankBaseUrl extends Authorization {

    //http://www.gmibank.com/api/tp-customers/43703



    protected RequestSpecification spec;


    @Before
    public void baseUrlSetup() {

        spec = new RequestSpecBuilder().setBaseUri("http://www.gmibank.com").build();




    }





}
