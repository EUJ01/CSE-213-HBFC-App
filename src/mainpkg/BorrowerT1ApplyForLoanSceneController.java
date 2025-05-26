/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelClass.AppendableOOS;
import ModelClass.BorrowerLoanApplication;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import User.Borrower;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class BorrowerT1ApplyForLoanSceneController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private DatePicker dateOfBirthDatePicker;
    @FXML
    private TextField nidTextField;
    @FXML
    private TextField eTinTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField passportNoTextField;
    @FXML
    private TextField occupationTextField;
    @FXML
    private TextField companyNameTextField;
    @FXML
    private TextField noOfFamilyMembersTextField;
    @FXML
    private TextField monthlySalaryTextField;
    @FXML
    private TextField locationOfTheLandTextField;
    @FXML
    private TextField potentialRentPerSqFtTextField;
    @FXML
    private TextField positionTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextField loanAmountRequestedTextField;
    @FXML
    private RadioButton agreeRadioButton;
    @FXML
    private RadioButton disagreeRadioButton;
    @FXML
    private ComboBox<String> loanTypeComboBox;

    public static ArrayList<BorrowerLoanApplication> localArr = new ArrayList<>();
    private static Borrower localBorr = new Borrower();

    /**
     * Initializes the controller class.
     */
    ToggleGroup tg;
    @FXML
    private Label outputLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loanTypeComboBox.getItems().addAll("Nagarbondhu", "Pollima", "Probashbondhu", "Abashon Unnoyon", "Abashon Meramot");

        tg = new ToggleGroup();
        agreeRadioButton.setToggleGroup(tg);
        disagreeRadioButton.setToggleGroup(tg);

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
    private void submitLoanApplicationOnClick(MouseEvent event) throws IOException {

        BorrowerLoanApplication temp1 = new BorrowerLoanApplication();
        if (agreeRadioButton.isSelected()) {
            temp1 = localBorr.submitLoanApplication(
                    nameTextField.getText(),
                    dateOfBirthDatePicker.getValue(),
                    nidTextField.getText(),
                    eTinTextField.getText(),
                    addressTextField.getText(),
                    passportNoTextField.getText(),
                    occupationTextField.getText(),
                    companyNameTextField.getText(),
                    positionTextField.getText(),
                    locationTextField.getText(),
                    Integer.parseInt(noOfFamilyMembersTextField.getText()),
                    Float.parseFloat(monthlySalaryTextField.getText()),
                    locationOfTheLandTextField.getText(),
                    Float.parseFloat(potentialRentPerSqFtTextField.getText()),
                    Float.parseFloat(loanAmountRequestedTextField.getText()),
                    loanTypeComboBox.getValue(),
                    agreeRadioButton.getText(),
                    "Pending");

            localArr.add(temp1);

            //pass to tracking scene
            FXMLLoader t4Loader = new FXMLLoader();
            t4Loader.setLocation(getClass().getResource("BorrowerT4TrackApplicationScene.fxml"));
            Parent t4Root = t4Loader.load();
            BorrowerT4TrackApplicationSceneController T4Controller = t4Loader.getController();
            T4Controller.borrowerPassApplication(localArr);
            //

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("LoanOfficerT1TotalApplicationForSelection.fxml"));
            Parent root = loader.load();
            Scene LoanOfficerT1TotalApplicationForSelection = new Scene(root);

            LoanOfficerT1TotalApplicationForSelectionController controller = loader.getController();
            controller.loanApplicationPassData(temp1);

        } else if (disagreeRadioButton.isSelected()) {
            Alert add = new Alert(Alert.AlertType.ERROR);
            add.setContentText("Cannot Proceed without agreeing to terms and conditions");
            add.setHeaderText(null);
            add.showAndWait();
        }

    }

}
