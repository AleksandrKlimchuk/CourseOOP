package service2.Serializator;

import org.w3c.dom.ls.LSOutput;
import service1.PortEntity;
import service1.TimetableGenerator;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TimetableGenerator timetableGenerator = new TimetableGenerator(10);
        timetableGenerator.print();
        TimetableSerializer.serialize(timetableGenerator, "service2");
    }
}
