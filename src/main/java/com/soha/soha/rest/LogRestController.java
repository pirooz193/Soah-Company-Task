package com.soha.soha.rest;


import com.soha.soha.log.AppLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api")
public class LogRestController {


    @GetMapping("/log")
    public String logRest() {
        try {

            RestTemplate restTemplate = new RestTemplate();
            String resourceUrl = "https://random-data-api.com/api/users/random_user";
            ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);

            AppLogger.logResponsesAndRequests(response, LogRestController.class);
            return response.getBody();

        } catch (Exception e) {
            e.printStackTrace();
            return "OOPS!";
        }

    }
}
