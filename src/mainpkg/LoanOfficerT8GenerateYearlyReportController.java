/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelClass.AccountantIncomeStatement;
import ModelClass.LoanOfficerLoanOffer;
import User.LoanOfficer;
import User.User;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fahim Shahriar
 */
public class LoanOfficerT8GenerateYearlyReportController implements Initializable {

    @FXML
    private BarChart<String, Float> yearReportBarChart;
    
    ArrayList<LoanOfficerLoanOffer>localLoanOfferArr = new ArrayList<>();
    
    private static LoanOfficer localLoanOfficer = new LoanOfficer();
    @FXML
    private ComboBox<LocalDate> dateCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoanOfficerLoanOffer temp = new LoanOfficerLoanOffer("1A2B3C", 1223, "2 months", "Loan Details", 2, 120, LocalDate.of(2012, 2, 28));
        LoanOfficerLoanOffer temp2 = new LoanOfficerLoanOffer("1A2B3C", 15000, "2 months", "Loan Details", 2, 120, LocalDate.of(2013, 3, 31));
        
        localLoanOfferArr.add(temp);
        localLoanOfferArr.add(temp2);
        
        for(LoanOfficerLoanOffer i : localLoanOfferArr){
            dateCB.getItems().add(i.getSentDate());
            
        }
        // TODO
    } 
    
    public void loggedLoanOfficer(User paramLoanOfficer) {
        localLoanOfficer = (LoanOfficer) paramLoanOfficer;
        
    }
    
    @FXML
    private void generateBarChartOnClick(MouseEvent event) {
        XYChart.Series<String, Float> chartData = new XYChart.Series<>();
        chartData = localLoanOfficer.generateLoanReport(dateCB.getValue(),localLoanOfferArr);
//        yearReportBarChart.getData().clear();
        yearReportBarChart.getData().add(chartData);
       
        
    }

    @FXML
    private void goBackToDashBoardOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("LoanOfficerDahsboadScene.fxml"));
        Parent root = loader.load();
        
        Scene loanOfficerDashBoard = new Scene(root);
//        LoanOfficerT1TotalApplicationForSelectionController controller =  loader.getController();
        
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
