package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSceneController {
    
    @FXML
    private AnchorPane loginSceneAnchorPane;
    
    @FXML
    private TextField usernameTF;

    @FXML
    private PasswordField passwordTF;

    @FXML
    private Button loginButton;

    private Connection conn;
    
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
    
    public Connection getConnection() {
    	return conn;
    }
    
    
    @FXML
    public void handleLoginButton() throws IOException {
        String enteredUsername = usernameTF.getText();
        String enteredPassword = passwordTF.getText();

        
        try {
            String sql = "SELECT * FROM `admin_credentials` WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, enteredUsername);
            pstmt.setString(2, enteredPassword);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
            	
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHomeScene.fxml"));
                Parent root = loader.load();
                AdminHomeSceneController adminController = loader.getController();
                adminController.setConnection(conn);
                NextSceneButton ns = new NextSceneButton();
                ns.nextScene(loginSceneAnchorPane, root);
                
            } else {
                AlertHelper.showAlert(AlertType.ERROR, "Login Error", "Username or password is incorrect.");
            }

            
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Error verifying login credentials: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
