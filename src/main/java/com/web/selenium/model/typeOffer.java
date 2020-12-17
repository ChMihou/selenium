package com.web.selenium.model;

import com.web.selenium.pojo.Offer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class typeOffer {
    public static void typeOffer142196(WebDriver webDriver, Offer offer) throws InterruptedException {
        webDriver.findElement(new By.ByName("firstname")).sendKeys(offer.getName());
        webDriver.findElement(new By.ByName("lastname")).sendKeys(offer.getLastName());
        webDriver.findElement(new By.ByName("email")).sendKeys(offer.getEmail());
        webDriver.findElement(new By.ByName("phone")).sendKeys(offer.getRealPhone() + "");
        Thread.sleep(3000);
        webDriver.findElement(new By.ByName("reg")).click();
        Thread.sleep(3000);
        webDriver.findElement(new By.ByName("expires_year")).sendKeys(offer.getYear());
        webDriver.findElement(new By.ByName("cardNumber")).sendKeys(offer.getCardNumber() + "");
        webDriver.findElement(new By.ByName("csc")).sendKeys(offer.getCvv());
//        webDriver.findElement(new By.ByName("city")).sendKeys(offer.getAddress());
//        webDriver.findElement(new By.ByName("country")).sendKeys(offer.getCountry());
//        webDriver.findElement(new By.ByName("")).sendKeys(offer.getDay());
        webDriver.findElement(new By.ByName("expires_month")).sendKeys(offer.getMonth());
        webDriver.findElement(new By.ByName("zip")).sendKeys(offer.getPostcode());
//        webDriver.findElement(new By.ByName("")).sendKeys(offer.getState());
        Thread.sleep(3000);
        webDriver.findElement(new By.ByName("submit")).click();
        Thread.sleep(3000);
        webDriver.quit();
    }
}
