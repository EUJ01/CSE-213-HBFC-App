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
public class CustomerServiceAgentDashboardSceneController implements Initializable {


    @FXML
    private Text customerServiceAgentNameLabel;
    @FXML
    private TextArea cutomerServiceAgentTextArea;
    @FXML
    private TextArea customerServiceAgentNotificationTextArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void confirmBorrowerPaymentOnClick(MouseEvent event) throws IOException {
        FXMLLoader T1loader = new FXMLLoader();
        T1loader.setLocation(getClass().getResource("CustomerServiceAgentT1PaymentConfirmScene.fxml"));
        Parent T1root = T1loader.load();
        
        Scene CustomerServiceAgentT3ResolveBorrowersComplaintScene = new Scene(T1root);
        
        Stage stg2borrower = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2borrower.setScene(CustomerServiceAgentT3ResolveBorrowersComplaintScene);
        stg2borrower.show();
    }

    @FXML
    private void requestOfficeSuppliesOnClick(MouseEvent event) throws IOException {
        FXMLLoader t2Loader = new FXMLLoader();
        t2Loader.setLocation(getClass().getResource("CustomerServiceAgentT2RequestOfficeSuppliesScene.fxml"));
        Parent t2Root = t2Loader.load();

        Scene t2LnOfcr = new Scene(t2Root);

        Stage t2Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t2Stg.setScene(t2LnOfcr);
        t2Stg.show();
    }

    @FXML
    private void resolveBorrowerComplaintOnClick(MouseEvent event) throws IOException {
        FXMLLoader t3Loader = new FXMLLoader();
        t3Loader.setLocation(getClass().getResource("CustomerServiceAgentT3ResolveBorrowersComplaintScene.fxml"));
        Parent t3Root = t3Loader.load();

        Scene t3LnOfcr = new Scene(t3Root);

        Stage t3Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t3Stg.setScene(t3LnOfcr);
        t3Stg.show();
    }

    @FXML
    private void generateComplainReportOnClick(MouseEvent event) throws IOException {
        FXMLLoader t4Loader = new FXMLLoader();
        t4Loader.setLocation(getClass().getResource("CustomerServiceAgentT4GenerateReportScene.fxml"));
        Parent t4Root = t4Loader.load();

        Scene t4LnOfcr = new Scene(t4Root);

        Stage t4Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t4Stg.setScene(t4LnOfcr);
        t4Stg.show();
       
    }

    @FXML
    private void updatePoliciesOnClick(MouseEvent event) throws IOException {
        FXMLLoader t5Loader = new FXMLLoader();
        t5Loader.setLocation(getClass().getResource("CustomerServiceAgentT5UpdatePolicies.fxml"));
        Parent t5Root = t5Loader.load();

        Scene t5LnOfcr = new Scene(t5Root);

        Stage t5Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t5Stg.setScene(t5LnOfcr);
        t5Stg.show();
       
    }

    @FXML
    private void sendNoticeOnClick(MouseEvent event) throws IOException {
        FXMLLoader t6Loader = new FXMLLoader();
        t6Loader.setLocation(getClass().getResource("CustomerServiceAgentT6SendNotice.fxml"));
        Parent t6Root = t6Loader.load();

        Scene t6LnOfcr = new Scene(t6Root);

        Stage t6Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t6Stg.setScene(t6LnOfcr);
        t6Stg.show();
       
    }

    @FXML
    private void sendSurveyOnClick(MouseEvent event) throws IOException {
        FXMLLoader t7Loader = new FXMLLoader();
        t7Loader.setLocation(getClass().getResource("CustomerServiceAgentT7SendSurvey.fxml"));
        Parent t7Root = t7Loader.load();

        Scene t7LnOfcr = new Scene(t7Root);

        Stage t7Stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        t7Stg.setScene(t7LnOfcr);
        t7Stg.show();
    }

    @FXML
    private void updateBorrowerProfileOnClick(MouseEvent event) throws IOException {
        FXMLLoader t8Loader = new FXMLLoader();
        t8Loader.setLocation(getClass().getResource("CustomerServiceAgentT8CreateUserExperienceSurvey.fxml"));
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

}
