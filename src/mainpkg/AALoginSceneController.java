/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import User.Accountant;
import User.Admin;
import User.User;
import User.Borrower;
import User.HRExecutive;
import User.HeadOfBranch;
import User.LegalAdvisor;
import User.LoanOfficer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author EUJ
 */
public class AALoginSceneController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private PasswordField pwTextField;
    @FXML
    private ComboBox<String> employeeTypeCB;

    public static ArrayList<User> userArr = new ArrayList<>();
    public static ArrayList<User> borrowerArr = new ArrayList<>();
    private final Admin administrator = new Admin();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        employeeTypeCB.getItems().addAll("Admin", "Accountant", "Collection Agent", "Customer Service Agent",
                "Head of Branch", "HR Executive", "Legal Advisor", "Loan Officer", "Borrower");

//        User acn = new Accountant("Accountant", 15000, null, null, "2120117",
//                "Sumaiya karim Katha", null, "female", "Accountant", "123");
//
//        User hr = new HRExecutive("Accountant", 15000, null, null, "2120009",
//                "Sumaiya karim Katha", null, "female", "HR Executive", "123");
//        User legad = new LegalAdvisor("Accountant", 15000, null, null, "2120009",
//                "Sumaiya karim Katha", null, "female", "Legal Advisor", "123");
//
//        User lo = new LoanOfficer("Loan Officer", 15000, null, null, "2120552",
//                "Md Fahim Shahriar", null, "male", "Loan Officer", "123");
//
//        User HoB = new HeadOfBranch("Loan Officer", 1500000, null, "2010189",
//                "Sumaiya karim Katha", null, "female", "Head of Branch", "123");
//        userArr.add(hr);
//        userArr.add(acn);
//        userArr.add(legad);
//        userArr.add(lo);
//        userArr.add(HoB);

