/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelClass.BorrowerLoanApplication;
import User.LoanOfficer;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fahim Shahriar
 */
public class LoanOfficerT1TotalApplicationForSelectionController implements Initializable {

    @FXML
    private TableView<BorrowerLoanApplication> borrowerTableView;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> borrowerNidTableColumn;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> borrowerNameTableColumn;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> loanTypeTableColumn;

    private static ArrayList<BorrowerLoanApplication> loanArr = new ArrayList<>();

    private static LoanOfficer localLoanOfficer = new LoanOfficer();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        borrowerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        borrowerNidTableColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        loanTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("loanType"));

        borrowerTableView.getItems().addAll(loanArr);
        // TODO
    }

    public void loggedLoanOfficer(User paramLoanOfficer) {
        localLoanOfficer = (LoanOfficer) paramLoanOfficer;
    }

    public void loanApplicationPassData(BorrowerLoanApplication pApplication) {
        loanArr.add(pApplication);
    }


    @FXML
    private void goBackToDashBoardOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("LoanOfficerDahsboadScene.fxml"));
        Parent root = loader.load();

        Scene loanOfficerDashBoard = new Scene(root);

        Stage loanOfficerGoBackToDashBoardStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loanOfficerGoBackToDashBoardStage.setScene(loanOfficerDashBoard);
        loanOfficerGoBackToDashBoardStage.show();
    }

    @FXML
    private void logOutOnClick(MouseEvent event) throws IOException {
        FXMLLoader lgLoader = new FXMLLoader();
        lgLoader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent logroot = lgLoader.load();

        Scene lnOfcrLg = new Scene(logroot);

        Stage lgStg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        lgStg.setScene(lnOfcrLg);
        lgStg.show();
    }

    @FXML
    private void selectForProcessOnClick(MouseEvent event) throws IOException {
        BorrowerLoanApplication selectedBorrowerApplication = borrowerTableView.getSelectionModel().getSelectedItem();
        selectedBorrowerApplication.setLoanOfficerId(localLoanOfficer.getId());

        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("LoanOfficerT2PerformInitialCheckandForwardtoCollectionAgent.fxml"));

        Parent root = loader1.load();
        Scene scene = new Scene(root);

        LoanOfficerT2PerformInitialCheckandForwardtoCollectionAgentController controller = loader1.getController();

        controller.t1toT2BorrowerLoanApplicationPassData(selectedBorrowerApplication);
    }
}
