package dragonbones;

import com.albert.dragonbones.validation.BeanValidator;
import com.albert.dragonbones.validation.UserBean;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class ValidatorTest1 {

    @Test
    public void validatorTest() {
        UserBean userBean = new UserBean();
        userBean.setAge(12);
        userBean.setName("张三");
        userBean.setAddress("124444444112");
        userBean.setEmail("123");
        userBean.setZipCode("000111");
//        BeanValidator.validate(userBean);


        System.out.println("84361514977640649629897056027297".length());


        BigDecimal a = new BigDecimal("1");
        BigDecimal b= null;
    }


    public static int differentDaysByMillisecond(Date date1, Date date2)
    {
        return (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
    }

    public static void main(String[] args) {
//        System.out.println(isOneYearLater(new Date()));
        Date now = new Date();

        Date d2 = DateUtils.addDays(now,-120);
        System.out.println(differentDaysByMillisecond(d2, now));
    }
}