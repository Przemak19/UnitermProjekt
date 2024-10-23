package pl.projekt.uniterm;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class UnitermController {

    @FXML
    private ScrollPane mainScrollPane;

    private final VBox mainVBox = new VBox(10);

    private final VBox sequencingVBox = new VBox(1);

    private final QuadCurve sequencingQuadCurve = new QuadCurve();

    private final HBox sequencingHBox = new HBox(10);

    private final Pane firstSequencingPane = new Pane();
    private final Label semicolonSequencingLabel = new Label(";");
    private final Pane secondSequencingPane = new Pane();

    private final Label firstSequencingExpression = new Label();
    private final Label secondSequencingExpression = new Label();

    private final HBox parallelingHBox = new HBox(5);

    private final VBox parallelingLineVBox = new VBox(0);

    private final Line parallelingLine = new Line();
    private final Line parallelingLine1 = new Line();
    private final Line parallelingLine2 = new Line();

    private final VBox parallelingVBox = new VBox(10);

    private final Pane firstParallelingPane = new Pane();
    private final Label semicolonParallelingLabel = new Label(";");
    private final Pane secondParallelingPane = new Pane();

    private final Label firstParallelingExpression = new Label();
    private final Label secondParallelingExpression = new Label();

    @FXML
    private void initialize() {

        sequencingQuadCurve.setControlY(-50);
        sequencingQuadCurve.setFill(null);
        sequencingQuadCurve.setStroke(Color.BLACK);
        sequencingQuadCurve.setStrokeWidth(1);

        parallelingLine.setStrokeWidth(1);
        parallelingLine.setStroke(Color.BLACK);

        parallelingLine1.setStrokeWidth(1);
        parallelingLine1.setStroke(Color.BLACK);

        parallelingLine2.setStrokeWidth(1);
        parallelingLine2.setStroke(Color.BLACK);

        firstSequencingPane.getChildren().add(firstSequencingExpression);
        secondSequencingPane.getChildren().add(secondSequencingExpression);

        sequencingHBox.getChildren().addAll(firstSequencingPane, semicolonSequencingLabel, secondSequencingPane);

        parallelingLineVBox.getChildren().addAll(parallelingLine1, parallelingLine, parallelingLine2);

        firstParallelingPane.getChildren().add(firstParallelingExpression);
        secondParallelingPane.getChildren().add(secondParallelingExpression);

        parallelingVBox.getChildren().addAll(firstParallelingPane, semicolonParallelingLabel, secondParallelingPane);

        mainVBox.setFillWidth(false);
        mainVBox.getChildren().clear();
        mainVBox.setAlignment(Pos.TOP_CENTER);

        sequencingVBox.setFillWidth(false);
        sequencingVBox.getChildren().addAll(sequencingQuadCurve, sequencingHBox);

        parallelingHBox.setFillHeight(false);
        parallelingHBox.getChildren().addAll(parallelingLineVBox, parallelingVBox);

        mainVBox.getChildren().addAll(sequencingVBox, parallelingHBox);

        mainScrollPane.setContent(mainVBox);

        parallelingHBox.setVisible(false);
        sequencingVBox.setVisible(false);
    }

    @FXML
    protected void onVerticalButtonClick() {
        parallelingHBox.setVisible(false);

        DialogBox.showInputDialog("Pionowa operacja zrównoleglenia", "Podaj wyrażenia dla pionowej operacji zrównoleglenia",
                firstParallelingExpression, secondParallelingExpression);

        parallelingVBox.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {

            double parallelingMinY = parallelingVBox.localToScene(0, 0).getY();
            System.out.println(parallelingMinY);

            double parallelingMaxY = parallelingVBox.localToScene(0, parallelingVBox.getHeight()).getY();
            System.out.println(parallelingMaxY);

            parallelingHBox.setVisible(true);
            parallelingLine.setStartY(parallelingMinY);
            parallelingLine.setEndY(parallelingMaxY);
        });
    }

    @FXML
    protected void onHorizontalButtonClick() {

        sequencingVBox.setVisible(false);

        DialogBox.showInputDialog("Pozioma operacja sekwencjonowania", "Podaj wyrażenia dla poziomej operacji sekwencjonowania",
                firstSequencingExpression, secondSequencingExpression);

        sequencingHBox.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {

            double sequencingMinX = sequencingHBox.localToScene(0, 0).getX();
            System.out.println(sequencingMinX);

            double sequencingMaxX = sequencingHBox.localToScene(sequencingHBox.getWidth(), 0).getX();
            System.out.println(sequencingMaxX);

            sequencingVBox.setVisible(true);
            sequencingQuadCurve.setStartX(sequencingMinX);
            sequencingQuadCurve.setEndX(sequencingMaxX);

            sequencingQuadCurve.setControlX((sequencingMinX + sequencingMaxX) / 2);
        });
    }

    @FXML
    protected  void onCloseMenuButtonClick() {
        Stage stage = (Stage) mainScrollPane.getScene().getWindow();
        stage.close();
    }

}