// Packages
package com.example.project;

// Imports
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.*;

import java.util.ArrayList;

public class Login extends Pane {

    // Attributes
    private TextField usernameField;
    private FileIO io = new FileIO();
    private PasswordField passwordField;
    private Button loginButton;
    private Button forgotButton;
    private Button registerButton;
    private int sceneWidth;
    private String username;
    private String password;
    private ArrayList <String> userdata;
    private ArrayList <User> currentUser;
    private User user;

    // ____________________________________________________

    public Login(int sceneWidth){

        this.sceneWidth = sceneWidth;
        this.setPrefWidth(this.sceneWidth);
        this.setStyle("-fx-background-color: #AAAAAAFF");

        // Create
        this.getChildren().add(display());

    } // Constructor end

    // ____________________________________________________

    public VBox display(){

        VBox loginBox = new VBox(15); // Padding / Margin
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPrefWidth(300); // Center of 600 (Scene)
        loginBox.setLayoutX(150);
        loginBox.setLayoutY(100);

        HBox buttons = new HBox(15);
        buttons.setAlignment(Pos.CENTER_RIGHT);

        Label loginLabel = new Label("Log in");
        loginLabel.setStyle("-fx-font-size: 48px; -fx-font-weight: bold; -fx-text-fill: rgba(0,0,0,0.50);");

        usernameField = new TextField();
        usernameField.setPrefHeight(40);
        usernameField.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-border-radius: 15px; -fx-background-radius: 15px; -fx-border-color: rgba(0,0,0,0.50);");
        usernameField.setPromptText("Username");

        passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        passwordField.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-border-radius: 15px; " +
                "-fx-background-radius: 15px; -fx-border-color: rgba(0,0,0,0.50);");
        passwordField.setPromptText("Password");

        registerButton = new Button("Want an account? Sign up now!");
        registerButton.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: rgba(0,0,0,0.50); " +
                "-fx-border-radius: 15px; -fx-background-radius: 15px; -fx-border-color: rgba(0,0,0,0.50);");
        registerButton.setPrefHeight(30);
        registerButton.setPrefWidth(300);

        loginButton = new Button("Log in");
        loginButton.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: rgba(0,0,0,0.50); " +
                "-fx-border-radius: 15px; -fx-background-radius: 15px; -fx-border-color: rgba(0,0,0,0.50);");
        loginButton.setPrefHeight(30);
        loginButton.setPrefWidth(100); // 1/3 of VBox scene

        forgotButton = new Button("Forgot something?");
        forgotButton.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: rgba(0,0,0,0.50);" +
                " -fx-border-radius: 15px; -fx-background-radius: 15px; -fx-border-color: rgba(0,0,0,0.50);");
        forgotButton.setPrefHeight(30);
        forgotButton.setPrefWidth(200); // 2/3 of VBox scene // 15 padding

        // Margins
        VBox.setMargin(registerButton, new Insets(30, 0, 0, 0)); // More padding for the register button

        // Add
        buttons.getChildren().addAll(loginButton, forgotButton); // HBox
        loginBox.getChildren().addAll(loginLabel, usernameField, passwordField, buttons, registerButton); // VBox

        // Events
        registerButton.setOnAction(e -> registerButtonAction());
        loginButton.setOnAction(e -> loginButtonAction());

        return loginBox;

    }

    // ____________________________________________________

    public void registerButtonAction(){

        // If user presses the Register button!
        Register register = new Register(600);
        StartBorder sb = new StartBorder(3);
        StartInfo si = new StartInfo(300);
        HBox registerHBox = new HBox(register, sb, si);

        Scene registerScene = new Scene(registerHBox, 900, 600);

        Stage stage = (Stage) getScene().getWindow(); // Main window
        stage.setScene(registerScene);
    }

    // ____________________________________________________

    public void loadUserData(){

        userdata = io.readData("src/main/java/data/userData.csv");

        for (String s : userdata){

            String[] values = s.split(", ");
            String valuesUsername = values[0].trim();
            String valuesPassword = values[1].trim();
            String valuesEmail = values[2].trim();
            String valuesStatus = values[3].trim();
            String valuesBanned = values[4].trim();

            user = new User(valuesUsername, valuesPassword, valuesEmail, valuesStatus, valuesBanned);
            currentUser.add(user);

        }

    }

    // ____________________________________________________

    public void loginButtonAction(){

        for(User u : currentUser){

            if(getUsername().equals(u.getUsername()) && getPassword().equals(u.getPassword())){
                System.out.println("Success #DEBUG");
            } else {
                System.out.println("Fail #DEBUG");
            }

        }

    }

    // ____________________________________________________

    public String getUsername(){
        this.username = usernameField.getText();
        return this.username;
    }

    // ____________________________________________________

    public String getPassword(){
        this.password = passwordField.getText();
        return this.password;
    }

    // ____________________________________________________

    public Button getLoginButton(){
        return this.loginButton;
    }

    // ____________________________________________________

    public Button getForgotButton(){
        return this.forgotButton;
    }

    // ____________________________________________________

    public Button getRegisterButton(){
        return this.registerButton;
    }

} // Login Class End
