/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fahim Shahriar
 */
public class CustomerServiceAgentT8CreateUserExperienceSurveyController implements Initializable {

    @FXML
    private TextField question1TextField;
    @FXML
    private RadioButton question1RadioButton5;
    @FXML
    private RadioButton question1RadioButton4;
    @FXML
    private RadioButton question1RadioButton3;
    @FXML
    private RadioButton question1RadioButton2;
    @FXML
    private RadioButton question1RadioButton1;
    @FXML
    private TextField question2TextField;
    @FXML
    private RadioButton question2RadioButton5;
    @FXML
    private RadioButton question2RadioButton4;
    @FXML
    private RadioButton question2RadioButton3;
    @FXML
    private RadioButton question2RadioButton2;
    @FXML
    private RadioButton question2RadioButton1;
    @FXML
    private TextField question3TextField;
    @FXML
    private RadioButton question3RadioButton5;
    @FXML
    private RadioButton question3RadioButton4;
    @FXML
    private RadioButton question3RadioButton2;
    @FXML
    private RadioButton question3RadioButton1;
    @FXML
    private TextField question4TextField;
    @FXML
    private RadioButton question4RadioButton5;
    @FXML
    private RadioButton question4RadioButton4;
    @FXML
    private RadioButton question4RadioButton3;
    @FXML
    private RadioButton question4RadioButton2;
    @FXML
    private RadioButton question4RadioButton1;
    @FXML
    private TextField question5TextField;
    @FXML
    private RadioButton question5RadioButton5;
    @FXML
    private RadioButton question5RadioButton4;
    @FXML
    private RadioButton question5RadioButton3;
    @FXML
    private RadioButton question5RadioButton2;
    @FXML
    private RadioButton question5RadioButton1;
    @FXML
    private TextField question6TextField;
    @FXML
    private RadioButton question6RadioButton5;
    @FXML
    private RadioButton question6RadioButton4;
    @FXML
    private RadioButton question6RadioButton3;
    @FXML
    private RadioButton question6RadioButton2;
    @FXML
    private RadioButton question6RadioButton1;
    @FXML
    private TextField question7TextField;
    @FXML
    private RadioButton question7RadioButton5;
    @FXML
    private RadioButton question7RadioButton4;
    @FXML
    private RadioButton question7RadioButton3;
    @FXML
    private RadioButton question7RadioButton2;
    @FXML
    private RadioButton question7RadioButton1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goBackToBashboardButtonOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        loader.setLocation(getClass().getResource("CustomerServiceAgentDashboardScene.fxml"));
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

    @FXML
    private void createSurveyOnClick(MouseEvent event) {
    }
    
}
