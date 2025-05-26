/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import ModelClass.LoanOfficerLoanOffer;
import ModelClass.Notification;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.chart.XYChart;

/**
 *
 * @author EUJ
 */
public class LoanOfficer extends User implements Serializable{
    
    String department;
    float salary;
    LocalDate dateOfJoin;
    LocalDate dateOfLeave;

    public LoanOfficer() {
    }

    public LoanOfficer(String department, float salary, LocalDate dateOfJoin, LocalDate dateOfLeave, String id, String name, LocalDate dob, String gender, String employeeType, String password) {
        super(id, name, dob, gender, employeeType, password);
        this.department = department;
        this.salary = salary;
        this.dateOfJoin = dateOfJoin;
        this.dateOfLeave = dateOfLeave;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public LocalDate getDateOfLeave() {
        return dateOfLeave;
    }

    public void setDateOfLeave(LocalDate dateOfLeave) {
        this.dateOfLeave = dateOfLeave;
    }

    @Override
    public String toString() {
        return super.toString() + "\ndepartment: " + department + "\nsalary: " + salary + "\ndateOfJoin: " + dateOfJoin
                + "\ndateOfLeave: " + dateOfLeave;
    }
    
    public LoanOfficerLoanOffer generateLoanOfferInstance(String loanID, float loanAmount, String loanDuration, String loanDetails, float interestPercentage, float monthlyInstallment){
        LoanOfficerLoanOffer temp2 = new LoanOfficerLoanOffer();
        temp2.setLoanID(loanID);
        temp2.setLoanAmount(loanAmount);
        temp2.setLoanDuration(loanDuration);
        temp2.setLoanDetails(loanDetails);
        temp2.setInterestPercentage(interestPercentage);
        temp2.setMonthlyInstallment(monthlyInstallment);
        
        return temp2;
        
    }
    
    public Notification approveOrDeclineLoanReschedule(String p1id, String p2id, String puserType, String pText){
        
        Notification temp = new Notification();
        temp.setSenderID(p1id);
        temp.setRecieverID(p2id);
        temp.setUserType(puserType);
        temp.setText(pText);
        
        return temp;
    }
    
    public  Notification senAdditionalDocument(String p1id, String p2id, String puserType, String pText){
        
        Notification temp = new Notification();
        temp.setSenderID(p1id);
        temp.setRecieverID(p2id);
        temp.setUserType(puserType);
        temp.setText(pText);
        
        return temp;
        
    }
    
    public XYChart.Series<String,Float>generateLoanReport(LocalDate pDate, ArrayList<LoanOfficerLoanOffer> pArr){
        XYChart.Series<String, Float> chartData = new XYChart.Series<>();
       
//        LocalDate selectedDate = pDate;
        
        float amount = 0;
        
        String x = "" + pDate;
        
        for(LoanOfficerLoanOffer i : pArr){
            if(i.getSentDate().equals(pDate)){
                amount = amount + i.getLoanAmount();
            }
        }
        chartData.getData().add(new XYChart.Data<>(x, amount));
        System.out.println("" + pDate + amount);
        return chartData;
        
    }
   
    
    
    
    
}