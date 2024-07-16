package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
    private TableColumn<Employee, String> department;

    @FXML
    private TableColumn<Employee, Double> hoursWorked;

    @FXML
    private TableColumn<Employee, String> performance;

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

    
    @FXML
    public void initialize() {
    	 if (conn != null) {
             System.out.println("Connection established successfully.");
             loadAttendanceData(conn);
         } else {
             System.out.println("Failed to establish connection.");
         }
    }
    
    private void loadAttendanceData(Connection conn) {
        try {
            LoadData dataLoader = new LoadData(conn);
            employeeData.addAll(dataLoader.getAllAttendance());

            System.out.println("Loaded " + employeeData.size() + " employees.");

            fName.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getName().getFirstName()));
            lName.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getName().getLastName()));
            mName.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getName().getMiddleName()));
            id.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
            department.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfile().getDepartment()));
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

            attendanceTable.setItems(employeeData);

        } catch (SQLException e) {
            AlertHelper.showAlert(AlertType.ERROR, "Error", "Error loading attendance data from database.");
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
         ns.nextScene(employeeAttendanceAnchorPane, root);
    }

}
