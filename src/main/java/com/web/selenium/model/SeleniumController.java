package com.web.selenium.model;

import com.web.selenium.pojo.Offer;
import com.web.selenium.untils.ExcelImport;
import com.web.selenium.untils.Selenium;
import com.web.selenium.untils.changeAwsIp;
import com.web.selenium.untils.readtxt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class SeleniumController {

    @RequestMapping("/")
    public String test() {
        return "/TestOffer";
    }

    @RequestMapping("/testSelenium")
    @ResponseBody
    public Offer testSelenium(Offer param) throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\cmh\\user.xls";
        String path = "C:\\Users\\Administrator\\Desktop\\cmh\\User-Agent.txt";
        Random random = new Random();
        List<Offer> offers = ExcelImport.importExcelAction(filePath);
        List<String> uas = readtxt.readTxt(path);
        List<Offer> offerList = new ArrayList<>();
        String allocation_id;
        allocation_id = changeAwsIp.bindIp2Instance();
        for (Offer offer : offers) {
            int uaNumber = Math.abs(random.nextInt(uas.size()));
            System.out.println("Fake browser access:" + uas.get(uaNumber));
            System.out.println("Fake identity login" + offer.toString());
            Selenium.selenium(offer, uas.get(uaNumber), param, offerList);
            changeAwsIp.freedIp(allocation_id);
            allocation_id = changeAwsIp.bindIp2Instance();
        }
        ExcelImport.exportExcel(offerList, param.getTypeOffer());
        return param;
    }
}
