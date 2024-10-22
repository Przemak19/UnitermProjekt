module pl.projekt.uniterm {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires java.desktop;

    opens pl.projekt.uniterm to javafx.fxml;
    exports pl.projekt.uniterm;
}