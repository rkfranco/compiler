module com.example.testefavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testefavafx to javafx.fxml;
    exports com.example.testefavafx;
}