/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelClass.BorrowerDocument;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fahim Shahriar
 */
public class LoanOfficerT3ApproveOrDeclineApplicationController implements Initializable {

    @FXML
    private TableView<BorrowerLoanApplication> borrowerTableView;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> borrowerNidTableColumn;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> borrowerNameTableColumn;
    @FXML
    private ImageView borrowerImgViewer;

    private static LoanOfficer localLoanOfficer = new LoanOfficer();

    private static ArrayList<BorrowerLoanApplication> localArr = new ArrayList<>();
    private static ArrayList<BorrowerDocument> localDocArr = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        borrowerNidTableColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        borrowerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        borrowerTableView.getItems().clear();
        borrowerTableView.getItems().addAll(localArr);

    }

    public void loggedLoanOfficer(User paramLoanOfficer) {
        localLoanOfficer = (LoanOfficer) paramLoanOfficer;
        
    }

    public void borrowerDocumentDataPass(BorrowerDocument paramDoc) {
        localDocArr.add(paramDoc);
    }

    public void borrowerLoanApplicationDataPass(BorrowerLoanApplication paraBorrowerLoanApplication) {
        localArr.add(paraBorrowerLoanApplication);
    }

    @FXML
    private void showBorrowerDocOnTableClick(MouseEvent event) {
        BorrowerLoanApplication selectedLoanApplication = borrowerTableView.getSelectionModel().getSelectedItem();

        for (BorrowerDocument i : localDocArr) {
            if (i.getSenderID().equals(selectedLoanApplication.getNid())) {
                borrowerImgViewer.setImage(i.getImageDoc());
                break;
            }
        }
    }

    @FXML
    private void approveOnClick(MouseEvent event) throws IOException {
        BorrowerLoanApplication approvedLoan = borrowerTableView.getSelectionModel().getSelectedItem();
        approvedLoan.setLoanStatus("Approved");
        borrowerTableView.getItems().clear();
        borrowerTableView.getItems().addAll(localArr);

        FXMLLoader approvedLoaderBorr = new FXMLLoader();
        approvedLoaderBorr.setLocation(getClass().getResource("BorrowerT4TrackApplicationScene.fxml"));
        Parent root1 = approvedLoaderBorr.load();

        Scene BorrowerT4TrackApplicationScene = new Scene(root1);

        BorrowerT4TrackApplicationSceneController BT4Controller = approvedLoaderBorr.getController();
        BT4Controller.loanOfficerApprovedApplication(localArr);

        FXMLLoader approvedLoaderT4 = new FXMLLoader();
        approvedLoaderT4.setLocation(getClass().getResource("LoanOfficerT4ExtendLoanOffer.fxml"));
        Parent root2 = approvedLoaderT4.load();

        Scene LoanOfficerT4ExtendLoanOfferScene = new Scene(root2);

        LoanOfficerT4ExtendLoanOfferController LOT4Controller = approvedLoaderT4.getController();
        LOT4Controller.loanOfficerT3toT4approvePassDate(approvedLoan);
    }

    @FXML
    private void declineOnClick(MouseEvent event) throws IOException {
        BorrowerLoanApplication declinedLoan = borrowerTableView.getSelectionModel().getSelectedItem();
        declinedLoan.setLoanStatus("Declined");
        borrowerTableView.getItems().clear();
        borrowerTableView.getItems().addAll(localArr);

        FXMLLoader declinedLoader = new FXMLLoader();
        declinedLoader.setLocation(getClass().getResource("BorrowerT4TrackApplicationScene.fxml"));
        Parent root = declinedLoader.load();
        Scene BorrowerT4TrackApplicationScene = new Scene(root);

        BorrowerT4TrackApplicationSceneController BT4Controller = declinedLoader.getController();
        BT4Controller.loanOfficerApprovedApplication(localArr);
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

}
