/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import User.Accountant;
import User.LoanOfficer;
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
 * @author Admin
 */
public class LoanOfficerDahsboadSceneController implements Initializable {

    @FXML
    private Text loanOfficerNameLabel;
    @FXML
    private TextArea loanOfficerTextArea;
    @FXML
    private TextArea loanOfficerNotificationTextArea;
    
    private LoanOfficer loggedLoanOfficer = new LoanOfficer(); 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void loanOfficerData(User paramLoanOfficer) throws IOException {
        loggedLoanOfficer = (LoanOfficer) paramLoanOfficer;
        loanOfficerTextArea.setText(paramLoanOfficer.toString());
        loanOfficerNameLabel.setText("Welcome " + paramLoanOfficer.getName());

        FXMLLoader loader1 = new FXMLLoader();
        FXMLLoader loader2 = new FXMLLoader();
        FXMLLoader loader3 = new FXMLLoader();
        FXMLLoader loader4 = new FXMLLoader();
        FXMLLoader loader5 = new FXMLLoader();
        FXMLLoader loader6 = new FXMLLoader();
        FXMLLoader loader7 = new FXMLLoader();
        FXMLLoader loader8 = new FXMLLoader();
//        
        loader1.setLocation(getClass().getResource("LoanOfficerT1TotalApplicationForSelection.fxml"));
        loader2.setLocation(getClass().getResource("LoanOfficerT2PerformInitialCheckandForwardtoCollectionAgent.fxml"));
        loader3.setLocation(getClass().getResource("LoanOfficerT3ApproveOrDeclineApplication.fxml"));
        loader4.setLocation(getClass().getResource("LoanOfficerT4ExtendLoanOffer.fxml"));
        loader5.setLocation(getClass().getResource("LoanOfficerT5ProcessReschedulePaymentProcess.fxml"));
        loader6.setLocation(getClass().getResource("LoanOfficerT6LoanAmortizationSchedule.fxml"));
        loader7.setLocation(getClass().getResource("LoanOfficerT7ProporsingNewLoanOfferingPolicies.fxml"));
        loader8.setLocation(getClass().getResource("LoanOfficerT8GenerateYearlyReport.fxml"));

        Parent root1 = loader1.load();
        Parent root2 = loader2.load();
        Parent root3 = loader3.load();
        Parent root4 = loader4.load();
        Parent root5 = loader5.load();
        Parent root6 = loader6.load();
        Parent root7 = loader7.load();
        Parent root8 = loader8.load();
//
        Scene scn1 = new Scene(root1);
        Scene scn2 = new Scene(root2);
        Scene scn3 = new Scene(root3);
        Scene scn4 = new Scene(root4);
        Scene scn5 = new Scene(root5);
        Scene scn6 = new Scene(root6);
//        Scene scn7 = new Scene(root7);
        Scene scn8 = new Scene(root8);
//
        LoanOfficerT1TotalApplicationForSelectionController controller1 = loader1.getController();
        LoanOfficerT2PerformInitialCheckandForwardtoCollectionAgentController controller2 = loader2.getController();
        LoanOfficerT3ApproveOrDeclineApplicationController controller3 = loader3.getController();
        LoanOfficerT4ExtendLoanOfferController controller4 = loader4.getController();
        LoanOfficerT5ProcessReschedulePaymentProcessController controller5 = loader5.getController();
        LoanOfficerT6LoanAmortizationScheduleController controller6 = loader6.getController();
        LoanOfficerT7ProporsingNewLoanOfferingPoliciesController controller7 = loader7.getController();
        LoanOfficerT8GenerateYearlyReportController controller8 = loader8.getController();
//
        controller1.loggedLoanOfficer(paramLoanOfficer);
        controller2.loggedLoanOfficer(paramLoanOfficer);
        controller3.loggedLoanOfficer(paramLoanOfficer);
        controller4.loggedLoanOfficer(paramLoanOfficer);
        controller5.loggedLoanOfficer(paramLoanOfficer);
        controller6.loggedLoanOfficer(paramLoanOfficer);
        controller7.loggedLoanOfficer(paramLoanOfficer);
        controller8.loggedLoanOfficer(paramLoanOfficer);
    }

