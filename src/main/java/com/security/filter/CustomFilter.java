package com.security.filter;

import javax.servlet.*;
import java.io.IOException;

public class CustomFilter extends GenericFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("CustomFilter is running ...");
        chain.doFilter(request, response);
    }
}
