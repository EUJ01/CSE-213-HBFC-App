/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import ModelClass.BorrowerComplaint;
import ModelClass.BorrowerDocument;
import ModelClass.BorrowerLoanReschedule;
import ModelClass.BorrowerLoanApplication;
import ModelClass.BorrowerPayment;
import ModelClass.LoanOfficerLoanOffer;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.scene.image.Image;

/**
 *
 * @author EUJ
 */
public class Borrower extends User implements Serializable {

    private LoanOfficerLoanOffer recievedLoan;
    private BorrowerPayment payment;

    public Borrower() {
    }

    public Borrower(LoanOfficerLoanOffer recievedLoan, BorrowerPayment payment) {
        this.recievedLoan = recievedLoan;
        this.payment = payment;
    }

    public Borrower(LoanOfficerLoanOffer recievedLoan, BorrowerPayment payment, String id, String name, LocalDate dob, String gender, String employeeType, String password) {
        super(id, name, dob, gender, employeeType, password);
        this.recievedLoan = recievedLoan;
        this.payment = payment;
    }

    public LoanOfficerLoanOffer getRecievedLoan() {
        return recievedLoan;
    }

    public void setRecievedLoan(LoanOfficerLoanOffer recievedLoan) {
        this.recievedLoan = recievedLoan;
    }

    public BorrowerPayment getPayment() {
        return payment;
    }

    public void setPayment(BorrowerPayment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return super.toString() + "\nrecievedLoan: " + recievedLoan + "\npayment: " + payment;
    }

    //T1
    public BorrowerLoanApplication submitLoanApplication(String name, LocalDate dob, String nid, String eTin, String address, String passportNo,
            String occupation, String companyName, String position, String location, int noOfMember, float salary, String locationLand, float rent,
            float loanRequest, String type, String term, String status) {

        BorrowerLoanApplication temp = new BorrowerLoanApplication();
        temp.setName(name);
        temp.setDateOfBirth(dob);
        temp.setNid(nid);
        temp.seteTin(eTin);
        temp.setAddress(address);
        temp.setPassportNo(passportNo);
        temp.setOccupation(occupation);
        temp.setCompanyName(companyName);
        temp.setPosition(position);
        temp.setLocation(location);
        temp.setNoOfFamilyMembers(noOfMember);
        temp.setMonthlySalary(salary);
        temp.setLocationOfTheLand(locationLand);
        temp.setPotentialRentPerSqFt(rent);
        temp.setLoanAmountRequested(loanRequest);
        temp.setLoanType(type);
        temp.setTerms(term);
        temp.setLoanStatus(status);

        return temp;
    }
    //T1

    //T2
    public BorrowerDocument borrowerSendRequireDocuments(String pSenderID, String pReceiverID, Image pImageDoc) {
        BorrowerDocument temp = new BorrowerDocument(pSenderID, pReceiverID, pImageDoc);
        return temp;

    }
    //T2
    //T3
    //T3
    //T4
    //T4
    //T5
    public float BorrowerLoanPaymentCalculator(float pRate, float pAmount, int pDuration) {
        float r = pRate / 1200;
        int n = pDuration * 12;

        float payment = 0;

        payment = (float) ((pAmount * r) / (1 - Math.pow(((1 + r)), (-n))));
        return payment;

    }
    //T5
    
    //T6
    public float BorrowerConstructionCostCalculator(float pResidentialArea, float pParkingArea, float pNumberOfTopFloor, float pTypicalFloorArea) {
        float constructionCost = 0;
        float groundFloor = 0;
        float topFloor = 0;

        groundFloor = pResidentialArea * 2774 + pParkingArea * 2251;

        if (pNumberOfTopFloor == 0) {
            topFloor = 0;
        } else {
            topFloor = (pNumberOfTopFloor * pTypicalFloorArea * 1693);
        }

        constructionCost = groundFloor + topFloor;

        return constructionCost;

    }
    //T6
    
    //T7
    public BorrowerComplaint lodgeComplaintOrFeedback(LocalDate pDate, String pTopic, String pDetails) {

        BorrowerComplaint temp = new BorrowerComplaint(pDate, pTopic, pDetails);

        return temp;
    }
    //T7

    //T8
    public BorrowerLoanReschedule loanReschedule(String pid, LocalDate pDate, String pRequestType, String pRescheduledMonth, String pPaymentDueMonth, String pRescheduleDetails) {
        BorrowerLoanReschedule temp = new BorrowerLoanReschedule(
                pid,
                pDate,
                pRequestType,
                pRescheduledMonth,
                pPaymentDueMonth,
                pRescheduleDetails);

        return temp;
    }
    //T8

    public static Borrower borrowerSignUp(String pNid, String pName, LocalDate pDate, String pGender, String pPassword) {
        Borrower temp = new Borrower(null, null, pNid, pName, pDate, pGender, "Borrower", pPassword);

        return temp;

    }

}
