/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class BorrowerT6ConstructionCostCalculatorSceneController implements Initializable {

    @FXML
    private TextField residentialAreaTextField;
    @FXML
    private TextField parkingAreaTextField;
    @FXML
    private ComboBox<String> noOfTopFloorComboBox;
    @FXML
    private TextField typicalFloorAreaTextField;
    @FXML
    private Label outputLabel;

    private static Borrower localBorr = new Borrower();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        noOfTopFloorComboBox.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

    }

    public void loggedBorrowerDataPass(Borrower paramBorrower) {
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

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AALoginScene);
        stg2borrower.show();
    }

    @FXML
    private void calculateOnClick(MouseEvent event) {
        float residentialArea = Float.parseFloat(residentialAreaTextField.getText());
        float parkingArea = Float.parseFloat(parkingAreaTextField.getText());
        float numberOfTopFloor = Float.parseFloat(noOfTopFloorComboBox.getValue());
        float typicalFloorArea = Float.parseFloat(typicalFloorAreaTextField.getText());

        float temp = localBorr.BorrowerConstructionCostCalculator(residentialArea, parkingArea, numberOfTopFloor, typicalFloorArea);

        outputLabel.setText("" + temp + " tk");
    }

}
