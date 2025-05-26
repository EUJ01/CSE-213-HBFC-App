/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import java.time.LocalDate;



/**
 *
 * @author Fahim Shahriar
 */
public class LoanPolicy {
    private LocalDate date;
    private String laID;
    private String subject;
    private String details;

    public LoanPolicy() {
    }

    public LoanPolicy(LocalDate date, String laID, String subject, String details) {
        this.date = date;
        this.laID = laID;
        this.subject = subject;
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLaID() {
        return laID;
    }

    public void setLaID(String laID) {
        this.laID = laID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "LoanPolicy{" + "date=" + date + ", laID=" + laID + ", subject=" + subject + ", details=" + details + '}';
    }
    
    
}
