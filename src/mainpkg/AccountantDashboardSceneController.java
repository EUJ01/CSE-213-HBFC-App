/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import User.Accountant;
import User.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class AccountantDashboardSceneController implements Initializable {

    @FXML
    private Text AccountantNameLabel;
    @FXML
    private TextArea AccountantInfoTextArea;
    @FXML
    private TextArea AccountantNotifTextArea;

    private static Accountant loggedAccountant = new Accountant();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        AccountantInfoTextArea.setText(loggedAccountant.toString());
        AccountantNameLabel.setText("Welcome " + loggedAccountant.getName());
    }

        public void acnData(User paramAccountant) throws IOException {
        
        loggedAccountant = (Accountant) paramAccountant;
        
        AccountantInfoTextArea.setText(paramAccountant.toString());
        AccountantNameLabel.setText("Welcome " + paramAccountant.getName());

        FXMLLoader loader1 = new FXMLLoader();
        FXMLLoader loader2 = new FXMLLoader();
        FXMLLoader loader3 = new FXMLLoader();
        FXMLLoader loader4 = new FXMLLoader();
        FXMLLoader loader5 = new FXMLLoader();
        FXMLLoader loader6 = new FXMLLoader();
        FXMLLoader loader7 = new FXMLLoader();
        FXMLLoader loader8 = new FXMLLoader();
        
        loader1.setLocation(getClass().getResource("AccountantT1PrepareJournalScene.fxml"));
        loader2.setLocation(getClass().getResource("AccountantT2PrepareIncomeStatementScene.fxml"));
        loader3.setLocation(getClass().getResource("AccountantT3ViewJournalRecordsScene.fxml"));
        loader4.setLocation(getClass().getResource("AccountantT4ViewIncomeStatementRecordsScene.fxml"));
        loader5.setLocation(getClass().getResource("AccountantT5PrepareDepartmentalBudgetScene.fxml"));
        loader6.setLocation(getClass().getResource("AccountantT6SendDeptBudgetToHOBScene.fxml"));
        loader7.setLocation(getClass().getResource("AccountantT7GenerateYearlyReportScene.fxml"));
        loader8.setLocation(getClass().getResource("AccountantT8SendReporttoHOBScene.fxml"));

        Parent root1 = loader1.load();
        Parent root2 = loader2.load();
        Parent root3 = loader3.load();
        Parent root4 = loader4.load();
        Parent root5 = loader5.load();
        Parent root6 = loader6.load();
        Parent root7 = loader7.load();
        Parent root8 = loader8.load();

        Scene scn1 = new Scene(root1);
        Scene scn2 = new Scene(root2);
        Scene scn3 = new Scene(root3);
        Scene scn4 = new Scene(root4);
        Scene scn5 = new Scene(root5);
        Scene scn6 = new Scene(root6);
        Scene scn7 = new Scene(root7);
        Scene scn8 = new Scene(root8);

        AccountantT1PrepareJournalSceneController controller1 = loader1.getController();
        AccountantT2PrepareIncomeStatementSceneController controller2 = loader2.getController();
        AccountantT3ViewJournalRecordsSceneController controller3 = loader3.getController();
        AccountantT4ViewIncomeStatementRecordsSceneController controller4 = loader4.getController();
        AccountantT5PrepareDepartmentalBudgetSceneController controller5 = loader5.getController();
        AccountantT6SendDeptBudgetToHOBSceneController controller6 = loader6.getController();
        AccountantT7GenerateYearlyReportSceneController controller7 = loader7.getController();
        AccountantT8SendReporttoHOBSceneController controller8 = loader8.getController();

        controller1.loggedAccountant(paramAccountant);
        controller2.loggedAccountant(paramAccountant);
        controller3.loggedAccountant(paramAccountant);
        controller4.loggedAccountant(paramAccountant);
        controller5.loggedAccountant(paramAccountant);
        controller6.loggedAccountant(paramAccountant);
        controller7.loggedAccountant(paramAccountant);
        controller8.loggedAccountant(paramAccountant);
    }

    @FXML
    private void PrepareJournalSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader T1loader = new FXMLLoader();
        T1loader.setLocation(getClass().getResource("AccountantT1PrepareJournalScene.fxml"));
        Parent T1root = T1loader.load();

        Scene AccountantT1PrepareJournalScene = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(AccountantT1PrepareJournalScene);
        stg2borrower.show();
    }

    @FXML
    private void PrepareIncomeStatementSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader T2loader = new FXMLLoader();
        T2loader.setLocation(getClass().getResource("AccountantT2PrepareIncomeStatementScene.fxml"));
        Parent T2root = T2loader.load();

        Scene AccountantT2PrepareIncomeStatementScene = new Scene(T2root);

        Stage stg2borrowerDash = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrowerDash.setScene(AccountantT2PrepareIncomeStatementScene);
        stg2borrowerDash.show();

    }

    @FXML
    private void viewJournalRecordSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountantT3ViewJournalRecordsScene.fxml"));
        Parent root = loader.load();

        Scene AccountantT3PrepareMonthlyBalanceSheetScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(AccountantT3PrepareMonthlyBalanceSheetScene);
        stg2.show();
    }

    @FXML
    private void viewIncomeStatementRecordSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountantT4ViewIncomeStatementRecordsScene.fxml"));
        Parent root = loader.load();

        Scene AccountantT6GenerateTaxReportScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(AccountantT6GenerateTaxReportScene);
        stg2.show();
    }

    @FXML
    private void PrepareUpdateDepartmentalBudgetSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountantT5PrepareDepartmentalBudgetScene.fxml"));
        Parent root = loader.load();

        Scene AccountantT4PrepareDepartmentalBudgetScene1 = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(AccountantT4PrepareDepartmentalBudgetScene1);
        stg2.show();
    }

    @FXML
    private void SendBudgetPlanstoHeadofBranchSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountantT6SendDeptBudgetToHOBScene.fxml"));
        Parent root = loader.load();

        Scene AccountantT5SendDeptBudgetToHOBScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(AccountantT5SendDeptBudgetToHOBScene);
        stg2.show();
    }

    @FXML
    private void GenerateFinancialReportSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountantT7GenerateYearlyReportScene.fxml"));
        Parent root = loader.load();

        Scene AccountantT7GenerateYearlyReportScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(AccountantT7GenerateYearlyReportScene);
        stg2.show();
    }

    @FXML
    private void SendFinancialReporttoHeadofBranchSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AccountantT8SendReporttoHOBScene.fxml"));
        Parent root = loader.load();

        Scene AccountantT8SendReporttoHOBScene = new Scene(root);

        Stage stg2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2.setScene(AccountantT8SendReporttoHOBScene);
        stg2.show();
    }

    @FXML
    private void ComplaintBoxSceneOnClick(MouseEvent event) {
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
