package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class NextSceneButton {
    
    public void nextScene(AnchorPane currentAnchorPane, Parent nextScene) {
        currentAnchorPane.getChildren().clear();
        currentAnchorPane.getChildren().setAll(nextScene);
    }
}