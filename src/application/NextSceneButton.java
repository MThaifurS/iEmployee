package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class NextSceneButton {
    public void nextScene(AnchorPane currentAnchorPane, String fxml) {
        try {
            AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml)));
            currentAnchorPane.getChildren().removeAll();
            currentAnchorPane.getChildren().setAll(nextAnchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}