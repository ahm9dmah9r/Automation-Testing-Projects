package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtil {
    //TODO: reading data from json file
    private static final String testDataPath = "src/test/resources/testdata";

    public static String getJsonData(String fileName, String field) throws FileNotFoundException {
        FileReader reader = new FileReader(testDataPath + fileName + ".json");
        JsonElement jsonElement = JsonParser.parseReader(reader);
        return jsonElement.getAsJsonObject().get(field).getAsString();


    }
    //TODO: reading data from properties file
    public static String getPropertiesData(String fileName, String field) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(testDataPath+fileName+ ".properties"));
        return properties.getProperty(field);


    }
}
