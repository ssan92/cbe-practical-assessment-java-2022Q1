package com.pichincha.store;

import com.pichincha.store.configuration.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({Properties.class})
public class ExamApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExamApplication.class, args);
  }

}
