package pl.projekt.uniterm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UnitermApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        DatabaseConnection databaseConnection = new DatabaseConnection();

        FXMLLoader fxmlLoader = new FXMLLoader(UnitermApplication.class.getResource("uniterm-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        stage.setTitle("Uniterm");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}