package sk.lukaspatrnciak.informationsystem.data.contract.domain.nonlife;

import sk.lukaspatrnciak.informationsystem.data.contract.domain.Contract;
import sk.lukaspatrnciak.informationsystem.data.contract.domain.enums.PropertyType;
import sk.lukaspatrnciak.informationsystem.data.user.domain.Address;
import sk.lukaspatrnciak.informationsystem.data.user.domain.User;

import java.util.Date;

public class ApartmentHouseNonlifeContract extends Contract {
    private Address propertyAddress;
    private PropertyType propertyType;
    private double propertyValue; // Hodnota nehuntelnosti v eurach
    private boolean garageInsurance; // Ano/Nie

    public ApartmentHouseNonlifeContract(String contractId, User insurer, Date startInsur, Date stopInsur, double insurenceAmmount, double monthlyPayment, Address propertyAddress, PropertyType propertyType, double propertyValue, boolean garageInsurance) {
        super(contractId, insurer, startInsur, stopInsur, insurenceAmmount, monthlyPayment);

        setPropertyAddress(propertyAddress);
        setPropertyType(propertyType);
        setPropertyValue(propertyValue);
        setGarageInsurance(garageInsurance);
    }

    // Setters
    public void setPropertyAddress(Address propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public void setPropertyValue(double propertyValue) {
        if (propertyValue < 0) {
            throw new IllegalArgumentException("[ ! ] Chybne zadana ciastka");
        }

        this.propertyValue = propertyValue;
    }

    public void setGarageInsurance(boolean garageInsurance) {
        this.garageInsurance = garageInsurance;
    }

    // Getters
    public Address getPropertyAddress() {
        return propertyAddress;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public double getPropertyValue() {
        return propertyValue;
    }

    public boolean isGarageInsurance() {
        return garageInsurance;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTyp nehnutelnosti:" + propertyType +
                "\nHodnota nehnutelnosti" + propertyValue +
                "\nPoistenie garaze(1 - ano/0 - nie): " + garageInsurance +
                "\nAdresa nehnutelnosti: " + propertyAddress;
    }
}
