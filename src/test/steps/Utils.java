import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class Utils {
    public static void getCustomer(String firstName) throws Throwable{
        when().
                get("/customers/{firstName}", firstName).
        then().
                statusCode(200).body("first_name", is(firstName));
    }
    public static void postCustomer(String firstName, String lastName) throws Throwable{
        Map<String, String> jsonBody = new HashMap<>();
        jsonBody.put("first_name",firstName );
        jsonBody.put("last_name", lastName);

        given().
                contentType(ContentType.JSON).
        with().
                body(jsonBody).
        when().
                post("/customers").
        then().
                statusCode(201).body("first_name", equalTo(firstName), "last_name", equalTo(lastName));
    }
    public  static  void updateCustomer(String firstName, String lastName) throws Throwable{
        Map<String, String> jsonBody = new HashMap<>();
        jsonBody.put("first_name",firstName );
        jsonBody.put("last_name",lastName);

        given().
                contentType(ContentType.JSON).
        with().
                body(jsonBody).
        when().
                patch("/customers").
        then().
                statusCode(204);

    }
}
