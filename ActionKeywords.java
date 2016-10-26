package example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ActionKeywords {

    public static WebDriver driver;

    public static void OpenBrowser(final String object) {
        
    	System.setProperty("webdriver.firefox.marionette", "D:\\Selenium Workspace\\Jars\\geckodriver.exe");
    	driver = new FirefoxDriver();
    }

    public static void navigate(final String object) {
    	
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(DriverScript.sPageData);
    }

    public static void click_MyAccount(final String object) {
        // driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        try {
            driver.findElement(ObjectMap.getLocator(object)).click();
        } catch (final Exception e) {
            
            e.printStackTrace();
        }
    }

    public static void input_Username(final String object) {
        // driver.findElement(By.id("log")).sendKeys("testuser_3");
        try {
        	
            driver.findElement(ObjectMap.getLocator(object)).sendKeys(DriverScript.sPageData);
        } catch (final Exception e) {
            
            e.printStackTrace();
        }
    }

    public static void input_Password(final String object) {
        // driver.findElement(By.id("pwd")).sendKeys("Test@123");
        try {
            driver.findElement(ObjectMap.getLocator(object)).sendKeys(DriverScript.sPageData);
        } catch (final Exception e) {
            
            e.printStackTrace();
        }
    }

    public static void click_Login(final String object) {
        // driver.findElement(By.id("login")).click();
        try {
            driver.findElement(ObjectMap.getLocator(object)).click();
        } catch (final Exception e) {
            
            e.printStackTrace();
        }
    }

    public static void waitFor() throws Exception {
        Thread.sleep(5000);
    }

    public static void input_Select(final String object) {
        // driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
        try {
            new Select(driver.findElement(ObjectMap.getLocator(object))).selectByVisibleText(DriverScript.sPageData);
            
        } catch (final Exception e) {
            
            e.printStackTrace();
        }
    }
    
    public static void click_Logout(final String object) {
        // driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
        try {
            driver.findElement(ObjectMap.getLocator(object)).click();
        } catch (final Exception e) {
            
            e.printStackTrace();
        }
    }

    public static void verifypagetitle(final String object) {
        // driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
        
        if(driver.getTitle().equalsIgnoreCase(DriverScript.sPageData)){
        	
        	System.out.println("Title has been Matched");
        	
        }else{
        	
        	System.out.println("Title Mis-Matched");
        }
        // try {
        // driver.findElement(ObjectMap.getLocator(object)).click();
        // } catch (final Exception e) {
        
        // e.printStackTrace();
        // }
    }

   /* public static void closeBrowser(final String object) {
        driver.close();
    }*/
}
