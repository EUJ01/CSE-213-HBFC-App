/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelClass.BorrowerLoanApplication;
import ModelClass.Notification;
import User.LoanOfficer;
import User.User;
import java.io.IOException;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fahim Shahriar
 */
public class LoanOfficerT2PerformInitialCheckandForwardtoCollectionAgentController implements Initializable {

    @FXML
    private TableView<BorrowerLoanApplication> borrowerTableView;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> borrowerNidTableColumn;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> borrowerNameTableColumn;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> loanTypeTableColumn;
    
    private static ArrayList<BorrowerLoanApplication> processArr = new ArrayList<>();
    
    private static LoanOfficer localLoanOfficer = new LoanOfficer();
    
    
    @FXML
    private TextField addiitionalFileTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        borrowerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        borrowerNidTableColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        loanTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("loanType"));
        
        borrowerTableView.getItems().addAll(processArr);
        // TODO
    }   
    
    public void loggedLoanOfficer(User paramLoanOfficer) {
        localLoanOfficer = (LoanOfficer) paramLoanOfficer;
       
    }
    
    @FXML
    private void checkOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LoanOfficerT3aViewApplicationDetails.fxml"));
        Parent root = loader.load();
        
        Scene viewScene = new Scene(root);
        
        LoanOfficerT3aViewApplicationDetailsController controller = loader.getController();
        controller.loanDetailPass(borrowerTableView.getSelectionModel().getSelectedItem());
        
        Stage stg = new Stage();
        stg.setScene(viewScene);
        stg.show();
    }

    @FXML
    private void forwardToCollectionAgentOnClick(MouseEvent event) throws IOException {
        BorrowerLoanApplication selectedBorrowerLoanApplication = borrowerTableView.getSelectionModel().getSelectedItem();
        
        Notification temp = new Notification();
        
        temp = localLoanOfficer.senAdditionalDocument(
                localLoanOfficer.getId(),
                selectedBorrowerLoanApplication.getNid(),
                "Loan Officer", 
                addiitionalFileTextField.getText());
        
        FXMLLoader loaderBA = new FXMLLoader();
        loaderBA.setLocation(getClass().getResource("BorrowerT2SendRequireDocumentsScene.fxml"));
        Parent root1 = loaderBA.load();
        
        Scene scene1 = new Scene(root1);
        
        BorrowerT2SendRequireDocumentsSceneController controller1 = loaderBA.getController();
        
        controller1.passDataLoanOfficerT2toBorowerT2(temp);
        
        FXMLLoader loaderT3 = new FXMLLoader();
        loaderT3.setLocation(getClass().getResource("LoanOfficerT3ApproveOrDeclineApplication.fxml"));
        Parent root2 = loaderT3.load();
        
        Scene scene2 = new Scene(root2);
        
        LoanOfficerT3ApproveOrDeclineApplicationController controller2 = loaderT3.getController();
        controller2.borrowerLoanApplicationDataPass(selectedBorrowerLoanApplication);
   
    }
    
    public void t1toT2BorrowerLoanApplicationPassData(BorrowerLoanApplication pApplication){
        processArr.add(pApplication);
        borrowerTableView.getItems().clear();
        borrowerTableView.getItems().addAll(processArr);
        
    }

    @FXML
    private void goBackToDashBoardOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("LoanOfficerDahsboadScene.fxml"));
        Parent root = loader.load();
        
        Scene loanOfficerDashBoard = new Scene(root);
        
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
