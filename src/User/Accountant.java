/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import ModelClass.AccountantDepartmentBudget;
import ModelClass.AccountantISExpense;
import ModelClass.AccountantISRevenue;
import ModelClass.AccountantIncomeStatement;
import ModelClass.AccountantJournal;
import ModelClass.AccountantReport;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.chart.XYChart;

/**
 *
 * @author EUJ
 */
public class Accountant extends User implements Serializable{
    
    private String department;
    private float salary;
    private LocalDate dateOfJoin;
    private LocalDate dateOfLeave;
    
    public Accountant() {
    }
    
    public Accountant(String department, float salary, LocalDate dateOfJoin, LocalDate dateOfLeave) {
        this.department = department;
        this.salary = salary;
        this.dateOfJoin = dateOfJoin;
        this.dateOfLeave = dateOfLeave;
    }
    
    public Accountant(String department, float salary, LocalDate dateOfJoin, LocalDate dateOfLeave, String id, String name, LocalDate dob, String gender, String employeeType, String password) {
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
        return super.toString() + "\ndepartment=" + department + "\nsalary=" + salary + "\ndateOfJoin=" + dateOfJoin + "\ndateOfLeave=" + dateOfLeave;
    }
   
    
    //T1
    public AccountantJournal addJournalEntry(String pID, LocalDate pDate, String pAccount, String pType, float pAmount) {
        AccountantJournal temp = new AccountantJournal();
        
        temp.setJournalID(pID);
        temp.setJournalDate(pDate);
        temp.setJournalAccount(pAccount);
        temp.setJournalType(pType);
        
        String str = " ";
        
        if (temp.getJournalType() == "Debit") {
            temp.setJournalDRAmount(pAmount);
        } else if (temp.getJournalType() == "Credit") {
            temp.setJournalCRAmount(pAmount);
        }
        
        return temp;
    }
    //T1
    
    
    //T2
    public AccountantISRevenue addIncomeRevenueEntry (String pEntry, float pAmount){
        
        AccountantISRevenue temp = new AccountantISRevenue(pEntry,pAmount); 
        return temp;
        
    }
    
    public AccountantISExpense addIncomeExpenseEntry (String pEntry, float pAmount){
        
        AccountantISExpense temp = new AccountantISExpense(pEntry,pAmount); 
        return temp;
        
    }
    
    public AccountantIncomeStatement addIncomeStatement(String pID, LocalDate pdate, ArrayList<AccountantISRevenue> pRevArr, ArrayList<AccountantISExpense> pExpArr) {
        AccountantIncomeStatement tempIS = new AccountantIncomeStatement();
        AccountantISRevenue tempRevenue = new AccountantISRevenue();
        AccountantISExpense tempExpense = new AccountantISExpense();
        
        
        tempIS.setIncomeID(pID);
        tempIS.setIncomeDate(pdate);
        tempIS.setRevenueArr(pRevArr);
        tempIS.setExpenseArr(pExpArr);
    
        float totalRev = 0;
        float totalExp = 0;
        float totalNet = 0;
        
        for(AccountantISRevenue i : tempIS.getRevenueArr()){
            totalRev = totalRev + i.getRevenueAmount();
        }
        
        for(AccountantISExpense i : tempIS.getExpenseArr()){
            totalExp = totalExp + i.getExpenseAmount();
        }
        
        totalNet = totalRev - totalExp;
        
        tempIS.setTotalRevenue(totalRev);
        tempIS.setTotalExpense(totalExp);
        tempIS.setNetIncome(totalNet);
        
        return tempIS;
    }
    //T2
    
    
    //T3
    public ArrayList<AccountantJournal> viewJournalRecords(ArrayList<AccountantJournal> pArr, LocalDate pDate){
        
        ArrayList<AccountantJournal> filteredArr = new ArrayList<>();
        
        for (AccountantJournal i : pArr) {
            if (i.getJournalDate().equals(pDate)) {
                filteredArr.add(i);
            }
        }
        return filteredArr;
    }
    //T3
    
    //T5
    public AccountantDepartmentBudget addDepartmentBudget(String pID, String pName, String pDept, String pYear, float psalary, float putility, float pElec, float pOther){
        
        float budget = psalary + putility + pElec + pOther;

        AccountantDepartmentBudget temp = new AccountantDepartmentBudget(pID,pName,pDept,
                pYear,psalary,putility,pElec,pOther,budget);
        
        return temp;
    }
    //T5
    
    //T7
    public XYChart.Series<String,Float> generateFinancialReport(LocalDate pDate, ArrayList<AccountantIncomeStatement> pArr){
        
        XYChart.Series<String,Float> chartData = new XYChart.Series<>();
        
        LocalDate selectedDate = pDate;
        
        for(AccountantIncomeStatement i : pArr){
            if (i.getIncomeDate().equals(selectedDate)) {
                chartData.getData().add(new XYChart.Data<>("Revenue",i.getTotalRevenue()));
                chartData.getData().add(new XYChart.Data<>("Expense",i.getTotalExpense()));
                chartData.getData().add(new XYChart.Data<>("Net Income",i.getNetIncome()));
            }
        }
        
        return chartData;
    }
    
    public AccountantReport saveFinancialReport (String pID, String pName, ArrayList<AccountantIncomeStatement> pArr){
        AccountantReport temp = new AccountantReport();
        temp.setReportID(pID);
        temp.setReportName(pName);
        temp.setISReportArr(pArr);
        
        return temp;
    }
    //T7
    

}   
