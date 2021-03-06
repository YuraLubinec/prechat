package com.oblenergo.chatBot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "com.oblenergo.chatBot", exclude = SecurityAutoConfiguration.class)
@PropertySource("classpath:serviceSecure.properties")
public class ChatBotApplication  {

  public static void main(String[] args) {

    SpringApplication.run(ChatBotApplication.class, args);
  }
}

//for packaging as war
//@SpringBootApplication(scanBasePackages = "com.oblenergo.chatBot", exclude = SecurityAutoConfiguration.class)
//@PropertySource("classpath:serviceSecure.properties")
//public class ChatBotApplication extends SpringBootServletInitializer {
//
//  @Override
//  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//    return application.sources(ChatBotApplication.class);
//  }
//
//  public static void main(String[] args) {
//    SpringApplication.run(ChatBotApplication.class, args);
//  }
//}
