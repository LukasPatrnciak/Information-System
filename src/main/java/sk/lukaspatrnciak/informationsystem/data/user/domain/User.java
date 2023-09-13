package sk.lukaspatrnciak.informationsystem.data.user.domain;

public class User {

    private long userId;
    private String name;
    private String surname;
    private String identificationNumber;
    private String email;

    private Address deliveryAddress;
    private Address correspondenceAddress;

    public User(long userId, String name, String surname, String email, String identificationNumber,  Address deliveryAddress, Address correspondenceAddress) {
        setUserId(userId);
        setName(name);
        setSurname(surname);
        setIdentificationNumber(identificationNumber);
        setEmail(email);
        setDeliveryAddress(deliveryAddress);
        setCorrespondenceAddress(correspondenceAddress);
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("[ ! ] Chybne zadane meno pouzivatela");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("[ ! ] Chybne zadane priezvisko pouzivatela");
        }
        this.surname = surname;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {

        if (identificationNumber.isEmpty()) {
            throw new IllegalArgumentException("[ ! ] Chybne zadane rodne cislo pouzivatela");
        }
        this.identificationNumber = identificationNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("[ ! ] Chybne zadany e-mail pouzivatela");
        }
        this.email = email;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Address getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public void setCorrespondenceAddress(Address correspondenceAddress) {
        if (correspondenceAddress == null) {
            this.correspondenceAddress = deliveryAddress;
        } else {
            this.correspondenceAddress = correspondenceAddress;
        }
    }
}