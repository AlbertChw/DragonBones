package com.albert.dragonbones.csv;

import com.albert.dragonbones.pingyin4j.PinyinUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.MapUtils;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Albert on 2019/4/24.
 */
public class ReadCSV {

    public static List<String> readCSV(String path) throws IllegalAccessException, InstantiationException {
        File csv = new File(path);  // CSV文件路径
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        List<String> allString = new ArrayList<>();
//        clz.newInstance();//通过Class类的实例获得UserInfo的实例
        try {

            int i = 0;
            while ((line = br.readLine()) != null)  //读取到的内容给line变量
            {
                if (i == 0) {
                    i = 1;
                    continue;
                }
                everyLine = line;
//                    System.out.println(everyLine);
                allString.add(everyLine);
            }
            System.out.println("csv表格中所有行数：" + allString.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allString;
    }

    public static void main(String[] args) throws Exception {



//        List<String> lineList = readCSV("/Users/Albert/Downloads/x.txt");
//
//        for (String line : lineList) {
//            Map<String, Object> map = JSON.parseObject(line, Map.class);
//            if (MapUtils.isNotEmpty(map)) {
//                Map.Entry<String, Object> entry = head(map);
//
//                System.out.println(entry.getKey());
//                System.out.println(entry.getValue().toString());
//                System.out.println(" ------> ");
//            }
//        }
    }
    private static Map.Entry<String, Object> head(Map<String, Object> map) {
        if (MapUtils.isEmpty(map)) {
            return null;
        }
        Map.Entry<String, Object> obj = null;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry != null) {
                return entry;
            }
        }
        return obj;
    }

}
