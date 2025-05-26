/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import User.Accountant;
import User.CollectionAgent;
import User.CustomerServiceAgent;
import User.HRExecutive;
import User.HeadOfBranch;
import User.LegalAdvisor;
import User.LoanOfficer;
import User.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aqib
 */
public class HRExecutiveT8GenerateEmployeeReportSceneController implements Initializable {

    @FXML
    private PieChart employeeSalaryPieChart;

    private ArrayList<User> user_list = new ArrayList<>();

    @FXML
    private PieChart employeeGenderPieChart;

    float Accountant_Salary =0;
    float CollectionAgent_Salary =0;
    float Customer_Service_Agent_Salary =0;
    float Head_of_Branch_Salary =0;
    float HR_Executive_Salary = 0;
    float Legal_Advisor_Salary =0;
    float Loan_Officer_Salary = 0;
    
    int Male = 0;
    int FeMale = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        "Admin", "Accountant", "Collection Agent", "Customer Service Agent",
//                "Head of Branch", "HR Executive", "Legal Advisor", "Loan Officer", "Borrower"
//                           7
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("employeeList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User temp;
            user_list.removeAll(user_list);

            try {
                while (true) {
                    temp = (User) ois.readObject();
                    user_list.add(temp);
                }
            } catch (Exception e) {
            }
        } catch (IOException ex) {
            System.out.println("No File Found!");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.out.println("final Exception");
                }
            }
        }

        for (User user : user_list) {
            
            if (user.getGender().equals("Male")) {
                Male +=1;
            }
            else{
            FeMale+=1;
            }

            if (user.getEmployeeType().equals("Accountant")) {
                Accountant_Salary += ((Accountant) user).getSalary();
            } else if (user.getEmployeeType().equals("Collection Agent")) {
                CollectionAgent_Salary += ((CollectionAgent) user).getSalary();
            } else if (user.getEmployeeType().equals("Customer Service Agent")) {
                Customer_Service_Agent_Salary += ((CustomerServiceAgent) user).getSalary();
            } else if (user.getEmployeeType().equals("Head of Branch")) {
                Head_of_Branch_Salary += ((HeadOfBranch) user).getSalary();
            } else if (user.getEmployeeType().equals("HR Executive")) {
                HR_Executive_Salary += ((HRExecutive) user).getSalary();
            } else if (user.getEmployeeType().equals("Legal Advisor")) {
                Legal_Advisor_Salary += ((LegalAdvisor) user).getSalary();
            } else {
                Loan_Officer_Salary += ((LoanOfficer) user).getSalary();
            }
        }
    }

    @FXML
    private void DesignationSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveDashboardScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void LogoutOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void generateSalaryPieChartonClick(MouseEvent event) {

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Accountant", Accountant_Salary),
                new PieChart.Data("Collection Agent", CollectionAgent_Salary),
                new PieChart.Data("Customer Service Agent", Customer_Service_Agent_Salary),
                new PieChart.Data("Head of Branch", Head_of_Branch_Salary),
                new PieChart.Data("HR Executive", HR_Executive_Salary),
                new PieChart.Data("Legal Advisor", Legal_Advisor_Salary),
                new PieChart.Data("Loan Officer", Loan_Officer_Salary)
        );

        employeeSalaryPieChart.setData(pieChartData);
        
        ObservableList<PieChart.Data> pieChartData_Gender = FXCollections.observableArrayList(
                new PieChart.Data("Male Employee", Male),
                new PieChart.Data("Female Employee", FeMale)
                
        );

        employeeGenderPieChart.setData(pieChartData_Gender);
    }

}
