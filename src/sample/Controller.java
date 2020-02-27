package sample;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Controller {
    public Button reset;
    public Button start;
    public Button end;
    public Button b0;
    public Button b1;
    public Button b2;
    public Button b3;
    public Button b4;
    public Button b5;
    public Button b6;
    public Button b7;
    public Button b8;
    public Button b9;
    public Button b10;
    public Button b11;
    public Button b12;
    public Button b13;
    public Button b14;
    public Button b15;
    private Game game;

    public Controller() {
        game = new Game();
    }

    public void click(ActionEvent actionEvent) {
        int value = Integer.parseInt(((Button)actionEvent.getSource()).getId().substring(((Button)actionEvent.getSource()).getId().lastIndexOf("b")+1));
        System.out.println(value);
        game.move(value);
        if (game.getField()!=null) {
            rePaint();
        }
    }

    private void rePaint(){
        Tile[][] tiles = game.getField().getTiles();

        b0.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        b0.setText(tiles[0][0].isValue()?"X":"O");
        b1.setText(tiles[1][0].isValue()?"X":"O");
        b2.setText(tiles[2][0].isValue()?"X":"O");
        b3.setText(tiles[3][0].isValue()?"X":"O");

        b4.setText(tiles[0][1].isValue()?"X":"O");
        b5.setText(tiles[1][1].isValue()?"X":"O");
        b6.setText(tiles[2][1].isValue()?"X":"O");
        b7.setText(tiles[3][1].isValue()?"X":"O");

        b8.setText(tiles[0][2].isValue()?"X":"O");
        b9.setText(tiles[1][2].isValue()?"X":"O");
        b10.setText(tiles[2][2].isValue()?"X":"O");
        b11.setText(tiles[3][2].isValue()?"X":"O");

        b12.setText(tiles[0][3].isValue()?"X":"O");
        b13.setText(tiles[1][3].isValue()?"X":"O");
        b14.setText(tiles[2][3].isValue()?"X":"O");
        b15.setText(tiles[3][3].isValue()?"X":"O");
    }

    public void reset(ActionEvent actionEvent) {
        game.reset();
        reset.setDisable(true);
        start.setDisable(false);
        end.setDisable(false);
    }

    public void start(ActionEvent actionEvent) {
        game.start();
        start.setDisable(true);
        reset.setDisable(false);
        end.setDisable(false);
    }

    public void end(ActionEvent actionEvent) {
        game.end();
        start.setDisable(false);
        reset.setDisable(false);
        end.setDisable(true);
    }
}
