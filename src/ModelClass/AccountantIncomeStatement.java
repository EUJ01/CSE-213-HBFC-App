/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author EUJ
 */
public class AccountantIncomeStatement implements Serializable{
    
    private String incomeID;
    private LocalDate incomeDate;
    private ArrayList<AccountantISRevenue> revenueArr;
    private ArrayList<AccountantISExpense> expenseArr;
    private Float totalRevenue;
    private Float totalExpense;
    private Float netIncome;

    public AccountantIncomeStatement() {
    }

    public AccountantIncomeStatement(String incomeID, LocalDate incomeDate, ArrayList<AccountantISRevenue> revenueArr, ArrayList<AccountantISExpense> expenseArr, Float totalRevenue, Float totalExpense, Float netIncome) {
        this.incomeID = incomeID;
        this.incomeDate = incomeDate;
        this.revenueArr = revenueArr;
        this.expenseArr = expenseArr;
        this.totalRevenue = totalRevenue;
        this.totalExpense = totalExpense;
        this.netIncome = netIncome;
    }

    public String getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(String incomeID) {
        this.incomeID = incomeID;
    }

    public LocalDate getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(LocalDate incomeDate) {
        this.incomeDate = incomeDate;
    }

    public ArrayList<AccountantISRevenue> getRevenueArr() {
        return revenueArr;
    }

    public void setRevenueArr(ArrayList<AccountantISRevenue> revenueArr) {
        this.revenueArr = revenueArr;
    }

    public ArrayList<AccountantISExpense> getExpenseArr() {
        return expenseArr;
    }

    public void setExpenseArr(ArrayList<AccountantISExpense> expenseArr) {
        this.expenseArr = expenseArr;
    }

    public Float getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Float totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Float getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Float totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Float getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(Float netIncome) {
        this.netIncome = netIncome;
    }

    @Override
    public String toString() {
        return "AccountantIncomeStatement{" + "incomeID=" + incomeID + ", incomeDate=" + incomeDate + ", revenueArr=" + revenueArr + ", expenseArr=" + expenseArr + ", totalRevenue=" + totalRevenue + ", totalExpense=" + totalExpense + ", netIncome=" + netIncome + '}';
    }

    

}
