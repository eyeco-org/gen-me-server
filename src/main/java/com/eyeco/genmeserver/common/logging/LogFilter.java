package com.eyeco.genmeserver.common.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class LogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        CachedHttpRequestServlet cachedReq = new CachedHttpRequestServlet((HttpServletRequest)request);
        HttpServletResponse res = (HttpServletResponse)response;

        String requestUri = cachedReq.getRequestURI();
        String requestMethod = cachedReq.getMethod();
        String requestBody = cachedReq.getCachedRequestData();

        log.info("---Method({}), Request({}) 필터---", requestMethod, requestUri);
        log.info("requestBodyData : \n{}", requestBody);
        filterChain.doFilter(cachedReq, res);
        log.info("---Method({}), Request({}) 필터---", requestMethod, requestUri);
    }
}
