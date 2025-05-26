/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.BorrowerComplaint;
import User.Borrower;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class BorrowerT7LodgeAComplaintOrProvideFeedbackSceneController implements Initializable {

    @FXML
    private TextField complaintOrFeedbackDetailsTextField;
    @FXML
    private TextField complaintOrFeedbackTopicTextField;
    @FXML
    private DatePicker complaintOrFeedbackDatePicker;
    
    private static Borrower localBorr = new  Borrower();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void loggedBorrowerDataPass(Borrower paramBorrower){
        localBorr = paramBorrower;
    
    }
    


    @FXML
    private void dashboardSceneOnClick(MouseEvent event) throws IOException {
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
        
        Stage stg2borrower = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AALoginScene);
        stg2borrower.show();
    }
    
    
    

    @FXML
    private void lodgeComplaintOrFeedbackOnClick(MouseEvent event) throws IOException {
        
        BorrowerComplaint temp1 = new BorrowerComplaint();
        
        temp1 = localBorr.lodgeComplaintOrFeedback(
                complaintOrFeedbackDatePicker.getValue(), 
                complaintOrFeedbackTopicTextField.getText(), 
                complaintOrFeedbackDetailsTextField.getText());
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CustomerServiceAgentT3ResolveBorrowersComplaintScene.fxml"));
        Parent root = loader.load();
        Scene CustomerServiceAgentT3ResolveBorrowersComplaintScene = new Scene(root);
        
        CustomerServiceAgentT3ResolveBorrowersComplaintSceneController controller = loader.getController();
        controller.borrowerComplaintDataPass(temp1);
    }
    
}
