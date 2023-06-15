package org.levelup.bank.system.config;

import java.lang.reflect.Field;
import java.util.Map;

public class PropertyAnnotationProcessor {

    public void process(Object configurationObject){
        try{
            Class<?> confClass = configurationObject.getClass();
            Map<String, String> properties = FileUtils.loadProperties("src/main/resources/bank-system.properties");

            Field[] fields = confClass.getDeclaredFields();
            for (Field field : fields) {
                Property annotation = field.getAnnotation(Property.class);
                if (annotation != null){
                    String propertyKey = annotation.value();
                    field.setAccessible(true);
                    field.set(configurationObject, properties.get(propertyKey));
                }
            }

        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }

    }
}
