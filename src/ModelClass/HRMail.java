/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import User.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author aqib
 */
public class HRMail {

    String F_Name;
    String L_Name;
    LocalDate Date;
    String Designation;

    public HRMail(String F_Name, String L_Name, LocalDate Date, String Designation) {
        this.F_Name = F_Name;
        this.L_Name = L_Name;
        this.Date = Date;
        this.Designation = Designation;
    }

    public HRMail() {
    }

    public HRMail(String F_Name, LocalDate Date, String Designation) {
        this.F_Name = F_Name;
        this.Date = Date;
        this.Designation = Designation;
    }
    

    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String F_Name) {
        this.F_Name = F_Name;
    }

    public String getL_Name() {
        return L_Name;
    }

    public void setL_Name(String L_Name) {
        this.L_Name = L_Name;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    @Override
    public String toString() {

        return "Dear " + F_Name + " " + L_Name + ",\n\n"
                + "We are pleased to offer you the position of " + Designation + " at our company. "
                + "Your start date will be " + Date.toString() + ".\n\n"
                + "We believe you will find your new position both challenging and rewarding. "
                + "We look forward to your contributions to our company's growth and success.\n\n"
                + "Please let us know if you have any questions or concerns. We look forward to welcoming you to our team.\n\n"
                + "Sincerely,\n"
                + "Elon Ma";
    }

    public String toString_Teminate() {
//        return null; //MAKE SURE TO REMOVE
        return "Dear " + F_Name + " of " + Designation + ",\n\n"
                    + "We regret to inform you that your employment with " + "HBFC" + " is terminated, effective immediately. "
                    + "Your last day of work was on " + Date.toString() + ".\n\n"
                    + "We want to take this opportunity to thank you for your contributions to the company during your employment. "
                    + "We wish you the best of luck in your future endeavors.\n\n"
                    + "Sincerely,\n\n"
                    + "HR Department\n"
                    + "HBGC" + "\n";


    }

    public String toString_Warning() {
//        return null; //MAKE SURE TO REMOVE

        return  "Dear " + F_Name + " of "+ Designation + ",\n\n"
                + "This is to inform you that your recent performance has not met our expectations. As per your job responsibility of  and the company policies, we expect our employees to maintain a certain standard of work and conduct. Your recent work has fallen short of this standard.\n\n"
                + "We would like to remind you of the importance of meeting our expectations and hope that you will take immediate steps to address the issues that have been identified. We are confident that you have the ability to improve your performance and contribute positively to the company.\n\n"
                + "As a responsible organization, we believe in providing our employees with adequate support and guidance to help them perform their duties effectively. Therefore, we will be assigning a mentor to you who will work closely with you to identify areas for improvement and help you develop the necessary skills.\n\n"
                + "Please note that failure to improve your performance may result in further disciplinary action, including termination of employment. We hope that you will take this warning seriously and work towards improving your performance.\n\n"
                + "Sincerely,\n\n"
                +Date + ",\n\n"
                + "Management";
    }
}
