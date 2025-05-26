/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.AppendableOOS;
import ModelClass.AccountantJournal;
import User.Accountant;
import User.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class AccountantT1PrepareJournalSceneController implements Initializable {

    @FXML
    private TableView<AccountantJournal> journalTable;
    @FXML
    private TableColumn<AccountantJournal, LocalDate> dateColumn;
    @FXML
    private TableColumn<AccountantJournal, String> AccountsColumn;
    @FXML
    private TableColumn<AccountantJournal, Float> debitColumn;
    @FXML
    private TableColumn<AccountantJournal, Float> creditColumn;
    @FXML
    private DatePicker journalDatePicker;
    @FXML
    private TextField journalEntryTextField;
    @FXML
    private TextField journalAmountTextField;
    @FXML
    private ComboBox<String> journalCRDRCB;

    private static Accountant localAccountant = new Accountant();
    private static ArrayList<AccountantJournal> journalArr = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        journalCRDRCB.getItems().addAll("Debit", "Credit");

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("journalDate"));
        AccountsColumn.setCellValueFactory(new PropertyValueFactory<>("journalAccount"));
        debitColumn.setCellValueFactory(new PropertyValueFactory<>("journalDRAmount"));
        creditColumn.setCellValueFactory(new PropertyValueFactory<>("journalCRAmount"));
        
        journalTable.getItems().addAll(journalArr);

    }

    public void loggedAccountant(User paramAccountant) {
        localAccountant = (Accountant) paramAccountant;
    }

    @FXML
    private void addEntryButtonOnClick(MouseEvent event) {

        AccountantJournal temp = new AccountantJournal();

        temp = localAccountant.addJournalEntry(
                localAccountant.getId(),
                journalDatePicker.getValue(),
                journalEntryTextField.getText(),
                journalCRDRCB.getValue(),
                Float.parseFloat(journalAmountTextField.getText()));

        journalArr.add(temp);
        journalTable.getItems().clear();
        journalTable.getItems().addAll(journalArr);

        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Journal.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableOOS(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(temp);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Write Exception Occured!");
        }
    }

    @FXML
    private void DashboardSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountantDashboardScene.fxml"));
        Parent dashroot = loader.load();

        Scene AccountantDashboardScene = new Scene(dashroot);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AccountantDashboardScene);
        stg2borrower.show();
    }

    @FXML
    private void LogoutOnCLick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent logroot = loader.load();

        Scene AALoginScene = new Scene(logroot);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AALoginScene);
        stg2borrower.show();
    }

}
