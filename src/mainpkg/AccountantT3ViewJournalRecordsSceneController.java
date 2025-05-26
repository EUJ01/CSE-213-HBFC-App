/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.AccountantJournal;
import User.Accountant;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class AccountantT3ViewJournalRecordsSceneController implements Initializable {

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
    private DatePicker filterDateDatePicker;

    private static ArrayList<AccountantJournal> journalArr = new ArrayList<>();
    private static Accountant localAccountant = new Accountant();

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("journalDate"));
        AccountsColumn.setCellValueFactory(new PropertyValueFactory<>("journalAccount"));
        debitColumn.setCellValueFactory(new PropertyValueFactory<>("journalDRAmount"));
        creditColumn.setCellValueFactory(new PropertyValueFactory<>("journalCRAmount"));

    }
    
    public void loggedAccountant(User paramAccountant) {
        localAccountant = (Accountant) paramAccountant;
        
    }

    @FXML
    private void loadJournalRecordsFromBinFile(MouseEvent event) throws IOException {

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Journal.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            AccountantJournal temp;
            journalArr.removeAll(journalArr);

            try {
                while (true) {
                    temp = (AccountantJournal) ois.readObject();
                    journalArr.add(temp);
                }

            } catch (Exception e) {

            }
        } catch (IOException ex) {
            System.out.println("No File Found!");
        } finally {
            if (ois != null) {
                ois.close();
                journalTable.getItems().clear();
                journalTable.getItems().addAll(journalArr);
            }
        }

    }

    @FXML
    private void viewJournalRecordsOnCLick(MouseEvent event) {
        
        ArrayList<AccountantJournal> filteredArr = localAccountant.viewJournalRecords(journalArr, filterDateDatePicker.getValue());

        journalTable.getItems().clear();
        journalTable.getItems().addAll(filteredArr);
    }

    @FXML
    private void dashboardSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountantDashboardScene.fxml"));
        Parent dashroot = loader.load();

        Scene AccountantDashboardScene = new Scene(dashroot);

        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(AccountantDashboardScene);
        stg.show();
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
