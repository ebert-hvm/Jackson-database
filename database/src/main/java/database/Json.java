package database;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    public void writeToJsonFile(List<String> data, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonData jsonData = new JsonData(data);
            objectMapper.writeValue(new File(filename), jsonData);
            System.out.println("Data written to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFromJsonFile(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonData jsonData = objectMapper.readValue(new File(filename), JsonData.class);
            return jsonData.getData();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class JsonData {
        private List<String> data;

        public JsonData() {
        }

        public JsonData(List<String> data) {
            this.data = data;
        }

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }
    }
}
