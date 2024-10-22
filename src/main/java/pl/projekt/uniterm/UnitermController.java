package pl.projekt.uniterm;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.QuadCurve;

public class UnitermController {

    @FXML
    private ScrollPane mainScrollPane;

    private QuadCurve quadCurve = new QuadCurve();
    private Label exp1 = new Label();
    private Label exp2 = new Label();
    private Label semicolonHorizontal = new Label();
    private VBox mainVBox = new VBox(10);
    private HBox labelBox = new HBox(10);

    @FXML
    protected void onHorizontalButtonClick() {

        String text1 = "wyrazenie 1 11111435345323233333323232323232332";
        String text2 = "wyrazenie 2 323445232332323213231231231231235435345345345345";

        //exp1.setText(text1);
        //exp2.setText(text2);

        int count1 = countLetters(text1);
        int count2 = countLetters(text2);

        if(count1 > count2) {
            //quadCurve.setStartX(count1 * (-35));
            //quadCurve.setEndX(count1 * 35);
            //semicolonHorizontal.setLayoutX(count1 * 10);
        } else {
            //quadCurve.setStartX(count2 * (-35));
            //quadCurve.setEndX(count2 * 35);
            //semicolonHorizontal.setLayoutX(count2 * 10);
        }

        //textFlow.setLayoutX(quadCurve.getStartX() + quadCurve.getLayoutX());
        //textFlow.setMinWidth(Math.abs(quadCurve.getStartX()) + Math.abs(quadCurve.getEndX()));

        //Exp1.setLayoutX(quadCurve.getStartX() + count1 * 10);
        //Exp2.setLayoutX(quadCurve.getEndX() - count2 * 10);

        //exp1.setVisible(true);
        //exp2.setVisible(true);
    }

    @FXML
    protected void onVerticalButtonClick() {
        //AlertBox.display("Podaj wyrażenia", "Proszę podać wyrażenia dla unitermu sekwencjonowania");

        //DialogBox.showInputDialog("Poziomy uniterm sekwencjonowania", "Podaj wyrażenia dla poziomego unitermu sekwencjonowania",exp1,exp2);
    }

    @FXML
    protected  void onCloseMenuButtonClick() {
        //Stage stage = (Stage) quadCurve.getScene().getWindow();
        //stage.close();
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

    public void probaMikrofonu() {

        quadCurve.setLayoutX(0);
        quadCurve.setLayoutY(0);
        quadCurve.setStartY(0);
        quadCurve.setEndY(0);
        quadCurve.setControlY(-50);
        quadCurve.setControlX(0);
        quadCurve.setFill(null);
        quadCurve.setStroke(Color.BLACK);
        quadCurve.setStrokeWidth(1);

        semicolonHorizontal.setText(";");

        labelBox.setAlignment(Pos.CENTER);
        labelBox.getChildren().addAll(exp1, semicolonHorizontal, exp2);

        mainVBox.getChildren().clear();
        mainVBox.setAlignment(Pos.CENTER);
        mainVBox.getChildren().addAll(quadCurve, labelBox);

        mainScrollPane.setContent(mainVBox);

        updateQuadCurve();
    }

    private void updateQuadCurve() {

        DialogBox.showInputDialog("Poziomy uniterm sekwencjonowania", "Podaj wyrażenia dla poziomego unitermu sekwencjonowania",exp1,exp2);

        double exp1CenterX = exp1.localToScene(exp1.getBoundsInLocal()).getMinX() + exp1.getWidth() / 2;
        double exp2CenterX = exp2.localToScene(exp2.getBoundsInLocal()).getMinX() + exp2.getWidth() / 2;

        System.out.println(exp1CenterX + " " + exp2CenterX);

        quadCurve.setStartX(-exp1CenterX);
        quadCurve.setEndX(exp2CenterX);
        quadCurve.setControlX((exp1CenterX + exp2CenterX) / 2);
    }

}