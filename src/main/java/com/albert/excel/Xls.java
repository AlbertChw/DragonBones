package com.albert.dragonbones.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * @description:
 * @author: Albert
 * @createDate: 2020-08-20
 * @version: 1.0
 */
public class Xls extends DealWorkBook {
    public static void testXls(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }
        FileInputStream fis = new FileInputStream(file);
        Workbook workBook = new HSSFWorkbook(fis, true); // 使用HSSFWorkbook 构造函数略有不同 true表示转化成为Nodes
        dealWorkBook(workBook); //
        workBook.close();
        fis.close();
    }

    public static void main(String[] args) throws Exception {
        testXls("");
    }
}
