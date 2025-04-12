/*

    GUI Practice. Making a communication platform for fun.
    As a hobby project in my spare time.

    Author:
    Guacamoleboy

    Plan
    ____

    Make a platform that can be used by people across the world. No need to
    be on the same network. Be able to communicate and write messages
    and store the data.


*/

// Packages
package App;

// Imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application { // Client class

    // Attributes
    private Login login = new Login(600, 600);
    private StartInfo startinfo = new StartInfo(300, 600);
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

        closeHandle(app);

        app.show();

    }

    // _______________________MAIN_________________________

    public static void main(String[] args) {
        launch();
    }

    // ____________________________________________________


    /*

        If a user closes the app then it should change their status to "Offline" again.
        This code does exactly that. Only for the logged in user. Else all would become "Offline" if
        anyone closes the app.

    */
    public void closeHandle(Stage stage){

        stage.setOnCloseRequest(e -> {

            ProcessData processdata = new ProcessData();

            String username = login.getUsername();

            for (User u : processdata.getUsers()){
                if(u.getUsername().equalsIgnoreCase(username)){
                    u.setStatus("Offline");
                    processdata.saveData();
                    break;
                }
            }

            System.exit(0);

        });

    }

} // Class end