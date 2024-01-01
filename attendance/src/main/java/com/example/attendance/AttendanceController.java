package com.example.attendance;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

public class AttendanceController implements Initializable {
    public RadioButton login_time;
    public RadioButton logout_time;
    public Label lable;
    public Pane att;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void submit(ActionEvent event) throws IOException {
        if (login_time.isSelected()) {
            try {
                Connection con = DB.getCon();
                String q = "insert into att(date,login_time,present) values(?,?,?)";
                String d = new SimpleDateFormat("dd-MM-yy").format(Calendar.getInstance().getTime());
                String time = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                String present = "P";

                PreparedStatement ps = con.prepareCall(q);
                ps.setString(1, d);
                ps.setString(2, time);
                ps.setString(3, present);
                ps.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Attendance");
                alert.setContentText("Present");
                alert.setHeaderText("Today is attendance");
                alert.show();


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (logout_time.isSelected()) {
            try {

                String d = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
                Connection con = DB.getCon();
                String q = "insert into att(logout_time) values(?)";

                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1, String.valueOf(d));
                ps.executeUpdate();

                Pane go_login = FXMLLoader.load(getClass().getResource("login.fxml"));
                att.getChildren().setAll(go_login);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