//        //employeeFileRead
        File ef = null;
        FileInputStream efis = null;
        ObjectInputStream eois = null;

        try {
            ef = new File("employeeList.bin");
            efis = new FileInputStream(ef);
            eois = new ObjectInputStream(efis);
            User temp;
            userArr.removeAll(userArr);

            try {
                while (true) {
                    temp = (User) eois.readObject();
                    userArr.add(temp);
                }
            } 
            catch (Exception e) {
            }
        } 
        catch (IOException ex) {
            System.out.println("No File Found!");
        } 
        finally {
            if (eois != null) {
                try {
                    eois.close();
                } 
                catch (IOException ex) {
                }
            }
        }
        //employeeFileRead
        //BorrFileRead
        File bf = null;
        FileInputStream bfis = null;
        ObjectInputStream bois = null;

        try {
            bf = new File("borrowerList.bin");
            bfis = new FileInputStream(bf);
            bois = new ObjectInputStream(bfis);
            User temp;

            if (borrowerArr.isEmpty()) {
                try {
                    while (true) {
                        temp = (User) bois.readObject();
                        borrowerArr.add(temp);
                    }
                } 
                catch (Exception e) {
                }
            }

        } 
        catch (IOException ex) {
            System.out.println("No File Found!");
        } 
        finally {
            if (bois != null) {
                try {
                    bois.close();
                } 
                catch (IOException ex) {
                }
            }
        }
        //BorrFileRead
    }

    public void empData(ArrayList<User> paramEmpArr) {
        userArr = paramEmpArr;
    }

    public void updatedBorrArrDataPass(ArrayList<User> pUpdatedArr) {
        borrowerArr = pUpdatedArr;
    }

    @FXML
    private void loginButtonOnClick(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();

        //admin login
        if (Admin.adminLogin(idTextField.getText(), pwTextField.getText(), employeeTypeCB.getValue(), administrator)) {

            if ("Admin".equals(employeeTypeCB.getValue())) {
                loader.setLocation(getClass().getResource("A1AdminScene.fxml"));
                Parent adminRoot = loader.load();

                Scene adminScn = new Scene(adminRoot);

                Stage adminstg = (Stage) ((Node) event.getSource()).getScene().getWindow();
                adminstg.setScene(adminScn);
                adminstg.show();
            }
        } //borrower login
        else if (Borrower.userLogin(idTextField.getText(), pwTextField.getText(), employeeTypeCB.getValue(), borrowerArr)) {
            if ("Borrower".equals(employeeTypeCB.getValue())) {
                loader.setLocation(getClass().getResource("BorrowerDashboardScene.fxml"));
                Parent brwrRoot = loader.load();

                Scene brwrDashboardScn = new Scene(brwrRoot);

                BorrowerDashboardSceneController dbController = loader.getController();
                for (User i : borrowerArr) {
                    if (idTextField.getText().equals(i.getId())) {
                        dbController.borrData(i);
                    }
                }

                Stage brwrstg = (Stage) ((Node) event.getSource()).getScene().getWindow();
                brwrstg.setScene(brwrDashboardScn);
                brwrstg.show();
            }
        } //employee login
        else if (User.userLogin(idTextField.getText(), pwTextField.getText(), employeeTypeCB.getValue(), userArr)) {
            if ("Accountant".equals(employeeTypeCB.getValue())) {
                loader.setLocation(getClass().getResource("AccountantDashboardScene.fxml"));
                Parent acnRoot = loader.load();

                Scene acnDashboardScn = new Scene(acnRoot);

                AccountantDashboardSceneController dbController = loader.getController();
                for (User i : userArr) {
                    if (idTextField.getText().equals(i.getId())) {
                        dbController.acnData(i);
                    }
                }

                Stage acnstg = (Stage) ((Node) event.getSource()).getScene().getWindow();
                acnstg.setScene(acnDashboardScn);
                acnstg.show();

            } else if (User.userLogin(idTextField.getText(), pwTextField.getText(), employeeTypeCB.getValue(), userArr)) {
                if ("Collection Agent".equals(employeeTypeCB.getValue())) {
                    loader.setLocation(getClass().getResource("CollectionAgentDashboardScene.fxml"));
                    Parent hobRoot = loader.load();

                    Scene hobDashboardScn = new Scene(hobRoot);

//                    AccountantDashboardSceneController dbController = loader.getController();
//                    for (User i : userArr) {
//                        if (idTextField.getText().equals(i.getId())) {
//                            dbController.acnData(i);
//                        }
//                    }
                    Stage acnstg = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    acnstg.setScene(hobDashboardScn);
                    acnstg.show();

                } else if (User.userLogin(idTextField.getText(), pwTextField.getText(), employeeTypeCB.getValue(), userArr)) {
                    if ("Head of Branch".equals(employeeTypeCB.getValue())) {
                        loader.setLocation(getClass().getResource("HeadOfBranchDashboardScene.fxml"));
                        Parent hobRoot = loader.load();

                        Scene hobDashboardScn = new Scene(hobRoot);

//                    AccountantDashboardSceneController dbController = loader.getController();
//                    for (User i : userArr) {
//                        if (idTextField.getText().equals(i.getId())) {
//                            dbController.acnData(i);
//                        }
//                    }
                        Stage acnstg = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        acnstg.setScene(hobDashboardScn);
                        acnstg.show();

                    } else if ("Loan Officer".equals(employeeTypeCB.getValue())) {
                        loader.setLocation(getClass().getResource("LoanOfficerDahsboadScene.fxml"));
                        Parent lnOfcrRoot = loader.load();

                        Scene lnOfcrDashboardScn = new Scene(lnOfcrRoot);
                        LoanOfficerDahsboadSceneController dbController = loader.getController();
                        for (User i : userArr) {
                            if (idTextField.getText().equals(i.getId())) {
                                dbController.loanOfficerData(i);
                            }
                        }

                        Stage lnOfcrstg = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        lnOfcrstg.setScene(lnOfcrDashboardScn);
                        lnOfcrstg.show();
                    } else if ("Customer Service Agent".equals(employeeTypeCB.getValue())) {
                        loader.setLocation(getClass().getResource("CustomerServiceAgentDashboardScene.fxml"));
                        Parent customRoot = loader.load();

                        Scene customDashboardScn = new Scene(customRoot);

                        Stage customStg = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        customStg.setScene(customDashboardScn);
                        customStg.show();
                    } else if ("HR Executive".equals(employeeTypeCB.getValue())) {
                        loader.setLocation(getClass().getResource("HRExecutiveDashboardScene.fxml"));
                        Parent hrRoot = loader.load();

                        Scene hrExDashboardScn = new Scene(hrRoot);
                        HRExecutiveDashboardSceneController dbController = loader.getController();

                        for (User i : userArr) {
                            if (idTextField.getText().equals(i.getId())) {
                                dbController.hrexData(i);
                            }
                        }
                        Stage hrStg = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        hrStg.setScene(hrExDashboardScn);
                        hrStg.show();
                    } else if ("Legal Advisor".equals(employeeTypeCB.getValue())) {
                        loader.setLocation(getClass().getResource("LegalAdvisorDashboardScene.fxml"));
                        Parent legalRoot = loader.load();

                        Scene legalDashboardScn = new Scene(legalRoot);

                        Stage legalStg = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        legalStg.setScene(legalDashboardScn);
                        legalStg.show();
                    }

                }
            }
        } else {
            Alert add = new Alert(Alert.AlertType.ERROR);
            add.setContentText("Username or Password Incorrect! try again");
            add.setHeaderText(null);
            add.showAndWait();
        }
    }

    @FXML
    private void signUpSceneOnClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BorrowerSignUpScene.fxml"));
        Parent dashroot = loader.load();

        Scene BorrowerSignUpScene = new Scene(dashroot);

        Stage stg2borrower = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg2borrower.setScene(BorrowerSignUpScene);
        stg2borrower.show();
    }

}
