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
public class HRJobPost {
    String Vacancy;
    String Designation;
    String Description;
    String Requirement;

    public HRJobPost(String Vacancy, String Designation, String Description, String Requirement) {
        this.Vacancy = Vacancy;
        this.Designation = Designation;
        this.Description = Description;
        this.Requirement = Requirement;
    }

    public HRJobPost() {
    }

    public String getVacancy() {
        return Vacancy;
    }

    public void setVacancy(String Vacancy) {
        this.Vacancy = Vacancy;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getRequirement() {
        return Requirement;
    }

    public void setRequirement(String Requirement) {
        this.Requirement = Requirement;
    }

    @Override
    public String toString() {
        return "JobPost{" + "Vacancy=" + Vacancy + ", Designation=" + Designation + ", Description=" + Description + ", Requirement=" + Requirement + '}';
    }
    
    
            
    
}
