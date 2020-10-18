import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostSteps {

    private RequestSpecification req;
    private Response res;

    @Given("content type is JSON")
    public void theContentTypeIsJSON() throws Throwable {
        req = given().contentType(ContentType.JSON);
    }

    @When("the user post firstname {string} and lastname {string}")
    public void theUserPostFirstnameAndLastname(String firstName, String lastName) throws Throwable {

        Map<String, String> jsonBody = new HashMap<>();
        jsonBody.put("first_name", firstName);
        jsonBody.put("last_name", lastName);
       res = req.with().
                body(jsonBody)
            .when().post("/customers");
    }

    @Then("the user receives status code of {int} after posting")
    public void theUserReceivesStatusCodeOf(int status) {
        res.then()
                .statusCode(status);

    }

    @And("the response body should contain customer firstname {string} and lastname {string}")
    public void theResponseBodyShouldContainCustomerFirstnameAndLastname(String firstName, String lastName) {
        res.then().body("first_name", equalTo(firstName), "last_name", equalTo(lastName));
    }

}
