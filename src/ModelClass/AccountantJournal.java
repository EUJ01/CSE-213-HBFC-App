/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelClass;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author EUJ
 */
public class AccountantJournal implements Serializable {

    private String journalID;
    private LocalDate journalDate;
    private String journalAccount;
    private String journalType;
    private Float journalDRAmount;
    private Float journalCRAmount;

    public AccountantJournal() {
    }

    public AccountantJournal(String journalID, LocalDate journalDate, String journalAccount, String journalType, float journalDRAmount, float journalCRAmount) {
        this.journalID = journalID;
        this.journalDate = journalDate;
        this.journalAccount = journalAccount;
        this.journalType = journalType;
        this.journalDRAmount = journalDRAmount;
        this.journalCRAmount = journalCRAmount;
    }

    public String getJournalID() {
        return journalID;
    }

    public void setJournalID(String journalID) {
        this.journalID = journalID;
    }

    public LocalDate getJournalDate() {
        return journalDate;
    }

    public void setJournalDate(LocalDate journalDate) {
        this.journalDate = journalDate;
    }

    public String getJournalAccount() {
        return journalAccount;
    }

    public void setJournalAccount(String journalAccount) {
        this.journalAccount = journalAccount;
    }

    public String getJournalType() {
        return journalType;
    }

    public void setJournalType(String journalType) {
        this.journalType = journalType;
    }

    public Float getJournalDRAmount() {
        return journalDRAmount;
    }

    public void setJournalDRAmount(float journalDRAmount) {
        this.journalDRAmount = journalDRAmount;
    }

    public Float getJournalCRAmount() {
        return journalCRAmount;
    }

    public void setJournalCRAmount(float journalCRAmount) {
        this.journalCRAmount = journalCRAmount;
    }

    @Override
    public String toString() {
        return "\njournalID: " + journalID
                + "\njournalDate: " + journalDate
                + "\njournalAccount: " + journalAccount
                + "\njournalType: " + journalType
                + "\njournalDRAmount: " + journalDRAmount
                + "\njournalCRAmount: " + journalCRAmount;
    }
}
