package com.albert.dragonbones.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.*;

/**
 * @description:
 * @author: Albert
 * @createDate: 2020-08-20
 * @version: 1.0
 */
public class DealWorkBook {
    public static Map<Integer, List<String>> dealWorkBook(Workbook workBook) {
        Sheet sheet = workBook.getSheetAt(0); // 获取第一个sheet
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>(); //第一个参数表示行数 第二个List保存该行的cell数据
        int i = 0;
        for (Row row : sheet) {

            map.put(i, new ArrayList<String>());
            for (Cell cell : row) { // 遍历当前行的所有cell
                switch (cell.getCellType()) {
                    case STRING:
                        map.get(i).add(cell.getRichStringCellValue().getString()); // 如果是字符串则保存
                        break;
                    case _NONE:
                        break;
                    case NUMERIC:
                        map.get(i).add(cell.getNumericCellValue() + ""); //将数值转换为字符串
                        break;
                    case BOOLEAN:
                        break;
                    case FORMULA:
                        break;
                    case BLANK:
                        break;
                    case ERROR:
                        break;
                }
            }
            i++;
        }
        return map;

    }
}
