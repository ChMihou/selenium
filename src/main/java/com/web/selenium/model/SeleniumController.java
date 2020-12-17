package com.web.selenium.model;

import com.web.selenium.pojo.Offer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public boolean testSelenium(Offer param) throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\cmh\\user.xls";
        String path = "C:\\Users\\Administrator\\Desktop\\cmh\\User-Agent.txt";
        int i = 10;
        Random random = new Random();
        List<Offer> offers = ExcelImport.importExcelAction(filePath);
        List<String> uas = readtxt.readTxt(path);
        while (i > 0) {
            int uaNumber = Math.abs(random.nextInt(uas.size()));
            int offerNumber = Math.abs(random.nextInt(offers.size()));
            System.out.println("Fake browser access:" + uas.get(uaNumber));
            System.out.println("Fake identity login"+offers.get(offerNumber).toString());
            Selenium.Selenium(offers.get(offerNumber), uas.get(uaNumber), param);
            i--;
        }
        return true;
    }
}