    @FXML
    private void totalApplicationForSelectionOnClick(MouseEvent event) throws IOException {
        FXMLLoader t1Loader = new FXMLLoader();
        t1Loader.setLocation(getClass().getResource("LoanOfficerT1TotalApplicationForSelection.fxml"));
        Parent t1Root = t1Loader.load();

        Scene t1LnOfcr = new Scene(t1Root);

        Stage t1Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t1Stg.setScene(t1LnOfcr);
        t1Stg.show();

    }

    @FXML
    private void performInitialCheckAndForwardToCollectionAgentOnClick(MouseEvent event) throws IOException {
        FXMLLoader t2Loader = new FXMLLoader();
        t2Loader.setLocation(getClass().getResource("LoanOfficerT2PerformInitialCheckandForwardtoCollectionAgent.fxml"));
        Parent t2Root = t2Loader.load();

        Scene t2LnOfcr = new Scene(t2Root);

        Stage t2Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t2Stg.setScene(t2LnOfcr);
        t2Stg.show();

    }

    @FXML
    private void approveOrDeclineOnClick(MouseEvent event) throws IOException {
        FXMLLoader t3Loader = new FXMLLoader();
        t3Loader.setLocation(getClass().getResource("LoanOfficerT3ApproveOrDeclineApplication.fxml"));
        Parent t3Root = t3Loader.load();

        Scene t3LnOfcr = new Scene(t3Root);

        Stage t3Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t3Stg.setScene(t3LnOfcr);
        t3Stg.show();

        
    }

    @FXML
    private void generateLoanOfferOnClick(MouseEvent event) throws IOException {
        FXMLLoader t4Loader = new FXMLLoader();
        t4Loader.setLocation(getClass().getResource("LoanOfficerT4ExtendLoanOffer.fxml"));
        Parent t4Root = t4Loader.load();

        Scene t4LnOfcr = new Scene(t4Root);

        Stage t4Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t4Stg.setScene(t4LnOfcr);
        t4Stg.show();

    }

    @FXML
    private void processReschedulePaymentApplicationOnClick(MouseEvent event) throws IOException {
        FXMLLoader t5Loader = new FXMLLoader();
        t5Loader.setLocation(getClass().getResource("LoanOfficerT5ProcessReschedulePaymentProcess.fxml"));
        Parent t5Root = t5Loader.load();

        Scene t5LnOfcr = new Scene(t5Root);

        Stage t5Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t5Stg.setScene(t5LnOfcr);
        t5Stg.show();

        
    }

    @FXML
    private void loanAmortizationScheduleOnCliCk(MouseEvent event) throws IOException {
        FXMLLoader t6Loader = new FXMLLoader();
        t6Loader.setLocation(getClass().getResource("LoanOfficerT6LoanAmortizationSchedule.fxml"));
        Parent t6Root = t6Loader.load();

        Scene t6LnOfcr = new Scene(t6Root);

        Stage t6Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t6Stg.setScene(t6LnOfcr);
        t6Stg.show();

    }

    @FXML
    private void proposeLoanOfferingPolicyOnClick(MouseEvent event) throws IOException {
        FXMLLoader t7Loader = new FXMLLoader();
        t7Loader.setLocation(getClass().getResource("LoanOfficerT7ProporsingNewLoanOfferingPolicies.fxml"));
        Parent t7Root = t7Loader.load();

        Scene t7LnOfcr = new Scene(t7Root);

        Stage t7Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t7Stg.setScene(t7LnOfcr);
        t7Stg.show();

    }

    @FXML
    private void generateReportOnClick(MouseEvent event) throws IOException {
        FXMLLoader t8Loader = new FXMLLoader();
        t8Loader.setLocation(getClass().getResource("LoanOfficerT8GenerateYearlyReport.fxml"));
        Parent t8Root = t8Loader.load();

        Scene t8LnOfcr = new Scene(t8Root);

        Stage t8Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t8Stg.setScene(t8LnOfcr);
        t8Stg.show();

    }

    @FXML
    private void complainBoxOnClick(MouseEvent event) {
    }

    @FXML
    private void logOutOnClick(MouseEvent event) throws IOException {
        FXMLLoader lgLoader = new FXMLLoader();
        lgLoader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent logroot = lgLoader.load();

        Scene lnOfcrLg = new Scene(logroot);

        Stage lgStg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        lgStg.setScene(lnOfcrLg);
        lgStg.show();

    }

    @FXML
    private void loadNotificationsOnClick(MouseEvent event) {
    }
    
}
