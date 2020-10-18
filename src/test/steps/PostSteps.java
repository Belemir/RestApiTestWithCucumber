import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostSteps {
   @Given("content type is JSON")
   public void theContentTypeIsJSON() throws Throwable {
   }

   @When("the user post firstname {string} and lastname {string}")
    public void theUserPostFirstnameAndLastname(String firstname, String lastname) throws Throwable {
    Utils.postCustomer(firstname,lastname);
    }

    @Then("the user receives status code of {int} after posting")
    public void theUserReceivesStatusCodeOf(int status) {
    }

    @And("the response body should contain customer firstname and lastname")
    public void theResponseBodyShouldContainCustomerFirstnameAndLastname() {
    }

}
