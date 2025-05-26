/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelClass.Notification;
import User.Borrower;
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
public class BorrowerDashboardSceneController implements Initializable {

    @FXML
    private Text borrowerNameLabel;
    @FXML
    private TextArea borrowerTextArea;
    @FXML
    private TextArea borrowerNotificationTextArea;

    private static Borrower loggedBorrower = new Borrower();

    public static Notification localNotification = new Notification();
//    public static Notification localUpdatedNotification = new Notification();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        borrowerTextArea.setText(loggedBorrower.toString());
        borrowerNameLabel.setText("Welcome " + loggedBorrower.getName());
        borrowerNotificationTextArea.setText(localNotification.getText());
    }

    public void loanRescheduleApplicationPassData(Notification paramNotification) {
        localNotification = paramNotification;
        borrowerNotificationTextArea.setText(localNotification.getText());
    }

//    public void loanOfficerRescheduleApprovedApplication(Notification paramUpdateNotification){
//        
//    }
//    
    public void borrData(User paramBorrower) throws IOException {
        loggedBorrower = (Borrower) paramBorrower;
        borrowerTextArea.setText(paramBorrower.toString());
        borrowerNameLabel.setText("Welcome ");

        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("BorrowerT1ApplyForLoanScene.fxml"));
        Parent T1root = loader1.load();
        Scene BorrowerT1ApplyForLoanScene = new Scene(T1root);
        BorrowerT1ApplyForLoanSceneController controller1 = loader1.getController();
        controller1.loggedBorrowerDataPass((Borrower) paramBorrower);

        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("BorrowerT2SendRequireDocumentsScene.fxml"));
        Parent T2root = loader2.load();
        Scene BorrowerT2SendRequireDocumentsScene = new Scene(T2root);
        BorrowerT2SendRequireDocumentsSceneController controller2 = loader2.getController();
        controller2.loggedBorrowerDataPass((Borrower) paramBorrower);

        FXMLLoader loader3 = new FXMLLoader();
        loader3.setLocation(getClass().getResource("BorrowerT3PayMonthlyInstallmentScene.fxml"));
        Parent T3root = loader3.load();
        Scene BorrowerT3PayMonthlyInstallmentScene = new Scene(T3root);
        BorrowerT3PayMonthlyInstallmentSceneController controller3 = loader3.getController();
        controller3.loggedBorrowerDataPass((Borrower) paramBorrower);

        FXMLLoader loader4 = new FXMLLoader();
        loader4.setLocation(getClass().getResource("BorrowerT4TrackApplicationScene.fxml"));
        Parent T4root = loader4.load();
        Scene BorrowerT4TrackApplicationScene = new Scene(T4root);
        BorrowerT4TrackApplicationSceneController controller4 = loader4.getController();
        controller4.loggedBorrowerDataPass((Borrower) paramBorrower);

        FXMLLoader loader5 = new FXMLLoader();
        loader5.setLocation(getClass().getResource("BorrowerT5LoanPaymentCalculatorScene.fxml"));
        Parent T5root = loader5.load();
        Scene BorrowerT5LoanPaymentCalculatorScene = new Scene(T5root);
        BorrowerT5LoanPaymentCalculatorSceneController controller5 = loader5.getController();
        controller5.loggedBorrowerDataPass((Borrower) paramBorrower);

        FXMLLoader loader6 = new FXMLLoader();
        loader6.setLocation(getClass().getResource("BorrowerT6ConstructionCostCalculatorScene.fxml"));
        Parent T6root = loader6.load();
        Scene BorrowerT6ConstructionCostCalculatorScene = new Scene(T6root);
        BorrowerT6ConstructionCostCalculatorSceneController controller6 = loader6.getController();
        controller6.loggedBorrowerDataPass((Borrower) paramBorrower);

        FXMLLoader loader7 = new FXMLLoader();
        loader7.setLocation(getClass().getResource("BorrowerT7LodgeAComplaintOrProvideFeedbackScene.fxml"));
        Parent T7root = loader7.load();
        Scene BorrowerT7LodgeAComplaintOrProvideFeedbackScene = new Scene(T7root);
        BorrowerT7LodgeAComplaintOrProvideFeedbackSceneController controller7 = loader7.getController();
        controller7.loggedBorrowerDataPass((Borrower) paramBorrower);

        FXMLLoader loader8 = new FXMLLoader();
        loader8.setLocation(getClass().getResource("BorrowerT8LoanRepaymentOrReschedule.fxml"));
        Parent T8root = loader8.load();
        Scene BorrowerT8LoanRepaymentOrReschedule = new Scene(T8root);
        BorrowerT8LoanRepaymentOrRescheduleController controller8 = loader8.getController();
        controller8.loggedBorrowerDataPass((Borrower) paramBorrower);

    }

    @FXML
    private void applyForLoanSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader T1loader = new FXMLLoader();
        T1loader.setLocation(getClass().getResource("BorrowerT1ApplyForLoanScene.fxml"));
        Parent T1root = T1loader.load();

        Scene BorrowerT1ApplyForLoanScene = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(BorrowerT1ApplyForLoanScene);
        stg2borrower.show();

    }

    @FXML
    private void sendRequireDocumentsSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader T2loader = new FXMLLoader();
        T2loader.setLocation(getClass().getResource("BorrowerT2SendRequireDocumentsScene.fxml"));
        Parent T2root = T2loader.load();

        Scene BorrowerT2SendRequireDocumentsScene = new Scene(T2root);

        Stage stg2borrowerDash = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrowerDash.setScene(BorrowerT2SendRequireDocumentsScene);
        stg2borrowerDash.show();

    }

    @FXML
    private void payMonthlyInstallmentSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BorrowerT3PayMonthlyInstallmentScene.fxml"));
        Parent root = loader.load();

        Scene BorrowerT3PayMonthlyInstallmentScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(BorrowerT3PayMonthlyInstallmentScene);
        stg2.show();

    }

    @FXML
    private void trackApplicationSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader T4loader = new FXMLLoader();
        T4loader.setLocation(getClass().getResource("BorrowerT4TrackApplicationScene.fxml"));
        Parent T4root = T4loader.load();

        Scene BorrowerT4TrackApplicationScene = new Scene(T4root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(BorrowerT4TrackApplicationScene);
        stg2.show();
    }

    @FXML
    private void loanPaymentCalculatorSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader T4loader = new FXMLLoader();
        T4loader.setLocation(getClass().getResource("BorrowerT5LoanPaymentCalculatorScene.fxml"));
        Parent lnPayRoot = T4loader.load();

        Scene BorrowerT5LoanPaymentCalculatorScene = new Scene(lnPayRoot);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(BorrowerT5LoanPaymentCalculatorScene);
        stg2.show();
    }

    @FXML
    private void constructionCostCalculatorSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader T6loader = new FXMLLoader();
        T6loader.setLocation(getClass().getResource("BorrowerT6ConstructionCostCalculatorScene.fxml"));
        Parent root = T6loader.load();

        Scene BorrowerT6ConstructionCostCalculatorScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(BorrowerT6ConstructionCostCalculatorScene);
        stg2.show();
    }

    @FXML
    private void lodgeComplaintProvideFeedbackSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BorrowerT7LodgeAComplaintOrProvideFeedbackScene.fxml"));
        Parent root = loader.load();

        Scene BorrowerT7LodgeAComplaintOrProvideFeedbackScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(BorrowerT7LodgeAComplaintOrProvideFeedbackScene);
        stg2.show();
    }

    @FXML
    private void loanRepaymentOrRescheduleSceneOnCLick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BorrowerT8LoanRepaymentOrReschedule.fxml"));
        Parent root = loader.load();

        Scene BorrowerT8LoanRepaymentOrReschedule = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(BorrowerT8LoanRepaymentOrReschedule);
        stg2.show();
    }

    @FXML
    private void logoutOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent logroot = loader.load();

        Scene AALoginScene = new Scene(logroot);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AALoginScene);
        stg2borrower.show();
    }

    @FXML
    private void loadNotificationsOnClick(MouseEvent event) {
    }

}
