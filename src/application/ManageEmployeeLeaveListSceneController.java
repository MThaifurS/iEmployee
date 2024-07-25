package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ManageEmployeeLeaveListSceneController {

    @FXML
    private AnchorPane employeeLeaveListAnchorPane;

    @FXML
    private TableView<Employee> tableLeave;

    @FXML
    private TableColumn<Employee, String> fName;

    @FXML
    private TableColumn<Employee, String> mName;

    @FXML
    private TableColumn<Employee, String> lName;

    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, LocalDate> startDate;

    @FXML
    private TableColumn<Employee, LocalDate> endDate;

    @FXML
    private TableColumn<Employee, String> approvalStatus;

    @FXML
    private TableColumn<Employee, Integer> leavesEntitled;

    @FXML
    private Button backButton;

    @FXML
    private Button approveButton;

    @FXML
    private Button disapproveButton;

    private ObservableList<Employee> employeeData = FXCollections.observableArrayList();
    private Connection conn;
    
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
	
	 public Connection getConnection() {
	    return conn;      
	        
	}
	 
	 private String convertApprovalStatus(boolean approvalStatus) {
	        return approvalStatus ? "Accepted" : "Declined";
	    }

    
	 public void initialize() {
	        if (conn != null) {
	            System.out.println("Connection established successfully.");
	            loadLeaveData(conn);
	        } else {
	            System.out.println("Failed to establish connection.");
	        }
	    }

	 private void loadLeaveData(Connection conn) {
	        try {
	            LoadData dataLoader = new LoadData(conn);
	            employeeData.addAll(dataLoader.getAllLeaves());

	            fName.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getName().getFirstName()));
	            lName.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getName().getLastName()));
	            mName.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getName().getMiddleName()));
	            id.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
	            startDate.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getLeaves().getLeavesList().get(0).getStartDate()));
	            endDate.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getLeaves().getLeavesList().get(0).getEndDate()));
	            approvalStatus.setCellValueFactory(cellData -> new SimpleObjectProperty<>(convertApprovalStatus(cellData.getValue().getLeaves().getLeavesList().get(0).getApprovalStatus())));
	            leavesEntitled.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getLeaveEntitled()));

	            approvalStatus.setCellFactory(column -> new TableCell<Employee, String>() {
	                @Override
	                protected void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    if (item == null || empty) {
	                        setText(null);
	                        setTextFill(Color.BLACK);
	                    } else {
	                        setText(item);
	                        if (item.equals("Accepted")) {
	                            setTextFill(Color.GREEN);
	                        } else if (item.equals("Declined")) {
	                            setTextFill(Color.RED);
	                        } else {
	                            setTextFill(Color.BLACK);
	                        }
	                    }
	                }
	            });

	            tableLeave.setItems(employeeData);
	            tableLeave.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

	        } catch (SQLException e) {
	            AlertHelper.showAlert(AlertType.ERROR, "Error", "Failed to load leave data from database.");
	            e.printStackTrace();
	        }
	    }

    
    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
    	 FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHomeScene.fxml"));
         Parent root = loader.load();
         
         AdminHomeSceneController adminController = loader.getController();
         adminController.setConnection(conn);

         NextSceneButton ns = new NextSceneButton();
         ns.nextScene(employeeLeaveListAnchorPane, root);
    }
    

    
    @FXML
    public void handleDisapproveButton(ActionEvent event) {
        Employee selectedEmployee = tableLeave.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            Leave selectedLeave = selectedEmployee.getLeaves().getLeavesList().get(0); 
            selectedLeave.setApprovalStatus(false);
            updateApprovalStatus(selectedEmployee.getId(), false);
            tableLeave.refresh();
        } else {
            AlertHelper.showAlert(AlertType.ERROR, "Error", "Please select an employee to disapprove leave.");
        }
    }

    
    private void updateApprovalStatus(int employeeId, boolean approvalStatus) {
        String query = "UPDATE leaves_list SET approval_status = ? WHERE id = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setBoolean(1, approvalStatus);
            statement.setInt(2, employeeId);
            statement.executeUpdate();
            System.out.println("Approval status updated for employee ID: " + employeeId);
        } catch (SQLException e) {
            AlertHelper.showAlert(AlertType.ERROR, "Error", "Failed to update approval status in database.");
            e.printStackTrace();
        }
    }

    
    @FXML
    public void handleApproveButton(ActionEvent event) {
        Employee selectedEmployee = tableLeave.getSelectionModel().getSelectedItem();
        if (selectedEmployee != null) {
            Leave selectedLeave = selectedEmployee.getLeaves().getLeavesList().get(0); 
            selectedLeave.setApprovalStatus(true);
            updateApprovalStatus(selectedEmployee.getId(), true);
            tableLeave.refresh();
        } else {
            AlertHelper.showAlert(AlertType.ERROR, "Error", "Please select an employee to approve leave.");
        }
    }
}
