package com.albert.dragonbones.csv;

import com.albert.dragonbones.pingyin4j.PinyinUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Albert on 2019/4/24.
 */
public class ReadCSV {

    private static Set<Map.Entry<String, Map<String, Boolean>>> en;

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

//day , <cargoId, exist>
        Map<String, Map<String, Boolean>> total = new HashMap<>();

        Map<String, Boolean> innerMap;

        List<String> lineList = readCSV("/Users/Albert/Downloads/隐私电话");

        for (int i =1 ; i<=166224 ;i++) {

            String line = lineList.get(i);
            if (StringUtils.isNotBlank(line)) {
                //split
                String day = line.split(",")[0];
                String cargoid = line.split(",")[1];
                boolean exist = "1.0".equals(line.split(",")[6]);
                System.out.println(i);
                innerMap  = total.get(day);//day
                if (MapUtils.isEmpty(innerMap)) {
                    innerMap = new HashMap<>();
                    innerMap.put(cargoid, exist);

                    total.put(day, innerMap);
                } else {
                    if(innerMap.get(cargoid) != null && !innerMap.get(cargoid)) {
                        innerMap.put(cargoid, exist);
                    }
                    total.put(day, innerMap);
                }

            }

        }

        en = total.entrySet();
        for (Map.Entry<String, Map<String, Boolean>> e : en) {
            Map<String, Boolean> v = e.getValue();
            int a = 0;
            Collection<Boolean> list = v.values();
            for(Boolean bool : list){
                if (bool) {
                    a++;
                }
            }

            System.out.println(e.getKey() +"  总货源  "+ e.getValue().size() + "  "+ a/e.getValue().size());
        }
    }

}
