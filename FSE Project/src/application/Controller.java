package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller {

    @FXML
    private Button finishCircleBtn;

    @FXML
    private Circle circle;

    @FXML
    private BorderPane rootPane;

    @FXML
    private Label scoreLbl;
	
	private static CircleGame cg;
	
	@FXML
	public void loadHome(ActionEvent e) throws IOException{
		BorderPane pane = FXMLLoader.load(getClass().getResource("Home.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	public void loadCircle(ActionEvent e) throws IOException{
		BorderPane pane = FXMLLoader.load(getClass().getResource("Circle.fxml"));
		rootPane.getChildren().setAll(pane);
		cg = new CircleGame(rootPane);
	}
	
	@FXML
	public void circleGame(MouseEvent e) {
		//Prevent some weird error honestly idk
	}
	
	@FXML
	public void endCG (ActionEvent e) {
		if (cg.getResult() >= 75) {
			circle.setFill(Color.GREEN);
		}
		else {
			circle.setFill(Color.RED);
		}
		scoreLbl.setText("Score: " + (int)cg.getResult() + "%");
	}
}
