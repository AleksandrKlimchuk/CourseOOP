package service1;

import service2.annotations.JsonObject;
import service2.annotations.JsonPrimitive;
import service2.annotations.JsonSerializable;

@JsonSerializable
public class Good {
    public static final int WEIGHT_LOWER_BOUND = 0;

    @JsonObject
    private TypesOfGoods type;
    @JsonPrimitive
    private int weight;

    public Good(TypesOfGoods type, int weight) throws Exception {
        if (weight < WEIGHT_LOWER_BOUND) {
            throw new Exception("Weight of good can't be negative.\n");
        }
        this.type = type;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws Exception {
        if (weight < WEIGHT_LOWER_BOUND) {
            throw new Exception("Weight of good can't be negative.\n");
        }
        this.weight = weight;
    }

    public TypesOfGoods getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Type of good: " + getType().toString() +
                " Weight: " + weight +  " " + (type == TypesOfGoods.CONTAINER ? "pieces" : "ton");
    }
}
