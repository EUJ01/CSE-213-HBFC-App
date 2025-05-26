/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import ModelClass.HRJobPost;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author aqib
 */
public class HRExecutiveT6CreateJobPostingSceneController implements Initializable {

    @FXML
    private TextField CreatePostVacancyNum;
    @FXML
    private ComboBox<String> CreatePostdesignition;
    @FXML
    private TextArea CreatePostDescription;
    @FXML
    private TextArea CreatePostRequirement;
    @FXML
    private TextArea GeneratePost;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CreatePostdesignition.getItems().addAll("Accountant", "Collection Agent", "Customer Service Agent",
                "Head of Branch", "HR Executive", "Legal Advisor", "Loan Officer", "Borrower");
    }

    @FXML
    private void DashboardSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HRExecutiveDashboardScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void LogoutOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AALoginScene.fxml"));
        Parent T1root = loader.load();

        Scene S1 = new Scene(T1root);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(S1);
        stg2borrower.show();
    }

    @FXML
    private void CreatePostGenerateButton(MouseEvent event) {


        HRJobPost post = new HRJobPost(CreatePostVacancyNum.getText(), CreatePostdesignition.getValue(),
                CreatePostDescription.getText(), CreatePostRequirement.getText());
        CreatePostVacancyNum.setText(null);
        CreatePostdesignition.setValue(null);
        CreatePostDescription.setText(null);
        CreatePostRequirement.setText(null);

        GeneratePost.setText(post.toString());
    }

    @FXML
    private void CreatePostButton(MouseEvent event) {
//I CANOT REMAE THE FILE FROM A USER
        String fileName = CreatePostdesignition.getValue();

        String filePath = "VacancyPost.txt";

//        String filePath = String.format(filePathTemplate, fileName);

        File file = new File(filePath);
//        File file = new File(fileName+".txt");

        try {
            String temp = GeneratePost.getText();
            FileWriter writer = new FileWriter(file);
            writer.write(temp);
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        GeneratePost.setText(null);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("File has been saved ");
        alert.setContentText("File saved as" + file);
        ;
        alert.showAndWait();
    }

}
