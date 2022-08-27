module com.example.testefavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.furb.compilador to javafx.fxml;
    exports br.com.furb.compilador;
}