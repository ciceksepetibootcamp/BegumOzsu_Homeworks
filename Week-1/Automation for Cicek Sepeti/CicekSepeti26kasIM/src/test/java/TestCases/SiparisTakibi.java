package TestCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiparisTakibi extends Ciceksepeti26Kasim{
    @org.junit.Test

    public void yanlisSiparisNumarasi() {

        driver.get("https://www.ciceksepeti.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon-close']")));
        driver.findElement(By.xpath("//span[@class='icon-close']")).click();
        WebElement elementHover = driver.findElement(By.cssSelector("div[class='header__right-col'] ul[class='user-menu__items  ']>li:nth-of-type(2)"));
        Actions action = new Actions(driver);
        action.moveToElement(elementHover).build().perform();


        driver.findElement(By.xpath("//div[@class='header__right-col']//a[@href='/siparis-takip']/span[@class='user-menu__title']")).click();
        driver.findElement(By.name("OrderCode")).click();
        driver.findElement(By.name("OrderCode")).sendKeys("237482734");
        driver.findElement(By.name("CustomerEmail")).click();
        driver.findElement(By.name("CustomerEmail")).sendKeys("begumozsu@outlook.com");
        driver.findElement(By.xpath("//button[@class='order-tracking-form__btn btn btn-primary btn-lg js-order-tracking-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='order-tracking-form__message js-order-tracking-message']")));
        String passwordError = driver.findElement(By.xpath("//p[@class='order-tracking-form__message js-order-tracking-message']")).getText();
        Assert.assertEquals(passwordError,"Girdiğiniz sipariş numarası veya e-posta hatalıdır.");


    }
    @org.junit.Test

    public void zorunluAlanKontrolu() {

        driver.get("https://www.ciceksepeti.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='icon-close']")));
        driver.findElement(By.xpath("//span[@class='icon-close']")).click();
        WebElement elementHover = driver.findElement(By.cssSelector("div[class='header__right-col'] ul[class='user-menu__items  ']>li:nth-of-type(2)"));
        Actions action = new Actions(driver);
        action.moveToElement(elementHover).build().perform();


        driver.findElement(By.xpath("//div[@class='header__right-col']//a[@href='/siparis-takip']/span[@class='user-menu__title']")).click();
        driver.findElement(By.name("OrderCode")).click();
        driver.findElement(By.name("OrderCode")).sendKeys("");
        driver.findElement(By.name("CustomerEmail")).click();
        driver.findElement(By.name("CustomerEmail")).sendKeys("begumozsu@outlook.com");
        driver.findElement(By.xpath("//button[@class='order-tracking-form__btn btn btn-primary btn-lg js-order-tracking-button']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"OrderCode-error\"]")));
        String passwordError = driver.findElement(By.xpath("//span[@id='OrderCode-error']")).getText();
        Assert.assertEquals(passwordError,"Bu bilginin doldurulması zorunludur.");


    }
}
