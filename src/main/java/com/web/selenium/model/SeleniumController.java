package com.web.selenium.model;

import com.web.selenium.pojo.Offer;
import com.web.selenium.untils.ExcelImport;
import com.web.selenium.untils.Selenium;
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
        int i = 5;
        Random random = new Random();
        List<Offer> offers = ExcelImport.importExcelAction(filePath);
        List<String> uas = readtxt.readTxt(path);
        List<Offer> offerList = new ArrayList<>();
        while (i > 0) {
            int uaNumber = Math.abs(random.nextInt(uas.size()));
            int offerNumber = Math.abs(random.nextInt(offers.size()));
            System.out.println("Fake browser access:" + uas.get(uaNumber));
            System.out.println("Fake identity login" + offers.get(offerNumber).toString());
            Selenium.selenium(offers.get(offerNumber), uas.get(uaNumber), param);
            offerList.add(offers.get(offerNumber));
            i--;
        }
        ExcelImport.exportExcel(offerList, param.getTypeOffer());
        return param;
    }
}
