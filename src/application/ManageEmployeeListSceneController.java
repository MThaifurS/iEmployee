package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


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
    
    private Connection conn;
    
   
    public Connection getConnection() {
		return conn;
	}
    
    
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
    
    
    public void initialize() {
        if (conn != null) {
            System.out.println("Connection established successfully.");
            loadEmployeeData();
        } else {
            System.out.println("Failed to establish connection.");
        }
    }

    private void loadEmployeeData() {
        try {
            LoadData dataLoader = new LoadData(conn);
            employeeData.addAll(dataLoader.getAllEmployees());

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

            employeeTable.setItems(employeeData);

        } catch (SQLException e) {
            AlertHelper.showAlert(AlertType.ERROR, "Error", "Error loading employee data from database.");
            e.printStackTrace();
        }
    }
    
    public void updateEmployee(Employee updatedEmployee) {
        int index = employeeData.indexOf(updatedEmployee);
        if (index != -1) {
            employeeData.set(index, updatedEmployee);
            
            try {
                LoadData dataLoader = new LoadData(conn);
                dataLoader.updateEmployee(updatedEmployee); 
            } catch (SQLException e) {
                AlertHelper.showAlert(AlertType.ERROR, "Error", "Failed to update employee in database.");
                e.printStackTrace();
            }
        } else {
            AlertHelper.showAlert(AlertType.ERROR, "Error", "Employee not found in the list.");
        }
    }
    
    public void refreshTable() {
    	employeeData.clear();
        loadEmployeeData();
    }

    @FXML
    public void handleAddButton(ActionEvent e) {
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

        } catch (Exception er) {
            AlertHelper.showAlert(AlertType.ERROR, "Error", "An error occurred while opening the Add Employee window.");
            er.printStackTrace();
        }
    }

    @FXML
    public void handleRemoveButton(ActionEvent event) {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            
            employeeData.remove(selectedEmployee);

            
            try {
                LoadData dataLoader = new LoadData(conn);
                dataLoader.deleteEmployee(selectedEmployee.getId()); 
            } catch (SQLException e) {
                AlertHelper.showAlert(AlertType.ERROR, "Error", "Failed to remove employee from database.");
                e.printStackTrace();
            }
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
    public void handleBackButton(ActionEvent event) throws IOException {
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHomeScene.fxml"));
         Parent root = loader.load();
         
         AdminHomeSceneController adminController = loader.getController();
         adminController.setConnection(conn);

         NextSceneButton ns = new NextSceneButton();
         ns.nextScene(employeeListAnchorPane, root);
    }

	
}
