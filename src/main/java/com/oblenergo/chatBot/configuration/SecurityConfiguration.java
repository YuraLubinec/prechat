package com.oblenergo.chatBot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final static String REALM = "Oblenergo chat service";

  @Autowired
  private RestUnauthorizedEntryPoint entryPoint;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    String[] antPatternsGet = { "/customer/physical/{\\d+}", "/customer/physical/{\\d+}/report", "/customer/physical/{\\d+}/bill",
        "/customer/juridical/*/*/report", "/customer/juridical/*/*" };
    String[] antPatternsPost = { "/customer/physical/{\\d+}/indicator/onezone", "/customer/physical/{\\d+}/indicator/twozone",
        "/customer/physical/{\\d+}/indicator/threezone" };

    http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, antPatternsGet).permitAll().antMatchers(HttpMethod.POST, antPatternsPost).permitAll()
        .anyRequest().authenticated().and().httpBasic().realmName(REALM).authenticationEntryPoint(entryPoint).and().cors().and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("secretuser").password("supersecret").roles("admin");
  }

}
