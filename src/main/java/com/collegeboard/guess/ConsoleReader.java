package com.collegeboard.guess;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ppham on 2/3/2015.
 */
public class ConsoleReader {
    private static final Logger logger = Logger.getLogger(ConsoleReader.class);

    /**
     * Read the user input from the console as a string.
     * @return string
     */
    public String getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("User: ");
        try {
            String s = br.readLine();
            return (s != null) ? s.trim() : "";
        } catch (IOException e) {
            logger.error(e);
            return "";
        }
    }

}
