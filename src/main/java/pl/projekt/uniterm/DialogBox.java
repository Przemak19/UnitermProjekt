package pl.projekt.uniterm;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogBox {

    public static void showInputDialog(String title, String message, Label firstUnitermExpression, Label secondUnitermExpression) {

        Stage dialog = new Stage();
        dialog.setTitle(title);
        dialog.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        Label labelMessage = new Label(message);
        labelMessage.setWrapText(true);
        labelMessage.setMaxWidth(380);

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();

        Button confirmButton = new Button("Zatwierdź");

        Button closeButton = new Button("Zamknij");

        confirmButton.setOnAction(e -> {
            String value1 = textField1.getText().trim();
            String value2 = textField2.getText().trim();

            if (!value1.isEmpty() && !value2.isEmpty()) {

                firstUnitermExpression.setText(value1);
                secondUnitermExpression.setText(value2);
                dialog.close();

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Błąd");
                alert.setHeaderText(null);
                alert.setContentText("Oba pola muszą być wypełnione.");
                alert.showAndWait();
            }
        });

        closeButton.setOnAction(e -> dialog.close());

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(confirmButton, closeButton);
        buttonBox.setAlignment(Pos.CENTER);

        grid.add(labelMessage, 0, 0, 2, 1);
        grid.add(new Label("Pole 1:"), 0, 1);
        grid.add(textField1, 1, 1);
        grid.add(new Label("Pole 2:"), 0, 2);
        grid.add(textField2, 1, 2);
        grid.add(buttonBox, 1, 3);

        Scene scene = new Scene(grid, 400, 250);
        dialog.setScene(scene);
        dialog.setResizable(false);
        dialog.showAndWait();
    }
}
