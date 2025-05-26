/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author aqib
 */
public class HRPolicy implements Serializable{

    LocalDate CreatedDate;
    LocalDate UpdatedDate;
    String Subject;
    String Detail;

    public HRPolicy(LocalDate CreatedDate, LocalDate UpdatedDate, String Subject, String Detail) {
        this.CreatedDate = CreatedDate;
        this.UpdatedDate = UpdatedDate;
        this.Subject = Subject;
        this.Detail = Detail;
    }

    public HRPolicy(LocalDate CreatedDate, String Subject, String Detail) {
        this.CreatedDate = CreatedDate;
        this.Subject = Subject;
        this.Detail = Detail;
    }

    public HRPolicy(String Subject, String Detail) {
        this.Subject = Subject;
        this.Detail = Detail;
    }

    public HRPolicy() {
    }

    public LocalDate getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(LocalDate CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public LocalDate getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(LocalDate UpdatedDate) {
        this.UpdatedDate = UpdatedDate;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

}
