/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelClass.BorrowerInstallment;
import ModelClass.BorrowerLoanApplication;
import ModelClass.BorrowerPayment;
import ModelClass.LoanOfficerLoanOffer;
import User.Borrower;
import User.LoanOfficer;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fahim Shahriar
 */
public class LoanOfficerT4ExtendLoanOfferController implements Initializable {

    @FXML
    private TableView<BorrowerLoanApplication> borrowerTableView;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> borrowerNidTableColumn;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> borrowerNameTableColumn;
    @FXML
    private TableColumn<BorrowerLoanApplication, String> borrowerContactDetailsTableColumn;
    @FXML
    private TableView<LoanOfficerLoanOffer> loanTableView1;
    @FXML
    private TableColumn<LoanOfficerLoanOffer, String> loanIDTableColumn1;
    @FXML
    private TableColumn<LoanOfficerLoanOffer, String> loanAmountTableColumn1;
    @FXML
    private TableColumn<LoanOfficerLoanOffer, String> loanDurationTableColumn1;
    @FXML
    private TableColumn<LoanOfficerLoanOffer, String> loanDetailsTableColumn11;
    @FXML
    private TextField loanIDTextField;
    @FXML
    private TextField loanAmountTextField;
    @FXML
    private TextField loanDurationTextField;
    @FXML
    private TextArea loanDetailsTextArea;
    @FXML
    private TextField interestPercentageTextField;
    @FXML
    private TextField monthlyInstallmentTextField;

    private static LoanOfficer localLoanOfficer = new LoanOfficer();
    private static BorrowerLoanApplication localSelectedApplication = new BorrowerLoanApplication();

    private static ArrayList<LoanOfficerLoanOffer> loanOfferArr = new ArrayList<>();
    private static ArrayList<BorrowerLoanApplication> approvedLoanApplicationsArr = new ArrayList<>();
    private static ArrayList<User> borrowerList = new ArrayList<User>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loanIDTableColumn1.setCellValueFactory(new PropertyValueFactory<>("loanID"));
        loanAmountTableColumn1.setCellValueFactory(new PropertyValueFactory<>("loanAmount"));
        loanDurationTableColumn1.setCellValueFactory(new PropertyValueFactory<>("loanDuration"));
        loanDetailsTableColumn11.setCellValueFactory(new PropertyValueFactory<>("loanDetails"));

        borrowerNidTableColumn.setCellValueFactory(new PropertyValueFactory<>("nid"));
        borrowerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        borrowerContactDetailsTableColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        borrowerTableView.getItems().clear();
        borrowerTableView.getItems().addAll(approvedLoanApplicationsArr);

        loanTableView1.getItems().clear();
        loanTableView1.getItems().addAll(loanOfferArr);

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("borrowerList.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            User temp;

            if (borrowerList.isEmpty()) {
                try {
                    while (true) {
                        temp = (User) ois.readObject();
                        borrowerList.add(temp);
                    }
                } catch (Exception e) {
                }
            }

        } catch (IOException ex) {
            System.out.println("No File Found!");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.out.println("final Exception");
                }
            }
        }
    }

    public void loggedLoanOfficer(User paramLoanOfficer) {
        localLoanOfficer = (LoanOfficer) paramLoanOfficer;
        
    }

    public void loanOfficerT3toT4approvePassDate(BorrowerLoanApplication paBorrowerLoanApplication) {
        approvedLoanApplicationsArr.add(paBorrowerLoanApplication);
    }

    @FXML
    private void selectInstanceOnClick(MouseEvent event) {
        BorrowerLoanApplication selectedLoanApplication = borrowerTableView.getSelectionModel().getSelectedItem();
        localSelectedApplication = selectedLoanApplication;
       
    }

    @FXML
    private void sendOfferToBorrowerOnClick(MouseEvent event) throws IOException {

        LoanOfficerLoanOffer selectedLoanOffer = loanTableView1.getSelectionModel().getSelectedItem();

        int size = Integer.parseInt(selectedLoanOffer.getLoanDuration()) * 12;
        float amount = selectedLoanOffer.getMonthlyInstallment();
        int j = 1;

        BorrowerPayment payment = new BorrowerPayment();
        ArrayList<BorrowerInstallment> installmentArr = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            BorrowerInstallment installment = new BorrowerInstallment();
            installment.setInstallmentNumber(i);
            installment.setAmount(amount);
            installment.setInstallmentDate(LocalDate.of(2023, j, 1));
            installment.setInstallmentStatus("Unpaid");
            installmentArr.add(installment);
            j++;
            if (j == 13) {
                j = 1;
            }
        }
        payment.setInstallments(installmentArr);

        for (User i : borrowerList) {
            if (i.getId().equals(localSelectedApplication.getNid())) {
                ((Borrower) i).setRecievedLoan(selectedLoanOffer);
                ((Borrower) i).setPayment(payment);
            }
        }

        //Send updated arraylist to loginscene
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent logroot = Loader.load();

        Scene scn = new Scene(logroot);

        AALoginSceneController controller = Loader.getController();
        controller.updatedBorrArrDataPass(borrowerList);
        //Send updated arraylist to loginscene

    }

    @FXML
    private void generateLoanOfferOnClick(MouseEvent event) {
        LoanOfficerLoanOffer temp2 = new LoanOfficerLoanOffer();

        temp2 = localLoanOfficer.generateLoanOfferInstance(
                loanIDTextField.getText(),
                Float.parseFloat(loanAmountTextField.getText()),
                loanDurationTextField.getText(),
                loanDetailsTextArea.getText(),
                Float.parseFloat(interestPercentageTextField.getText()),
                Float.parseFloat(monthlyInstallmentTextField.getText())
        );

        loanOfferArr.add(temp2);

        loanTableView1.getItems().clear();
        loanTableView1.getItems().addAll(loanOfferArr);
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
