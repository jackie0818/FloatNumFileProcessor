package com.codeway;

import java.io.*;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FloatNumberFileProcessor {
    private static String CLASS = FloatNumberFileProcessor.class.getName();
    private static Logger logger = Logger.getLogger(CLASS);

    //main entry
    public static void main(String[] args) throws IOException {
        if (args != null && args.length == 1) {
            process(args[0]);
        } else {
            if(logger.isLoggable(Level.INFO)) {
                logger.info("Please just append one parameter to specify the file path!");
            }
        }
    }


   // process the input file and output the required message "total num of all numbers" and "Sum of them"
    private static void process(String file) {
        String method = "process";
        logger.entering(CLASS, method);
        File f = new File(file);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.severe("File " + file + " Not Found!");
            }
            return;
        }
        String line;
        int totalNum = 0;
        BigDecimal sum = new BigDecimal("0");
        try {
            if (logger.isLoggable(Level.INFO)) {
                logger.log(Level.INFO, "Start processing file : " + file);
            }
            while((line = br.readLine()) != null) {
                String[] floatsArray = line.split(" +");
                for (String flt : floatsArray) {
                    sum = sum.add(new BigDecimal(flt));
                    totalNum++;
                }
                if (logger.isLoggable(Level.FINE)) {
                    logger.log(Level.FINE, "Processing line : " + line);
                }
            }
	    if (logger.isLoggable(Level.INFO)) {
	        logger.info("Total count of numbers : " + totalNum);
	        logger.info("Sum of all numbers : " + sum.toString());
	    }
            if (logger.isLoggable(Level.INFO)) {
                logger.log(Level.INFO, "Processing ends. ");
            }
        } catch (IOException e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, "Error occurs during processing!", e);
            }
        } catch (NumberFormatException e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, "Invalid number format found");
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                //ignore
            }
        }
        logger.exiting(CLASS, method);
    }
}
