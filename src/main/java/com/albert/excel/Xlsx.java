package com.albert.dragonbones.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: Albert
 * @createDate: 2020-08-20
 * @version: 1.0
 */
public class Xlsx extends DealWorkBook {
    public static Map<Integer, List<String>> testXlsx(String path) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return null;
        }
        FileInputStream fis = null;
        Workbook workBook = null;
        try {
            fis = new FileInputStream(file);
            workBook = new XSSFWorkbook(fis); // 使用XSSFWorkbook
            return dealWorkBook(workBook); // 将代码封装复用，见下一个方法

        } catch (Exception e) {
            e.printStackTrace();
        } finally { //关流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (workBook != null) {
                try {
                    workBook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Map<Integer, List<String>> map = testXlsx("/Users/Albert/Downloads/0820-1027.xlsx");

        StringBuilder builder = new StringBuilder("select * from dwd.dwd_flow_ada_time_predict_hi where  tags = \"truckLengthRecommend\" and cargo_id in (");
        Set<Integer> keys = map.keySet(); // 以下为遍历 Map看解析结果
        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            if (key == 0) {
                continue;
            }
            List<String> list = map.get(key);
            for (int i=0; i<1; i++) {
                builder.append(list.get(i)).append(",");
            }
        }
        builder.append(");");
        System.out.println(builder.toString());
    }
}
