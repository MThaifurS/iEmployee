package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
        Parent loginRoot = loader.load();
        LoginSceneController controller = loader.getController();

        Connection conn =DatabaseConnection.getInstance().getConnection();
        controller.setConnection(conn);

        primaryStage.setTitle("iEmployee");
        primaryStage.setScene(new Scene(loginRoot, 1000, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
