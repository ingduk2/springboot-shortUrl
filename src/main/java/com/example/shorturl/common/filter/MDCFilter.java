package com.example.shorturl.common.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
public class MDCFilter extends OncePerRequestFilter {

    public static final String REQUEST_ID = "req-id";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        MDC.put(REQUEST_ID, keyGenerate());

        filterChain.doFilter(request, response);

        MDC.clear();
    }

    private String keyGenerate() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
