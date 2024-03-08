module com.renaro {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.renaro to javafx.fxml;
    exports com.renaro;
}
