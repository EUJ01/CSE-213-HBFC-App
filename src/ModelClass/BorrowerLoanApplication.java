/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class BorrowerLoanApplication {
    private String name;
    private LocalDate dateOfBirth;
    private String nid;
    private String eTin;
    private String address;
    private String passportNo;
    private String occupation, companyName, position, location;
    private int noOfFamilyMembers;
    private float monthlySalary;
    private String locationOfTheLand;
    private float potentialRentPerSqFt;
    private float loanAmountRequested;
    private String loanType;
    private String terms;
    private String loanStatus;
    
    private String loanOfficerId;
    private String collectionAgentId;

    public BorrowerLoanApplication() {
    }

    public BorrowerLoanApplication(String name, LocalDate dateOfBirth, String nid, String eTin, String address, String passportNo, String occupation, String companyName, String position, String location, int noOfFamilyMembers, float monthlySalary, String locationOfTheLand, float potentialRentPerSqFt, float loanAmountRequested, String loanType, String terms, String loanStatus, String loanOfficerId, String collectionAgentId) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nid = nid;
        this.eTin = eTin;
        this.address = address;
        this.passportNo = passportNo;
        this.occupation = occupation;
        this.companyName = companyName;
        this.position = position;
        this.location = location;
        this.noOfFamilyMembers = noOfFamilyMembers;
        this.monthlySalary = monthlySalary;
        this.locationOfTheLand = locationOfTheLand;
        this.potentialRentPerSqFt = potentialRentPerSqFt;
        this.loanAmountRequested = loanAmountRequested;
        this.loanType = loanType;
        this.terms = terms;
        this.loanStatus = loanStatus;
        this.loanOfficerId = loanOfficerId;
        this.collectionAgentId = collectionAgentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String geteTin() {
        return eTin;
    }

    public void seteTin(String eTin) {
        this.eTin = eTin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNoOfFamilyMembers() {
        return noOfFamilyMembers;
    }

    public void setNoOfFamilyMembers(int noOfFamilyMembers) {
        this.noOfFamilyMembers = noOfFamilyMembers;
    }

    public float getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getLocationOfTheLand() {
        return locationOfTheLand;
    }

    public void setLocationOfTheLand(String locationOfTheLand) {
        this.locationOfTheLand = locationOfTheLand;
    }

    public float getPotentialRentPerSqFt() {
        return potentialRentPerSqFt;
    }

    public void setPotentialRentPerSqFt(float potentialRentPerSqFt) {
        this.potentialRentPerSqFt = potentialRentPerSqFt;
    }

    public float getLoanAmountRequested() {
        return loanAmountRequested;
    }

    public void setLoanAmountRequested(float loanAmountRequested) {
        this.loanAmountRequested = loanAmountRequested;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getLoanOfficerId() {
        return loanOfficerId;
    }

    public void setLoanOfficerId(String loanOfficerId) {
        this.loanOfficerId = loanOfficerId;
    }

    public String getCollectionAgentId() {
        return collectionAgentId;
    }

    public void setCollectionAgentId(String collectionAgentId) {
        this.collectionAgentId = collectionAgentId;
    }
            

   

    @Override
    public String toString() {
        return "name= " + name + 
                "\ndateOfBirth= " + dateOfBirth + 
                "\nnid= " + nid + 
                "\neTin= " + eTin + 
                "\naddress= " + address + 
                "\npassportNo =" + passportNo + 
                "\noccupation= " + occupation + 
                "\ncompanyName= " + companyName + 
                "\nposition= " + position + 
                "\nlocation= " + location +
                "\nnoOfFamilyMembers= " + noOfFamilyMembers + 
                "\nmonthlySalary= " + monthlySalary + 
                "\nlocationOfTheLand= " + locationOfTheLand + 
                "\npotentialRentPerSqFt= " + potentialRentPerSqFt +
                "\nloanAmountRequested= " + loanAmountRequested + 
                "\nloanType=" + loanType;
    }
    
    

}