package sk.lukaspatrnciak.informationsystem.data.contract.service;

import sk.lukaspatrnciak.informationsystem.data.contract.domain.Contract;
import sk.lukaspatrnciak.informationsystem.data.contract.domain.enums.PropertyType;
import sk.lukaspatrnciak.informationsystem.data.contract.domain.enums.TravelPurpose;
import sk.lukaspatrnciak.informationsystem.data.contract.domain.enums.ValidArea;
import sk.lukaspatrnciak.informationsystem.data.contract.domain.life.AccidentLifeContract;
import sk.lukaspatrnciak.informationsystem.data.contract.domain.life.TravelLifeContract;
import sk.lukaspatrnciak.informationsystem.data.contract.domain.nonlife.ApartmentHouseNonlifeContract;
import sk.lukaspatrnciak.informationsystem.data.contract.domain.nonlife.HomeNonlifeContract;
import sk.lukaspatrnciak.informationsystem.data.user.domain.Address;
import sk.lukaspatrnciak.informationsystem.data.user.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class ContractService {
    Map<String, String> contracts  = new HashMap<>();
    ArrayList<Contract> contractsArray = new ArrayList<>();

    // Travell Life Contract
    public void createTravelLifeContract(String contractId, User insurer, Date startInsur, Date stopInsur, double insurenceAmmount, double monthlyPayment, boolean isEu, User insured, TravelPurpose travelPurpose) {
        TravelLifeContract travelLifeContract = new TravelLifeContract(contractId, insurer, startInsur, stopInsur, insurenceAmmount, monthlyPayment, isEu, insured, travelPurpose);
        contractsArray.add(travelLifeContract);
    }

    public void editTravelLifeContract(TravelLifeContract travelLifeContract, User newInsurer, Date newStartInsur, Date newStopInsur, double newInsurenceAmmount, double newMonthlyPayment) {
        travelLifeContract.setCreateDate();
        travelLifeContract.setInsurer(newInsurer);
        travelLifeContract.setStartInsur(newStartInsur);
        travelLifeContract.setStopInsur(newStopInsur);
        travelLifeContract.setInsurenceAmmount(newInsurenceAmmount);
        travelLifeContract.setMonthlyPayment(newMonthlyPayment);
    }

    // Accident Life Contract
    public void createAccidentLifeContract(String contractId, User insurer, Date startInsur, Date stopInsur, double insurenceAmmount, double monthlyPayment, User insured, ValidArea validArea, double pernamentConsequences, double accidentDeath, double hospitalisationCompensation) {
        AccidentLifeContract accidentLifeContract = new AccidentLifeContract(contractId, insurer, startInsur, stopInsur, insurenceAmmount, monthlyPayment, insured, validArea, pernamentConsequences, accidentDeath, hospitalisationCompensation);
        contractsArray.add(accidentLifeContract);
    }

    public void editAccidentLifeContract(AccidentLifeContract accidentLifeContract, User newInsurer, Date newStartInsur, Date newStopInsur, double newInsurenceAmmount, double newMonthlyPayment) {
        accidentLifeContract.setCreateDate();
        accidentLifeContract.setInsurer(newInsurer);
        accidentLifeContract.setStartInsur(newStartInsur);
        accidentLifeContract.setStopInsur(newStopInsur);
        accidentLifeContract.setInsurenceAmmount(newInsurenceAmmount);
        accidentLifeContract.setMonthlyPayment(newMonthlyPayment);
    }

    // Home Nonlife Contract
    public void createHomeNonlifeContract(String contractId, User insurer, Date startInsur, Date stopInsur, double insurenceAmmount, double monthlyPayment, Address propertyAddress, PropertyType propertyType, double propertyValue, double householdAppliancesValue) {
        HomeNonlifeContract homeNonlifeContract = new HomeNonlifeContract(contractId, insurer, startInsur, stopInsur, insurenceAmmount, monthlyPayment, propertyAddress, propertyType, propertyValue, householdAppliancesValue);
        contractsArray.add(homeNonlifeContract);
    }

    public void editHomeNonlifeContract(HomeNonlifeContract homeNonlifeContract, User newInsurer, Date newStartInsur, Date newStopInsur, double newInsurenceAmmount, double newMonthlyPayment) {
        homeNonlifeContract.setCreateDate();
        homeNonlifeContract.setInsurer(newInsurer);
        homeNonlifeContract.setStartInsur(newStartInsur);
        homeNonlifeContract.setStopInsur(newStopInsur);
        homeNonlifeContract.setInsurenceAmmount(newInsurenceAmmount);
        homeNonlifeContract.setMonthlyPayment(newMonthlyPayment);
    }

    // Apartment House Nonlife Contract
    public void ApartmentHouseNonlifeContract(String contractId, User insurer, Date startInsur, Date stopInsur, double insurenceAmmount, double monthlyPayment, Address propertyAddress, PropertyType propertyType, double propertyValue, boolean garageInsurance) {
        ApartmentHouseNonlifeContract apartmentHouseNonlifeContract = new ApartmentHouseNonlifeContract(contractId, insurer, startInsur, stopInsur, insurenceAmmount, monthlyPayment, propertyAddress, propertyType, propertyValue, garageInsurance);
        contractsArray.add(apartmentHouseNonlifeContract);
    }

    public void editApartmentHouseNonlifeContract(ApartmentHouseNonlifeContract apartmentHouseNonlifeContract, User newInsurer, Date newStartInsur, Date newStopInsur, double newInsurenceAmmount, double newMonthlyPayment) {
        apartmentHouseNonlifeContract.setCreateDate();
        apartmentHouseNonlifeContract.setInsurer(newInsurer);
        apartmentHouseNonlifeContract.setStartInsur(newStartInsur);
        apartmentHouseNonlifeContract.setStopInsur(newStopInsur);
        apartmentHouseNonlifeContract.setInsurenceAmmount(newInsurenceAmmount);
        apartmentHouseNonlifeContract.setMonthlyPayment(newMonthlyPayment);
    }

    public void listAllContracts() {
        for (Contract contract: contractsArray){
            System.out.println(contract.toString());
        }
    }
}
