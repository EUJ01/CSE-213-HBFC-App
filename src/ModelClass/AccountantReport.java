/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import java.util.ArrayList;

/**
 *
 * @author EUJ
 */
public class AccountantReport {
    
    private String reportID;
    private String reportName;
    private ArrayList<AccountantIncomeStatement> ISReportArr = new ArrayList<>();

    public AccountantReport() {
    }

    public AccountantReport(String reportID, String reportName) {
        this.reportID = reportID;
        this.reportName = reportName;
    }

    public String getReportID() {
        return reportID;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public ArrayList<AccountantIncomeStatement> getISReportArr() {
        return ISReportArr;
    }

    public void setISReportArr(ArrayList<AccountantIncomeStatement> ISReportArr) {
        this.ISReportArr = ISReportArr;
    }

    @Override
    public String toString() {
        return "AccountantReport{" + "reportID=" + reportID + ", reportName=" + reportName + ", ISReportArr=" + ISReportArr + '}';
    }

}
