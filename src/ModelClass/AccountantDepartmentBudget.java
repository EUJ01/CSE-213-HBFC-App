/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

/**
 *
 * @author EUJ
 */
public class AccountantDepartmentBudget {
    private String accountantID;
    private String reportName;
    private String reportDept;
    private String budgetYear;
    private float annualEmpSalary;
    private float annualUtilityBill;
    private float annualElecBill;
    private float otherExpenses;
    private float budget;

    public AccountantDepartmentBudget() {
    }

    public AccountantDepartmentBudget(String accountantID, String reportName, String reportDept, String budgetYear, float annualEmpSalary, float annualUtilityBill, float annualElecBill, float otherExpenses, float budget) {
        this.accountantID = accountantID;
        this.reportName = reportName;
        this.reportDept = reportDept;
        this.budgetYear = budgetYear;
        this.annualEmpSalary = annualEmpSalary;
        this.annualUtilityBill = annualUtilityBill;
        this.annualElecBill = annualElecBill;
        this.otherExpenses = otherExpenses;
        this.budget = budget;
    }

    public String getAccountantID() {
        return accountantID;
    }

    public void setAccountantID(String accountantID) {
        this.accountantID = accountantID;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportDept() {
        return reportDept;
    }

    public void setReportDept(String reportDept) {
        this.reportDept = reportDept;
    }

    public String getBudgetYear() {
        return budgetYear;
    }

    public void setBudgetYear(String budgetYear) {
        this.budgetYear = budgetYear;
    }

    public float getAnnualEmpSalary() {
        return annualEmpSalary;
    }

    public void setAnnualEmpSalary(float annualEmpSalary) {
        this.annualEmpSalary = annualEmpSalary;
    }

    public float getAnnualUtilityBill() {
        return annualUtilityBill;
    }

    public void setAnnualUtilityBill(float annualUtilityBill) {
        this.annualUtilityBill = annualUtilityBill;
    }

    public float getAnnualElecBill() {
        return annualElecBill;
    }

    public void setAnnualElecBill(float annualElecBill) {
        this.annualElecBill = annualElecBill;
    }

    public float getOtherExpenses() {
        return otherExpenses;
    }

    public void setOtherExpenses(float otherExpenses) {
        this.otherExpenses = otherExpenses;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "reportName: " + reportName + "\nreportDept: " + reportDept + "\nbudgetYear: " + budgetYear + 
                "\nannualEmpSalary: " + annualEmpSalary + "\nannualUtilityBill: " + annualUtilityBill + 
                "\nannualElecBill: " + annualElecBill + "\notherExpenses: " + otherExpenses + "\nbudget=" + budget;
    }

    
    

    
    
    
    
}
