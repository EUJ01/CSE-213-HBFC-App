/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.AppendableOOS;
import User.Borrower;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class BorrowerSignUpSceneController implements Initializable {

    @FXML
    private TextField nidTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private RadioButton maleRB;
    @FXML
    private RadioButton femaleRB;
    @FXML
    private PasswordField passwordTextField;

    private ToggleGroup tg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        tg = new ToggleGroup();
        maleRB.setToggleGroup(tg);
        femaleRB.setToggleGroup(tg);

    }

    @FXML
    private void signUpOnClick(MouseEvent event) throws IOException {
        Borrower temp1 = new Borrower();

        if (maleRB.isSelected()) {
            temp1 = Borrower.borrowerSignUp(
                    nidTextField.getText(),
                    nameTextField.getText(),
                    dobDatePicker.getValue(),
                    maleRB.getText(),
                    passwordTextField.getText());
        } else if (femaleRB.isSelected()) {
            temp1 = Borrower.borrowerSignUp(
                    nidTextField.getText(),
                    nameTextField.getText(),
                    dobDatePicker.getValue(),
                    femaleRB.getText(),
                    passwordTextField.getText());
        }

        File borrFile = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            borrFile = new File("borrowerList.bin");
            if (borrFile.exists()) {
                fos = new FileOutputStream(borrFile, true);
                oos = new AppendableOOS(fos);
            } else {
                fos = new FileOutputStream(borrFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(temp1);
        } catch (IOException ex) {
            System.out.print("File writing successful");
        } finally {
            if (oos != null) {
                oos.close();
            }
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent root = loader.load();
        Scene AALoginScene = new Scene(root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AALoginScene);
        stg2borrower.show();
    }

}
