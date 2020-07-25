package com.Sztomberska.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

  public static final String FILE_PATH = "/home/abolka/Projects/Szkolenia"
                                         + "/JavaPodstawyProgramowanie/AplikacjaBankowa2/storage.txt";

  public static  <T> void save(T[] data){
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      String dataAsString = objectMapper.writeValueAsString(data);
      File file = new File(FILE_PATH);
      file.createNewFile();
      FileWriter writer = new FileWriter(file);
      writer.write(dataAsString);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static <T> T read(Class<T> type){
    try {
      Path path = Paths.get(FILE_PATH);
      List<String> values = Files.readAllLines(path);
      if (values.size() == 1){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(values.get(0),type);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
