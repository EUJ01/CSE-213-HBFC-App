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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class CollectionAgentT2NotifyDelinquentBorrowerSceneController implements Initializable {

    @FXML
    private TableView<?> delinquentTable;
    @FXML
    private TableColumn<?, ?> delinquentNameColumn;
    @FXML
    private TableColumn<?, ?> delinquentNIDColumn;
    @FXML
    private TableColumn<?, ?> delinquentDueDateColumn;
    @FXML
    private DatePicker delinquentNoticeDatePicker;
    @FXML
    private TextArea notifyDelinquentTextArea;

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
        loader.setLocation(getClass().getResource("CollectionAgentDashboardScene.fxml"));
        Parent root = loader.load();

        Scene CollectionAgentDashboardScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(CollectionAgentDashboardScene);
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
    private void sendNotificationToDelinquentOnCLick(MouseEvent event) {
    }

}
