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
public class BorrowerComplaint {
    private LocalDate date;
    private String complaintTopic;
    private String complaintDetails;

    public BorrowerComplaint() {
    }

    public BorrowerComplaint(LocalDate date, String complaintTopic, String complaintDetails) {
        this.date = date;
        this.complaintTopic = complaintTopic;
        this.complaintDetails = complaintDetails;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComplaintTopic() {
        return complaintTopic;
    }

    public void setComplaintTopic(String complaintTopic) {
        this.complaintTopic = complaintTopic;
    }

    public String getComplaintDetails() {
        return complaintDetails;
    }

    public void setComplaintDetails(String complaintDetails) {
        this.complaintDetails = complaintDetails;
    }

    @Override
    public String toString() {
        return "BorrowerComplaint{" + "date=" + date + ", complaintTopic=" + complaintTopic + ", complaintDetails=" + complaintDetails + '}';
    }
    
    
}
