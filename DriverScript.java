package example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import utility.ExcelUtils;

public class DriverScript {

    public static Properties OR;
    public static ActionKeywords actionKeywords;
    public static String sActionKeyword;
    public static String sPageObject;
    public static String sPageData;
    public static Method method[];



    public static void main(final String[] args) throws NoSuchMethodException, SecurityException{
        
    	actionKeywords = new ActionKeywords();
        method = actionKeywords.getClass().getMethods();

        final String Path_DataEngine = Constants.Path_TestData;
        //System.out.println(Path_DataEngine);

        try {
            ExcelUtils.setExcelFile(Path_DataEngine, Constants.Sheet_TestSteps);
        } catch (final Exception e) {
            
            e.printStackTrace();
        }

        // Declaring String variable for storing Object Repository path
        final String Path_OR = Constants.Path_OR;
        // Creating file system object for Object Repository text/property file
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(Path_OR);
            
        } catch (final FileNotFoundException e) {
            
            e.printStackTrace();
        }
        // Creating an Object of properties
        OR = new Properties(System.getProperties());
        // Loading all the properties from Object Repository property file in to
        // OR object
        try {
            OR.load(fs);
        } catch (final IOException e1) {
            
            e1.printStackTrace();
        }
        
        for (int iRow = 1; iRow <= ExcelUtils.ExcelWSheet.getLastRowNum(); iRow++) {
            try {
                sActionKeyword = ExcelUtils.getCellData(iRow,Constants.Col_ActionKeyword);
                
            } catch (final Exception e) {
                
                e.printStackTrace();
            }
            
            try {
            	
            	sPageObject = ExcelUtils.getCellData(iRow,Constants.Col_PageObject);
                
            } catch (final Exception e) {
                
                e.printStackTrace();
            }
            
            try {

            	sPageData = ExcelUtils.getCellData(iRow,Constants.Col_testData);
            	
            } catch (final Exception e) {
                
                e.printStackTrace();
            }
            try {
               execute_Actions();
            } catch (final Exception e) {
                
                e.printStackTrace();
            }
        }
    }

    private static void execute_Actions() throws Exception {
        
        for (int i = 0; i < method.length; i++) {
        	
            if (method[i].getName().equals(sActionKeyword)) {
                // This is to execute the method or invoking the method
                // Passing 'Page Object' name and 'Action Keyword' as Arguments
                // to this method
            	
            	
            	if(actionKeywords ==null){
            		method[i].invoke(sPageObject,sPageData);
            		
            	}else if(sPageObject ==null){
            		
            		method[i].invoke(actionKeywords,sPageData);
            		
            	}else if(sPageData ==null){
            		
            		method[i].invoke(actionKeywords,sPageObject);
            		
            	}else{
            		
            		method[i].invoke(sPageObject,sPageData);
            	}
                
                break;
            }
        }
    }

}
