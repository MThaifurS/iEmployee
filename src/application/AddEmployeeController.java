package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddEmployeeController {

    @FXML
    private TextField fNameTF;
    @FXML
    private TextField lNameTF;
    @FXML
    private TextField mNameTF;
    @FXML
    private TextField idTF;
    @FXML
    private TextField dateJoinedTF;
    @FXML
    private TextField departmentTF;
    @FXML
    private TextField streetTF;
    @FXML
    private TextField cityTF;
    @FXML
    private TextField stateTF;
    @FXML
    private TextField postalCodeTF;
    @FXML
    private TextField emailTF;
    @FXML
    private TextField phoneNumberTF;
    @FXML
    private Button submitButton;
    @FXML
    private Button cancelButton;

    private ManageEmployeeListSceneController manageEmployeeListSceneController;
    private DataHandler dataHandler;

    public void setManageEmployeeListSceneController(ManageEmployeeListSceneController controller) {
        this.manageEmployeeListSceneController = controller;
        this.dataHandler = new DataHandler(controller.getConnection()); 
    }

    @FXML
    public void handleSubmitButton(ActionEvent event) {
        if (manageEmployeeListSceneController != null && areFieldsValid()) {
        	
            try {
            	
                int id = Integer.parseInt(idTF.getText());
                Name name = new Name(fNameTF.getText(), mNameTF.getText(), lNameTF.getText());
                Address address = new Address(streetTF.getText(), cityTF.getText(), stateTF.getText(), postalCodeTF.getText());
                Contact contact = new Contact(emailTF.getText(), phoneNumberTF.getText());
                Profile profile = new Profile(address, contact, departmentTF.getText(), dateJoinedTF.getText());
                Employee newEmployee = new Employee(name, id, profile);
                
                
                dataHandler.insertEmployee(newEmployee);
                manageEmployeeListSceneController.refreshTable();
                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.close();
                

            } catch (NumberFormatException e) {
                AlertHelper.showAlert(AlertType.ERROR, "Invalid Input", "Please enter a valid integer for ID.");
                e.printStackTrace();
            } catch (SQLException e) {
                AlertHelper.showAlert(AlertType.ERROR, "Database Error", "Failed to add employee to the database.");
                e.printStackTrace();
            }
        } else {
            AlertHelper.showAlert(AlertType.ERROR, "Missing Fields", "Please fill in all fields.");
        }
    }

    @FXML
    public void handleCancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private boolean areFieldsValid() {
        return  !fNameTF.getText().isEmpty() &&
                !lNameTF.getText().isEmpty() &&
                !mNameTF.getText().isEmpty() &&
                !idTF.getText().isEmpty() &&
                !dateJoinedTF.getText().isEmpty() &&
                !departmentTF.getText().isEmpty() &&
                !streetTF.getText().isEmpty() &&
                !cityTF.getText().isEmpty() &&
                !stateTF.getText().isEmpty() &&
                !postalCodeTF.getText().isEmpty() &&
                !emailTF.getText().isEmpty() &&
                !phoneNumberTF.getText().isEmpty();
    }

}
