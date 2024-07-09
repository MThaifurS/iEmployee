package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;

public class ManageEmployeeAttendanceListSceneController {

    @FXML
    private AnchorPane employeeAttendanceAnchorPane;

    @FXML
    private TableView<Employee> attendanceTable;

    @FXML
    private TableColumn<Employee, String> fName;

    @FXML
    private TableColumn<Employee, String> lName;

    @FXML
    private TableColumn<Employee, String> mName;

    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, Double> hoursWorked;

    @FXML
    private TableColumn<Employee, String> performance;

    @FXML
    private Button backButton;

    private ObservableList<Employee> employeeData = FXCollections.observableArrayList();
    
    

    @FXML
    public void initialize() {
        
        fName.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getName().getFirstName()));
        lName.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getName().getLastName()));
        mName.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getName().getMiddleName()));
        id.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
        hoursWorked.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAttendance().getHoursWorked()));
        performance.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAttendance().getPerformanceStatus()));
        performance.setCellFactory(column -> new TableCell<Employee, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item);
                    if (item.equals("Good")) {
                        setTextFill(Color.GREEN);
                    } else if (item.equals("Bad")) {
                        setTextFill(Color.RED);
                    }
                }
            }
        });
        
        employeeData = SampleData.createSampleAttendance();
     
        attendanceTable.setItems(employeeData);
        
    }

    
    @FXML
    public void handleBackButton(ActionEvent event) {
        NextSceneButton ns = new NextSceneButton();
        ns.nextScene(employeeAttendanceAnchorPane, "AdminHomeScene.fxml");
    }

}
