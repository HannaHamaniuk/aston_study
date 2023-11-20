package org.example.model.entity.car;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class SportCar extends Car{
    @Column(name="max_speed")
    private int maxSpeed;

    public SportCar() {
    }

    public SportCar(String brand, String color, int enginePower, int maxSpeed) {
        super(brand, color, enginePower);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
