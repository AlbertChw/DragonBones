package com.albert.dragonbones.jdk;

import com.albert.dragonbones.validation.UserBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * Java8 新特性——Map的骚操作
 */
public class MapTest {

    public static void main(String[] args) {

//        foreach();
//        replaceAll();
//        putIfAbsent();
//        computeIfAbsent();
//        merge();
        String s = "{\"23984\":\"19177328\",\"22798\":\"18701501\"}";

        Map<String, Object> map = (Map<String, Object>) JSONObject.parse(s);


        System.out.println(map.get("22798"));

        Long l = Long.parseLong(map.get("22798").toString());
        System.out.println(l);
    }


    /**
     * 新的遍历方式
     */
    public static void foreach() {
        Map<Integer, UserBean> map = new HashMap<>();
        UserBean e1 = new UserBean();
        e1.setName("name1");
        map.put(1, e1);

        UserBean e2 = new UserBean();
        e2.setName("name2");
        map.put(2, e2);
        map.forEach((k, v) -> System.out.println(k + "-" + v.getName()));
    }

    /**
     * 批量修改
     */
    public static void replaceAll() {
        Map<Integer, UserBean> map = new HashMap<>();
        UserBean e1 = new UserBean();
        e1.setName("name1");
        e1.setAge(10);
        map.put(1, e1);

        UserBean e2 = new UserBean();
        e2.setName("name2");
        map.put(2, e2);
        System.out.println(JSON.toJSONString(map));

        //将age == null 设置为9
        map.replaceAll((k, v) -> {
            v.setAge(Optional.ofNullable(v.getAge()).orElse(9));
            return v;
        });

        System.out.println(JSON.toJSONString(map));
    }

    /**
     * 如果当前Key在Map中不存在就put
     */
    public static void putIfAbsent() {

        //传统方式
        Map<String, UserBean> map = new HashMap<>();
        UserBean u = map.get("putIfAbsent");
        if (u == null) {
            u = new UserBean();
            u.setName("名字");
            map.put("putIfAbsent", u);
        }
        System.out.println(JSON.toJSONString(map));


        //新方式
        Map<String, UserBean> map1 = new HashMap<>();
        u = new UserBean();
        u.setName("名字1");
        map1.putIfAbsent("putIfAbsent", u);
        System.out.println(JSON.toJSONString(map1));
    }

    /**
     * 首先判断提供的Key在map中是否存在，如果不存在，则根据输入的Key进行处理生成一个值，然后put到Map中
     */
    public static void computeIfAbsent() {
        Map<Integer, Double> sqrt = new HashMap<>();
        sqrt.computeIfAbsent(31, Math::sqrt);
        System.out.println(JSON.toJSONString(sqrt));
    }

    /**
     * 合并操作，如果key值不存在，则直接用新值替换；否则根据提供的算子处理新值与旧值，如果处理结果为空删除key，否则用处理结果替换value。
     */
    public static void merge() {
        //学生的集合
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三", "男", 18));
        students.add(new Student("李四", "男", 20));
        students.add(new Student("韩梅梅", "女", 18));
        students.add(new Student("小红", "女", 45));
        Map<String, Integer> resultMap = new HashMap<>();

        //第一个是所选map的key，第二个是需要合并的值，第三个是 如何合并，也就是说合并方法的具体实现
        students.forEach(student -> resultMap.merge(student.getSex(), student.getScore(), Integer::sum));

        System.out.println(JSON.toJSONString(resultMap));
    }

    private static class Student {
        private String name;
        private String sex;
        private Integer score;

        public Student() {
        }

        public Student(String name, String sex, Integer score) {
            this.name = name;
            this.sex = sex;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }
}
