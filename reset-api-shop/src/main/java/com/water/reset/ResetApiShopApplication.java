package com.water.reset;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class ResetApiShopApplication {

    public static void main(String[] args) {
        System.out.println("启动开始");
        SpringApplication.run(ResetApiShopApplication.class, args);
        System.out.println("启动成功");
    }

}
