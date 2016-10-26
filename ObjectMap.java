package example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {

    static Properties prop;

    public ObjectMap() {
        
         prop = new Properties();

        try {

            final FileInputStream fis = new FileInputStream(Constants.Path_OR);
            prop.load(fis);
            fis.close();
        } catch (final IOException e) {

            System.out.println(e.getMessage());
        }

    }

    public static By getLocator(final String strElement) throws Exception {

        // retrieve the specified object from the object list
    	prop = new Properties();

        try {

            final FileInputStream fis = new FileInputStream(Constants.Path_OR);
            prop.load(fis);
            fis.close();
        } catch (final IOException e) {

            System.out.println(e.getMessage());
        }
    	
        final String locator = prop.getProperty(DriverScript.sPageObject);

        // extract the locator type and value from the object
        final String locatorType = locator.split("=")[0];
        final String locatorValue = locator.split("=")[1];
        
        if (locatorType.toLowerCase().equals("id")) {
        	
            return By.id(locatorValue);
            
        } else if (locatorType.toLowerCase().equals("name")) {
        	
            return By.name(locatorValue);
            
        } else if ((locatorType.toLowerCase().equals("classname"))|| (locatorType.toLowerCase().equals("class"))) {
        	
            return By.className(locatorValue);
            
        } else if ((locatorType.toLowerCase().equals("tagname"))|| (locatorType.toLowerCase().equals("tag"))) {
        	
            return By.className(locatorValue);
            
        } else if ((locatorType.toLowerCase().equals("linktext"))|| (locatorType.toLowerCase().equals("link"))) {
        	
            return By.linkText(locatorValue);
            
        } else if (locatorType.toLowerCase().equals("partiallinktext")) {
        	
            return By.partialLinkText(locatorValue);
            
        } else if ((locatorType.toLowerCase().equals("cssselector"))|| (locatorType.toLowerCase().equals("css"))) {
        	
            return By.cssSelector(locatorValue);
            
        } else if (locatorType.toLowerCase().equals("xpath")) {
        	
            return By.xpath(locatorValue);
            
        } else {
        	
            throw new Exception("Unknown locator type '" + locatorType + "'");
        }
    }

}
