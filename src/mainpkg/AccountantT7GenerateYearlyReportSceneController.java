/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.AccountantIncomeStatement;
import ModelClass.AccountantReport;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class AccountantT7GenerateYearlyReportSceneController implements Initializable {

    @FXML
    private BarChart<String, Float> reportBarChart;
    @FXML
    private ComboBox<LocalDate> reportYearCB;
    @FXML
    private TextField financialReportNameTextField;

    private static Accountant localAccountant = new Accountant();
    private static ArrayList<AccountantIncomeStatement> localISArr = new ArrayList<>();

    private static ArrayList<AccountantIncomeStatement> localReportArr = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

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
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.out.println("OIS didn't close properly");
                }

                for (AccountantIncomeStatement i : localISArr) {
                    reportYearCB.getItems().add(i.getIncomeDate());
                }
            }
        }

    }

    public void loggedAccountant(User paramAccountant) {
        localAccountant = (Accountant) paramAccountant;
       
    }

    @FXML
    private void generateFinancialReportOnClick(MouseEvent event) {

        XYChart.Series<String, Float> chartData = new XYChart.Series<>();
        chartData = localAccountant.generateFinancialReport(reportYearCB.getValue(), localISArr);
        reportBarChart.getData().add(chartData);

        for (AccountantIncomeStatement i : localISArr) {
            if (i.getIncomeDate().equals(reportYearCB.getValue())) {
                localReportArr.add(i);
            }
        }

    }

    @FXML
    private void saveFinancialReportOnClick(MouseEvent event) throws IOException {
        AccountantReport temp = new AccountantReport();

        temp = localAccountant.saveFinancialReport(
                localAccountant.getId(),
                financialReportNameTextField.getText(),
                localReportArr);

        localReportArr.removeAll(localReportArr);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountantT8SendReporttoHOBScene.fxml"));
        Parent root = loader.load();

        Scene scn = new Scene(root);

        AccountantT8SendReporttoHOBSceneController controller = loader.getController();
        controller.t7ToT8DataPass(temp);
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
