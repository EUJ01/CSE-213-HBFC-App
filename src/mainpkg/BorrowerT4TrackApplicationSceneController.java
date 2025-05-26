/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.BorrowerLoanApplication;
import User.Borrower;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class BorrowerT4TrackApplicationSceneController implements Initializable {

    @FXML
    private TableView<BorrowerLoanApplication> trackApplicationTable;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> applicationTypeColumn;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> applicationStatusColumn;

    public static ArrayList<BorrowerLoanApplication> localArr = new ArrayList<>();
    public static ArrayList<BorrowerLoanApplication> localUpdatedArr = new ArrayList<>();
    private static Borrower localBorr = new Borrower();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        applicationTypeColumn.setCellValueFactory(new PropertyValueFactory<>("loanType"));
        applicationStatusColumn.setCellValueFactory(new PropertyValueFactory<>("loanStatus"));
        
        trackApplicationTable.getItems().clear();
        
        for(BorrowerLoanApplication i: localArr){
            if (i.getNid().equals(localBorr.getId())) {
                trackApplicationTable.getItems().add(i);
            }
        }
    }

    public void loggedBorrowerDataPass(Borrower paramBorrower) {
        localBorr = paramBorrower;

    }

    public void borrowerPassApplication(ArrayList<BorrowerLoanApplication> paramArr) {
        localArr = paramArr;
    }

    public void loanOfficerApprovedApplication(ArrayList<BorrowerLoanApplication> paramUpdatedArr) {
        localUpdatedArr = paramUpdatedArr;
        for (BorrowerLoanApplication i : localArr) {
            for (BorrowerLoanApplication j : localUpdatedArr) {
                if (i.getNid() == j.getNid() && j.getLoanStatus() != "Pending") {
                    i.setLoanStatus(j.getLoanStatus());
                }
            }
        }

    }

    @FXML
    private void dashboardSceneOnCLick(MouseEvent event) throws IOException {
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
