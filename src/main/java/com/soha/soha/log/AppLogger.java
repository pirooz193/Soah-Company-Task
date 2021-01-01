package com.soha.soha.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;


public class AppLogger {

    /**
     * This Method id Logging  Requests
     *
     * @param request
     * @param clazz
     */
    public static <T> void logRequest(HttpServletRequest request, Class<T> clazz) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info("Request Method : " + request.getMethod());
        logger.info("Request Address : " + request.getRemoteAddr());
        logger.info("Request URL : " + request.getRequestURL().toString());
        logger.info("Request URI : " + request.getRequestURI());
    }

    /**
     * This Method id Logging  Response
     *
     * @param response
     * @param clazz
     */
    public static <T> void logResponses(ResponseEntity<String> response, Class<T> clazz) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info("Header : " + response.getHeaders().toString());
        logger.info("Body : " + response.getBody());

    }


}
