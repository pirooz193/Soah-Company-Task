package com.soha.soha.log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppLogger {

    /**
     * this method logs the response and requests( in the file and console )
     *
     * @param response
     * @param clazz
     * @throws IOException
     */
    public static void logResponsesAndRequests(ResponseEntity<String> response, Class clazz) throws IOException {

        //LOG  IN THE FILE
        File file = new File("C:\\Users\\Kamtel\\Downloads\\demo\\soha\\src\\main\\resources\\logs.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        writer.append(" Header : ");
        writer.append(response.getHeaders().toString());
        writer.append(" / ");
        writer.append("Body : ");
        writer.append(response.getBody());
        writer.close();

        //LOG IN THE CONSOLE
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(response.getHeaders().toString());
        logger.info(response.getBody());

    }
}
