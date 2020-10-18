import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.given;

public class DeleteSteps {
    @Given("the user sends delete request for customer {string}")
    public void theUserSendsDeleteRequestForCustomer(String customer) {
        given().delete("/customers/{customer}", customer).then().statusCode(204);
    }

    @Then("the user receives status code of {int} after deleting")
    public void theUserReceivesStatusCodeOfAfterDeleting(int arg0) {
    }
}
