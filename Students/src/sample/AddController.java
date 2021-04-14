package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class AddController implements Initializable {
	@FXML
	private Button close;
	@FXML
	private TextField firstnameTextField;
	@FXML
	private TextField lastnameTextField;
	@FXML
	private TextField groupTextField;
	@FXML
	private TextField courseTextField;
	@FXML
	private TextField facultyTextField;
	@FXML
	private Label messageLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { }
	
	public void closeOnAction(ActionEvent event) {
		Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
	}
	
	public void applyOnAction() {
		DatabaseConnection connection = new DatabaseConnection();
		Connection connectionDB = connection.getConnection();
		
		String firstname = firstnameTextField.getText();
		String lastname = lastnameTextField.getText();
		int group = Integer.parseInt(groupTextField.getText());
		int course = Integer.parseInt(courseTextField.getText());
		int faculty = Integer.parseInt(facultyTextField.getText());
		
		String insertFields = "INSERT INTO students (`firstname`, `lastname`, `group`, `course`, `faculty`) VALUES ('";
    	String insertValues = firstname + "', '" + lastname + "', " + group + ", " + course + ", " + faculty  + ");";
    	String insertToRegister = insertFields + insertValues;
		
		try {
    		Statement statement = connectionDB.createStatement();
    		statement.executeUpdate(insertToRegister);
    		messageLabel.setText("Student has been added successfully!");
    		clearFields();
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    		e.getCause();
    	}
	}
	
	public void clearFields() {
    	firstnameTextField.setText("");
    	lastnameTextField.setText("");
    	groupTextField.setText("");
    	courseTextField.setText("");
    	facultyTextField.setText("");
    }
    
}
