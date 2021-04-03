package service2.Serializator;

import service1.*;

public class JsonSerializer {
    public static void main(String[] args) {
        /*Date date = new Date(1, new Time(12, 10));
        Ship ship = new Ship("Ship1");
        Good good = new Good(TypesOfGoods.LIQUID, 10000);
        PortEntity portEntity = new PortEntity(date, ship, good);
        try {
            System.out.println(ToJsonSerializer.convertToJson(portEntity));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        TimetableGenerator timetableGenerator = new TimetableGenerator(10);
        timetableGenerator.print();
    }
}
