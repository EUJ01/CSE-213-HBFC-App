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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class HeadOfBranchDashboardSceneController implements Initializable {

    @FXML
    private Text HeadOfBranchNameLabel;
    @FXML
    private TextArea HeadOfBranchTextArea;
    @FXML
    private TextArea HeadOfBranchNotificationTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void assignTasksSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchT1AssignTasksScene.fxml"));
        Parent root = loader.load();
        
        Scene HeadOfBranchT1AssignTasksScene = new Scene(root);
        
        Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(HeadOfBranchT1AssignTasksScene);
        stg2.show();
    }

    @FXML
    private void loanProposalsSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchT2LoanProposalsScene.fxml"));
        Parent root = loader.load();
        
        Scene HeadOfBranchT2LoanProposalsScene = new Scene(root);
        
        Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(HeadOfBranchT2LoanProposalsScene);
        stg2.show();
    }

    @FXML
    private void departmentalBudgetsSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchT3ApproveDeclineDepartmentalBudgets.fxml"));
        Parent root = loader.load();
        
        Scene HeadOfBranchT3ApproveDeclineDepartmentalBudgets = new Scene(root);
        
        Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(HeadOfBranchT3ApproveDeclineDepartmentalBudgets);
        stg2.show();
    }

    @FXML
    private void feedbackOnImprovementsSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchT4FeedbackOnImprovements.fxml"));
        Parent root = loader.load();
        
        Scene HeadOfBranchT4FeedbackOnImprovements = new Scene(root);
        
        Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(HeadOfBranchT4FeedbackOnImprovements);
        stg2.show();
    }

    @FXML
    private void conductTrainingProgramsSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchT5ConductTrainingPrograms.fxml"));
        Parent root = loader.load();
        
        Scene HeadOfBranchT5ConductTrainingPrograms = new Scene(root);
        
        Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(HeadOfBranchT5ConductTrainingPrograms);
        stg2.show();
    }

    @FXML
    private void scheduleMeetingsSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchT6ScheduleMeetingsWithEmployees.fxml"));
        Parent root = loader.load();
        
        Scene HeadOfBranchT6ScheduleMeetingsWithEmployees = new Scene(root);
        
        Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(HeadOfBranchT6ScheduleMeetingsWithEmployees);
        stg2.show();
    }

    @FXML
    private void performanceEvaluationsSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchT7PerformanceEvaluations.fxml"));
        Parent root = loader.load();
        
        Scene HeadOfBranchT7PerformanceEvaluations = new Scene(root);
        
        Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(HeadOfBranchT7PerformanceEvaluations);
        stg2.show();
    }

    @FXML
    private void financialReportsSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchT8FinancialReports.fxml"));
        Parent root = loader.load();
        
        Scene HeadOfBranchT8FinancialReports = new Scene(root);
        
        Stage stg2 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stg2.setScene(HeadOfBranchT8FinancialReports);
        stg2.show();
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
    
}
