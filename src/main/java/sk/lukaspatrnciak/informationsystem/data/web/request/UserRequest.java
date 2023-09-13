package sk.lukaspatrnciak.informationsystem.data.web.request;

import com.sun.istack.internal.NotNull;
import sk.lukaspatrnciak.informationsystem.data.user.domain.Address;
import sk.lukaspatrnciak.informationsystem.data.user.domain.User;
import sk.lukaspatrnciak.informationsystem.data.user.service.IdGenerator;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserRequest {

    private long userId = IdGenerator.newId();
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String identificationNumber;
    @NotNull
    private String email;

    @NotNull
    private String cityDelivery;
    @NotNull
    private String streetDelivery;
    @NotNull
    private String houseNumberDelivery;
    @NotNull
    private String postalCodeDelivery;

    private String cityCorrespondence;
    private String streetCorrespondence;
    private String houseNumberCorrespondence;
    private String postalCodeDCorrespondence;

    // Setters
    public void setCityDelivery(String cityDelivery) {
        this.cityDelivery = cityDelivery;
    }

    public void setStreetDelivery(String streetDelivery) {
        this.streetDelivery = streetDelivery;
    }

    public void setHouseNumberDelivery(String houseNumberDelivery) {
        this.houseNumberDelivery = houseNumberDelivery;
    }

    public void setPostalCodeDelivery(String postalCodeDelivery) {
        this.postalCodeDelivery = postalCodeDelivery;
    }

    public void setCityCorrespondence(String cityCorrespondence) {
        this.cityCorrespondence = cityCorrespondence;
    }

    public void setStreetCorrespondence(String streetCorrespondence) {
        this.streetCorrespondence = streetCorrespondence;
    }

    public void setHouseNumberCorrespondence(String houseNumberCorrespondence) {
        this.houseNumberCorrespondence = houseNumberCorrespondence;
    }

    public void setPostalCodeDCorrespondence(String postalCodeDCorrespondence) {
        this.postalCodeDCorrespondence = postalCodeDCorrespondence;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("[ ! ] Chybne zadane meno pouzivatela");
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("[ ! ] Chybne zadane priezvisko pouzivatela");
        }
        this.surname = surname;
    }

    public void setIdentificationNumber(String identificationNumber) {

        if (identificationNumber.isEmpty()) {
            throw new IllegalArgumentException("[ ! ] Chybne zadane rodne cislo pouzivatela");
        }
        this.identificationNumber = identificationNumber;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("[ ! ] Chybne zadany e-mail pouzivatela");
        }
        this.email = email;
    }

    // Getters
    public long getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getIdentificationNumber() {
        return identificationNumber;
    }
    public String getEmail() {
        return email;
    }
    public String getCityDelivery() {
        return cityDelivery;
    }

    public String getStreetDelivery() {
        return streetDelivery;
    }

    public String getHouseNumberDelivery() {
        return houseNumberDelivery;
    }

    public String getPostalCodeDelivery() {
        return postalCodeDelivery;
    }

    public String getCityCorrespondence() {
        return cityCorrespondence;
    }

    public String getStreetCorrespondence() {
        return streetCorrespondence;
    }

    public String getHouseNumberCorrespondence() {
        return houseNumberCorrespondence;
    }

    public String getPostalCodeDCorrespondence() {
        return postalCodeDCorrespondence;
    }

    public User returnUser() {
        Address deliveryAddress = new Address(getCityDelivery(), getStreetDelivery(), getHouseNumberDelivery(), getPostalCodeDelivery());

        Address correspondenceAddress = new Address(getCityCorrespondence(), getStreetCorrespondence(), getHouseNumberCorrespondence(), getPostalCodeDCorrespondence());

        User user = new User(getUserId(),
                getName(),
                getSurname(),
                getEmail(),
                getIdentificationNumber(),
                deliveryAddress,
                correspondenceAddress);

        return user;
    }
}