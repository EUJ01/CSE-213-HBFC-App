/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.AccountantReport;
import User.Accountant;
import User.User;
import java.io.File;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class AccountantT8SendReporttoHOBSceneController implements Initializable {

    @FXML
    private TableView<AccountantReport> financialReportToSendTable;
    @FXML
    private TableColumn<AccountantReport, String> finReportNameColumn;

    private static Accountant localAccountant = new Accountant();
    private static ArrayList<AccountantReport> localReportArr = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        finReportNameColumn.setCellValueFactory(new PropertyValueFactory<>("reportName"));
        financialReportToSendTable.getItems().addAll(localReportArr);
    }

    public void loggedAccountant(User paramAccountant) {
        localAccountant = (Accountant) paramAccountant;
        
    }

    public void t7ToT8DataPass(AccountantReport paramReport) {
        localReportArr.add(paramReport);

        
        financialReportToSendTable.getItems().add(paramReport);

    }

    @FXML
    private void sendFinancialReportTOHOBOnClick(MouseEvent event) throws IOException {

        AccountantReport selectedReport = financialReportToSendTable.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HeadOfBranchT3ApproveDeclineDepartmentalBudgets.fxml"));
        Parent root = loader.load();
        Scene scn = new Scene(root);

        HeadOfBranchT8FinancialReportsController controller = loader.getController();
        controller.finReportDataPass(selectedReport);
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
