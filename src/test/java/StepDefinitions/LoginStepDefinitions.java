package StepDefinitions;

import Pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import setup.Setup;

public class LoginStepDefinitions extends Setup {
    loginPage login;
    @Given("User could not visited the portal")
    public void user_could_not_visited_the_portal() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
    @When("User inputs invalid {string} and {string}")
    public void user_inputs_invalid_and(String username, String password) {
        login = new loginPage(driver);
        login.dologin(username,password);
    }
    @Then("User can see Error Massage")
    public void user_can_see_Error_Massage() {
        String ActualUrl = login.lvlError.getText();
        Assert.assertTrue(ActualUrl.contains("Invalid credentials"));
        driver.close();
    }

}
