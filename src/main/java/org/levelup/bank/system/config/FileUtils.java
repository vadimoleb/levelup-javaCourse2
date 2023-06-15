package org.levelup.bank.system.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileUtils {
    public static Map<String, String> loadProperties (String propertiesFilename) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(propertiesFilename))){
            Map<String, String> properties = new HashMap<>();
            String line;
            while ( (line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] pair = line.split("=",2);
                    properties.put(pair[0],pair[1]);
                }
            }
            return properties;
        }
    }
}
