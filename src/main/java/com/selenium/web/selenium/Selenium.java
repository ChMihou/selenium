package com.selenium.web.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Selenium {

    public static void Selenium(Offer offer, String ua, Offer param) throws InterruptedException {
        Thread.sleep(3000);
        //获取Ip
        System.out.println(getIp());
        DesiredCapabilities capabilities;
        ChromeOptions options = new ChromeOptions();
        WebDriver webDriver;
        if (ua.contains("mobile")) {
            Map<String, String> mobileEmulation = new HashMap<String, String>();
            mobileEmulation.put("deviceName", "Galaxy S5");
            ChromeOptions headlessOptions = new ChromeOptions();
            headlessOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, headlessOptions);
            webDriver = new ChromeDriver(capabilities);
        } else {
            options.addArguments("Accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            options.addArguments("Accept-Encoding=gzip, deflate, sdch");
            options.addArguments("Accept-Language=fr-be,zh;q=0.8");
            options.addArguments("Upgrade-Insecure-Requests=1");
            options.addArguments("User-Agent=" + ua);
            webDriver = new ChromeDriver(options);
        }
        System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
        //火狐浏览器
//        System.setProperty("webdriver.gecko.driver", "c://geckodriver.exe");
//        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        // 与浏览器同步非常重要，必须等待浏览器加载完毕
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //打开目标地址
        webDriver.get(param.getUrl());
        //输入账号 密码并登陆系统
        Thread.sleep(1000);
        webDriver.findElement(new By.ByName(param.getName())).sendKeys(offer.getLastName());
        webDriver.findElement(new By.ByName(param.getEmail())).sendKeys(offer.getEmail());
        webDriver.findElement(new By.ByName(param.getYear())).sendKeys(offer.getYear());
        webDriver.findElement(new By.ByName(param.getLastName())).sendKeys(offer.getLastName());
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

    public static String getIp() {
        try {
            InetAddress ia = InetAddress.getLocalHost();
            return ia.getHostAddress();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "500";
        }
    }
}