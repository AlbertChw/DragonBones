package com.albert.dragonbones.csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

//        List<String> truckSeries = readCSV("/Users/Albert/Downloads/truck_series.csv");
//
//        List<String> truckBrand = readCSV("/Users/Albert/Downloads/truck_brand.csv");
//
//        List<String> truckModel = readCSV("/Users/Albert/Downloads/truck_model.csv");
//
//
//        List<Product> productList = new ArrayList<>();
//
//
//
//        List<String> insertProduct = new ArrayList<>();
//
//        String insert = " insert into `product` (`id`, `product_no`,`product_name`,`product_pic_url`,`brand_id`) values ()";

    }
}
