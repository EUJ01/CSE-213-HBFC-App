/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author EUJ
 */
public class CollectionAgent extends User implements Serializable{
    
    private String department;
    private float salary;
    private LocalDate dateOfJoin;
    private LocalDate dateOfLeave;

    public CollectionAgent() {
    }

    public CollectionAgent(String department, float salary, LocalDate dateOfJoin) {
        this.department = department;
        this.salary = salary;
        this.dateOfJoin = dateOfJoin;
    }

    public CollectionAgent(String department, float salary, LocalDate dateOfJoin, String id, String name, LocalDate dob, String gender, String employeeType, String password) {
        super(id, name, dob, gender, employeeType, password);
        this.department = department;
        this.salary = salary;
        this.dateOfJoin = dateOfJoin;
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
        return "CollectionAgent{"+ super.toString() + "department=" + department + ", salary=" + salary + ", dateOfJoin=" + dateOfJoin + '}';
    }
    
    
    
}
