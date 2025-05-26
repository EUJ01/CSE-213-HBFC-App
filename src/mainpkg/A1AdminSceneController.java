/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import User.Admin;
import User.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ModelClass.AppendableOOS;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class A1AdminSceneController implements Initializable {

    @FXML
    private TextField empIdTextField;
    @FXML
    private TextField empNameTextField;
    @FXML
    private DatePicker empDobDatePicker;
    @FXML
    private RadioButton empFemaleRB;
    @FXML
    private ComboBox<String> empDesigCB;
    @FXML
    private TextField empPassTextField;
    @FXML
    private ComboBox<String> empDeptCB;
    @FXML
    private TextField empSalaryTextField;
    @FXML
    private DatePicker empDojDatePicker;
    @FXML
    private TableView<User> empTableView;
    @FXML
    private TableColumn<User, String> empIdColumn;
    @FXML
    private TableColumn<User, String> empDesigColumn;
    @FXML
    private TableColumn<User, LocalDate> empDojColumn;
    @FXML
    private RadioButton empMaleRB;

    public static ArrayList<User> empList = new ArrayList<>();
    private ToggleGroup tg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tg = new ToggleGroup();
        empMaleRB.setToggleGroup(tg);
        empFemaleRB.setToggleGroup(tg);

        empDeptCB.getItems().addAll("Operations", "Legal", "Finance", "Human Resource", "Recovery & Collection");
        empDesigCB.getItems().addAll("Accountant", "Collection Agent", "Customer Service Agent",
                "Head of Branch", "HR Executive", "Legal Advisor", "Loan Officer");

        empIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        empDesigColumn.setCellValueFactory(new PropertyValueFactory<>("employeeType"));
        empDojColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfJoin"));
        // TODO
    }

    @FXML
    private void addEmployeeOnClick(MouseEvent event) throws IOException {

        File empwFile = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        if (empMaleRB.isSelected()) {
            User temp = Admin.createEmployeeAccount(
                    empIdTextField.getText(),
                    empNameTextField.getText(),
                    empDobDatePicker.getValue(),
                    empMaleRB.getText(),
                    empDesigCB.getValue(),
                    empPassTextField.getText(),
                    empDeptCB.getValue(),
                    Float.parseFloat(empSalaryTextField.getText()),
                    empDojDatePicker.getValue());

            empList.add(temp);
            empTableView.getItems().add(temp);

            try {
                empwFile = new File("employeeList.bin");
                if (empwFile.exists()) {
                    fos = new FileOutputStream(empwFile, true);
                    oos = new AppendableOOS(fos);
                } else {
                    fos = new FileOutputStream(empwFile);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(temp);
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

            Scene loginScn = new Scene(root);

            AALoginSceneController controller = loader.getController();
            controller.empData(empList);

        } 
        
        else if (empFemaleRB.isSelected()) {
            User temp = Admin.createEmployeeAccount(
                    empIdTextField.getText(),
                    empNameTextField.getText(),
                    empDobDatePicker.getValue(),
                    empFemaleRB.getText(),
                    empDesigCB.getValue(),
                    empPassTextField.getText(),
                    empDeptCB.getValue(),
                    Float.parseFloat(empSalaryTextField.getText()),
                    empDojDatePicker.getValue());

            empList.add(temp);
            empTableView.getItems().add(temp);

            try {
                empwFile = new File("employeeList.bin");
                if (empwFile.exists()) {
                    fos = new FileOutputStream(empwFile, true);
                    oos = new AppendableOOS(fos);
                } else {
                    fos = new FileOutputStream(empwFile);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(temp);
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

            Scene loginScn = new Scene(root);

            AALoginSceneController controller = loader.getController();
            controller.empData(empList);
        }
    }

    @FXML
    private void loadEmployeeListFromBinaryFile(MouseEvent event) throws IOException {
        
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("employeeList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User temp;
            empList.removeAll(empList);

            try {
                while (true) {
                    temp = (User) ois.readObject();
                    empList.add(temp);
                }

            } 
            
            catch (Exception e) {
            }
        } 
        
        catch (IOException ex) {
            System.out.println("No File Found!");
        } 
        
        finally {
            if (ois != null) {
                ois.close();
                empTableView.getItems().clear();
                empTableView.getItems().addAll(empList);
            }
        }
    }

    @FXML
    private void logoutOnClick(MouseEvent event) throws IOException {
        FXMLLoader outloader = new FXMLLoader();
        outloader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent logroot = outloader.load();

        Scene AALoginScene = new Scene(logroot);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AALoginScene);
        stg2borrower.show();
    }

}
