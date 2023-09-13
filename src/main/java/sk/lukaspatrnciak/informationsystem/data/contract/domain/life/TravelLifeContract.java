package sk.lukaspatrnciak.informationsystem.data.contract.domain.life;

import sk.lukaspatrnciak.informationsystem.data.contract.domain.Contract;
import sk.lukaspatrnciak.informationsystem.data.contract.domain.enums.TravelPurpose;
import sk.lukaspatrnciak.informationsystem.data.user.domain.User;

import java.util.Date;

public class TravelLifeContract extends Contract {
    private boolean isEu;
    private User insured; // Referencia na poistenca
    private long insuredId; // Referencia na poistenca ID
    private TravelPurpose travelPurpose;

    public TravelLifeContract(String contractId, User insurer, Date startInsur, Date stopInsur, double insurenceAmmount, double monthlyPayment, boolean isEu, User insured, TravelPurpose travelPurpose) {
        super(contractId, insurer, startInsur, stopInsur, insurenceAmmount, monthlyPayment);

        setIsEu(isEu);
        setInsured(insured);
        setInsuredId(insured);
        setTravelPurpose(travelPurpose);
    }

    // Setters
    public void setInsured(User insured) {
        if (insured == null) {
            throw new IllegalArgumentException("[ ! ] Chybne zadane meno pouzivatela");
        }

        this.insured = insured;
    }

    public void setInsuredId(User insured) {
        this.insuredId = insured.getUserId();
    }

    public void setTravelPurpose(TravelPurpose travelPurpose) {
        this.travelPurpose = travelPurpose;
    }

    public void setIsEu(boolean isEu) {
        this.isEu = isEu;
    }

    // Getters
    public boolean isEu() {
        return isEu;
    }

    public User getInsured() {
        return insured;
    }

    public long getInsuredId() {
        return insuredId;
    }

    public TravelPurpose getTravelPurpose() {
        return travelPurpose;
    }
}
