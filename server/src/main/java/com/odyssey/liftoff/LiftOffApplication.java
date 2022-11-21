package com.odyssey.liftoff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LiftOffApplication {

  public static void main(String[] args) {
    SpringApplication.run(LiftOffApplication.class, args);
  }

}
