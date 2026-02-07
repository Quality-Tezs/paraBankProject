package stepdefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {

    LoginPage login = new LoginPage();

    @Given("user opens parabank site")
    public void openSite() {
        login.openSite("https://parabank.parasoft.com/");
    }

    @When("user logs in")
    public void login() {
        login.login("john", "demo");
    }

    @Then("login should be successful")
    public void success() {
        System.out.println("Login successful");
    }
}
