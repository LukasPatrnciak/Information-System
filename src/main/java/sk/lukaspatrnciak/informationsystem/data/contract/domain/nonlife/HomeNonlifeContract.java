package sk.lukaspatrnciak.informationsystem.data.contract.domain.nonlife;

import sk.lukaspatrnciak.informationsystem.data.contract.domain.Contract;
import sk.lukaspatrnciak.informationsystem.data.contract.domain.enums.PropertyType;
import sk.lukaspatrnciak.informationsystem.data.user.domain.Address;
import sk.lukaspatrnciak.informationsystem.data.user.domain.User;

import java.util.Date;

public class HomeNonlifeContract extends Contract {
    private Address propertyAddress;
    private PropertyType propertyType;
    private double propertyValue; // Hodnota nehuntelnosti v eurach
    private double householdAppliancesValue; // Hodnota spotrebicov v domacnosti v eurach

    public HomeNonlifeContract(String contractId, User insurer, Date startInsur, Date stopInsur, double insurenceAmmount, double monthlyPayment, Address propertyAddress, PropertyType propertyType, double propertyValue, double householdAppliancesValue) {
        super(contractId, insurer, startInsur, stopInsur, insurenceAmmount, monthlyPayment);

        setPropertyAddress(propertyAddress);
        setPropertyType(propertyType);
        setPropertyValue(propertyValue);
        setHouseholdAppliancesValue(householdAppliancesValue);
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

    public void setHouseholdAppliancesValue(double householdAppliancesValue) {
        if (householdAppliancesValue < 0) {
            throw new IllegalArgumentException("[ ! ] Chybne zadana ciastka");
        }

        this.householdAppliancesValue = householdAppliancesValue;
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

    public double getHouseholdAppliancesValue() {
        return householdAppliancesValue;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTyp nehnutelnosti:" + propertyType +
                "\nHodnota nehnutelnosti" + propertyValue +
                "\nHodnota spotrebicov v domacnosti: " + householdAppliancesValue +
                "\nAdresa nehnutelnosti: " + propertyAddress;
    }
}
