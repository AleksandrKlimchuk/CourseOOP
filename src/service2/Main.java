package service2;

import org.w3c.dom.ls.LSOutput;
import service1.PortEntity;
import service1.TimetableGenerator;
import service2.Serializator.TimetableSerializer;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TimetableGenerator timetableGenerator = new TimetableGenerator(10);
        timetableGenerator.print();
        TimetableSerializer.serialize(timetableGenerator, "service2");
    }
}
