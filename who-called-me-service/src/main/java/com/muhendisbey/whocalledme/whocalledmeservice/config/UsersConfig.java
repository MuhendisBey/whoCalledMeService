package com.muhendisbey.whocalledme.whocalledmeservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class UsersConfig
{
    @Bean
    public Collection<UserDetails> getUsers()
    {
        var adminUser = User.withDefaultPasswordEncoder()
                .username("anakin")
                .password("12345")
                .authorities("ADMIN", "USER")
                .build();

        var normalUser = User.withDefaultPasswordEncoder()
                .username("neo")
                .password("1234")
                .authorities("USER")
                .build();

        var disabledUser = User.withDefaultPasswordEncoder()
                .username("bruce")
                .password("123")
                .authorities("ADMIN")
                .disabled(true)
                .build();

        return new ArrayList<>() {{add(adminUser); add(normalUser); add(disabledUser);}};
    }
}
