package com.alvy.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionResolver implements HandlerExceptionResolver {   
  
    @Override  
    public ModelAndView resolveException(HttpServletRequest request,   
            HttpServletResponse response, Object handler, Exception ex) {
    	
    	ModelAndView modelAndView = new ModelAndView("exception/global_exception");
    	modelAndView.addObject("errorMsg", ex.getMessage());
        return modelAndView;   
    }   
  
} 