package com.baseweb;

import java.io.IOException;
import java.util.*;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

final class MutableHttpServletRequest extends HttpServletRequestWrapper {
    // holds custom header and value mapping
    private final Map<String, String> customHeaders;

    public MutableHttpServletRequest(HttpServletRequest request){
        super(request);
        this.customHeaders = new HashMap<String, String>();
    }

    public void putHeader(String name, String value){
        this.customHeaders.put(name, value);
    }

    public String getHeader(String name) {
        // check the custom headers first
        String headerValue = customHeaders.get(name);

        if (headerValue != null){
            return headerValue;
        }
        // else return from into the original wrapped object
        return ((HttpServletRequest) getRequest()).getHeader(name);
    }

    public Enumeration<String> getHeaderNames() {
        // create a set of the custom header names
        Set<String> set = new HashSet<String>(customHeaders.keySet());

        // now add the headers from the wrapped request object
        @SuppressWarnings("unchecked")
        Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
        while (e.hasMoreElements()) {
            // add the names of the request headers into the list
            String n = e.nextElement();
            set.add(n);
        }

        // create an enumeration from the set and return
        return Collections.enumeration(set);
    }
}

public class HelloWorldFilter implements javax.servlet.Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(req);
        mutableRequest.putHeader("userObj", "custom value12312312");
        chain.doFilter(mutableRequest, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}