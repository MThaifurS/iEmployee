package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class LoginSceneController {
	
		private Parent root;
		
	
		@FXML
		private AnchorPane loginSceneAnchorPane;
		
	 	@FXML
	    private TextField usernameTF;

	 	@FXML
	    private PasswordField passwordTF;

	    @FXML
	    private Button loginButton;

	    private Credential correctCredential = new Credential("utp", "123");
	    
	    public void usernameSave(ActionEvent evant)  throws IOException {
	    	String username = usernameTF.getText();
	    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
	    	root = loader.load();
	    	
	    	AdminHomeSceneController Home = loader.getController();
	    	Home.displayUsername(username);
	    	
	    }
	   
	    
	    @FXML
	    public void handleLoginButton() {
	        String enteredUsername = usernameTF.getText();
	        String enteredPassword = passwordTF.getText();

	        if (enteredUsername.equals(correctCredential.getUsername()) && enteredPassword.equals(correctCredential.getPassword())) {
	    
	            NextSceneButton ns = new NextSceneButton();
	            ns.nextScene(loginSceneAnchorPane, "AdminHomeScene.fxml");
	            
	        } else {            
	        	AlertHelper.showAlert(AlertType.ERROR, "Login Error", "Username or password is incorrect.");
	        }
	    }
}
