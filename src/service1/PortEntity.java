package service1;


import service2.annotations.DeserializeConstructor;
import service2.annotations.JsonObject;
import service2.annotations.JsonSerializable;
import service3.Manager;

import java.util.ArrayDeque;
import java.util.Scanner;

@JsonSerializable
public class PortEntity {
    @JsonObject
    private Date date;
    @JsonObject
    private Ship ship;
    @JsonObject
    private Good good;
    @JsonObject
    private Time parkingTime;


    public PortEntity(Date date, Ship ship, Good good) {
        try {
            this.date = date;
            this.ship = ship;
            this.good = good;
            TypesOfGoods type = good.getType();
            int performance = switch (type) {
                case DRY -> Manager.DRY_PERFORMANCE;
                case LIQUID -> Manager.LIQUID_PERFORMANCE;
                case CONTAINER -> Manager.CONTAINER_PERFORMANCE;
            };
            this.parkingTime = computeParkingTime(good.getWeight(), performance); /*Need service3*/
        }
        catch (Exception error) {
            System.out.println(error.toString() +
                    "\nYou can't create PortEntity with current parameters\n");
        }
    }

    @DeserializeConstructor
    public PortEntity(String JsonString) throws Exception {
        Scanner localScanner = new Scanner(JsonString);
        ArrayDeque<String> deque = new ArrayDeque<>(6);
        int day = Integer.parseInt(localScanner.next());
        int hour = Integer.parseInt(localScanner.next());
        int minute = Integer.parseInt(localScanner.next());
        String name = localScanner.next();
        TypesOfGoods type = TypesOfGoods.getTypeByString(localScanner.next());
        int weight = Integer.parseInt(localScanner.next());
        int parkingHour = Integer.parseInt(localScanner.next());
        int parkingMinute = Integer.parseInt(localScanner.next());
        try {
            this.date = new Date(day, hour, minute);
            this.ship = new Ship(name);
            this.good = new Good(type, weight);
            this.parkingTime = new Time(parkingHour, parkingMinute);
        }
        catch (Exception error) {
            System.out.println(error.toString() +
                    "\nYou can't create PortEntity with current parameters\n");
        }
    }
    public Date getDate() {
        return date;
    }

    public Ship getShip() {
        return ship;
    }

    public Good getGood() {
        return good;
    }

    public Time getParkingTime() {
        return parkingTime;
    }

    private Time computeParkingTime(int weight, int performance) throws Exception {
        int minutes = (int) Math.floor((double) weight / performance);
        int hours = minutes / (Time.MINUTE_UPPER_BOUND + 1);
        minutes %= Time.MINUTE_UPPER_BOUND + 1;
        return new Time(hours, minutes);
    }

    @Override
    public String toString() {
        return date.toString() + " " + ship.toString() + " " + good.toString() +
                " Parking time: " + parkingTime.toString();
    }
}
