module com.example.examencontactos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.examencontactos to javafx.fxml;
    exports com.example.examencontactos;
}