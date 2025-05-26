/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.AppendableOOS;
import ModelClass.HRPolicy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class HRExecutiveT1CreateHRPolicySceneController implements Initializable {

    @FXML
    private TableView<HRPolicy> HRPolicytableview;
    @FXML
    private TableColumn<HRPolicy, LocalDate> HRPolicyDateColumn;
    @FXML
    private TableColumn<HRPolicy, String> HRPolicycolumnSubjectColumn;
    @FXML
    private TextArea DetailsHRPolicy;
    @FXML
    private DatePicker CreatedDateHRPolicy;
    @FXML
    private TextField CreatedSubjectHRPolicy;

    private static ArrayList<HRPolicy> holderrrr = new ArrayList<>();
    private static ArrayList<HRPolicy> hrPolicies = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        HRPolicyDateColumn.setCellValueFactory(new PropertyValueFactory<>("CreatedDate"));
        HRPolicycolumnSubjectColumn.setCellValueFactory(new PropertyValueFactory<>("Subject"));
        
    }

    @FXML
    private void loadbutton(MouseEvent event) throws IOException {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("HRPolicy.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            HRPolicy temp;
            holderrrr.removeAll(holderrrr);

            try {
                while (true) {
                    temp = (HRPolicy) ois.readObject();
                    holderrrr.add(temp);
                }

            } catch (Exception e) {
            }
        } catch (IOException ex) {
            System.out.println("No File Found!");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("No File Found!");
            alert.setContentText("");

            alert.showAndWait();
        } finally {
            if (ois != null) {
                ois.close();
                HRPolicytableview.getItems().clear();
                HRPolicytableview.getItems().addAll(holderrrr);
//                System.out.println("PRINTTT1111111");
            }
        }
    }

    @FXML
    private void CreateHRPolicy(MouseEvent event) throws IOException {
        HRPolicytableview.getItems().clear();
        HRPolicy temp1 = new HRPolicy(CreatedDateHRPolicy.getValue(), CreatedSubjectHRPolicy.getText(), DetailsHRPolicy.getText());
        hrPolicies.add(temp1);

        File empwFile = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            empwFile = new File("HRPolicy.bin");
            if (empwFile.exists()) {
                fos = new FileOutputStream(empwFile, true);
                oos = new AppendableOOS(fos);
//                System.out.println("PRINTTT");
            } else {
                fos = new FileOutputStream(empwFile);
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

        CreatedSubjectHRPolicy.setText("");
        DetailsHRPolicy.setText("");
        CreatedDateHRPolicy.setValue(null);
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
//    HRPolicytableview.setOnMouseClicked(event -> {
//    // get the selected row in the table view
//    HRPolicy hrPolicy = HRPolicytableview.getSelectionModel().getSelectedItem();
//    if (hrPolicy != null) {
//        // display the complaint details in the text area
//        DetailsHRPolicy.setText(hrPolicy.getDetail());
//    }

    @FXML
    private void mouseclicktogetDetails(MouseEvent event) {
            // get the selected row in the table view
    HRPolicy hrPolicy_temp = HRPolicytableview.getSelectionModel().getSelectedItem();
    if (hrPolicy_temp != null) {
        // display the complaint details in the text area
        DetailsHRPolicy.setText(hrPolicy_temp.getDetail());
    }

}

    @FXML
    private void Cleardetails(MouseEvent event) {
        DetailsHRPolicy.setText(null);
    }
}