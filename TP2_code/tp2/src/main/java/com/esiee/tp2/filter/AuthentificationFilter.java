package com.esiee.tp2.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthentificationFilter {
	private static final String UNAUTHORIZED_MESSAGE = "Unauthorized access";
    private static final String USER_SESSION_ATTRIBUTE = "username";
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        if (session == null || session.getAttribute(USER_SESSION_ATTRIBUTE) == null) {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, UNAUTHORIZED_MESSAGE);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
