import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

public class GetSteps {

    private Response res;
    @When("the client calls customer {string}")
    public void theClientCallsCustomer(String firstName) throws Throwable{
        res =  when().
                    get("/customers/{firstName}", firstName);
    }

    @Then("the user receives status code of {int}")
    public void theUserReceivesStatusCodeOf(int status) {
        res.then()
                .statusCode(status);
    }

    @And("the response body should contain customer name {string}")
    public void theResponseBodyShouldContain(String name) throws Throwable {
        res.then().body("first_name", is(name));
    }
}
