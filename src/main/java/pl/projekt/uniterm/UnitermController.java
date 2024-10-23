package pl.projekt.uniterm;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class UnitermController {

    @FXML
    private ScrollPane mainScrollPane;

    private final QuadCurve quadCurve = new QuadCurve();
    private final VBox mainVBox = new VBox(10);

    private final Label unitemExpressions = new Label();

    @FXML
    protected void onVerticalButtonClick() {

    }

    @FXML
    protected  void onCloseMenuButtonClick() {
        Stage stage = (Stage) mainScrollPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onHorizontalButtonClick() {

        quadCurve.setVisible(false);
        quadCurve.setLayoutX(0);
        quadCurve.setLayoutY(0);
        quadCurve.setStartY(0);
        quadCurve.setEndY(0);
        quadCurve.setControlY(-50);
        quadCurve.setControlX(0);
        quadCurve.setFill(null);
        quadCurve.setStroke(Color.BLACK);
        quadCurve.setStrokeWidth(1);

        mainVBox.setFillWidth(false);
        mainVBox.getChildren().clear();
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.getChildren().addAll(quadCurve, unitemExpressions);

        mainScrollPane.setContent(mainVBox);

        DialogBox.showInputDialog("Poziomy uniterm sekwencjonowania", "Podaj wyrażenia dla poziomego unitermu sekwencjonowania",unitemExpressions);

        unitemExpressions.layoutBoundsProperty().addListener((observable, oldValue, newValue) ->
                {
                    double unitermMinX = unitemExpressions.localToScene(0, 0).getX();
                    System.out.println(unitermMinX);

                    double unitermMaxX = unitemExpressions.localToScene(unitemExpressions.getWidth(), 0).getX();
                    System.out.println(unitermMaxX);

                    quadCurve.setVisible(true);
                    quadCurve.setStartX(unitermMinX);
                    quadCurve.setEndX(unitermMaxX);

                    quadCurve.setControlX((unitermMinX + unitermMaxX) / 2);
                }
        );
    }

}