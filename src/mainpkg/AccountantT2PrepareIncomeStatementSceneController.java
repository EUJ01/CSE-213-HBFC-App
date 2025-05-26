/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.AccountantISExpense;
import ModelClass.AccountantISRevenue;
import ModelClass.AccountantIncomeStatement;
import ModelClass.AppendableOOS;
import User.Accountant;
import User.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
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
import javafx.scene.control.Label;
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
public class AccountantT2PrepareIncomeStatementSceneController implements Initializable {

    @FXML
    private TableView<AccountantISRevenue> RevenueTable;
    @FXML
    private TableColumn<AccountantISRevenue, String> RevenueEntryColumn;
    @FXML
    private TableColumn<AccountantISRevenue, Float> RevenueAmountColumn;
    @FXML
    private TableView<AccountantISExpense> ExpenseTable;
    @FXML
    private TableColumn<AccountantISExpense, String> ExpenseEntryColumn;
    @FXML
    private TableColumn<AccountantISExpense, Float> ExpenseAmountColumn;
    @FXML
    private DatePicker incomeStatementDatePicker;
    @FXML
    private TextField incomeStatementEntryTextField;
    @FXML
    private TextField incomeStatementAmountTextField;
    @FXML
    private Label incomeStatementYearEndLabel;
    @FXML
    private ComboBox<String> incomeStatementTypeCB;

    private static Accountant localAccountant = new Accountant();
    private static ArrayList<AccountantISRevenue> revenueArr = new ArrayList<>();
    private static ArrayList<AccountantISExpense> expenseArr = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        incomeStatementTypeCB.getItems().addAll("Revenue", "Expense");

        RevenueEntryColumn.setCellValueFactory(new PropertyValueFactory<>("revenueEntry"));
        RevenueAmountColumn.setCellValueFactory(new PropertyValueFactory<>("revenueAmount"));
        ExpenseEntryColumn.setCellValueFactory(new PropertyValueFactory<>("expenseEntry"));
        ExpenseAmountColumn.setCellValueFactory(new PropertyValueFactory<>("expenseAmount"));

        RevenueTable.getItems().clear();
        RevenueTable.getItems().addAll(revenueArr);

        ExpenseTable.getItems().clear();
        ExpenseTable.getItems().addAll(expenseArr);
    }

    public void loggedAccountant(User paramAccountant) {
        localAccountant = (Accountant) paramAccountant;
       
    }

    @FXML
    private void addEntryButtonOnClick(MouseEvent event) {

        incomeStatementYearEndLabel.setText("For the year ending: " + incomeStatementDatePicker.getValue());

        if (incomeStatementTypeCB.getValue() == "Revenue") {
            AccountantISRevenue temp = new AccountantISRevenue();
            temp = localAccountant.addIncomeRevenueEntry(incomeStatementEntryTextField.getText(),
                    Float.parseFloat(incomeStatementAmountTextField.getText()));
            revenueArr.add(temp);
            RevenueTable.getItems().clear();
            RevenueTable.getItems().addAll(revenueArr);

        } else if (incomeStatementTypeCB.getValue() == "Expense") {
            AccountantISExpense temp = new AccountantISExpense();
            temp = localAccountant.addIncomeExpenseEntry(incomeStatementEntryTextField.getText(),
                    Float.parseFloat(incomeStatementAmountTextField.getText()));
            expenseArr.add(temp);
            ExpenseTable.getItems().clear();
            ExpenseTable.getItems().addAll(expenseArr);
        }

    }

    @FXML
    private void saveIncomeStatementToBinFileOnClick(MouseEvent event) {
        AccountantIncomeStatement temp = new AccountantIncomeStatement();
        temp = localAccountant.addIncomeStatement(
                localAccountant.getId(),
                incomeStatementDatePicker.getValue(), 
                revenueArr,
                expenseArr);
        
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("IncomeStatement.bin");
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
        
        revenueArr.removeAll(revenueArr);
        expenseArr.removeAll(expenseArr);
        RevenueTable.getItems().clear();
        ExpenseTable.getItems().clear();

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
