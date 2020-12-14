package com.web.selenium.model;

import com.web.selenium.pojo.Offer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class typeOffer {
    public static void typeOffer1(WebDriver webDriver, Offer offer) throws InterruptedException {
        webDriver.findElement(new By.ByName("name")).sendKeys(offer.getName());
        webDriver.findElement(new By.ByName("lastname")).sendKeys(offer.getLastName());
        webDriver.findElement(new By.ByName("email")).sendKeys(offer.getEmail());
        Thread.sleep(3000);
        webDriver.findElement(new By.ByXPath("//input[@class='" + "text" + "']")).click();
        Thread.sleep(3000);
        webDriver.findElement(new By.ByName("year")).sendKeys(offer.getYear());
        webDriver.findElement(new By.ByName("cardNumber")).sendKeys(offer.getCardNumber());
        webDriver.findElement(new By.ByName("cvv")).sendKeys(offer.getCvv());
        webDriver.findElement(new By.ByName("city")).sendKeys(offer.getAddress());
        webDriver.findElement(new By.ByName("country")).sendKeys(offer.getCountry());
        webDriver.findElement(new By.ByName("")).sendKeys(offer.getDay());
        webDriver.findElement(new By.ByName("")).sendKeys(offer.getMonth());
        webDriver.findElement(new By.ByName("")).sendKeys(offer.getPhone());
        webDriver.findElement(new By.ByName("")).sendKeys(offer.getPostcode());
        webDriver.findElement(new By.ByName("")).sendKeys(offer.getState());
        Thread.sleep(3000);
        webDriver.findElement(new By.ByXPath("//input[@class='" + "" + "']")).click();
        Thread.sleep(3000);
        webDriver.quit();
    }
}
