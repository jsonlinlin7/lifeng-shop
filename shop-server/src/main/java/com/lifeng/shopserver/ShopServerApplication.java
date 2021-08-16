package com.lifeng.shopserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//mybatis扫描mapper包，生成代理
@MapperScan("com.lifeng.shopserver.**.mapper")
public class ShopServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopServerApplication.class, args);
    }

}
