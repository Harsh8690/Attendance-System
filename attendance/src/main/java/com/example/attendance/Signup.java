package com.example.attendance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Signup extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader=new FXMLLoader(getClass().getResource("Signup.fxml"));
        Pane signup=loader.load();
        Scene scene=new Scene(signup);
        Stage primaryStage=new Stage();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Attendance");
        primaryStage.show();
    }
}
