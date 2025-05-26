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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ModelClass.HRMail;
import User.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import User.User;
import javafx.scene.control.Alert;

/**
 *
 * @author aqib
 */
public class HRExecutiveT5Warn_FireEmployeeSceneController implements Initializable {

    @FXML
    private TextField employeeWarningIDTextField;
    @FXML
    private DatePicker MailDate;
    @FXML
    private TextArea ShowTemplateMail;
    private static ArrayList<User> user_list_1 = new ArrayList<>();
//    String name_to_find = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void SendMail(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Mail has been sent ");
        alert.setContentText("Sent to" + "ID:" + employeeWarningIDTextField.getText());
        alert.showAndWait();
    }

    @FXML
    private void clearInputsOnClick(MouseEvent event) {
        employeeWarningIDTextField.setText(null);
        MailDate.setValue(null);
        ShowTemplateMail.setText(null);
    }

    @FXML
    private void WarningMaibutton(MouseEvent event) {
        String idToFind = employeeWarningIDTextField.getText();
        String name_to_find = null;
        String designation_to_find = null;

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("employeeList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User temp;
            user_list_1.removeAll(user_list_1);

            try {
                while (true) {
                    temp = (User) ois.readObject();
                    user_list_1.add(temp);
                }
            } catch (Exception e) {
            }
        } catch (IOException ex) {
            System.out.println("No File Found!");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.out.println("final Exception");
                }
            }
        }

        for (User user : user_list_1) {
            if (user.getId().equals(idToFind)) {
                name_to_find = user.getName();
                designation_to_find = user.getEmployeeType();
                HRMail mail = new HRMail(name_to_find, MailDate.getValue(), designation_to_find);
                String mailholder;
                mailholder = mail.toString_Warning();
                ShowTemplateMail.setText(mailholder);
                break;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("ID not found");
                alert.setContentText("The ID you have typed ID:" + idToFind + " is not found in the database. Please check the ID you have typed.");

                alert.showAndWait();
                break;
            }
        }

    }

    @FXML
    private void TerminateMailButton(MouseEvent event) {
        String idToFind = employeeWarningIDTextField.getText();
        String name_to_find = null;
        String designation_to_find = null;

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("employeeList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User temp;
            user_list_1.removeAll(user_list_1);

            try {
                while (true) {
                    temp = (User) ois.readObject();
                    user_list_1.add(temp);
                }
            } catch (Exception e) {
            }
        } catch (IOException ex) {
            System.out.println("No File Found!");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.out.println("final Exception");
                }
            }
        }

        for (User user : user_list_1) {
            if (user.getId().equals(idToFind)) {
                name_to_find = user.getName();
                designation_to_find = user.getEmployeeType();
                HRMail mail = new HRMail(name_to_find, MailDate.getValue(), designation_to_find);
                String mailholder;
                mailholder = mail.toString_Teminate();
                ShowTemplateMail.setText(mailholder);
                break;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("ID not found");
                alert.setContentText("The ID you have typed ID:" + idToFind + " is not found in the database. Please check the ID you have typed.");

                alert.showAndWait();
            }
        }

    }

}
