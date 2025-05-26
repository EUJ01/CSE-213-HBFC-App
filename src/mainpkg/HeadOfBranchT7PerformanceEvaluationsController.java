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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class HeadOfBranchT7PerformanceEvaluationsController implements Initializable {

    @FXML
    private RadioButton qualityOfWork5RadioButton;
    @FXML
    private RadioButton qualityOfWork4RadioButton;
    @FXML
    private RadioButton qualityOfWork3RadioButton;
    @FXML
    private RadioButton qualityOfWork2RadioButton;
    @FXML
    private RadioButton qualityOfWork1RadioButton;
    @FXML
    private RadioButton initiativeAndProblemSolving5RadioButton;
    @FXML
    private RadioButton initiativeAndProblemSolving4RadioButton;
    @FXML
    private RadioButton initiativeAndProblemSolving3RadioButton;
    @FXML
    private RadioButton initiativeAndProblemSolving2RadioButton;
    @FXML
    private RadioButton initiativeAndProblemSolving1RadioButton;
    @FXML
    private RadioButton communicationSkills5RadioButton;
    @FXML
    private RadioButton communicationSkills4RadioButton;
    @FXML
    private RadioButton communicationSkills3RadioButton;
    @FXML
    private RadioButton communicationSkills2RadioButton;
    @FXML
    private RadioButton communicationSkills1RadioButton;
    @FXML
    private RadioButton collaborationAndTeamwork5RadioButton;
    @FXML
    private RadioButton collaborationAndTeamwork4RadioButton;
    @FXML
    private RadioButton collaborationAndTeamwork3RadioButton;
    @FXML
    private RadioButton collaborationAndTeamwork2RadioButton;
    @FXML
    private RadioButton collaborationAndTeamwork1RadioButton;
    @FXML
    private RadioButton attendanceAndPunctuality5RadioButton;
    @FXML
    private RadioButton attendanceAndPunctuality4RadioButton;
    @FXML
    private RadioButton attendanceAndPunctuality3RadioButton;
    @FXML
    private RadioButton attendanceAndPunctuality2RadioButton;
    @FXML
    private RadioButton attendanceAndPunctuality1RadioButton;
    @FXML
    private RadioButton adaptibility5RadioButton;
    @FXML
    private RadioButton adaptibility4RadioButton;
    @FXML
    private RadioButton adaptibility3RadioButton;
    @FXML
    private RadioButton adaptibility2RadioButton;
    @FXML
    private RadioButton adaptibility1RadioButton;
    @FXML
    private RadioButton dependabilityAndReliability5RadioButton;
    @FXML
    private RadioButton dependabilityAndReliability4RadioButton;
    @FXML
    private RadioButton dependabilityAndReliability3RadioButton;
    @FXML
    private RadioButton dependabilityAndReliability2RadioButton;
    @FXML
    private RadioButton dependabilityAndReliability1RadioButton;
    @FXML
    private TableView<?> performanceEvaluationsTableView;
    @FXML
    private TableColumn<?, ?> performanceEvaluationEmployeeIdColumn;
    @FXML
    private TableColumn<?, ?> performanceEvaluationEmployeeNameColumn;
    @FXML
    private TableColumn<?, ?> performanceEvaluationEvaluationColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dashboardOnClick(MouseEvent event) throws IOException {
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
    private void performanceEvaluationConfirmEvaluationOnClick(MouseEvent event) {
    }

    @FXML
    private void performanceEvaluationLoadEmployeeOnClick(MouseEvent event) {
    }
    
}
