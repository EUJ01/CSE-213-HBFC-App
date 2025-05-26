/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.BorrowerLoanReschedule;
import User.Borrower;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class BorrowerT8LoanRepaymentOrRescheduleController implements Initializable {

    @FXML
    private TextField repaymentOrRescheduleDetailsTextField;
    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private ComboBox<String> requestTypeComboBox;
    @FXML
    private ComboBox<String> rescheduledMonthComboBox;
    @FXML
    private ComboBox<String> paymentDueMonthComboBox;

    private static Borrower localBorr = new Borrower();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rescheduledMonthComboBox.getItems().addAll("January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December");

        paymentDueMonthComboBox.getItems().addAll("January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December");
        requestTypeComboBox.getItems().addAll("Early Payment", "Late Payment");

    }

    public void loggedBorrowerDataPass(Borrower paramBorrower) {
        localBorr = paramBorrower;

    }

    @FXML
    private void loanRepaymentOrRescheduleSceneOnCLick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BorrowerDashboardScene.fxml"));
        Parent dashroot = loader.load();

        Scene BorrowerDashboardScene = new Scene(dashroot);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(BorrowerDashboardScene);
        stg2borrower.show();
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
    private void requestPaymentRescheduleOnClick(MouseEvent event) throws IOException {
        BorrowerLoanReschedule temp1 = new BorrowerLoanReschedule();

        temp1 = localBorr.loanReschedule(
                localBorr.getId(),
                dateDatePicker.getValue(),
                requestTypeComboBox.getValue(),
                rescheduledMonthComboBox.getValue(),
                paymentDueMonthComboBox.getValue(),
                repaymentOrRescheduleDetailsTextField.getText());

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LoanOfficerT5ProcessReschedulePaymentProcess.fxml"));
        Parent root = loader.load();
        Scene LoanOfficerT5ProcessReschedulePaymentProcessController = new Scene(root);

        LoanOfficerT5ProcessReschedulePaymentProcessController controller = loader.getController();
        controller.borrowerLoanRescheduleDataPass(temp1);
    }
}
