package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;

public class PrincipalController implements Initializable {
	
	@FXML
	private TableView<ModelTable> table;
	@FXML
	private TableColumn<ModelTable, String> column_firstname;
	@FXML
	private TableColumn<ModelTable, String> column_lastname;
	@FXML
	private TableColumn<ModelTable, String> column_group;
	@FXML
	private TableColumn<ModelTable, String> column_course;
	@FXML
	private TableColumn<ModelTable, String> column_faculty;
	
	@FXML
	private Button close;
	
	
	ObservableList<ModelTable> oblist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	public void closeOnAction(ActionEvent event) {
		Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
	}
	
	public void printStudentsOnAction(ActionEvent event) {
		printStudents();
	}
	
	public void printStudents() {
		try {
			oblist = FXCollections.observableArrayList();
			
			Connection connection = DatabaseConnection.getConnection();
			
			column_firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
			column_lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
			column_group.setCellValueFactory(new PropertyValueFactory<>("group"));
			column_course.setCellValueFactory(new PropertyValueFactory<>("course"));
			column_faculty.setCellValueFactory(new PropertyValueFactory<>("faculty"));
			
			ResultSet result = connection.createStatement().executeQuery("SELECT firstname, lastname, faculty.name, value, univ_group.name\r\n"
					+ "FROM students inner join faculty on students.faculty = faculty.faculty_id \r\n"
					+ "			  inner join course on students.course = course.course_id\r\n"
					+ "              inner join univ_group on students.group = univ_group.group_id;");
			
			while(result.next()) {
				oblist.add(new ModelTable(result.getString("firstname"),
						result.getString("lastname"),
						result.getString("univ_group.name"),
						result.getString("value"), 
						result.getString("faculty.name")));
			}
			
			table.setItems(oblist);
		} catch (SQLException e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	public void addStudentsOnAction() {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("addStudent.fxml"));
    		Stage registerStage = new Stage();
    		registerStage.initStyle(StageStyle.UNDECORATED);
    		registerStage.setScene(new Scene(root, 400, 400));
    		registerStage.show();
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    		e.getCause();
    	}
    }
    
}
