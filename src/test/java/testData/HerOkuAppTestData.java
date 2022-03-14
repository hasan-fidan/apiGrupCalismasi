package testData;

import com.github.javafaker.Faker;

import java.util.HashMap;

public class HerOkuAppTestData {
    /*
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
          */
static int sayi =10;

    public HashMap<String, Object> setupExpectedData() {

        HashMap<String,Object> bookingDates = new HashMap<>();
            bookingDates.put("checkin","2022-02-01");
            bookingDates.put("checkout","2022-02-11");



        HashMap<String,Object> expectedData = new HashMap<>();

            expectedData.put("bookingdates", bookingDates);
            expectedData.put("firstname", "BATCH_44_"+sayi);
            expectedData.put("lastname", Faker.instance().artist().name());
            expectedData.put("totalprice", 1234567);
            expectedData.put("depositpaid", true);

sayi++;

        return expectedData;


    }






}
