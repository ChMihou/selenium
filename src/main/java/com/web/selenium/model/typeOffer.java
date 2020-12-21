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
        Thread.sleep(5000);
        webDriver.findElement(new By.ByName("expires_year")).sendKeys(offer.getYear());
        webDriver.findElement(new By.ByName("cardNumber")).sendKeys(offer.getCardNumber() + "");
        webDriver.findElement(new By.ByName("csc")).sendKeys(offer.getCvv());
        webDriver.findElement(new By.ByName("expires_month")).sendKeys(offer.getMonth());
        webDriver.findElement(new By.ByName("zip")).sendKeys(offer.getPostcode());
        Thread.sleep(3000);
        webDriver.findElement(new By.ByName("submit")).click();
        Thread.sleep(50000);
        webDriver.quit();
    }

    public static void typeOffer142355(WebDriver webDriver, Offer offer) throws InterruptedException {
        webDriver.findElement(new By.ByName("firstname")).sendKeys(offer.getName());
        webDriver.findElement(new By.ByName("lastname")).sendKeys(offer.getLastName());
        webDriver.findElement(new By.ByName("email")).sendKeys(offer.getEmail());
        webDriver.findElement(new By.ByName("address")).sendKeys(offer.getAddress());
        webDriver.findElement(new By.ByName("zip")).sendKeys(offer.getPostcode());
        webDriver.findElement(new By.ByName("city")).sendKeys(offer.getCountry());
        webDriver.findElement(new By.ByName("bd_day")).sendKeys("18");
        webDriver.findElement(new By.ByName("bd_month")).sendKeys("L");
        webDriver.findElement(new By.ByName("bd_year")).sendKeys("1996");
        webDriver.findElement(new By.ByName("phone")).sendKeys(offer.getPhone() + "");
        webDriver.findElement(new By.ByXPath("//input[@class='p-acceptterms__input']\"")).click();
        Thread.sleep(3000);
        webDriver.findElement(new By.ByXPath("//button[@class='submit-button submit-button--emailandaddress']")).click();
        Thread.sleep(5000);
        webDriver.findElement(new By.ByName("cardnumber")).sendKeys(offer.getCardNumber() + "");
        webDriver.findElement(new By.ByName("cardholder")).sendKeys(offer.getLastName());
        webDriver.findElement(new By.ByName("card.cvv")).sendKeys(offer.getCvv());
        webDriver.findElement(new By.ByName("//input[@class='wpwl-control wpwl-control-expiry']")).sendKeys(offer.getMonth() + offer.getYear().substring(2));
        Thread.sleep(3000);
        webDriver.findElement(new By.ByXPath("//input[@class='wpwl-button wpwl-button-pay']")).click();
        Thread.sleep(50000);
        webDriver.quit();
    }

    public static void typeOffer141237(WebDriver webDriver, Offer offer) throws InterruptedException {
        webDriver.findElement(new By.ByName("firstname")).sendKeys(offer.getName());
        webDriver.findElement(new By.ByName("lastname")).sendKeys(offer.getLastName());
        webDriver.findElement(new By.ByName("email")).sendKeys(offer.getEmail());
        Thread.sleep(3000);
        webDriver.findElement(new By.ByXPath("//button[@class='claim submit-button submit-button--emailandaddress']")).click();
        Thread.sleep(5000);
        webDriver.findElement(new By.ByName("cardholder")).sendKeys(offer.getName() + " " + offer.getLastName());
        webDriver.findElement(new By.ByName("monthexpiredate")).sendKeys(offer.getMonth());
        webDriver.findElement(new By.ByName("yearexpiredate")).sendKeys(offer.getYear().substring(2));
        webDriver.findElement(new By.ByName("cardnumber")).sendKeys(offer.getCardNumber() + "");
        webDriver.findElement(new By.ByName("security")).sendKeys(offer.getCvv());
        Thread.sleep(3000);
        webDriver.findElement(new By.ByXPath("//button[@class='btn btn-gradient btn-block px-4 ladda-button heart cardSubmitButton']")).click();
        Thread.sleep(50000);
        webDriver.quit();
    }

}
