package com.albert.jdk;

import java.util.Optional;

/**
 * @description: Java Optional 实例介绍
 * @author: Albert
 * @createDate: 2019-07-23
 * @version: 1.0
 */
public class OptionalTest {

    public static void main(String[] args) {

//        create();
//        check();
//        get();
    }

    //1.创建
    public static void create () {
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.toString());

        Optional<String> ofOptional = Optional.of("name"); // 不支持 null
        System.out.println(ofOptional.get());//取值

        Optional<String> nonOptional = Optional.ofNullable(null); // 支持 null


    }

    //如果 Optional有值，isPresent() 返回 true
    public static void check(){
        Optional<String> nonEmptyOptional = Optional.of("name");
        System.out.println(nonEmptyOptional.isPresent());
    }

    // Optional 取值
    public static void get() {
        Optional<String> nonEmptyOptional = Optional.ofNullable("orignal");
        String value = nonEmptyOptional.get();//get() = 返回值包含在 Optional 中返回
        System.out.println(value);

        System.out.println("================");

        //orElse() = 如果值不存在，则返回默认值
        // Optional 包含 null 时, 使用 orElse 值
        Optional<String> emptyOptional = Optional.ofNullable(null);
        String defaultvalue = emptyOptional.orElse("default Value");
        System.out.println(defaultvalue);

        System.out.println("================");

        // Optional 不包含 null 时, 不使用 orElse 值
        Optional<String> optional = Optional.ofNullable("orginal");
        String value1 = optional.orElse("default Value");
        System.out.println(value1);

        System.out.println("================");


        // Optional 包含 null 时, 使用 orElse
        String v1 = emptyOptional.orElseGet(()->"default value");
        System.out.println(v1);

        // Optional 不包含 null 时, 不使用 orElse
        String v2 = nonEmptyOptional.orElseGet(()->"default value");
        System.out.println(v2);
    }

}


