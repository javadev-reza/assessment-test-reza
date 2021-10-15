package assessment.test.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransformFile {

    public File getFile(String path) {
        return new File(path);
    }

    public List<String> readFile(File file){
        List<String> result = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void writeFile(List<String> dataLog, String path, String ext){
        try {
            FileWriter myWriter = new FileWriter(path);
            if(ext.matches("txt")){
                dataLog.forEach(data -> {
                    try {
                        myWriter.append(data).append("\n");
                        System.out.println("writing : "+data);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                JsonArray jsonArray = new JsonArray();
                dataLog.forEach(data -> {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("log : ", data);
                    jsonArray.add(jsonObject);
                    System.out.println("writing : "+data);
                });
                JsonObject jsonObject = new JsonObject();
                jsonObject.add("dataLogs", jsonArray);
                myWriter.write(jsonObject.toString());
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
