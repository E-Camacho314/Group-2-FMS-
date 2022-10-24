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
    @FXML
    private Label timeLbl;
    
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
	
	private static CircleGame cg;
	private static ReactionGame rg;
	private static MatchingGame mg;
	
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
	public void loadReaction(ActionEvent e) throws IOException{
		BorderPane pane = FXMLLoader.load(getClass().getResource("Reaction.fxml"));
		rootPane.getChildren().setAll(pane);
		rg = new ReactionGame(rootPane, b1, b2, b3, b4, b5, b6, b7, b8, b9);
	}
	
	@FXML
	public void loadMatching(ActionEvent e) throws IOException{
		BorderPane pane = FXMLLoader.load(getClass().getResource("Matching.fxml"));
		rootPane.getChildren().setAll(pane);
		mg = new MatchingGame(rootPane);
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
