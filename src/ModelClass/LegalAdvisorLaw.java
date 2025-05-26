/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

/**
 *
 * @author aqib
 */
public class LegalAdvisorLaw {
    int ID;
    String Subject;
    String Detail;

    public LegalAdvisorLaw(int ID, String Subject, String Detail) {
        this.ID = ID;
        this.Subject = Subject;
        this.Detail = Detail;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "LegalAdvisor_Laws{" + "ID=" + ID + ", Subject=" + Subject + ", Detail=" + Detail + '}';
    }
    
    
}
