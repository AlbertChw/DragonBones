package com.albert.dragonbones.validation;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * 简单参数校验
 *
 * Created by Albert on 2018/7/18.
 */
public class UserBean {
    @Range(min = 20, max = 50, message = "age应该在[20，50]之间")
    private Integer age;

    @NotNull(message = "name不能为空")
    private String name;

    @Length(max = 100, message = "address不能超过100")
    private String address;

    @Email(message = "email格式不对")
    private String email;

    @ZipCode(message = "邮编格式错误")
    private String zipCode;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}