package service2.Serializator;

import service1.PortEntity;
import service1.TimetableGenerator;

import java.io.FileWriter;
import java.io.IOException;

public class TimetableSerializer {
    static  public void serialize(TimetableGenerator timetableGenerator, String filename) {
        PortEntity[] timetable = timetableGenerator.getTimetable();
        FileWriter outputJsonFile = null;
        try {
            outputJsonFile = new FileWriter(filename + ".json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (PortEntity portEntity : timetable) {
                if (outputJsonFile != null) {
                    outputJsonFile.write(ToJsonSerializer.convertToJson(portEntity));
                    outputJsonFile.write("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something wrong.\n");
        }
        try {
            outputJsonFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
