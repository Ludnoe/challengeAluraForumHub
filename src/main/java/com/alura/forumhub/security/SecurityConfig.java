package com.alura.forumhub.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .authenticationProvider(ldapAuthenticationProvider())
                .addFilterBefore(new JWTAuthenticationFilter(authenticationManager(), userDetailsService), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public DaoAuthenticationProvider ldapAuthenticationProvider() {
        LdapAuthenticationProvider ldapAuthenticationProvider = new LdapAuthenticationProvider();
        ldapAuthenticationProvider.setUserDnPatterns("uid={username}");
        ldapAuthenticationProvider.setBaseDn("ou=people,dc=example,dc=com");
        ldapAuthenticationProvider.setContextSource(contextSource());
        ldapAuthenticationProvider.setUserDetailsService(userDetailsService);
        return ldapAuthenticationProvider;
    }

    @Bean
    public ContextSource<Object> contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://localhost:389");
        contextSource.setBaseDn("ou=people,dc=example,dc=com");
        contextSource.setUserDn("cn=Manager,dc=example,dc=com");
        contextSource.setPassword("senhaDoManager");
        return contextSource;
    }
}

