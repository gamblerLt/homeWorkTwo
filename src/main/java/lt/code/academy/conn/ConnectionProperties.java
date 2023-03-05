package lt.code.academy.conn;

import java.io.InputStream;
import java.util.Properties;

public class ConnectionProperties {
    private static final String PROPERTIES_FILE_NAME = "connection.properties";

    private static ConnectionProperties instance;
    private final Properties properties;

    private ConnectionProperties() {
        properties = new Properties();

        try (InputStream stream = this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME)){
            properties.load(stream);
        } catch(Exception e) {
            System.out.println("Nepavyko nuskaityti failo " + e.getMessage());
        }
    }

    public static ConnectionProperties getInstance() {
        if(instance == null) {
            instance = new ConnectionProperties();
        }

        return instance;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}

