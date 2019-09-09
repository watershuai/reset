package com.water.reset.action;

import com.water.reset.utils.RateLimiter;

import java.util.Scanner;

/**
 * @Description: TODO
 * @author:water
 * @Data:
 */
public class Test {
    public static void main(String[] args) {
        //令牌桶限流：峰值每秒可以处理10个请求，正常每秒可以处理3个请求
        RateLimiter rateLimiter = new RateLimiter(10, 3);

        //模拟请求
        while (true){
            //在控制台输入一个值按回车，相对于发起一次请求
            Scanner scanner = new Scanner(System.in);
            scanner.next();

            //令牌桶返回true或者false
            if(rateLimiter.execute()){
                System.out.println("允许访问");
            }else{
                System.err.println("禁止访问");
            }
        }
    }
}
