package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminHomeSceneController {
	@FXML
	private AnchorPane adminSceneAnchorPane;
	@FXML
	private Button manageEmployeeList;
	@FXML
	private Button manageLeaveList;
	@FXML
	private Button manageAttendanceList;
	@FXML
	private Button logOutButton;
	@FXML
	private Label labelEmployeeName;
	
	private Connection conn;
	
	public void setConnection(Connection conn) {
        this.conn = conn;
    }
	
	 public Connection getConnection() {
	    return conn;     
	}
	

	@FXML
	public void handleManageEmployeeList(ActionEvent event) throws SQLException, IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageEmployeeListScene.fxml"));
        Parent root = loader.load();
        ManageEmployeeListSceneController employeeController = loader.getController();
        employeeController.setConnection(conn);
        employeeController.initialize();

        NextSceneButton ns = new NextSceneButton();
        ns.nextScene(adminSceneAnchorPane, root);
	}
	
	@FXML
	public void handleManageLeaveList(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageEmployeeLeaveListScene.fxml"));
        Parent root = loader.load();
        ManageEmployeeLeaveListSceneController leaveController = loader.getController();
        leaveController.setConnection(conn);
        leaveController.initialize();

        NextSceneButton ns = new NextSceneButton();
        ns.nextScene(adminSceneAnchorPane, root);
	}
	
	@FXML
	public void handleManageAttandanceList(ActionEvent event) throws SQLException, IOException {
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageEmployeeAttendanceListScene.fxml"));
        Parent root = loader.load();
        ManageEmployeeAttendanceListSceneController attendanceController = loader.getController();
        attendanceController.setConnection(conn);
        attendanceController.initialize();

        NextSceneButton ns = new NextSceneButton();
        ns.nextScene(adminSceneAnchorPane, root);
	}
	
	
	@FXML
	public void handleLogOutButton(ActionEvent event) {
		Stage stage = (Stage) adminSceneAnchorPane.getScene().getWindow();
	    stage.close();
	}
}
