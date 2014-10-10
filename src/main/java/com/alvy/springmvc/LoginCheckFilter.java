package com.alvy.springmvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class LoginCheckFilter implements Filter {
 
	List<String> excludeUrls;
	
    public void destroy() {
    }
 
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String requestUrl = request.getRequestURL().toString();
        Object userName = request.getSession().getAttribute("userName");
        if (!ignoreCheck(requestUrl) && userName == null) {
        	response.sendRedirect(request.getContextPath() + "/user/login");
        }
        chain.doFilter(req, res);
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String urls = filterConfig.getInitParameter("exclude-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");
 
        excludeUrls = new ArrayList<String>();
 
        while (token.hasMoreTokens()) {
        	excludeUrls.add(token.nextToken());
 
        }	
	}
	
	private boolean ignoreCheck(String requestUrl) {
		for (String excludeUrl : excludeUrls) {
			if (requestUrl.contains(excludeUrl)) {
				return true;
			}
		}
		return false;
	}
}