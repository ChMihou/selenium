package com.web.selenium.model;

import com.web.selenium.pojo.Offer;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description : TODO导入excel
 * @date : Mar 31, 2018 5:17:14 PM
 */

public class ExcelImport {

    public static void main(String args[]) {
        try {
            //文件路径
            String filePath = "D:/offer.xls";
            List<Offer> offers = importExcelAction(filePath);
            for (Offer offer : offers) {
                System.out.println(offer);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block

            e.printStackTrace();

        }

    }

    //导入Excel数据

    public static List<Offer> importExcelAction(String filePath) throws Exception {

        HSSFWorkbook wookbook = new HSSFWorkbook(new FileInputStream(filePath));

        HSSFSheet sheet = wookbook.getSheet("offer");

        //获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        //遍历行
        List<Offer> list = new ArrayList<Offer>();

        for (int i = 0; i < rows; i++) {
            // 读取左上端单元格
            HSSFRow row = sheet.getRow(i);

            // 行不为空
            if (row != null) {
                Map<String, Object> map = new HashMap<String, Object>();

                //获取到Excel文件中的所有的列
                int cells = row.getPhysicalNumberOfCells();

                //卡号
                HSSFCell cardNum = row.getCell(0);
                String cardNumber = getValue(cardNum);
                //持有人姓氏
                HSSFCell LName = row.getCell(6);
                String lastName = getValue(LName);
                //持有人名字
                HSSFCell Name = row.getCell(5);
                String name = getValue(Name);
                //年份
                HSSFCell Year = row.getCell(1);
                String year = getValue(Year);
                //月份
                HSSFCell Month = row.getCell(2);
                String month = getValue(Month);
                //日
                HSSFCell Cvv = row.getCell(3);
                String cvv = getValue(Cvv);
                //国家
                HSSFCell Country = row.getCell(10);
                String country = getValue(Country);
                //城市
                HSSFCell Address = row.getCell(9);
                String city = getValue(Address);
                //邮箱
                HSSFCell Email = row.getCell(7);
                String email = getValue(Email);
                //state
                HSSFCell State = row.getCell(11);
                String state = getValue(State);
                HSSFCell Phone = row.getCell(8);
                String phone = getValue(Phone);
                //卡code
                HSSFCell Postcode = row.getCell(4);
                String postcode = getValue(Postcode);

                //日
                HSSFCell CC = row.getCell(12);
                String cc = getValue(CC);

                HSSFCell realPhone = row.getCell(13);
                String realphone = getValue(realPhone);

                Offer offer = new Offer(cardNumber, lastName, name, year, month, cvv, postcode, country, city, email, phone, state,cc,realphone);

                list.add(offer);
            }
        }
        return list;
    }

    private static String getValue(HSSFCell xSSFCell) {
        if (null == xSSFCell) {
            return "";
        }
        if (xSSFCell.getCellTypeEnum() == CellType.BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(xSSFCell.getBooleanCellValue());
        } else if (xSSFCell.getCellTypeEnum() == CellType.NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(xSSFCell.getNumericCellValue()).replace(".0", "");
        } else {
            // 返回字符串类型的值
            return String.valueOf(xSSFCell.getStringCellValue());
        }
    }
}
