package com.albert.dragonbones;

import com.albert.dragonbones.validation.BeanValidator;
import com.albert.dragonbones.validation.UserBean;
import org.junit.Test;

public class ValidatorTest1 {

    @Test
    public void validatorTest() {
        UserBean userBean = new UserBean();
        userBean.setAge(12);
        userBean.setName("张三");
        userBean.setAddress("124444444112");
        userBean.setEmail("123");
        userBean.setZipCode("000111");
        BeanValidator.validate(userBean);
    }
}