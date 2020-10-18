import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetSteps {
    @When("the client calls customer {string}")
    public void theClientCallsCustomer(String firstName) throws Throwable{
        Utils.getCustomer(firstName);
    }

    @Then("the user receives status code of {int}")
    public void theUserReceivesStatusCodeOf(int status) {
    }

    @And("the response body should contain customer name")
    public void theResponseBodyShouldContain() throws Throwable {
    }
}
