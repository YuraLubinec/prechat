package com.oblenergo.chatBot.configuration;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestUnauthorizedEntryPoint extends BasicAuthenticationEntryPoint {
  
  @Override
  public void afterPropertiesSet() throws Exception {
    setRealmName("Oblenergo chat service");
  }

}
