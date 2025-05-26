/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author EUJ
 */
public class User implements Serializable{
    private String id;
    private String name;
    private LocalDate dob;
    private String gender;
    private String employeeType;
    private String password;

    public User() {
    }

    public User(String id, String name, LocalDate dob, String gender, String employeeType, String password) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.employeeType = employeeType;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ID= " + id + "\nName= " + name + "\nDoB= " + dob + "\nGender=" + gender + "\nemployeeType= " + employeeType;
    }
    
    
    
    public static boolean userLogin(String id, String pass, String type, ArrayList<User> userArr){
        
        for(User i:userArr)
        {
            if (i.getEmployeeType().equals(type) && i.getId().equals(id) && i.password.equals(pass)) {
                    return true;
            }
        }
        return false;
        
    }
    
}
