package com.web.selenium.model;

import com.web.selenium.pojo.Offer;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

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

        HSSFSheet sheet = wookbook.getSheet("Sheet1");

        //获取到Excel文件中的所有行数
        int rows = sheet.getPhysicalNumberOfRows();

        //遍历行
        List<Offer> list = new ArrayList<Offer>();

        for (int i = 1; i < rows; i++) {
            // 读取左上端单元格
            HSSFRow row = sheet.getRow(i);

            // 行不为空
            if (row != null) {
                Map<String, Object> map = new HashMap<String, Object>();

                //获取到Excel文件中的所有的列
                int cells = row.getPhysicalNumberOfCells();

                //卡号
                row.getCell(0).setCellType(CellType.STRING);
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

                row.getCell(8).setCellType(CellType.STRING);
                HSSFCell Phone = row.getCell(8);
                String phone = getValue(Phone);
                //卡code
                HSSFCell Postcode = row.getCell(4);
                String postcode = getValue(Postcode);

                //日
                HSSFCell CC = row.getCell(12);
                String cc = getValue(CC);

                row.getCell(13).setCellType(CellType.STRING);
                HSSFCell realPhone = row.getCell(13);
                String realphone = getValue(realPhone);
                Offer offer = new Offer(cardNumber, lastName, name, year, month, cvv, postcode, country, city, email, phone, state, cc, "0" + realphone);

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
            String Number = String.valueOf(xSSFCell.getNumericCellValue());
            if (Number.contains(",")) {
                Number = Number.replace(",", "");
            }
            return Number.replace(".0", "");
        } else {
            // 返回字符串类型的值
            return String.valueOf(xSSFCell.getStringCellValue());
        }
    }

    public void exportExcel(List<Offer> offers, HttpServletResponse response) throws IOException {

        HSSFWorkbook wb = new HSSFWorkbook();

        //编辑excel表格的页脚
        HSSFSheet sheet = wb.createSheet("获取excel测试表格");
        //创建第一个单元格
        HSSFRow row = sheet.createRow(0);
        //设置行高
        row.setHeight((short) (26.25 * 20));
        //为第一行单元格设值
        row.createCell(0).setCellValue("用户信息列表");

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第1行结束
         *从第1个单元格开始
         *从第3个单元格结束
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 2);
        sheet.addMergedRegion(rowRegion);

		/*CellRangeAddress columnRegion = new CellRangeAddress(1,4,0,0);
		sheet.addMergedRegion(columnRegion);*/


        /*
         * 动态获取数据库列 sql语句 select COLUMN_NAME from INFORMATION_SCHEMA.Columns where table_name='user' and table_schema='test'
         * 第一个table_name 表名字
         * 第二个table_name 数据库名称
         * */
        //创建第二行表格
        row = sheet.createRow(1);
        //设置行高
        row.setHeight((short) (22.50 * 20));
        //为第一个单元格设值
        row.createCell(0).setCellValue("cardNumber");
        //为第二个单元格设值
        row.createCell(1).setCellValue("email");
        //为第三个单元格设值
        row.createCell(2).setCellValue("phone");
        //为第四个单元格设值
        row.createCell(2).setCellValue("address");
        //为第五个单元格设值
        row.createCell(2).setCellValue("country");

        for (int i = 0; i < offers.size(); i++) {
            //创建第i+2行单元表格
            row = sheet.createRow(i + 2);
            Offer offer = offers.get(i);
            row.createCell(0).setCellValue(offer.getCardNumber());
            row.createCell(1).setCellValue(offer.getEmail());
            row.createCell(2).setCellValue(offer.getPhone());
            row.createCell(3).setCellValue(offer.getAddress());
            row.createCell(4).setCellValue(offer.getCountry());
        }
        //设置默认行高
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应，
        for (int i = 0; i <= offers.size() + 2; i++) {
            sheet.autoSizeColumn(i);
        }
        /*
         * 下载到指定文件夹内
         */
        OutputStream os = response.getOutputStream();
        String resultName = "";
        String ctxPath = "C:\\Users\\Administrator\\Desktop\\cmh";
        String name = new SimpleDateFormat("ddHHmmss").format(new Date());
        String fileName = name + "users.xlsx";
        String bizPath = "files";
        String nowday = new SimpleDateFormat("yyyyMMdd").format(new Date());
        File file = new File(ctxPath + File.separator + bizPath + File.separator + nowday);
        if (!file.exists()) {
            file.mkdirs();// 创建文件根目录
        }
        String savePath = file.getPath() + File.separator + fileName;
        resultName = bizPath + File.separator + nowday + File.separator + fileName;
        if (resultName.contains("\\")) {
            resultName = resultName.replace("\\", "/");
        }
        System.out.print(resultName);
        System.out.print(savePath);
        // 响应到客户端需要下面注释的代码
//            this.setResponseHeader(response, filename);
//            OutputStream os = response.getOutputStream(); //响应到服务器
        // 保存到当前路径savePath
        os = new FileOutputStream(savePath);

        wb.write(os);
        os.flush();
        os.close();
    }
}
