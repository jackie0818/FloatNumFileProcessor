package com.codeway;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.*;

/**
 * Created by liyixiao on 16/2/3.
 */
public class FloatNumberFileProcessorTest extends TestCase {

    private static String TEST_FILES_LOC = new File(FloatNumberFileProcessorTest.class.getResource("/").getPath()).getParentFile().getParentFile().getPath() + File.separator + "testFiles";

    private String logFile = "a.log";

    public void setUp() throws Exception {
        super.setUp();
        File f = new File(logFile);
        if (f.exists()) {
            f.delete();
        }
        f.createNewFile();
    }


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FloatNumberFileProcessorTest( String testName )
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FloatNumberFileProcessorTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testFloatNumberFileProcessorTest_normal() throws Exception
    {
        Logger logger = Logger.getLogger("com.codeway");
        Handler memHandler = new FileHandler(logFile);
        logger.addHandler(memHandler);
        String filepath = TEST_FILES_LOC + File.separator + "testFile_normal.txt";
        FloatNumberFileProcessor.main(new String[]{filepath});
        memHandler.flush();
        memHandler.close();
        String logMsg = readLogFile(new File(logFile));
        //System.out.println(logMsg);
        assertTrue("Has no total count of numbers", logMsg.contains("Total count of numbers : 9"));
        assertTrue("Has no sum of all numbers", logMsg.contains("Sum of all numbers : 36.00433"));
    }


    public void testFloatNumberFileProcessorTest_nonNum() throws Exception
    {
        Logger logger = Logger.getLogger("com.codeway");
        Handler memHandler = new FileHandler(logFile);
        logger.addHandler(memHandler);
        String filepath = TEST_FILES_LOC + File.separator + "testFile_nonNum.txt";
        FloatNumberFileProcessor.main(new String[]{filepath});
        memHandler.flush();
        memHandler.close();
        String logMsg = readLogFile(new File(logFile));
        //System.out.println(logMsg);
        assertTrue("should has exception - Invalid number format found", logMsg.contains("Invalid number format found"));
    }

    public void testFloatNumberFileProcessorTest_empty() throws Exception
    {
        Logger logger = Logger.getLogger("com.codeway");
        Handler memHandler = new FileHandler(logFile);
        logger.addHandler(memHandler);
        String filepath = TEST_FILES_LOC + File.separator + "testFile_empty.txt";
        FloatNumberFileProcessor.main(new String[]{filepath});
        memHandler.flush();
        memHandler.close();
        String logMsg = readLogFile(new File(logFile));
        //System.out.println(logMsg);
        assertTrue("Has no total count of numbers", logMsg.contains("Total count of numbers : 0"));
        assertTrue("Has no sum of all numbers", logMsg.contains("Sum of all numbers : 0"));
    }

    public void testFloatNumberFileProcessorTest_noExist() throws Exception
    {
        Logger logger = Logger.getLogger("com.codeway");
        Handler memHandler = new FileHandler(logFile);
        logger.addHandler(memHandler);
        String filepath = TEST_FILES_LOC + File.separator + "testFile_nonExist.txt";
        FloatNumberFileProcessor.main(new String[]{filepath});
        memHandler.flush();
        memHandler.close();
        String logMsg = readLogFile(new File(logFile));
        //System.out.println(logMsg);
        assertTrue("Should report file not found", logMsg.contains("File " + filepath + " Not Found!"));
    }

    public void testFloatNumberFileProcessorTest_nullParameter() throws Exception
    {
        Logger logger = Logger.getLogger("com.codeway");
        Handler memHandler = new FileHandler(logFile);
        logger.addHandler(memHandler);
        FloatNumberFileProcessor.main(null);
        memHandler.flush();
        memHandler.close();
        String logMsg = readLogFile(new File(logFile));
        //System.out.println(logMsg);
        assertTrue("Should report usage", logMsg.contains("Please just append one parameter to specify the file path!"));
    }

    private String readLogFile(File f) throws Exception {
        BufferedReader fr = new BufferedReader(new FileReader(f));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = fr.readLine()) != null) {
            sb.append(line).append("\n");
        }
        fr.close();
        return sb.toString();
    }

}
