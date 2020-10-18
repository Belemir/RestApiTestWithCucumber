import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatchSteps {
    @When("the user {string} sends a patch request with last name {string}")
    public void theUserSendsAPatchRequestWithLastName(String firstname, String lastname) throws Throwable {
        Utils.updateCustomer(firstname,lastname);
    }

    @Then("the user receives status code of {int} after patch request")
    public void theUserReceivesStatusCodeOfAfterPatchRequest(int arg0) {
    }

    @Then("the user perform get operation")
    public void theUserPerformGetOperation() {
    }

    @And("the user should see updated surname as {string}")
    public void theUserShouldSeeUpdatedSurnameAs(String arg0) {
    }
}
