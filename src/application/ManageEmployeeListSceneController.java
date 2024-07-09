package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

public class ManageEmployeeListSceneController {
	
    @FXML
    private AnchorPane employeeListAnchorPane;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> fName;

    @FXML
    private TableColumn<Employee, String> lName;

    @FXML
    private TableColumn<Employee, String> mName;

    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, String> dateJoined;

    @FXML
    private TableColumn<Employee, String> department;

    @FXML
    private TableColumn<Employee, String> street;

    @FXML
    private TableColumn<Employee, String> city;

    @FXML
    private TableColumn<Employee, String> state;

    @FXML
    private TableColumn<Employee, String> postalCode;

    @FXML
    private TableColumn<Employee, String> email;

    @FXML
    private TableColumn<Employee, String> phoneNum;

    

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button editButton;

    @FXML
    private Button backButton;
    
    private ObservableList<Employee> employeeData = FXCollections.observableArrayList();

    
    @FXML
    public void initialize() {
        
        fName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName().getFirstName()));
        lName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName().getLastName()));
        mName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName().getMiddleName()));
        id.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        dateJoined.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfile().getDateJoined()));
        department.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfile().getDepartment()));
        street.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfile().getAddress().getStreet()));
        city.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfile().getAddress().getCity()));
        state.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfile().getAddress().getState()));
        postalCode.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfile().getAddress().getPostalCode()));
        email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfile().getContactInfo().getEmail()));
        phoneNum.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfile().getContactInfo().getPhoneNum()));
        
        employeeData = SampleData.createSampleEmployees();
        
        employeeTable.setItems(employeeData);
    }

    public void addEmployee(Employee newEmployee) {
        employeeData.add(newEmployee);
    }
    
    public void updateEmployee(Employee updatedEmployee) {
        int index = -1;
        for (int i = 0; i < employeeData.size(); i++) {
            if (employeeData.get(i).getId() == updatedEmployee.getId()) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            employeeData.set(index, updatedEmployee);
        } else {
        	AlertHelper.showAlert(AlertType.ERROR, "Error", "Employee not found in the list.");
        }
        
    }
        
        
    @FXML
    public void handleAddButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEmployee.fxml"));
            Parent root = loader.load();

            AddEmployeeController addEmployeeController = loader.getController();
            addEmployeeController.setManageEmployeeListSceneController(this);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add New Employee");
            stage.setScene(new Scene(root));
            stage.showAndWait();

        } catch (Exception e) {
        	AlertHelper.showAlert(AlertType.ERROR, "Error", "An error occurred while opening the Add Employee window.");
            e.printStackTrace();
        }
    }


	
	


	@FXML
	public void handleRemoveButton(ActionEvent event) {
		Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            employeeData.remove(selectedEmployee);
        } else {
        	AlertHelper.showAlert(AlertType.ERROR, "Error", "Please select an employee to remove.");
        }
	}

	@FXML
	public void handleEditButton() {
	    Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
	    if (selectedEmployee != null) {
	        try {
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(getClass().getResource("EditEmployee.fxml")); 
	            Parent root = loader.load();

	            
	            EditEmployeeController editEmployeeController = loader.getController();

	            
	            editEmployeeController.setEmployee(selectedEmployee);
	            editEmployeeController.setManageEmployeeListSceneController(this);

	            Stage stage = new Stage();
	            stage.initModality(Modality.APPLICATION_MODAL);
	            stage.setTitle("Edit Employee");
	            stage.setScene(new Scene(root));
	            stage.showAndWait();

	        } catch (IOException e) {
	        	AlertHelper.showAlert(AlertType.ERROR, "Error", "An error occurred while opening the Edit Employee window.");
	            e.printStackTrace();
	        } catch (Exception e) {
	        	AlertHelper.showAlert(AlertType.ERROR, "Error", "An unexpected error occurred.");
	            e.printStackTrace();
	        }
	    } else {
	    	AlertHelper.showAlert(AlertType.ERROR, "Error", "Please select an employee to edit.");
	    }
	}
	
	
	@FXML
	public void handleBackButton(ActionEvent event) {
		NextSceneButton ns = new NextSceneButton();
        ns.nextScene(employeeListAnchorPane, "AdminHomeScene.fxml");
        
        
	}
	
	
}
