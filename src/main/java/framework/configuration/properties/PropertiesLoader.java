package framework.configuration.properties;

import framework.configuration.TestsConfig;
import framework.exceptions.TestsConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;


public class PropertiesLoader {

  public static void populate(TestsConfig config) {
    Properties properties;
    PropertyFile propertyFileAnnotation = config.getClass().getAnnotation(PropertyFile.class);
    if (propertyFileAnnotation != null) {
      String propertyFileName = propertyFileAnnotation.value();
      properties = new Properties();
      try {
        InputStream stream = PropertiesLoader.class.getClassLoader().getResourceAsStream(propertyFileName);
        if (stream != null) {
          properties.load(stream);
        } else {
          throw new TestsConfigurationException("Unable to read property file with name '" + propertyFileName + "' - file not found");
        }
      } catch (IOException e) {
        throw new TestsConfigurationException("Error while reading property file with name '" + propertyFileName + "' : " + e.getMessage(), e);
      }
    } else properties = System.getProperties();

    Field[] fields = config.getClass().getDeclaredFields();
    for (Field field : fields) {
      Property propertyAnnotation = field.getAnnotation(Property.class);
      if (propertyAnnotation != null) {
        String propertyName = propertyAnnotation.value();
        String propertyValue = properties.getProperty(propertyName);
        if (propertyValue != null) {
          try {
            field.setAccessible(true);
            field.set(config, propertyValue);
          } catch (IllegalAccessException e) {
            throw new TestsConfigurationException("Field cannot be set...", e);
          }
        }
      }
    }
  }

}
