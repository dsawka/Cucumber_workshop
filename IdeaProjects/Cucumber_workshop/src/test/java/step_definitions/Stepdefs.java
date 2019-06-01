package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class Stepdefs {

    private static final String EMAIL_INPUT_SENT = "main-page-top__email-input-sent";
    private static final String NAME_FIELD = "fos_user_registration_form_name";
    private static final String LAST_NAME_FIELD = "fos_user_registration_form_lastname";
    private static final String PASSWORD_FIELD = "fos_user_registration_form_plainPassword_first";
    private static final String PASSWORD_SECOND_FIELD = "fos_user_registration_form_plainPassword_second";
    private static final String CITY_FIELD = "form_city";
    private static final String POSTAL_CODE_FIELD = "form_postal_code";
    private static final String STREET_FIELD = "form_street";
    private static final String STREET_NUMBER_FIELD = "form_number";
    private static final String INPUT_CHECKBOX_FIELD = "//input[@type='checkbox']";
    private static final String REGISTER_SUBMIT_BTN = "register-submit-btn";
    private static final String LOGGED_USER_NAME = "user-name";
    private WebDriver driver;

    @Given("there is a browser with home page")
    public void thereIsABrowserWithHomePage() {
        System.setProperty("webdriver.chrome.driver", "/home/damian/IDEA/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://men-men-s-01.codersguru.pl/");
    }


    @When("user clicks registration button")
    public void userClicksRegistrationButton() {
        String emailValue = getEmail();
        driver.get("https://men-men-s-01.codersguru.pl/");
        driver.findElement(By.className("main-page-top__email-input")).sendKeys(emailValue);
        driver.findElement(By.className(EMAIL_INPUT_SENT)).submit();
    }

    @Then("user is on registration page")
    public void userIsOnRegistrationPage() {
        assertEquals("https://men-men-s-01.codersguru.pl/register/", driver.getCurrentUrl());
    }


    @And("input field firstname is filled with (.*)")
    public void inputFieldFirstnameIsFilledWithFirstnameparameter(String parameter) {
        driver.findElement(By.id(NAME_FIELD)).sendKeys(parameter);
    }

    @And("input field lastname is filled with (.*)")
    public void inputFieldLastnameIsFilledWithLastnameparameter(String parameter) {
        driver.findElement(By.id(LAST_NAME_FIELD)).sendKeys(parameter);
    }

    @And("input field password is filled with (.*)")
    public void inputFieldPasswordIsFilledWithPasswordparameter(String parameter) {
        driver.findElement(By.id(PASSWORD_FIELD)).sendKeys(parameter);
        driver.findElement(By.id(PASSWORD_SECOND_FIELD)).sendKeys(parameter);
    }

    @And("input field city is filled with (.*)")
    public void inputFieldCityIsFilledWithCityparameter(String parameter) {
        driver.findElement(By.id(CITY_FIELD)).sendKeys(parameter);
    }

    @And("input field postal code is filled with (.*)")
    public void inputFieldPostalCodeIsFilledWithPostalcodeparameter(String parameter) {
        driver.findElement(By.id(POSTAL_CODE_FIELD)).sendKeys(parameter);
    }

    @And("input field street is filled with (.*)")
    public void inputFieldStreetIsFilledWithStreetparameter(String parameter) {
        driver.findElement(By.id(STREET_FIELD)).sendKeys(parameter);
    }

    @And("input field street number is filled with (.*)")
    public void inputFieldStreetNumberIsFilledWithStreetnumberparameter(String parameter) {
        driver.findElement(By.id(STREET_NUMBER_FIELD)).sendKeys(parameter);
    }

    @And("mark that he knows regulations")
    public void markThatHeKnowsRegulations() {
        driver.findElement(By.xpath(INPUT_CHECKBOX_FIELD)).click();
    }

    @And("click register")
    public void clickRegister() {
        driver.findElement(By.id(REGISTER_SUBMIT_BTN)).click();
    }

    @And("user is logged (.*)")
    public void userIsLoggedFirstnameparameter(String parameter) {
        String new_user = driver.findElement(By.id(LOGGED_USER_NAME)).getText();
        Assert.assertEquals(new_user, parameter);
    }

    private String getEmail() {
        String emailName = randomAlphanumeric(5);
        String subDomain = randomAlphanumeric(5);
        String domain = randomAlphabetic(3);
        return String.format("%s@%s.%s", emailName, subDomain, domain);
    }
}
