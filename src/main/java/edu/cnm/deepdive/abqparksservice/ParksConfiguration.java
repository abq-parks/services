package edu.cnm.deepdive.abqparksservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
public class ParksConfiguration {

  @Value("${oauth.clientId}")
  private String clientId;

  @Bean
  public ResourceServerTokenServices tokenServices() {
    return new GoogleTokenServices(clientId);
  }

}
