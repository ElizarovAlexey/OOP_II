package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.PasswordField;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {
	
	@FXML
	private ImageView registerIconImageView;
	@FXML
	private Button closeButton;
	@FXML
	private Button signInButton;
	@FXML
	private Label registrationMessageLabel;
	@FXML
	private Label confirmPasswordLabel;
	@FXML
	private Button registerButton;
	@FXML
	private TextField firstnameTextField;
	@FXML
	private TextField lastnameTextField;
	@FXML
	private TextField usernameTextField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private PasswordField confirmPasswordField;
	
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File registerIconFile = new File("images/register-icon.png");
        Image registerIconImage = new Image(registerIconFile.toURI().toString());
        registerIconImageView.setImage(registerIconImage);
    }
    
    public void closeButtonOnAction(ActionEvent event) {
    	Stage stage = (Stage)closeButton.getScene().getWindow();
    	stage.close();
    	Platform.exit();
    }
    
    public void registerButtonOnAction(ActionEvent event) {
    	if (passwordField.getText().equals(confirmPasswordField.getText())) {
    		registerUser();
    		confirmPasswordLabel.setText("");
    	} else {
    		confirmPasswordLabel.setText("Password does not match");
    	}
    }
    
    public void registerUser() {
    	DataBaseConnection connection = new DataBaseConnection();
    	Connection connectionDB = connection.getConnection();
    	
    	String firstname = firstnameTextField.getText();
    	String lastname = lastnameTextField.getText();
    	String username = usernameTextField.getText();
    	String password = passwordField.getText();
    	
    	String insertFields = "INSERT INTO accounts (firstname, lastname, username, password) VALUES ('";
    	String insertValues = firstname + "', '" + lastname + "', '" + username + "', '" + password + "');";
    	String insertToRegister = insertFields + insertValues;
    	
    	try {
    		
    		Statement statement = connectionDB.createStatement();
    		statement.executeUpdate(insertToRegister);
    		registrationMessageLabel.setText("User has been registered successfully!");
    		clearFields();
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    		e.getCause();
    	}
    }
    
    public void signInButtonOnAction(ActionEvent event) {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
    		Stage loginStage = new Stage();
    		loginStage.initStyle(StageStyle.UNDECORATED);
    		loginStage.setScene(new Scene(root, 500, 400));
            loginStage.show();
    	} catch(Exception e) {
    		e.printStackTrace();
    		e.getCause();
    	} finally {
    		Stage stage = (Stage)signInButton.getScene().getWindow();
        	stage.close();
    	}
    }
    
    public void clearFields() {
    	firstnameTextField.setText("");
    	lastnameTextField.setText("");
    	usernameTextField.setText("");
    	passwordField.setText("");
    	confirmPasswordField.setText("");
    }
}
