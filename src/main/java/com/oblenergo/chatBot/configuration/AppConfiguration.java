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
    // for developing
    // registry.addMapping("/**");
    // production
    registry.addMapping("/**").allowedMethods("GET", "POST", "OPTIONS").allowedOrigins(environment.getRequiredProperty("allow.origin.local"),
        environment.getRequiredProperty("allow.origin.global1"), environment.getRequiredProperty("allow.origin.global2")).allowCredentials(false);
  }

}
