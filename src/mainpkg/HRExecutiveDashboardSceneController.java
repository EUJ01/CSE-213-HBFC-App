/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import User.HRExecutive;
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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aqib
 */
public class HRExecutiveDashboardSceneController implements Initializable {

    @FXML
    private Text HRExecutiveNameLabel;
    @FXML
    private TextArea HRExecutiveTextArea;
    @FXML
    private TextArea HRExecutiveNotificationTextArea;
    
    private static HRExecutive loggedHRExecutive = new HRExecutive();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        HRExecutiveTextArea.setText(loggedHRExecutive.toString());
        HRExecutiveNameLabel.setText("Welcome " + loggedHRExecutive.getName());
        // TODO
    }
    
    public void hrexData(User paramHRExecutive){
                
        loggedHRExecutive = (HRExecutive) paramHRExecutive;
        
        HRExecutiveTextArea.setText(paramHRExecutive.toString());
        HRExecutiveNameLabel.setText("Welcome " + paramHRExecutive.getName());
    }

    @FXML
    private void HRPolicySceneOnClick(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveT1CreateHRPolicyScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void ComplaintBoxSceneOnClick(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveT2RespondToComplaintBoxScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void RecruitmentSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveT3PotentialEmployeeCVScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void RecruitmentMailSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveT4SendMailToHired_RejectedEmployee.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void WarningMailSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveT5Warn_FireEmployeeScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void CreatepostSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveT6CreateJobPostingScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void EmployeesInformationSceneOnClick(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveT7UpdateEmployeeInfoScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void SummaryChartSceneOnClick(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveT8GenerateEmployeeReportScene.fxml"));
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

}
