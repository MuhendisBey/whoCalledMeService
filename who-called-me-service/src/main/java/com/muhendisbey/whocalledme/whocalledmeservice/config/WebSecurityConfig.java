package com.muhendisbey.whocalledme.whocalledmeservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Configuration
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final Collection<UserDetails> users;

    public WebSecurityConfig(Collection<UserDetails> users)
    {
        this.users = users;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        var imo = auth.inMemoryAuthentication();

        for (var user : users)
        {
            log.info("Adding user: " + user);
            imo.withUser(user);
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic();
    }
}
