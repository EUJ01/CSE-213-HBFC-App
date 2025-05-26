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
public class AccountantISRevenue implements Serializable{
    
    private String revenueEntry;
    private Float revenueAmount;

    public AccountantISRevenue() {
    }

    public AccountantISRevenue(String revenueEntry, Float revenueAmount) {
        this.revenueEntry = revenueEntry;
        this.revenueAmount = revenueAmount;
    }

    public String getRevenueEntry() {
        return revenueEntry;
    }

    public void setRevenueEntry(String revenueEntry) {
        this.revenueEntry = revenueEntry;
    }

    public Float getRevenueAmount() {
        return revenueAmount;
    }

    public void setRevenueAmount(Float revenueAmount) {
        this.revenueAmount = revenueAmount;
    }

    @Override
    public String toString() {
        return "AccountantISRevenue{" + "revenueEntry=" + revenueEntry + ", revenueAmount=" + revenueAmount + '}';
    }
}
