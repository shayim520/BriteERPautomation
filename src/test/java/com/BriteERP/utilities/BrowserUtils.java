package com.BriteERP.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BrowserUtils {
    /**
     *
     * @param expectedResult
     * @param actualResult
     * Verifies if two strings are equals.
     */
    public static void verifyEquals(String expectedResult, String actualResult){
        if(expectedResult.equals(actualResult)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("Expected result: "+expectedResult);
            System.out.println("Actual result: "+actualResult);
        }
    }

    /**
     *  This method will put on pause execution
     * @param seconds
     */
    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds * 1000 );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @param page
     * @param driver
     * This method will open example page based on link name
     */
    public static void openPage(String page, WebDriver driver){
        //we will find all examples on the home page
        List<WebElement> listOfExamples = driver.findElements(By.tagName("a"));
        for(WebElement example: listOfExamples){
            if(example.getText().contains(page)){
                example.click();
                break;
            }
        }
    }

    public static void verifyIsDisplayed(WebElement element){
        if(element.isDisplayed()){
            System.out.println("PASSED");
            System.out.println(element.getText()+": is visible");
        }else{
            System.out.println("FAILED");
            System.out.println(element.getText()+": is not visible!");
        }
    }

    /*
     * takes screenshot
     * @param name
     * take a name of a test and returns a path to screenshot takes
     */
    public static String getScreenshot(String name) {
        // name the screenshot with the current date time to avoid duplicate name
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_hh:mm:ss a"));
        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }


}

