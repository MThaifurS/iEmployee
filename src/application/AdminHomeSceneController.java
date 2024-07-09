package application;


//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	
	
	public void displayUsername(String username) {
		labelEmployeeName.setText("Hello " + username + "!");
		
	}

	@FXML
	public void handleManageEmployeeList(ActionEvent event) {
		NextSceneButton ns = new NextSceneButton();
        ns.nextScene(adminSceneAnchorPane, "ManageEmployeeListScene.fxml");
	}
	
	@FXML
	public void handleManageLeaveList(ActionEvent event) {
		NextSceneButton ns = new NextSceneButton();
        ns.nextScene(adminSceneAnchorPane, "ManageEmployeeLeaveListScene.fxml");
	}
	
	@FXML
	public void handleManageAttandanceList(ActionEvent event) {
		NextSceneButton ns = new NextSceneButton();
        ns.nextScene(adminSceneAnchorPane, "ManageEmployeeAttendanceListScene.fxml");
	}
	
	
	@FXML
	public void handleLogOutButton(ActionEvent event) {
		Stage stage = (Stage) adminSceneAnchorPane.getScene().getWindow();
	    stage.close();
	}
}
