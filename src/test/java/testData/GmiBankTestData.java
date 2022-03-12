package testData;

import java.util.HashMap;

public class GmiBankTestData {

   //"firstName": "Alda",
   //        "lastName": "Monahan",
   //        "middleInitial": "Nichelle Hermann Kohler",
   //        "email": "com.github.javafaker.Name@7c011174@gmail.com",
   //        "mobilePhoneNumber": "909-162-8114",
   //        "city": "St Louis",
   //        "ssn": "108-53-6655"


    public HashMap<String, Object> expectedDataSetup() {


        HashMap<String,Object> expectedData = new HashMap<>();

            expectedData.put("firstName","Alda");
            expectedData.put("lastName","Monahan");
            expectedData.put("middleInitial","Nichelle Hermann Kohler");
            expectedData.put("email","com.github.javafaker.Name@7c011174@gmail.com");
            expectedData.put("mobilePhoneNumber","909-162-8114");
            expectedData.put("city","St Louis");
            expectedData.put("ssn","108-53-6655");

        return  expectedData;

    }







}
