package com.oblenergo.chatBot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAsync
public class AppConfiguration extends WebMvcConfigurerAdapter {

  @Autowired
  private Environment environment;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/customer/**").allowedMethods("GET", "POST", "OPTION").allowedOrigins(environment.getRequiredProperty("allow.origin"));
  }

}
