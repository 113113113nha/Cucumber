package cucumber;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import element.loginPageElement;
import element.navigatedElement;
import element.registerPageElement;

public class login {
	AppiumDriver <WebElement> driver;
	
	String path = "D://Chovinh//";
	String appName = "ChoVinh-release_3bf337f_160307_1424.apk";
	String platformName = "Android";
	String version = "4.2.2";
	String deviceName = "4d004a83be0890e1";
	String appPackage = "chovinh.arisvn.com.chovinhcom";
	
	loginPageElement logElement = new loginPageElement();
	navigatedElement navElement = new navigatedElement();
	registerPageElement regElement = new registerPageElement();
	
	@Before
	public void setUp() throws MalformedURLException {
		File app = new File(path, appName);
	    
	    DesiredCapabilities cap = new DesiredCapabilities();
	    cap.setCapability("platformName", platformName);
	    cap.setCapability("platformVersion", version);
	    cap.setCapability("deviceName", deviceName);
	    cap.setCapability("app-package", appPackage);
	    cap.setCapability("app",app.getAbsolutePath());
	    
	    driver = new AndroidDriver <WebElement> (new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}
	
	@After
	public void cleanUp() {
		driver.quit();
	}
	
	@Given("^I am an user$")
	public void i_am_an_user() throws Throwable {
		System.out.println("I am an user");
	}

	@Given("^I go to Login screen$")
	public void goToLoginScreen() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement menuIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(navElement.getMenuIconXpath())));
		menuIcon.click();
			
		WebElement loginText = driver.findElement(By.xpath(navElement.getLoginTextXPath()));
		loginText.click();
	}

	@Then("^I see the \"([^\"]*)\" is \"([^\"]*)\"$")
	public void checkScreenTitle(String title, String expectedTitle) throws Throwable {	
		WebElement actualTitle = driver.findElement(By.name(logElement.getElementXPath(title)));
		Assert.assertEquals(actualTitle.getText(), expectedTitle);
		System.out.println("The title of Login screen is: " + actualTitle.getText());
	}
	
	@Then("^I see the placeholder of \"([^\"]*)\" field is \"([^\"]*)\"$")
	public void checkFieldPlaceholder(String field, String expectedPlaceholder) throws Throwable {
		WebElement actualPlaceholder = driver.findElement(By.xpath(logElement.getElementXPath(field)));
		Assert.assertEquals(actualPlaceholder.getText(), expectedPlaceholder);
		System.out.println("The placeholder of Username field is: "+ actualPlaceholder.getText());
	}

	@Then("^I see the value of \"([^\"]*)\" is \"([^\"]*)\"$")
	public void checkButtonValue(String button, String expectedValue) throws Throwable {
		WebElement actualValue = driver.findElement(By.xpath(logElement.getElementXPath(button)));
		Assert.assertEquals(actualValue.getText(), expectedValue);
		System.out.println("The text of " + button + "is: " + actualValue.getText());	
	}

	@Then("^I see the \"([^\"]*)\" between Login and Register buttons is \"([^\"]*)\"$")
	public void checkText(String text, String expectedText) throws Throwable {
		WebElement orText = driver.findElement(By.xpath(logElement.getElementXPath(text)));
		Assert.assertEquals(orText.getText(), expectedText);
		System.out.println("The text between Login and Register button is: "+ expectedText);
	}

	@When("^I input \"([^\"]*)\" into \"([^\"]*)\" field$")
	public void inputIntoField(String text, String field) throws Throwable {
		WebElement e = driver.findElement(By.xpath(logElement.getElementXPath(field)));
		e.sendKeys(text);
	}

	@When("^I click on \"([^\"]*)\"$")
	public void clickButton(String button) throws Throwable {
		WebElement loginBtn = driver.findElement(By.xpath(logElement.getElementXPath(button)));
		loginBtn.click();
	}

	@Then("^I login successfully$")
	public void i_login_successfully() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(navElement.getUsernameXPath())));
		Assert.assertEquals(username.getText(), "Namtest");
	}

	@Then("^I am redirected to Register screen$")
	public void i_am_redirected_to_Register_screen() throws Throwable {
		WebElement regTitle = driver.findElement(By.name(regElement.getRegisterTitleName()));
		Assert.assertEquals(regTitle.getText(), "Đăng ký");
	}
}
