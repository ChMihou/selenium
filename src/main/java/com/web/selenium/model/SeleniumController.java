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
        String filePath = "C:\\Users\\Administrator\\Desktop\\2.xlsx";
        String path = "C:\\Users\\Administrator\\Desktop\\ua.txt";
        int i = 10;
        Random random = new Random();
        List<Offer> offers = ExcelImport.importExcelAction(filePath);
        List<String> uas = readtxt.readTxt(path);
        System.out.println(param.toString());
        System.out.println(offers.get(Math.abs(random.nextInt(offers.size()))));
        while (i > 0) {
            int uaNumber = Math.abs(random.nextInt(uas.size()));
            int offerNumber = Math.abs(random.nextInt(offers.size()));
            System.out.println("虚伪身份访问:" + uas.get(uaNumber));
            Selenium.Selenium(offers.get(offerNumber), uas.get(uaNumber), param);
            i--;
        }
        return true;
    }
}
