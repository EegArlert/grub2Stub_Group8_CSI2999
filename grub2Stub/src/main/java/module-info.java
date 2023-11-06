module com.example.grub2stub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.grub2stub to javafx.fxml;
    exports com.example.grub2stub;
}