package com.sellhouse;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sellhouse.mapper")
public class Application {

  @PostConstruct
  void started() {
    TimeZone.setDefault(TimeZone.getTimeZone("CTT"));
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
