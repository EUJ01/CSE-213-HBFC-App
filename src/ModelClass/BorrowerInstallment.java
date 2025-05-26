/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class BorrowerInstallment {

    private int installmentNumber;
    private float amount;
    private LocalDate installmentDate;
    private String installmentStatus;

    public BorrowerInstallment() {
    }

    public BorrowerInstallment(int installmentNumber, float amount, LocalDate installmentDate, String installmentStatus) {
        this.installmentNumber = installmentNumber;
        this.amount = amount;
        this.installmentDate = installmentDate;
        this.installmentStatus = installmentStatus;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getInstallmentDate() {
        return installmentDate;
    }

    public void setInstallmentDate(LocalDate installmentDate) {
        this.installmentDate = installmentDate;
    }

    public String getInstallmentStatus() {
        return installmentStatus;
    }

    public void setInstallmentStatus(String installmentStatus) {
        this.installmentStatus = installmentStatus;
    }

    @Override
    public String toString() {
        return "installmentNumber: " + installmentNumber + ", amount: " + amount + ", installmentDate: " + installmentDate + ", installmentStatus: " + installmentStatus + "\n";
    }

}
