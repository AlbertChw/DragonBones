package com.albert.spring.domain;

import com.albert.spring.annotation.Super;

/**
 * @description:
 * @author: Albert
 * @createDate: 2020-09-24
 * @version: 1.0
 */
@Super
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
