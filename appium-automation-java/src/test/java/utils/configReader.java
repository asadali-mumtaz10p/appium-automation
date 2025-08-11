package utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private final Properties properties;

    public configReader() {
        BufferedReader reader;
        String propertyFilePath = "Configuration/config.properties";

        try{
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try{
                properties.load(reader);
                reader.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
            throw new RuntimeException("config.properties not found at" + propertyFilePath);
        }
    }
    public String getAppPackage(){
        String appPackage = properties.getProperty("appPackage");
        if(appPackage != null) return appPackage;
        else throw new RuntimeException("appPackage is not defined.");
    }
    public String getAppActivity(){
        String appActivity = properties.getProperty("appActivity");
        if(appActivity != null) return appActivity;
        else throw new RuntimeException("appActivity is not defined.");
    }
    public String getAppPath(){
        String path = properties.getProperty("app");
        if(path != null) return path;
        else throw new RuntimeException("path is not defined.");
    }
    public String getNoReset(){
        String noReset = properties.getProperty("noReset");
        if(noReset != null) return noReset;
        else throw new RuntimeException("noReset is not defined.");
    }
    public String getNewCommandTimeout(){
        String timeOut = properties.getProperty("newCommandTimeout");
        if(timeOut != null) return timeOut;
        else throw new RuntimeException("timeOut is not defined.");
    }
    public String getAppiumDriverEndPoint(){
        String endPoint = properties.getProperty("appiumServerUrl");
        if(endPoint != null) return endPoint;
        else throw new RuntimeException("endPoint is not defined.");
    }
}
