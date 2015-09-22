package database_handling;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SQLReader {
    //================================================================================
    // Fields
    //================================================================================

    private Properties properties;
    private InputStream inpStream;
    private String queryFileName;

    //================================================================================
    // Constructors
    //================================================================================
    
    SQLReader(String queryFileName) {
        properties = new Properties();
        this.queryFileName = queryFileName;
    }

    //================================================================================
    // Methods
    //================================================================================
    public String getQuery(String key) {
        try {
            inpStream = new FileInputStream(queryFileName);
            properties.load(inpStream);
        } catch (IOException ex) {
            System.out.println("Exception while loading properties. " + ex.getMessage());
        }
        inpStream = null;
        return properties.getProperty(key);
    
    }
}
