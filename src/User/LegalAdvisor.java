
package User;

import java.io.Serializable;
import java.time.LocalDate;


public class LegalAdvisor extends User implements Serializable{
    
    String department;
    float salary;
    LocalDate dateOfJoin;
    LocalDate dateOfLeave;

    public LegalAdvisor() {
    }

    public LegalAdvisor(String department, float salary, LocalDate dateOfJoin, LocalDate dateOfLeave, String id, String name, LocalDate dob, String gender, String employeeType, String password) {
        super(id, name, dob, gender, employeeType, password);
        this.department = department;
        this.salary = salary;
        this.dateOfJoin = dateOfJoin;
        this.dateOfLeave = dateOfLeave;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public LocalDate getDateOfLeave() {
        return dateOfLeave;
    }

    public void setDateOfLeave(LocalDate dateOfLeave) {
        this.dateOfLeave = dateOfLeave;
    }
    
    @Override
    public String toString() {
        return "LegalAdvisor{" + super.toString() + "department=" + department + ", salary=" + salary + ", dateOfJoin=" + dateOfJoin + ", dateOfLeave=" + dateOfLeave + '}';
    }
    
    
    
    
    
    

    
}
