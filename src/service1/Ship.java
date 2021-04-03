package service1;

import service2.annotations.JsonPrimitive;
import service2.annotations.JsonSerializable;

@JsonSerializable
public class Ship {
    @JsonPrimitive
    private String name;

    public Ship(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
