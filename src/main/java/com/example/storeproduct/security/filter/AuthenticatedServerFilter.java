package com.example.storeproduct.security.filter;

import com.example.storeproduct.security.token.CustomSimpleToken;
import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticatedServerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String serverName = request.getHeader("x-server-auth");
        if (serverName == null) {
            filterChain.doFilter(request, response);
            return;
        }

        CustomSimpleToken customSimpleToken = new CustomSimpleToken(
                serverName,
                Sets.newHashSet(new SimpleGrantedAuthority("SERVER"))
        );

        SecurityContextHolder.getContext().setAuthentication(customSimpleToken);

        filterChain.doFilter(request, response);
    }
}
