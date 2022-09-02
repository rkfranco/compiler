module com.example.testefavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.fxmisc.richtext;
    requires org.fxmisc.flowless;
    requires reactfx;


    opens br.com.furb.compilador to javafx.fxml;
    exports br.com.furb.compilador;
}