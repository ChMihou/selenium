package com.web.selenium.model;

import com.web.selenium.pojo.Offer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class typeOffer {
    public static void typeOffer1(WebDriver webDriver, Offer offer, Offer param) throws InterruptedException {
        webDriver.findElement(new By.ByName(param.getName())).sendKeys(offer.getName());
        webDriver.findElement(new By.ByName(param.getEmail())).sendKeys(offer.getEmail());
        Thread.sleep(2000);
        webDriver.findElement(new By.ByXPath("//input[@class='" + offer.getSubmit1() + "']")).click();
        Thread.sleep(2000);
        webDriver.findElement(new By.ByName(param.getYear())).sendKeys(offer.getYear());
        webDriver.findElement(new By.ByName(param.getLastName())).sendKeys(offer.getLastName());
        webDriver.findElement(new By.ByName(param.getCardNumber())).sendKeys(offer.getCardNumber());
        webDriver.findElement(new By.ByName(param.getCvv())).sendKeys(offer.getCvv());
        webDriver.findElement(new By.ByName(param.getCity())).sendKeys(offer.getCity());
        webDriver.findElement(new By.ByName(param.getCountry())).sendKeys(offer.getCountry());
        webDriver.findElement(new By.ByName(param.getDay())).sendKeys(offer.getDay());
        webDriver.findElement(new By.ByName(param.getMonth())).sendKeys(offer.getMonth());
        webDriver.findElement(new By.ByName(param.getPhone())).sendKeys(offer.getPhone());
        webDriver.findElement(new By.ByName(param.getPostcode())).sendKeys(offer.getPostcode());
        webDriver.findElement(new By.ByName(param.getState())).sendKeys(offer.getState());
        Thread.sleep(2000);
        webDriver.findElement(new By.ByXPath("//input[@class='" + offer.getSubmit2() + "']")).click();
        Thread.sleep(2000);
        webDriver.quit();
    }

    public static void typeOffer2(WebDriver webDriver, Offer offer, Offer param) throws InterruptedException {
        webDriver.findElement(new By.ByName(param.getName())).sendKeys(offer.getName());
        webDriver.findElement(new By.ByName(param.getEmail())).sendKeys(offer.getEmail());
        webDriver.findElement(new By.ByName(param.getLastName())).sendKeys(offer.getLastName());
        webDriver.findElement(new By.ByName(param.getCountry())).sendKeys(offer.getCountry());
        webDriver.findElement(new By.ByName(param.getCity())).sendKeys(offer.getCity());
        webDriver.findElement(new By.ByName(param.getPhone())).sendKeys(offer.getPhone());
        Thread.sleep(2000);
        webDriver.findElement(new By.ByXPath("//input[@class='" + offer.getSubmit1() + "']")).click();
        Thread.sleep(2000);
        webDriver.findElement(new By.ByName(param.getCvv())).sendKeys(offer.getCvv());
        webDriver.findElement(new By.ByName(param.getCardNumber())).sendKeys(offer.getCardNumber());
        webDriver.findElement(new By.ByName(param.getYear())).sendKeys(offer.getYear());
        webDriver.findElement(new By.ByName(param.getDay())).sendKeys(offer.getDay());
        webDriver.findElement(new By.ByName(param.getMonth())).sendKeys(offer.getMonth());
        webDriver.findElement(new By.ByName(param.getPostcode())).sendKeys(offer.getPostcode());
        webDriver.findElement(new By.ByName(param.getState())).sendKeys(offer.getState());
        Thread.sleep(2000);
        webDriver.findElement(new By.ByXPath("//input[@class='" + offer.getSubmit2() + "']")).click();
        Thread.sleep(2000);
        webDriver.quit();
    }

    public static void typeOffer3(WebDriver webDriver, Offer offer, Offer param) throws InterruptedException {
        webDriver.findElement(new By.ByName(param.getLastName())).sendKeys(offer.getLastName());
        webDriver.findElement(new By.ByName(param.getEmail())).sendKeys(offer.getEmail());
        webDriver.findElement(new By.ByName(param.getYear())).sendKeys(offer.getYear());
        webDriver.findElement(new By.ByName(param.getName())).sendKeys(offer.getName());
        webDriver.findElement(new By.ByName(param.getCardNumber())).sendKeys(offer.getCardNumber());
        webDriver.findElement(new By.ByName(param.getCvv())).sendKeys(offer.getCvv());
        webDriver.findElement(new By.ByName(param.getCity())).sendKeys(offer.getCity());
        Thread.sleep(2000);
        webDriver.findElement(new By.ByName(param.getCountry())).sendKeys(offer.getCountry());
        webDriver.findElement(new By.ByName(param.getDay())).sendKeys(offer.getDay());
        webDriver.findElement(new By.ByName(param.getMonth())).sendKeys(offer.getMonth());
        webDriver.findElement(new By.ByName(param.getPhone())).sendKeys(offer.getPhone());
        webDriver.findElement(new By.ByName(param.getPostcode())).sendKeys(offer.getPostcode());
        webDriver.findElement(new By.ByName(param.getState())).sendKeys(offer.getState());
        Thread.sleep(2000);
        webDriver.findElement(new By.ByXPath("//input[@class='" + offer.getSubmit1() + "']")).click();
        webDriver.findElement(new By.ByXPath("//input[@class='" + offer.getSubmit2() + "']")).click();
        Thread.sleep(2000);
        webDriver.quit();
    }
}
