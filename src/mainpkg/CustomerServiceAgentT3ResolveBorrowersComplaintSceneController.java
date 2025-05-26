/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.BorrowerComplaint;
import ModelClass.BorrowerLoanApplication;
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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class CustomerServiceAgentT3ResolveBorrowersComplaintSceneController implements Initializable {

    @FXML
    private TableView<BorrowerComplaint> confirmationTableView;
    @FXML
    private TableColumn<BorrowerComplaint, String> borrowerNIDTableColumn;
    @FXML
    private TableColumn<BorrowerComplaint, String> borrowerNameTableColumn1;
    @FXML
    private TableColumn<BorrowerComplaint, String> compainTableColumn11;
    @FXML
    private TextArea complaintDetailTextArea;
    @FXML
    private TextArea customerServiceAgentNotificationTextArea;
    
    private static ArrayList <BorrowerLoanApplication> loanArrCA = new ArrayList<>();
    
    
    private static ArrayList<BorrowerComplaint> complaintArr = new ArrayList<BorrowerComplaint>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void passDataLoanOfficerT2toCustomerServiceAgentT3(BorrowerLoanApplication pApplication){
        loanArrCA.add(pApplication);
        System.out.println(pApplication);
        
    }
    
    public void borrowerComplaintDataPass(BorrowerComplaint pComplaint){
        complaintArr.add(pComplaint);
    
    }
        
    


    @FXML
    private void goBackToDashBoardOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("CustomerServiceAgentDashboardScene.fxml"));
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

    @FXML
    private void detailedViewButtonOnClick(MouseEvent event) {
        
        
    }

    @FXML
    private void sendReplyButtonOnClick(MouseEvent event) {
        
        String str = "";
        
        for(BorrowerComplaint i : complaintArr){
            str = str + i + "\n";
        }
        
        customerServiceAgentNotificationTextArea.setText(str);
    }
    
}
