/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Fahim Shahriar
 */
public class LoanOfficerLoanReport {
    private LocalDate date;
    private float totalLoan;

    public LoanOfficerLoanReport() {
    }

    public LoanOfficerLoanReport(LocalDate date, float totalLoan) {
        this.date = date;
        this.totalLoan = totalLoan;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(float totalLoan) {
        this.totalLoan = totalLoan;
    }

    @Override
    public String toString() {
        return "LoanOfficerLoanReport{" + "date=" + date + ", totalLoan=" + totalLoan + '}';
    }

    
    
    
    
}
