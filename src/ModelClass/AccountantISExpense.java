/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import java.io.Serializable;

/**
 *
 * @author EUJ
 */
public class AccountantISExpense implements Serializable{
    
    private String expenseEntry;
    private Float expenseAmount;

    public AccountantISExpense() {
    }

    public AccountantISExpense(String expenseEntry, Float expenseAmount) {
        this.expenseEntry = expenseEntry;
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseEntry() {
        return expenseEntry;
    }

    public void setExpenseEntry(String expenseEntry) {
        this.expenseEntry = expenseEntry;
    }

    public Float getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Float expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
    
}
