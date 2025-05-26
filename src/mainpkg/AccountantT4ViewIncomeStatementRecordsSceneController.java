/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.AccountantISExpense;
import ModelClass.AccountantISRevenue;
import ModelClass.AccountantIncomeStatement;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
public class AccountantT4ViewIncomeStatementRecordsSceneController implements Initializable {
    
    @FXML
    private Label incomeStatementYearEndLabel;
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
    private Label totalRevenueLabel;
    @FXML
    private Label totalExpenseLabel;
    @FXML
    private Label netIncomeLabel;
    @FXML
    private ComboBox<LocalDate> dateCB;
    
    private static ArrayList<AccountantIncomeStatement> localISArr = new ArrayList<>();
    private static Accountant localAccountant = new Accountant();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        RevenueEntryColumn.setCellValueFactory(new PropertyValueFactory<>("revenueEntry"));
        RevenueAmountColumn.setCellValueFactory(new PropertyValueFactory<>("revenueAmount"));
        ExpenseEntryColumn.setCellValueFactory(new PropertyValueFactory<>("expenseEntry"));
        ExpenseAmountColumn.setCellValueFactory(new PropertyValueFactory<>("expenseAmount"));
    }
    
    public void loggedAccountant(User paramAccountant) {
        localAccountant = (Accountant) paramAccountant;
        
    }
    
    @FXML
    private void viewIncomeStatementOnClick(MouseEvent event) {
        
        LocalDate selectedDate = dateCB.getValue();
        incomeStatementYearEndLabel.setText("For the Year Ending: " + selectedDate);
        
        AccountantIncomeStatement temp = new AccountantIncomeStatement();
        for (AccountantIncomeStatement i : localISArr) {
            if (i.getIncomeDate().equals(selectedDate)) {
                temp = i;
            }
        }
        
        RevenueTable.getItems().clear();
        RevenueTable.getItems().addAll(temp.getRevenueArr());
        
        ExpenseTable.getItems().clear();
        ExpenseTable.getItems().addAll(temp.getExpenseArr());
        
        totalRevenueLabel.setText("Total Revenue: " + temp.getTotalRevenue());
        totalExpenseLabel.setText("Total Expense: " + temp.getTotalExpense());
        netIncomeLabel.setText("net Income: " + temp.getNetIncome());
    }
    
    @FXML
    private void loadIncomeStatementFromBinFile(MouseEvent event) throws IOException {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            f = new File("IncomeStatement.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            AccountantIncomeStatement temp;
            localISArr.removeAll(localISArr);
            
            try {
                while (true) {
                    temp = (AccountantIncomeStatement) ois.readObject();
                    localISArr.add(temp);
                }
                
            } catch (Exception e) {
                
            }
        } catch (IOException ex) {
            System.out.println("No File Found!");
        } finally {
            if (ois != null) {
                ois.close();
                for (AccountantIncomeStatement i : localISArr) {
                    dateCB.getItems().add(i.getIncomeDate());
                }
            }
        }
        
    }
    
    @FXML
    private void dashboardSceneOnCLick(MouseEvent event) throws IOException {
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
