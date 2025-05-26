/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class BorrowerPayment {

    private ArrayList<BorrowerInstallment> installments;

    public BorrowerPayment() {
    }

    public BorrowerPayment(ArrayList<BorrowerInstallment> installments) {
        this.installments = installments;
    }

    public ArrayList<BorrowerInstallment> getInstallments() {
        return installments;
    }

    public void setInstallments(ArrayList<BorrowerInstallment> installments) {
        this.installments = installments;
    }

    @Override
    public String toString() {
        return "Installments: \n" + installments;
    }

}
