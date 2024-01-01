package com.example.attendance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javax.xml.stream.events.StartElement;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    public Pane signup;
    public TextField name;
    public TextField email;
    public PasswordField pass;
    public TextField mobile;
    public TextField address;
    public Label lable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void go_login(ActionEvent event) {
        try {
            HBox go_login= FXMLLoader.load(getClass().getResource("Login.fxml"));
            signup.getChildren().setAll(go_login);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void submit(ActionEvent event) {

        String Name=name.getText();
        String Email=email.getText();
        String Password=pass.getText();
        String Address=address.getText();
        String Mobile=mobile.getText();

        try {
            Connection con= DB.getCon();
            String q="insert into signup(name,email,password,address,phone) values(?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,Name);
            ps.setString(2,Email);
            ps.setString(3,Password);
            ps.setString(4,Address);
            ps.setString(5,Mobile);
            ps.executeUpdate();
            Mail.email("harshdolipal@gmail.com",email.getText(),"Attendance","You are successfully added in attendance system... Thanks !");

            lable.setText("Update Successfully...!");




        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
