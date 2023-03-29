module com.example.poointerfaz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.poointerfaz to javafx.fxml;
    exports com.example.poointerfaz;
}