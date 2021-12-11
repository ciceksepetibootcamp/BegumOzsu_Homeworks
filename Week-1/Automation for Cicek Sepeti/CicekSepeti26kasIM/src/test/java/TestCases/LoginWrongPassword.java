package TestCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginWrongPassword extends Ciceksepeti26Kasim {

    @org.junit.Test
    public void sucsess_login() {

        driver.get("https://www.ciceksepeti.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon-close']")));
        driver.findElement(By.xpath("//span[@class='icon-close']")).click();
        WebElement elementHover = driver.findElement(By.cssSelector("div[class='header__right-col'] ul[class='user-menu__items  ']>li:nth-of-type(2)"));
        Actions action = new Actions(driver);
        action.moveToElement(elementHover).build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/nav/ul/li[2]/div/div/ul/li[1]/a/span[2]")));
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/nav/ul/li[2]/div/div/ul/li[1]/a/span[2]")).click();
        driver.findElement(By.id("EmailLogin")).click();
        driver.findElement(By.id("EmailLogin")).sendKeys("begumozsu@outlook.com");
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).sendKeys("Begum94+");
        driver.findElement(By.xpath("//*[@id=\"userLogin\"]/div[6]/button")).click();
    }

    @org.junit.Test
    public void wrong_password() {

        driver.get("https://www.ciceksepeti.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon-close']")));
        driver.findElement(By.xpath("//span[@class='icon-close']")).click();
        WebElement elementHover = driver.findElement(By.cssSelector("div[class='header__right-col'] ul[class='user-menu__items  ']>li:nth-of-type(2)"));

        Actions action = new Actions(driver);
        action.moveToElement(elementHover).build().perform();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/nav/ul/li[2]/div/div/ul/li[1]/a/span[2]")));
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[2]/nav/ul/li[2]/div/div/ul/li[1]/a/span[2]")).click();
        driver.findElement(By.id("EmailLogin")).click();
        driver.findElement(By.id("EmailLogin")).sendKeys("begumozsu@outlook.com");
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).sendKeys("Begum95+");
        driver.findElement(By.xpath("//*[@id=\"userLogin\"]/div[6]/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modalBox\"]/div/div/div[1]")));
        String passwordError = driver.findElement(By.xpath("//*[@id=\"modalBox\"]/div/div/div[2]")).getText();
        Assert.assertEquals(passwordError,"Mail adresi veya şifre hatalı.Lütfen bilgilerinizi kontrol edip tekrar deneyin.");
    }
}
