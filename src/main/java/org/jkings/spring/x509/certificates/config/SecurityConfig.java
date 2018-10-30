/**
 * SecurityConfig.java
 * Creation Date: 30/10/2018, 12:28:51
 *
 */
package org.jkings.spring.x509.certificates.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Configuration Security class
 * @author Juan Manuel Reyes Medina (jkings@cle.ninja)
 * @version 1.0
 * @since Passport 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .anyRequest()
      .authenticated()
      .and()
      .x509()
      .subjectPrincipalRegex("CN=(.*?)(?:,|$)")
      .userDetailsService(userDetailsService());
  }

  @Override
  @Bean
  public UserDetailsService userDetailsService() {
    return (UserDetailsService) username -> {
      if (username.equals("jkings")) {
        return new User(username, "", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
      } else {
        throw new UsernameNotFoundException(String.format("User %s not found", username));
      }
    };
  }
}
