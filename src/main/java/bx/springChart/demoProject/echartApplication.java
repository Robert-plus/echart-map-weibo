package bx.springChart.demoProject;


import lombok.extern.slf4j.Slf4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
//@MapperScan("bx.springChart.mybatisDemo.mapper")//使用MapperScan批量扫描所有的Mapper接口；
public class echartApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(echartApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
