/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelClass.LoanPolicy;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fahim Shahriar
 */
public class LoanOfficerT7ProporsingNewLoanOfferingPoliciesController implements Initializable {

    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private TextField subjectOfTheApplicationTextField;
    @FXML
    private TextArea detailesTextField;
    @FXML
    private TextField legalAdvisorIdTextField;
    
    private static ArrayList<LoanPolicy> loanPolicysArr = new ArrayList<>();
    
    private static LoanOfficer localLoanOfficer = new LoanOfficer();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
      public void loggedLoanOfficer(User paramLoanOfficer) {
        localLoanOfficer = (LoanOfficer) paramLoanOfficer;
       
    }
    
    @FXML
    private void sendToLegalAdvisorOnClick(MouseEvent event) throws IOException {
        
        LoanPolicy temp = new LoanPolicy();
        temp.setDate(dateDatePicker.getValue());
        temp.setLaID(legalAdvisorIdTextField.getId());
        temp.setDetails(detailesTextField.getText());
        
//        loanPolicysArr.add(temp);
        
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("LegalAdvisorT2_LawsandRegulation.fxml"));
        
        Parent root = loader1.load();
        Scene scene = new Scene(root);
        
        LegalAdvisorT2_LawsandRegulationController controller = loader1.getController();
        
        controller.loanPolicyPassData(temp);   
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
