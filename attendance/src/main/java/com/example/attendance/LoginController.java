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

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField login_user;
    public PasswordField login_pass;
    public HBox login;
    public Label lable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginBtn(ActionEvent event) {

        try {
            Connection con=DB.getCon();
            String q="select * from signup";
            Statement st=con.createStatement();
            ResultSet rs= st.executeQuery(q);
            while (rs.next()){

                String email=rs.getNString(2);
                String pass=rs.getString(3);

                if (login_user.getText().equals(email) && login_pass.getText().equals(pass)){
                    try {
                        Pane Att=FXMLLoader.load(getClass().getResource("Att.fxml"));
                        login.getChildren().setAll(Att);
                    }
                    catch (Exception  e){
                        e.printStackTrace();
                    }
                }
                else {
                    lable.setText("please enter valid username and password");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    public void sign_btn(ActionEvent event) {
        try {
            Pane goSign=FXMLLoader.load(getClass().getResource("Signup.fxml"));
            login.getChildren().setAll(goSign);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
