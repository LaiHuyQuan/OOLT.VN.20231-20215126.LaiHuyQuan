package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    private RadioButton rButton1, rButton2;
    private boolean isPenMode = false;


    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle circle;
        if (isPenMode) {
            circle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        } else {
            circle = new Circle(event.getX(), event.getY(), 10, drawingAreaPane.getBackground().getFills().getFirst().getFill());
        }
        drawingAreaPane.getChildren().add(circle);
    }


    public void Draw(ActionEvent event) {
        if (rButton1.isSelected()) {
            isPenMode = true;
        }
    }

    public void Erase(ActionEvent event) {
        if (rButton2.isSelected()) {
            isPenMode = false;
        }
    }
}
