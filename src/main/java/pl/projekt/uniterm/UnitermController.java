package pl.projekt.uniterm;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class UnitermController {

    @FXML
    private ScrollPane mainScrollPane;

    private final QuadCurve quadCurve = new QuadCurve();
    private final Label exp1 = new Label();
    private final Label exp2 = new Label();
    private final Label semicolonHorizontal = new Label();
    private final VBox mainVBox = new VBox(10);
    private final HBox labelBox = new HBox(10);

    @FXML
    protected void onVerticalButtonClick() {
        //AlertBox.display("Podaj wyrażenia", "Proszę podać wyrażenia dla unitermu sekwencjonowania");

        //DialogBox.showInputDialog("Poziomy uniterm sekwencjonowania", "Podaj wyrażenia dla poziomego unitermu sekwencjonowania",exp1,exp2);
    }

    @FXML
    protected  void onCloseMenuButtonClick() {
        Stage stage = (Stage) mainScrollPane.getScene().getWindow();
        stage.close();
    }

    //metoda dodatkowa do zliczania liczby znakow w ciagu znakow
    private int countLetters(String input) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
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

        exp1.setVisible(false);
        exp2.setVisible(false);
        semicolonHorizontal.setVisible(false);

        labelBox.setAlignment(Pos.CENTER);
        labelBox.getChildren().clear();
        labelBox.getChildren().addAll(exp1, semicolonHorizontal, exp2);

        mainVBox.getChildren().clear();
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.getChildren().addAll(quadCurve, labelBox);

        mainScrollPane.setContent(mainVBox);

        DialogBox.showInputDialog("Poziomy uniterm sekwencjonowania", "Podaj wyrażenia dla poziomego unitermu sekwencjonowania",exp1,exp2);
        semicolonHorizontal.setText(";");

        updateQuadCurve();
    }

    private void updateQuadCurve() {


        double unitermMinX = labelBox.localToScene(labelBox.getLayoutBounds()).getMinX();
        double unitermMaxX = labelBox.localToScene(labelBox.getLayoutBounds()).getMaxX();

        double exp1MinX = exp1.localToScene(exp1.getLayoutBounds()).getMinX();
        double exp2MaxX = exp2.localToParent(exp2.getBoundsInLocal()).getMaxX();

        System.out.println( unitermMinX + " " + unitermMaxX + "   hboxy");

        System.out.println(exp1MinX + " " + exp2MaxX + "   expy");

        exp1.setVisible(true);
        exp2.setVisible(true);
        semicolonHorizontal.setVisible(true);

        quadCurve.setVisible(true);
        quadCurve.setStartX(unitermMinX);
        quadCurve.setEndX(unitermMaxX);
        quadCurve.setControlX((unitermMinX + unitermMaxX) / 2);
    }

}