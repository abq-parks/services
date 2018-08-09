package edu.cnm.deepdive.abqparksservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * Defines configuration elements for Oauth implementation.
 */
@Configuration
public class ParksConfiguration {

  @Value("${oauth.clientId}")
  private String clientId;

  /**
   * Get GoogleTokenServices object with Google client ID.
   * @return GoogleTokenServices
   */
  @Bean
  public ResourceServerTokenServices tokenServices() {
    return new GoogleTokenServices(clientId);
  }

}
