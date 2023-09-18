package UtilsTesNG;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import java.util.HashMap;
import java.util.Map;

public class FileReaderTestNG {
    private static final ObjectMapper mapper = new ObjectMapper();
    public static File readJsonFileSelenium(final String path) {
        String filePath = ResourceUtils.getResourceFilePathAbsPath(path);
        return new File(filePath);
    }

    public static Map<String, String> getDataBasedOnTestCaseNameSelenium(final String testcaseName) {
        try {
            File file = readJsonFileSelenium("TestData.json");
            File finalFile = file.exists() ? file : readJsonFileSelenium("JsonData.json");
            Map<String, HashMap<String, String>> testCases = mapper.readValue(finalFile, new TypeReference<>() {
            });
            return testCases.get(testcaseName);
        } catch (Exception exception) {
            System.out.println("Exception while reading data from json file. Exception: " + exception.getMessage());
        }
        return null;
    }


}
