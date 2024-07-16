package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import javafx.scene.control.Button;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class EditEmployeeController {

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
    private Button saveButton;
    
    @FXML
    private Button cancelButton;
    
    

    private Employee employee;
    private ManageEmployeeListSceneController manageEmployeeListSceneController;
    
    

    public void setEmployee(Employee employee) {
    	
        this.employee = employee;
        
        fNameTF.setText(employee.getName().getFirstName());
        lNameTF.setText(employee.getName().getLastName());
        mNameTF.setText(employee.getName().getMiddleName());
        idTF.setText(String.valueOf(employee.getId()));
        dateJoinedTF.setText(employee.getProfile().getDateJoined());
        departmentTF.setText(employee.getProfile().getDepartment());
        streetTF.setText(employee.getProfile().getAddress().getStreet());
        cityTF.setText(employee.getProfile().getAddress().getCity());
        stateTF.setText(employee.getProfile().getAddress().getState());
        postalCodeTF.setText(employee.getProfile().getAddress().getPostalCode());
        emailTF.setText(employee.getProfile().getContactInfo().getEmail());
        phoneNumberTF.setText(employee.getProfile().getContactInfo().getPhoneNum());
        
    }
    
    

    public void setManageEmployeeListSceneController(ManageEmployeeListSceneController controller) {
        this.manageEmployeeListSceneController = controller;
    }
    
    

    @FXML
    private void handleSaveButton() {
    	
        employee.getName().setFirstName(fNameTF.getText());
        employee.getName().setLastName(lNameTF.getText());
        employee.getName().setMiddleName(mNameTF.getText());
        employee.setId(Integer.parseInt(idTF.getText()));
        employee.getProfile().setDateJoined(dateJoinedTF.getText());
        employee.getProfile().setDepartment(departmentTF.getText());
        employee.getProfile().getAddress().setStreet(streetTF.getText());
        employee.getProfile().getAddress().setCity(cityTF.getText());
        employee.getProfile().getAddress().setState(stateTF.getText());
        employee.getProfile().getAddress().setPostalCode(postalCodeTF.getText());
        employee.getProfile().getContactInfo().setEmail(emailTF.getText());
        employee.getProfile().getContactInfo().setPhoneNum(phoneNumberTF.getText());

        manageEmployeeListSceneController.updateEmployee(employee);
        
        closeWindow();
    }

    @FXML
    private void handleCancelButton() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) fNameTF.getScene().getWindow();
        stage.close();
    }
}
