package com.oblenergo.chatBot.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "com.oblenergo.chatBot", exclude=SecurityAutoConfiguration.class)
@PropertySource("classpath:serviceSecure.properties")
public class ChatBotApplication {

  public static void main(String[] args) {
    
    SpringApplication.run(ChatBotApplication.class, args);
  }
}
