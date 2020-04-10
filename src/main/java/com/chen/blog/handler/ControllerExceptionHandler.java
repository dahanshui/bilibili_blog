package com.chen.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(HttpServletRequest httpServletRequest, Exception e, Model model) throws Exception {
        logger.error("httpRequestUrl:{},Exception:{}",httpServletRequest.getRequestURI(),e.getMessage());
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        model.addAttribute("url",httpServletRequest.getRequestURI());
        model.addAttribute("exception",e);
        return "error/error";
    }

}
