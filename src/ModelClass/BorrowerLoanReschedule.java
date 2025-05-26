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
public class BorrowerLoanReschedule {
    private String borrowerNid;
    private LocalDate date;
    private String requestType;
    private String rescheduledMonth;
    private String paymentDueMonth;
    private String rescheduleDetails;

    public BorrowerLoanReschedule() {
    }

    public BorrowerLoanReschedule(String borrowerNid, LocalDate date, String requestType, String rescheduledMonth, String paymentDueMonth, String rescheduleDetails) {
        this.borrowerNid = borrowerNid;
        this.date = date;
        this.requestType = requestType;
        this.rescheduledMonth = rescheduledMonth;
        this.paymentDueMonth = paymentDueMonth;
        this.rescheduleDetails = rescheduleDetails;
    }

    public String getBorrowerNid() {
        return borrowerNid;
    }

    public void setBorrowerNid(String borrowerNid) {
        this.borrowerNid = borrowerNid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRescheduledMonth() {
        return rescheduledMonth;
    }

    public void setRescheduledMonth(String rescheduledMonth) {
        this.rescheduledMonth = rescheduledMonth;
    }

    public String getPaymentDueMonth() {
        return paymentDueMonth;
    }

    public void setPaymentDueMonth(String paymentDueMonth) {
        this.paymentDueMonth = paymentDueMonth;
    }

    public String getRescheduleDetails() {
        return rescheduleDetails;
    }

    public void setRescheduleDetails(String rescheduleDetails) {
        this.rescheduleDetails = rescheduleDetails;
    }

    @Override
    public String toString() {
        return "BorrowerLoanReschedule{" + "borrowerNid=" + borrowerNid + ", date=" + date + ", requestType=" + requestType + ", rescheduledMonth=" + rescheduledMonth + ", paymentDueMonth=" + paymentDueMonth + ", rescheduleDetails=" + rescheduleDetails + '}';
    }
    
    
    
}
