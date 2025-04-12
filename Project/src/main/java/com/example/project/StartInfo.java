// Packages
package com.example.project;

// Imports
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class StartInfo extends Pane {

    // Attributes
    private int sceneWidth;

    // ____________________________________________________

    public StartInfo(int sceneWidth){

        this.sceneWidth = sceneWidth;
        this.setPrefWidth(this.sceneWidth);
        this.setStyle("-fx-background-color: orange;");

        VBox loginBox = new VBox(15); // Padding / Margin
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPrefWidth(150); // Center of 300 (Scene)
        loginBox.setLayoutX(75);
        loginBox.setLayoutY(75);


    } // Constructor End

} //StartInfo Class end
