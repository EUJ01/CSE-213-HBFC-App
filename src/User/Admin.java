/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import java.time.LocalDate;

/**
 *
 * @author EUJ
 */
public class Admin{
    
    private String id = "admin";
    private String password = "admin123";
    private String Admin = "Admin";
    

    public Admin() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin() {
        return Admin;
    }

    public void setAdmin(String Admin) {
        this.Admin = Admin;
    }
    
    
    

    public static User createEmployeeAccount(String pid, String pname, LocalDate pdob, String pgender, String pdesig, String ppass, String pdept, float psalary, LocalDate pdoj) {

        if ("Accountant".equals(pdesig)) {
            Accountant account = new Accountant();
            account.setId(pid);
            account.setName(pname);
            account.setDob(pdob);
            account.setGender(pgender);
            account.setEmployeeType(pdesig);
            account.setPassword(ppass);
            account.setDepartment(pdept);
            account.setSalary(psalary);
            account.setDateOfJoin(pdoj);

            return account;
        } else if ("Collection Agent".equals(pdesig)) {
            CollectionAgent account = new CollectionAgent();
            account.setId(pid);
            account.setName(pname);
            account.setDob(pdob);
            account.setGender(pgender);
            account.setEmployeeType(pdesig);
            account.setPassword(ppass);
            account.setDepartment(pdept);
            account.setSalary(psalary);
            account.setDateOfJoin(pdoj);

            return account;
        } else if ("Customer Service Agent".equals(pdesig)) {
            CustomerServiceAgent account = new CustomerServiceAgent();
            account.setId(pid);
            account.setName(pname);
            account.setDob(pdob);
            account.setGender(pgender);
            account.setEmployeeType(pdesig);
            account.setPassword(ppass);
            account.setDepartment(pdept);
            account.setSalary(psalary);
            account.setDateOfJoin(pdoj);

            return account;
        } else if ("Head of Branch".equals(pdesig)) {
            HeadOfBranch account = new HeadOfBranch();
            account.setId(pid);
            account.setName(pname);
            account.setDob(pdob);
            account.setGender(pgender);
            account.setEmployeeType(pdesig);
            account.setPassword(ppass);
            account.setDepartment(pdept);
            account.setSalary(psalary);
            account.setDateOfJoin(pdoj);

            return account;
        } else if ("HR Executive".equals(pdesig)) {
            HRExecutive account = new HRExecutive();
            account.setId(pid);
            account.setName(pname);
            account.setDob(pdob);
            account.setGender(pgender);
            account.setEmployeeType(pdesig);
            account.setPassword(ppass);
            account.setDepartment(pdept);
            account.setSalary(psalary);
            account.setDateOfJoin(pdoj);

            return account;
        } else if ("Legal Advisor".equals(pdesig)) {
            LegalAdvisor account = new LegalAdvisor();
            account.setId(pid);
            account.setName(pname);
            account.setDob(pdob);
            account.setGender(pgender);
            account.setEmployeeType(pdesig);
            account.setPassword(ppass);
            account.setDepartment(pdept);
            account.setSalary(psalary);
            account.setDateOfJoin(pdoj);

            return account;
        } else if ("Loan Officer".equals(pdesig)) {
            LoanOfficer account = new LoanOfficer();
            account.setId(pid);
            account.setName(pname);
            account.setDob(pdob);
            account.setGender(pgender);
            account.setEmployeeType(pdesig);
            account.setPassword(ppass);
            account.setDepartment(pdept);
            account.setSalary(psalary);
            account.setDateOfJoin(pdoj);

            return account;
        } else {
            return null;
        }
    }

    public static boolean adminLogin(String id, String pass, String type, Admin paramAdmin) {

        if (paramAdmin.getAdmin().equals(type) && paramAdmin.getId().equals(id) && paramAdmin.getPassword().equals(pass)) {
            return true;
        }
        return false;

    }

}
