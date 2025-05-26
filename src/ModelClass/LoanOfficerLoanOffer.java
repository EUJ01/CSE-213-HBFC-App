/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import java.time.LocalDate;

/**
 *
 * @author Fahim Shahriar
 */
public class LoanOfficerLoanOffer {
    private String loanID;
    private float loanAmount;
    private String loanDuration;
    private String loanDetails;
    private float interestPercentage;
    private float monthlyInstallment;
    private LocalDate sentDate;

    public LoanOfficerLoanOffer() {
    }

    public LoanOfficerLoanOffer(String loanID, float loanAmount, String loanDuration, String loanDetails, float interestPercentage, float monthlyInstallment, LocalDate sentDate) {
        this.loanID = loanID;
        this.loanAmount = loanAmount;
        this.loanDuration = loanDuration;
        this.loanDetails = loanDetails;
        this.interestPercentage = interestPercentage;
        this.monthlyInstallment = monthlyInstallment;
        this.sentDate = sentDate;
    }

    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(String loanDuration) {
        this.loanDuration = loanDuration;
    }

    public String getLoanDetails() {
        return loanDetails;
    }

    public void setLoanDetails(String loanDetails) {
        this.loanDetails = loanDetails;
    }

    public float getInterestPercentage() {
        return interestPercentage;
    }

    public void setInterestPercentage(float interestPercentage) {
        this.interestPercentage = interestPercentage;
    }

    public float getMonthlyInstallment() {
        return monthlyInstallment;
    }

    public void setMonthlyInstallment(float monthlyInstallment) {
        this.monthlyInstallment = monthlyInstallment;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDate sentDate) {
        this.sentDate = sentDate;
    }

    @Override
    public String toString() {
        return "\nloanAmount: " + loanAmount + 
                "\nloanDuration: " + loanDuration + "\ninterestPercentage: " + interestPercentage + "\nmonthlyInstallment: " + monthlyInstallment +
                "\nloanDetails: " + loanDetails;
    }
    
}
