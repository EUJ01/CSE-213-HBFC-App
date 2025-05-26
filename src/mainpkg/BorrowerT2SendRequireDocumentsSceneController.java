/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import ModelClass.BorrowerDocument;
import ModelClass.Notification;
import User.Borrower;
import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class BorrowerT2SendRequireDocumentsSceneController implements Initializable {

    @FXML
    private TableView<Notification> sendRequireDocumentsTableView;
    @FXML
    private TableColumn<Notification, String> employeeTypeColumn;
    @FXML
    private TableColumn<Notification, String> documentDescriptionColumn;

    private static ArrayList<Notification> additionalNotificationBorrowerArr = new ArrayList<>();
    private static Borrower localBorr = new Borrower();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        employeeTypeColumn.setCellValueFactory(new PropertyValueFactory<>("userType"));
        documentDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Text"));

        sendRequireDocumentsTableView.getItems().clear();
        for(Notification i: additionalNotificationBorrowerArr){
            if (localBorr.getId().equals(i.getRecieverID())) {
                 sendRequireDocumentsTableView.getItems().add(i);
            }
        }
    }

    public void passDataLoanOfficerT2toBorowerT2(Notification pAdditionalDocNotification) {
        additionalNotificationBorrowerArr.add(pAdditionalDocNotification);
    }

    public void loggedBorrowerDataPass(Borrower paramBorrower) {
        localBorr = paramBorrower;
    }

    @FXML
    private void sendDocumentOnClick(MouseEvent event) throws IOException {
        Notification selectedNotif = sendRequireDocumentsTableView.getSelectionModel().getSelectedItem();

        FileChooser fc = new FileChooser();
        File tempFile = fc.showOpenDialog(null);

        Image img = new Image(tempFile.toURI().toString());
        BorrowerDocument tempDoc = new BorrowerDocument(localBorr.getId(), selectedNotif.getSenderID(), img);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LoanOfficerT3ApproveOrDeclineApplication.fxml"));
        Parent logroot = loader.load();
        Scene LoanOfficerT3ApproveOrDeclineApplication = new Scene(logroot);

        LoanOfficerT3ApproveOrDeclineApplicationController controller = loader.getController();
        controller.borrowerDocumentDataPass(tempDoc);

    }

    @FXML
    private void dashboardSceneOnClick(MouseEvent event) throws IOException {
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
