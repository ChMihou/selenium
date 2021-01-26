package com.web.selenium.untils;

import com.web.selenium.model.typeOffer;
import com.web.selenium.pojo.Offer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Selenium {

    public static void selenium(Offer offer, String ua, Offer param, List<Offer> offerList) throws InterruptedException {
        if (param.getTypeOffer() != null) {
            Thread.sleep(3000);
            //获取Ip
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\cmh\\chromedriver.exe");
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
                options.addArguments("User-Agent=" + ua);
                webDriver = new ChromeDriver(options);
            }
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
            offer.setId(param.getTypeOffer());
            if (param.getTypeOffer() == 142196) {
                typeOffer.typeOffer142196(webDriver, offer,offerList);
            } else if (param.getTypeOffer() == 142355) {
                typeOffer.typeOffer142355(webDriver, offer,offerList);
            } else if (param.getTypeOffer() == 141237) {
                typeOffer.typeOffer141237(webDriver, offer,offerList);
            } else if (param.getTypeOffer() == 143139) {
                typeOffer.typeOffer143139(webDriver, offer,offerList);
            } else if (param.getTypeOffer() == 143138) {
                typeOffer.typeOffer143138(webDriver, offer,offerList);
            } else if (param.getTypeOffer() == 142395) {
                typeOffer.typeOffer142395(webDriver, offer,offerList);
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