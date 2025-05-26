/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelClass.BorrowerLoanReschedule;
import ModelClass.Notification;
import java.io.IOException;
import User.Borrower;
import User.LoanOfficer;
import User.User;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fahim Shahriar
 */
public class LoanOfficerT5ProcessReschedulePaymentProcessController implements Initializable {

    @FXML
    private TableView<BorrowerLoanReschedule> borrowerTableView;
    @FXML
    private TableColumn<BorrowerLoanReschedule, String> borrowerNidTableColumn;
    @FXML
    private TableColumn<BorrowerLoanReschedule, String> rescheduleTypeTableColumn1;
    
    private static LoanOfficer localLoanOfficer = new LoanOfficer();
    
    private static ArrayList <BorrowerLoanReschedule> rescheduleArr = new ArrayList<BorrowerLoanReschedule>();
    @FXML
    private TextArea detailsTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        borrowerNidTableColumn.setCellValueFactory(new PropertyValueFactory<>("borrowerNid"));
        rescheduleTypeTableColumn1.setCellValueFactory(new PropertyValueFactory<>("requestType"));
        borrowerTableView.getItems().addAll(rescheduleArr);
        // TODO
    } 
    
    public void loggedLoanOfficer(User paramLoanOfficer) {
        localLoanOfficer = (LoanOfficer) paramLoanOfficer;
        
    }
    
    public void borrowerLoanRescheduleDataPass (BorrowerLoanReschedule pReschedule){
        rescheduleArr.add(pReschedule);
        borrowerTableView.getItems().addAll(rescheduleArr);
    }
    
    @FXML
    private void detailedViewOnClick(MouseEvent event) {
        BorrowerLoanReschedule detailLoanReschedule = borrowerTableView.getSelectionModel().getSelectedItem();
        detailsTextArea.setText(detailLoanReschedule.toString());
    }

    @FXML
    private void approveButtonOnClick(MouseEvent event) throws IOException {
        BorrowerLoanReschedule approveLoanReschedule = borrowerTableView.getSelectionModel().getSelectedItem();
        
        Notification temp = new Notification();
        
        temp = localLoanOfficer.approveOrDeclineLoanReschedule(
                approveLoanReschedule.getBorrowerNid(),
                localLoanOfficer.getId(),
                "Borrower", 
                "The application have been approved");
        
        FXMLLoader approvedLoader = new FXMLLoader();
        approvedLoader.setLocation(getClass().getResource("BorrowerDashboardScene.fxml"));
        Parent root = approvedLoader.load();
        
        Scene BorrowerDashBoardScene = new Scene(root);
        BorrowerDashboardSceneController BdashboardController = approvedLoader.getController();
        BdashboardController.loanRescheduleApplicationPassData(temp);
        
    }

    @FXML
    private void declineButtonOnClick(MouseEvent event) throws IOException {
        BorrowerLoanReschedule approveLoanReschedule = borrowerTableView.getSelectionModel().getSelectedItem();
        
        Notification temp = new Notification();
        
        temp = localLoanOfficer.approveOrDeclineLoanReschedule(
                approveLoanReschedule.getBorrowerNid(),
                localLoanOfficer.getId(),
                "Borrower", 
                "The application have been denied");
        
        FXMLLoader approvedLoader = new FXMLLoader();
        approvedLoader.setLocation(getClass().getResource("BorrowerDashboardScene.fxml"));
        Parent root = approvedLoader.load();
        
        Scene BorrowerDashBoardScene = new Scene(root);
        BorrowerDashboardSceneController BdashboardController = approvedLoader.getController();
        BdashboardController.loanRescheduleApplicationPassData(temp);
    }

    @FXML
    private void goBackToDashBoardOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("LoanOfficerDahsboadScene.fxml"));
        Parent root = loader.load();
        
        Scene loanOfficerDashBoard = new Scene(root);
//        LoanOfficerT1TotalApplicationForSelectionController controller =  loader.getController();
        
        Stage loanOfficerGoBackToDashBoardStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loanOfficerGoBackToDashBoardStage.setScene(loanOfficerDashBoard);
        loanOfficerGoBackToDashBoardStage.show();
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

    
    
}
