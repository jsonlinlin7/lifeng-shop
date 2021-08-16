package com.lifeng.shopserver.mapper;

import com.lifeng.shopserver.pojo.entry.Shopuser;
import com.lifeng.shopserver.service.ShopuserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopuserMapperTest {
    @Resource
    ShopuserService shopuserService;

    @Test
    //测试出数据库的内容，没问题
    public void test1() {
        List<Shopuser> shopuserList = shopuserService.list();
        for (Shopuser shopuser : shopuserList) {
            System.out.println(shopuser);
        }
    }

    /**
     * 测试增加数据
     */
    @Test
    public void test2() {
        Shopuser shopuser  = new Shopuser();
        shopuser.setPhone("12345");shopuser.setUsername("linlin7");shopuser.setPassword("123456");shopuser.setAddress("广东省");
        shopuserService.save(shopuser);
        System.out.println(shopuser);
    }
}