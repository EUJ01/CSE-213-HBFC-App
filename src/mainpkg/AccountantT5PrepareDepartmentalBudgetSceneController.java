/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.AccountantDepartmentBudget;
import User.Accountant;
import User.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class AccountantT5PrepareDepartmentalBudgetSceneController implements Initializable {

    @FXML
    private ComboBox<String> budgetDeptCB;
    @FXML
    private TextField budgetYearTextField;
    @FXML
    private TextField budgetReportNameTextField;
    @FXML
    private TextField annualSalaryTextField;
    @FXML
    private TextField annualUtilityTextField;
    @FXML
    private TextField annualElecBillTextField;
    @FXML
    private TextField otherExpenseTextField;
    @FXML
    private TextArea budgetReportDetailsTextField;
    
    private static Accountant localAccountant = new Accountant();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        budgetDeptCB.getItems().addAll("Accountant", "Collection Agent", "Customer Service Agent",
                "Head of Branch", "HR Executive", "Legal Advisor", "Loan Officer");
    }  
    
    public void loggedAccountant(User paramAccountant) {
        localAccountant = (Accountant) paramAccountant;
        
    }
    
    @FXML
    private void addBudgettoTableBtnOnClick(MouseEvent event) throws IOException {
        
        AccountantDepartmentBudget temp = localAccountant.addDepartmentBudget(localAccountant.getId(),budgetReportNameTextField.getText(),
                budgetDeptCB.getValue(),budgetYearTextField.getText(),
                Float.parseFloat(annualSalaryTextField.getText()),Float.parseFloat(annualUtilityTextField.getText()),
                Float.parseFloat(annualElecBillTextField.getText()),Float.parseFloat(otherExpenseTextField.getText()));
        
        budgetReportDetailsTextField.setText(temp.toString());
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountantT6SendDeptBudgetToHOBScene.fxml"));
        Parent root = loader.load();
        
        Scene AccountantT6SendDeptBudgetToHOBScene = new Scene(root);
        AccountantT6SendDeptBudgetToHOBSceneController controller = loader.getController();
        controller.t5ToT6budgetReportDataPass(temp);
        
        
    }

    @FXML
    private void dashboardSceneOnClick(MouseEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountantDashboardScene.fxml"));
        Parent dashroot = loader.load();

        Scene AccountantDashboardScene = new Scene(dashroot);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AccountantDashboardScene);
        stg2borrower.show();
    }

    @FXML
    private void LogoutOnCLick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent logroot = loader.load();

        Scene AALoginScene = new Scene(logroot);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AALoginScene);
        stg2borrower.show();
    }
    
}
