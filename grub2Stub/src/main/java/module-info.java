module com.example.grub2stub {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.grub2stub to javafx.fxml;
    exports com.example.grub2stub;
}