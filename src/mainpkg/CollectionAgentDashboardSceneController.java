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
 * @author EUJ
 */
public class CollectionAgentDashboardSceneController implements Initializable {

    @FXML
    private Text cANameWelcomeLabel;
    @FXML
    private TextArea cAInfoTextArea;
    @FXML
    private TextArea cANotifTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void trackBorrowerAccountSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CollectionAgentT1TrackBorrowerAccountScene.fxml"));
        Parent root = loader.load();

        Scene CollectionAgentT1TrackBorrowerAccountScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(CollectionAgentT1TrackBorrowerAccountScene);
        stg2.show();
    }

    @FXML
    private void notifyDelinquentBorrowerSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CollectionAgentT2NotifyDelinquentBorrowerScene.fxml"));
        Parent root = loader.load();

        Scene CollectionAgentT2NotifyDelinquentBorrowerScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(CollectionAgentT2NotifyDelinquentBorrowerScene);
        stg2.show();
    }

    @FXML
    private void evaluateBorrowerFinancialSituationSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CollectionAgentT3EvaluateLoanApplicationScene.fxml"));
        Parent root = loader.load();

        Scene CollectionAgentT3EvaluateLoanApplicationScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(CollectionAgentT3EvaluateLoanApplicationScene);
        stg2.show();
    }

    @FXML
    private void scheduleMeetingWithBorrowerSceneOnCLick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CollectionAgentT4ViewFDCPAScene.fxml"));
        Parent root = loader.load();

        Scene CollectionAgentT4ViewFDCPScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(CollectionAgentT4ViewFDCPScene);
        stg2.show();
    }

    @FXML
    private void updateBorrowerInformationSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CollectionAgentT5UpdateBorrowerInformationScene.fxml"));
        Parent root = loader.load();

        Scene CollectionAgentT4ViewFDCPScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(CollectionAgentT4ViewFDCPScene);
        stg2.show();
    }

    @FXML
    private void sendDemandLetterToDelinquentSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CollectionAgentT6SendDemandLetterToDelinquent.fxml"));
        Parent root = loader.load();

        Scene CollectionAgentT5UpdateBorrowerInformationScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(CollectionAgentT5UpdateBorrowerInformationScene);
        stg2.show();
    }

    @FXML
    private void provideFeedbacktoHeadofBranchSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CollectionAgentT7ProvideFeedbackToHOBScene.fxml"));
        Parent root = loader.load();

        Scene CollectionAgentT6SendDemandLetterToDelinquent = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(CollectionAgentT6SendDemandLetterToDelinquent);
        stg2.show();
    }

    @FXML
    private void generateReportOnDelenquentAccountSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CollectionAgentT8GenerateReportOnDelinquentAccountScene.fxml"));
        Parent root = loader.load();

        Scene CollectionAgentT7ProvideFeedbackToHOBScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(CollectionAgentT7ProvideFeedbackToHOBScene);
        stg2.show();
    }

    @FXML
    private void complaintBoxSceneOnClick(MouseEvent event) throws IOException {
        
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
    
}
