package service1;

import service2.annotations.JsonPrimitive;
import service2.annotations.JsonSerializable;

import java.util.Locale;

@JsonSerializable
public enum TypesOfGoods {
    DRY(0, "dry"),
    LIQUID(1, "liquid"),
    CONTAINER(2, "container");

    private final Integer index;
    @JsonPrimitive
    private final String typeDescription;

    TypesOfGoods(Integer value, String type) {
        index = value;
        typeDescription = type;
    }

    static TypesOfGoods getTypeByString(String type) {
        type.toLowerCase(Locale.ROOT);
        TypesOfGoods result = switch(type) {
            case  "dry" -> TypesOfGoods.DRY;
            case "liquid" -> TypesOfGoods.LIQUID;
            case "container" -> TypesOfGoods.CONTAINER;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
        return result;
    }

    @Override
    public String toString() {
        return typeDescription;
    }
}