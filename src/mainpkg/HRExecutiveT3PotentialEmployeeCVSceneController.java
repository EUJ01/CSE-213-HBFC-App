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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aqib
 */
public class HRExecutiveT3PotentialEmployeeCVSceneController implements Initializable {

    @FXML
    private TableView<?> Recruitmenttableview;
    @FXML
    private TableColumn<?, ?> Recruitmentcolumn1;
    @FXML
    private TableColumn<?, ?> Recruitmentcolumn2;
    @FXML
    private TableColumn<?, ?> Recruitmentcolumn3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void DashboardSceneOnClick(MouseEvent event) throws IOException {
                                        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveDashboardScene.fxml"));
        Parent T1root = loader.load();
        
        Scene S1 = new Scene(T1root);
        
        Stage stg2borrower = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void LogoutOnClick(MouseEvent event) throws IOException {
              FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent T1root = loader.load();
        
        Scene S1 = new Scene(T1root);
        
        Stage stg2borrower = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }
    
}
