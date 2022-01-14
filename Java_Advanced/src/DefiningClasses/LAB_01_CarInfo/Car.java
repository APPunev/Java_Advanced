package DefiningClasses.LAB_01_CarInfo;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int hp;

    public Car(String brand){
        this(brand, "unknown", -1);
    }

    public Car(String brand, String model, int hp) {
        this.setBrand(brand);
        this.setModel(model);
        this.setHp(hp);
    }

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String carInfo(){
        return toString();
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",brand, model,hp);
    }
}
