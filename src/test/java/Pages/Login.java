package Pages;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    // Login class will track all the needed web elements locators.

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public Login(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for login
    By Username = By.id("username");
    By Password = By.id("password");
    By logbtn = By.name("commit");
    //Locator for Invalid username and password
    By inemailpass = By.xpath("/html/body/div[2]/div[1]");
    //Locator for required message for username
    By usern = By.id("username-error");
    //Locator for required message for password
    By passs = By.id("password-error");

    //Method to enter username
    public void enterUsername(String user) {
        driver.findElement(Username).sendKeys(user);
    }

    //Method to clear username text
    public void clearUsername() {
        driver.findElement(Username).clear();
    }

    //Method to enter password
    public void enterPass(String pass) {
        driver.findElement(Password).sendKeys(pass);
    }

    //Method to clear password text
    public void clearPass() {
        driver.findElement(Username).clear();
    }

    //Method to click login button
    public void clickLogin() {
        driver.findElement(logbtn).click();
    }

    //Method to return message
    public String returnmessage() {
      return   driver.findElement(inemailpass).getText();
    }

    //Method to return required error message for username
    public String requsernamemsg() {
        return   driver.findElement(usern).getText();
    }

    //Method to return required error message for password
    public String reqpassmsg() {
        return   driver.findElement(passs).getText();
    }


}
