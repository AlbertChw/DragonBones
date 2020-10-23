package com.albert.dragonbones.spring;

import com.albert.dragonbones.spring.annotation.Super;
import com.albert.dragonbones.spring.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @description: 依赖注入
 * @author: Albert
 * @createDate: 2020-09-24
 * @version: 1.0
 */
public class DependencyInjection {
    public static void main(String[] args) {

        //读取xml配置文件
        //启动spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/spring-lookup.xml");

        //按类型查找
        lookupByType(beanFactory);

        //按名称查找
        lookupByName(beanFactory);

        //延迟查找
        lookupInlazy(beanFactory);

        lookupCollectionByType(beanFactory);


        //按注解查找
        lookupByAnnotation(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> map = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 所有的User集合对象"+map);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String , User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有的User集合对象"+map);
        }
    }

    //ObjectFactory 对象并不是直接返回了实际的 Bean，而是一个 Bean 的查找代理。
    // 当得到 ObjectFactory 对象时，相当于 Bean 没有被创建，只有当 getObject() 方法时，才会触发 Bean 实例化等生命周期。
    private static void lookupInlazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找:" + user);
    }

    private static void lookupByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("按名称查找:"+user);
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("按类型查找:"+user);
    }
}
