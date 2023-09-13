package sk.lukaspatrnciak.informationsystem.data.contract.domain.life;

import sk.lukaspatrnciak.informationsystem.data.contract.domain.Contract;
import sk.lukaspatrnciak.informationsystem.data.contract.domain.enums.ValidArea;
import sk.lukaspatrnciak.informationsystem.data.user.domain.User;

import java.util.Date;

public class AccidentLifeContract extends Contract {
    private User insured; // Referencia na poistenca
    private long insuredId; // Referencia na poistenca ID
    private ValidArea validArea;
    private double pernamentConsequences; // Trvale nasledky urazu (peniaze)
    private double accidentDeath; // Smrt v dosledku urazu (peniaze)
    private double hospitalisationCompensation; // Kompenzacia hospitalizacie (peniaze)

    public AccidentLifeContract(String contractId, User insurer, Date startInsur, Date stopInsur, double insurenceAmmount, double monthlyPayment, User insured, ValidArea validArea, double pernamentConsequences, double accidentDeath, double hospitalisationCompensation) {
        super(contractId, insurer, startInsur, stopInsur, insurenceAmmount, monthlyPayment);

        setInsured(insured);
        setInsuredId(insured);
        setValidArea(validArea);
        setPernamentConsequences(pernamentConsequences);
        setAccidentDeath(accidentDeath);
        setHospitalisationCompensation(hospitalisationCompensation);
    }

    // Setters
    public void setInsured(User insured) {
        if (insured == null) {
            throw new IllegalArgumentException("[ ! ] Chybne zadane meno pouzivatela");
        }

        this.insured = insured;
    }

    public void setInsuredId(User insurer) {
        this.insuredId = insured.getUserId();
    }

    public void setValidArea(ValidArea validArea) {
        this.validArea = validArea;
    }

    public void setPernamentConsequences(double pernamentConsequences) {
        if (pernamentConsequences < 0) {
            throw new IllegalArgumentException("[ ! ] Chybne zadana ciastka");
        }

        this.pernamentConsequences = pernamentConsequences;
    }

    public void setAccidentDeath(double accidentDeath) {
        if (accidentDeath < 0) {
            throw new IllegalArgumentException("[ ! ] Chybne zadana ciastka");
        }

        this.accidentDeath = accidentDeath;
    }

    public void setHospitalisationCompensation(double hospitalisationCompensation) {
        if (hospitalisationCompensation < 0) {
            throw new IllegalArgumentException("[ ! ] Chybne zadana ciastka");
        }

        this.hospitalisationCompensation = hospitalisationCompensation;
    }

    // Getters
    public User getInsured() {
        return insured;
    }

    public long getInsuredId() {
        return insuredId;
    }

    public ValidArea getValidArea() {
        return validArea;
    }

    public double getPernamentConsequences() {
        return pernamentConsequences;
    }

    public double getAccidentDeath() {
        return accidentDeath;
    }

    public double getHospitalisationCompensation() {
        return hospitalisationCompensation;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nID poistenej osoby:" + insuredId +
                "\nPoisteny pouzivatel: " + insured +
                "\nUzemna platnost: " + validArea +
                "\nTrvale nasledky urazu (poistna suma): " + pernamentConsequences +
                "\nSmrt v dosledku urazu (poistna suma): " + accidentDeath +
                "\nDenne odskodne za hospitalizaciu: " + validArea;
    }
}
