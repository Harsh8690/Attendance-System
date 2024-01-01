module com.example.attendance {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires jakarta.mail;


    opens com.example.attendance to javafx.fxml;
    exports com.example.attendance;
}