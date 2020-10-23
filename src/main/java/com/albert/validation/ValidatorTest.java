package com.albert.validation;

public class ValidatorTest {

    public static void main(String[] args) {
        UserBean userBean = new UserBean();
//        userBean.setAge(55);
        userBean.setName("张三");
        userBean.setAddress("124444444112");
        userBean.setEmail("123");
        userBean.setZipCode("000111");
        BeanValidator.validate(userBean);
    }
}