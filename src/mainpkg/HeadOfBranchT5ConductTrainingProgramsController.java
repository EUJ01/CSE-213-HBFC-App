/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class HeadOfBranchT5ConductTrainingProgramsController implements Initializable {

    @FXML
    private DatePicker dateOfTrainingProgramDatePicker;
    @FXML
    private RadioButton operationsDepartmentRadioButton;
    @FXML
    private RadioButton legalDepartmentRadioButton;
    @FXML
    private RadioButton financeDepartmentRadioButton;
    @FXML
    private RadioButton humanResourceDepartmentDepartmentRadioButton;
    @FXML
    private RadioButton recoveryAndCollectionDepartmentRadioButton;
    @FXML
    private TextArea topicOfTrainingProgramTextField;
    @FXML
    private TextArea detailsOfTrainingProgramTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dashboardSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchDashboardScene.fxml"));
        Parent logroot = loader.load();
        
        Scene HeadOfBranchDashboardScene = new Scene(logroot);
        
        Stage stg2borrower = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2borrower.setScene(HeadOfBranchDashboardScene);
        stg2borrower.show();
    }

    @FXML
    private void logoutOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent logroot = loader.load();
        
        Scene AALoginScene = new Scene(logroot);
        
        Stage stg2borrower = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AALoginScene);
        stg2borrower.show();
    }

    @FXML
    private void announceTrainingProgramOnClick(MouseEvent event) {
    }
    
}
