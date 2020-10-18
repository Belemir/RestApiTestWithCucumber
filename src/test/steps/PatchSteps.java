import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class PatchSteps {
    private RequestSpecification req;
    private Response resPatch,resGet;
    @When("the user {string} sends a patch request with last name {string}")
    public void theUserSendsAPatchRequestWithLastName(String firstName, String lastName) throws Throwable {
        Map<String, String> jsonBody = new HashMap<>();
        jsonBody.put("first_name",firstName );
        jsonBody.put("last_name",lastName);
       req = given().contentType(ContentType.JSON);
       resPatch = req.with().
                body(jsonBody).
               when().
                patch("/customers");
    }

    @Then("the user receives status code of {int} after patch request")
    public void theUserReceivesStatusCodeOfAfterPatchRequest(int status) {
        resPatch.then()
                .statusCode(status);
    }

    @Then("the user perform get operation for customer {string}")
    public void theUserPerformGetOperation(String firstName) {
        resGet =  when().
                get("/customers/{firstName}", firstName);
    }

    @And("the user should see updated surname as {string}")
    public void theUserShouldSeeUpdatedSurnameAs(String lastName) {
        resGet.then().body("last_name", is(lastName));
    }

    @And("the response body should contain code {string}")
    public void theResponseBodyShouldContainCode(String code) {
        resPatch.then().body("code", is(code));
    }

}
