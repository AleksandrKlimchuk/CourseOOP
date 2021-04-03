package service2.Serializator;

import service1.*;

public class JsonSerializer {
    public static void main(String[] args) {
        TimetableGenerator timetableGenerator = new TimetableGenerator(10);
        timetableGenerator.print();
    }
}
