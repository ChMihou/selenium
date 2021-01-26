package com.web.selenium.untils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class readtxt {
    public static List<String> readTxt(String path) throws IOException {
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        List<String> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
        // 防止路径乱码   如果utf-8 乱码  改GBK  用UTF-8，在电脑上自己创建的txt  用GBK
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
            if (line.lastIndexOf("---") < 0) {
                list.add(line);
            }
        }
        br.close();
        isr.close();
        fis.close();
        return list;
    }

    public static void writeFileContext(List<String> strings) throws Exception {
        String ctxPath = "C:\\Users\\Administrator\\Desktop\\cmh";
        String name = new SimpleDateFormat("ddHHmmss").format(new Date());
        String fileName = "Ip:" + name + ".txt";
        String bizPath = "files";
        String nowday = new SimpleDateFormat("yyyyMMdd").format(new Date());
        File file = new File(ctxPath + File.separator + bizPath + File.separator + nowday);
        //如果没有文件就创建
        if (!file.isFile()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath() + File.separator + fileName));
        for (String l : strings) {
            writer.write(l + "\r\n");
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        String path = "d:\\User-Agent.txt";
        int i = 10;
        for (String txt : readtxt.readTxt(path)) {
            System.out.println(txt);
            if (i < 0)
                break;
            i--;
        }
    }
}