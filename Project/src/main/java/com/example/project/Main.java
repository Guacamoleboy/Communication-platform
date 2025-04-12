/*

    GUI Practice. Making a communication platform for fun.
    As a hobby project in my spare time.

    Plan
    ____

    Make a platform that can be used by people across the world. No need to
    be on the same network. Be able to communicate and write messages
    and store the data.


*/

// Packages
package com.example.project;

// Imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application { // Client class

    // Attributes
    private Login login = new Login(600);
    private Register register = new Register(600);
    private StartInfo startinfo = new StartInfo(300);
    private StartBorder startborder = new StartBorder(3);

    // ____________________________________________________

    @Override
    public void start(Stage app) {

        app.setTitle("Guacamoleboy");

        // Side by side layout JavaFX (left -> Right) // HBox
        HBox mainScene = new HBox(startinfo, startborder, login); // Start Scene

        Scene scene = new Scene(mainScene, 900, 600);
        app.setResizable(false); // Don't change width / height
        app.setScene(scene);
        app.show();

    }

    // _______________________MAIN_________________________

    public static void main(String[] args) {
        launch();
    }

} // Class end