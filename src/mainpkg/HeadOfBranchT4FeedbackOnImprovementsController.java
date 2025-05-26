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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class HeadOfBranchT4FeedbackOnImprovementsController implements Initializable {

    @FXML
    private Button feedbackOnImprovementsDatePicker;
    @FXML
    private TableView<?> topicColumn;
    @FXML
    private TableColumn<?, ?> feedbackOnImprovementsDateColumn;
    @FXML
    private TableColumn<?, ?> feedbackOnImprovementsTopicColumn;
    @FXML
    private Label feedbackOnImprovementsDetails;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dashboardSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchDashboardScene.fxml"));
        Parent logroot = loader.load();
        
        Scene HeadOfBranchDashboardScene = new Scene(logroot);
        
        Stage stg2borrower = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2borrower.setScene(HeadOfBranchDashboardScene);
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
    private void DissmissFeedbackOnImprovementsOnClick(MouseEvent event) {
    }

    @FXML
    private void ApproveFeedbackOnImprovementsOnClick(MouseEvent event) {
    }
    
}
