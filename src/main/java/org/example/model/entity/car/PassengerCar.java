package org.example.model.entity.car;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("P")
public class PassengerCar extends Car {
    @Column(name="pass_amount")
    private int passengerAmount;

    public PassengerCar() {
    }

    public PassengerCar(String brand, String color, int enginePower, int passengerAmount) {
        super(brand, color, enginePower);
        this.passengerAmount = passengerAmount;
    }

    public int getPassengerAmount() {
        return passengerAmount;
    }

    public void setPassengerAmount(int passengerAmount) {
        this.passengerAmount = passengerAmount;
    }
}
