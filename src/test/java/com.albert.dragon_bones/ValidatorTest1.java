package com.albert.dragon_bones;

import com.albert.dragon_bones.thread.validation.BeanValidator;
import com.albert.dragon_bones.thread.validation.UserBean;
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