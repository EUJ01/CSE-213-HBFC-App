/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.BorrowerLoanApplication;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;



/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class LoanOfficerT3aViewApplicationDetailsController implements Initializable {

    @FXML
    private TextArea loanApplicationDetailsTextArea;
    
    public BorrowerLoanApplication localApp = new BorrowerLoanApplication();

    /**
     * Initializes the controller class.
     */
    
    public void loanDetailPass(BorrowerLoanApplication paramApplication){
        localApp = paramApplication;
        loanApplicationDetailsTextArea.setText(localApp.toString());
        
    }
    
    
    @Override  
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        loanApplicationDetailsTextArea.setText(localApp.toString());
    }
    
    

    
    
}
