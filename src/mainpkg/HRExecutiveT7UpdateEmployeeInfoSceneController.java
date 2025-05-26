/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import User.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aqib
 */
public class HRExecutiveT7UpdateEmployeeInfoSceneController implements Initializable {

    @FXML
    private TableView<User> EmployeeInformationtableview;
    @FXML
    private TableColumn<User, String> EmployeeInformationID;
    @FXML
    private TableColumn<User, String> EmployeeInformationLName;
    @FXML
    private TableColumn<User, String> EmployeeInformationDesignition;
    @FXML
    private TableColumn<User, Float> EmployeeInformationSalary;
    @FXML
    private TableColumn<User, LocalDate> EmployeeInformationJoiningDate;

    private static ArrayList<User> user_list = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        EmployeeInformationID.setCellValueFactory(new PropertyValueFactory<>("id"));
        EmployeeInformationLName.setCellValueFactory(new PropertyValueFactory<>("name"));
        EmployeeInformationDesignition.setCellValueFactory(new PropertyValueFactory<>("employeeType"));
        EmployeeInformationSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        EmployeeInformationJoiningDate.setCellValueFactory(new PropertyValueFactory<>("dateOfJoin"));

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("employeeList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User temp;
            user_list.removeAll(user_list);

            try {
                while (true) {
                    temp = (User) ois.readObject();
                    user_list.add(temp);
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

        EmployeeInformationtableview.getItems().clear();
        EmployeeInformationtableview.getItems().addAll(user_list);
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

}
