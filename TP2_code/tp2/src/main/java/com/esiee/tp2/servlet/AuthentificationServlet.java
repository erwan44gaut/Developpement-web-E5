package com.esiee.tp2.servlet;

import java.io.IOException;
import java.util.Map;

import com.esiee.tp2.domain.Person;
import com.esiee.tp2.model.Datamodel;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final String USERNAME_PARAM = "username";
	private static final String PASSWORD_PARAM = "password";
	
	private static final String MISSING_USERNAME = "Username missing!";
	private static final String MISSING_PASSWORD = "Password missing!";
	private static final String ERROR_AUTH = "Authentification error!";
	
	private static final String PAGE_REDIRECTION_VALID = "/home.jsp";
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(USERNAME_PARAM);
        String password = request.getParameter(PASSWORD_PARAM);
    	
    	if (username == null || username.isBlank()) {
    		throw new ServletException(MISSING_USERNAME);
    	}
    	
    	if (password == null || password.isBlank()) {
    		throw new ServletException(MISSING_PASSWORD);
    	}
    	
    	Datamodel datamodel = Datamodel.getInstance();
        Map<Long, Person> persons = datamodel.getPersons();

        Person authenticatedPerson = null;
    	
    	for (Person person : persons.values()) {
            if (person.getLogin().equals(username) && person.getPassword().equals(password)) {
                authenticatedPerson = person;
                break;
            }
        }

        if (authenticatedPerson == null) {
        	throw new ServletException(ERROR_AUTH);
        }
    	
    	HttpSession session = request.getSession();
        session.setAttribute(USERNAME_PARAM, username);
        response.sendRedirect(request.getContextPath() + PAGE_REDIRECTION_VALID);
	}
}
