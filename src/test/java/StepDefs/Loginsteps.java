package StepDefs;

import Pages.Login;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class Loginsteps {

    static WebDriver driver;
    static Login home;



    // Scenario 1 : Login with invalid user and invalid pass
    @Given("^Open website url$")
    public void Open_website_url() throws Throwable {
        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        // Instantiate a ChromeDriver class.
        driver=new ChromeDriver();
        // Launch Website
        driver.navigate().to("https://urs.earthdata.nasa.gov/");
        //Maximize the browser
        driver.manage().window().maximize();
    }

    @When("^user logged with invalid username \"(.*)\" and invalid password \"(.*)\"$")
    public void user2_logged_with_username(String username,String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        home = new Login(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.enterUsername(username);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.enterPass(password);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.clickLogin();

    }

    @Then("^Validation message should be displayed$")
    public void validation_message_should_be_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Assert.assertEquals(home.returnmessage(),"Invalid username or password");
    }



    // Scenario 2 : Login with valid user and invalid pass
    @When("^user logged with valid username \"([^\"]*)\" and invalid password \"([^\"]*)\"$")
    public void user_logged_with_username_and_password(String arg1, String arg2) throws Throwable {
        home.clearUsername();
        home.clearPass();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.enterUsername(arg1);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.enterPass(arg2);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.clickLogin();
    }

    @Then("^Error message should be displayed$")
    public void error_message_should_be_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Assert.assertEquals(home.returnmessage(),"Invalid username or password");
    }



    // Scenario 3 : Login with invalid user and valid pass
    @When("^user logged with invalid username \"([^\"]*)\" and valid password \"([^\"]*)\"$")
    public void user_logged_with_invalid_username_and_valid_password(String arg1, String arg2) throws Throwable {
        home.clearUsername();
        home.clearPass();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.enterUsername(arg1);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.enterPass(arg2);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.clickLogin();
    }

    @Then("^Valid error message should be displayed$")
    public void valid_error_message_should_be_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Assert.assertEquals(home.returnmessage(),"Invalid username or password");
    }


    // Scenario 4 : Login with empty user and pass
    @When("^user logged with empty username and password")
    public void user_logged_with_empty_username_and_password() throws Throwable {
        home.clearUsername();
        home.clearPass();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.enterUsername("");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.enterPass("");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        home.clickLogin();
    }

    @Then("^Required error message should be displayed$")
    public void required_error_message_should_be_displayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Assert.assertEquals(home.requsernamemsg(),"Username is required");
        Assert.assertEquals(home.reqpassmsg(),"Password is required");
    }

}
