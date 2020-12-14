package com.web.selenium.model;

import com.web.selenium.pojo.Offer;
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
        if (param.getTypeOffer() != null && param.getTypeOffer() > 0 && param.getTypeOffer() < 4) {
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
            if (param.getTypeOffer() == 1) {
                typeOffer.typeOffer1(webDriver, offer, param);
            } else if (param.getTypeOffer() == 2) {
                typeOffer.typeOffer2(webDriver, offer, param);
            } else if (param.getTypeOffer() == 3) {
                typeOffer.typeOffer3(webDriver, offer, param);
            }
        }
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