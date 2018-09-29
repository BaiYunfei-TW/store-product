package com.example.storeproduct.security;

import com.example.storeproduct.security.filter.AuthenticatedServerFilter;
import com.example.storeproduct.security.filter.AuthenticatedTokenFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
                .addFilterBefore(new AuthenticatedServerFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new AuthenticatedTokenFilter(), BasicAuthenticationFilter.class)
            .csrf()
                .disable()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
