/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.BorrowerInstallment;
import User.Borrower;
import java.io.IOException;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class BorrowerT3PayMonthlyInstallmentSceneController implements Initializable {

    @FXML
    private ComboBox<Integer> installmentNoComboBox;
    @FXML
    private TableView<BorrowerInstallment> monthlyInstallmentTableView;
    @FXML
    private TableColumn<BorrowerInstallment, Integer> installmentNoColumn;
    @FXML
    private TableColumn<BorrowerInstallment, LocalDate> dueDateColumn;
    @FXML
    private TableColumn<BorrowerInstallment, Float> totalTkColumn;

    private static Borrower localBorr = new Borrower();
    private static ArrayList<BorrowerInstallment> localInstallmentArr = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        installmentNoColumn.setCellValueFactory(new PropertyValueFactory<>("installmentNumber"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("installmentDate"));
        totalTkColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        if (localBorr.getPayment() != null) {
            localInstallmentArr = localBorr.getPayment().getInstallments();
        }

        installmentNoComboBox.getItems().clear();
        for (BorrowerInstallment i : localInstallmentArr) {
            installmentNoComboBox.getItems().add(i.getInstallmentNumber());
        }
        // TODO
    }

    public void loggedBorrowerDataPass(Borrower paramBorrower) {
        localBorr = paramBorrower;
    }

    @FXML
    private void payOnlineOnClick(MouseEvent event) {

    }

    @FXML
    private void dashboardOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BorrowerDashboardScene.fxml"));
        Parent dashroot = loader.load();

        Scene BorrowerDashboardScene = new Scene(dashroot);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(BorrowerDashboardScene);
        stg2borrower.show();

    }

    @FXML
    private void logoutOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent logroot = loader.load();

        Scene AALoginScene = new Scene(logroot);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AALoginScene);
        stg2borrower.show();
    }

}
