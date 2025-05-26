/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.AccountantDepartmentBudget;
import User.Accountant;
import User.User;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class AccountantT6SendDeptBudgetToHOBSceneController implements Initializable {

    @FXML
    private TableView<AccountantDepartmentBudget> budgetTable;
    @FXML
    private TableColumn<AccountantDepartmentBudget, String> reportNameColumn;
    @FXML
    private TableColumn<AccountantDepartmentBudget, String> reportYearColumn;
    @FXML
    private TableColumn<AccountantDepartmentBudget, String> reportDepartmentColumn;
    @FXML
    private TableColumn<AccountantDepartmentBudget, Float> reportBudgetColumn;
    @FXML
    private TextArea reportDetailstextArea;

    private static Accountant localAccountant = new Accountant();
    private static ArrayList<AccountantDepartmentBudget> localBudgetArr = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        reportNameColumn.setCellValueFactory(new PropertyValueFactory<>("reportName"));
        reportYearColumn.setCellValueFactory(new PropertyValueFactory<>("budgetYear"));
        reportDepartmentColumn.setCellValueFactory(new PropertyValueFactory<>("reportDept"));
        reportBudgetColumn.setCellValueFactory(new PropertyValueFactory<>("budget"));

        budgetTable.getItems().clear();
        budgetTable.getItems().addAll(localBudgetArr);

    }

    public void loggedAccountant(User paramAccountant) {
        localAccountant = (Accountant) paramAccountant;
        
    }

    public void t5ToT6budgetReportDataPass(AccountantDepartmentBudget pBudget) {
        localBudgetArr.add(pBudget);
    }

    @FXML
    private void showBudgetDetailsOnClick(MouseEvent event) {
        AccountantDepartmentBudget selected = budgetTable.getSelectionModel().getSelectedItem();
        reportDetailstextArea.setText(selected.toString());
    }

    @FXML
    private void sendReportToHOBOnClick(MouseEvent event) throws IOException {
        AccountantDepartmentBudget sent = budgetTable.getSelectionModel().getSelectedItem();
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchT3ApproveDeclineDepartmentalBudgets.fxml"));
        Parent root = loader.load();
        
        Scene HeadOfBranchT3ApproveDeclineDepartmentalBudgets = new Scene(root);
        
        HeadOfBranchT3ApproveDeclineDepartmentalBudgetsController controller = loader.getController();
        controller.budgetDataPass(sent);
    }

    @FXML
    private void dashboardSceneOnClick(MouseEvent event) throws IOException {
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
