
package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WizardingWorldTests {

    WebDriver driver = null;

    //Navigate to WizardingWorld
    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("starting-browser is open");
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        System.out.println("project path" + projectPath);

        System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        System.out.println("ending");
        driver.navigate().to("https://google.com");
    }


    @When("user enters text in google search box")
    public void user_enters_text_in_google_search_box() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[2]/div[2]/input")).sendKeys("Wizarding World");
    }
    @And("hits Enter")
    public void hits_enter() {
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[2]/div[2]/input")).sendKeys(Keys.ENTER);
    }
    @Then("user navigate to the Wizarding World")
    public void user_navigate_to_the_wizarding_world() {
        System.out.println("ordayim");
        driver.findElement(By.xpath("//h3[contains(.,\'Wizarding World: The Official Home of Harry Potter\')]")).click();
        System.out.println("burdayim");
    }

    //Login Flow

    @When("user is on Wizarding World page")
    public void user_is_on_wizarding_world_page() {
        System.out.println("nerdeyim");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[2]/div[2]/input")).sendKeys("Wizarding World");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[2]/div[2]/input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//h3[contains(.,\'Wizarding World: The Official Home of Harry Potter\')]")).click();
        System.out.println("burdayim");
    }

    @When("user is on login page")
    public void user_is_on_login_page() {
        driver.findElement(By.xpath("//*[@id=\"wizarding_world_login\"]/span")).click();
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String email, String password) {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
    }


    @When("clicks on continue button")
    public void clicks_on_continue_button() {
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]/div")).click();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cls-1")));
    }
    //Negative Flow
    @Then("user see the fail message")
    public void user_see_the_fail_message() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/section[1]/h1")));
    }


}
