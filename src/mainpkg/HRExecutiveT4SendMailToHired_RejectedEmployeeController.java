/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelClass.HRMail;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aqib
 */
public class HRExecutiveT4SendMailToHired_RejectedEmployeeController implements Initializable {

    @FXML
    private TextField RequirementMailFName;
    @FXML
    private DatePicker RequirementMailDate;
    @FXML
    private TextField RequirementMailLName;
    @FXML
    private ComboBox<String> RequirementMailDesignation;
    @FXML
    private TextArea RequirementMailGenerateTemplate;
    @FXML
    private TextField recruitmentEmailTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequirementMailDesignation.getItems().addAll("Accountant", "Collection Agent", "Customer Service Agent",
                "Head of Branch", "HR Executive", "Legal Advisor", "Loan Officer", "Borrower");

        // TODO
    }

    @FXML
    private void DashboardSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveDashboardScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void LogoutOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void RequirementMailSetValues(MouseEvent event) {
        HRMail mail = new HRMail(RequirementMailFName.getText(),
                RequirementMailLName.getText(), RequirementMailDate.getValue(), RequirementMailDesignation.getValue());
        String temp;
        temp = mail.toString();
        RequirementMailGenerateTemplate.setText(temp);

    }

    @FXML
    private void RequirementMailSend(MouseEvent event) {
//        recruitmentEmailTextField
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle("Error Dialog");
//        alert.setHeaderText("An error occurred!");
//        alert.setContentText("Please check your input and try again.");
        if (recruitmentEmailTextField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Email not typed");
            alert.setContentText("Please type a valid emial");

            alert.showAndWait();
        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText("Mail has been sent");
            alert.setContentText("Mail has been send to " + recruitmentEmailTextField.getText());

            alert.showAndWait();
        }

    }

}
