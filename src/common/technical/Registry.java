package common.technical;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Registry {
    private static Registry uniqueInstance;
    private Properties prop;
    private final static String fileToLoad= "a2.properties";
    
    private Registry() throws IOException{
        prop = new Properties();
        FileInputStream fis = new FileInputStream(fileToLoad);
        prop.load(fis);
    }
    public static Registry getUniqueInstance() throws IOException{
        if(uniqueInstance == null)
            uniqueInstance = new Registry();
        return uniqueInstance;
    }
    public String getProperty(String key){
        return prop.getProperty(key);
    }
    
    public Properties getProps(){
        return prop;
    }
}
