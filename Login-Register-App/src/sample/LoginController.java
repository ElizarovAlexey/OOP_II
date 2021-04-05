package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button signUpButton;
    @FXML
    private Label loginTextLabel;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File lockFile = new File("images/lock.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    public void actionLoginButton(ActionEvent event) {
        if (usernameTextField.getText().isBlank() && passwordTextField.getText().isBlank()) {
        	loginTextLabel.setText("Enter login and password");
        } else {
        	validateLogin();
        }
    }

    public void actionCancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DataBaseConnection connection = new DataBaseConnection();
        Connection connectDatabase = connection.getConnection();

        String loginVerify = "SELECT count(1) FROM accounts WHERE username = '"
                + usernameTextField.getText() + "' AND password = '"
                + passwordTextField.getText() + "'";

        try {
            Statement statement = connectDatabase.createStatement();
            ResultSet result = statement.executeQuery(loginVerify);

            while(result.next()) {
                if (result.getInt(1) == 1) {
                    loginTextLabel.setText("Login success!");
                } else {
                    loginTextLabel.setText("Invalid login. Try again!");
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
    
    public void signUpButtonOnAction(ActionEvent event) {
    	createAccountForm();
    }
    
    public void createAccountForm() {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
    		Stage registerStage = new Stage();
    		registerStage.initStyle(StageStyle.UNDECORATED);
    		registerStage.setScene(new Scene(root, 500, 530));
    		registerStage.show();
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    		e.getCause();
    	} finally {
    		Stage stage = (Stage)signUpButton.getScene().getWindow();
        	stage.close();
    	}
    }
    
}
