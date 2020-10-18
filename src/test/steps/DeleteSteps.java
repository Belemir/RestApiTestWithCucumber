import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteSteps {
    private Response res;
    @Given("the user sends delete request for customer {string}")
    public void theUserSendsDeleteRequestForCustomer(String customer) {
        res = given().delete("/customers/{customer}", customer);
    }

    @Then("the user receives status code of {int} after deleting")
    public void theUserReceivesStatusCodeOfAfterDeleting(int arg0) {
        res.then().statusCode(204);
    }
}
