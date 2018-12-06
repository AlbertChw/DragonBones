package com.albert.dragonbones.orika;

import com.alibaba.fastjson.JSON;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaTest {

    public static void main(String[] args) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        //假设你映射的对象的一些字段的名称并不匹配,你可以通过ClassMapBuider API来为这些不同的fields注册映射关系：
        mapperFactory.classMap(Person.class, PersonDTO.class).field("ext1", "ext2").byDefault().register();

        /*//假设你映射的对象中有的字段你不想copy，你可以通过exclude进行过滤
        mapperFactory.classMap(PersonDTO.class, Person.class).exclude("sex").byDefault().register();*/
        MapperFacade mapper = mapperFactory.getMapperFacade();

        Person person = new Person();
        person.setId(1);
        person.setName("小王");
        person.setSex(1);
        person.setExt1("ext...");

        PersonDTO personDTO = mapper.map(person, PersonDTO.class);
        System.out.println(JSON.toJSONString(personDTO));
    }

}
