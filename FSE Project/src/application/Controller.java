package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller{

    @FXML
    private Circle circle;

    @FXML
    private BorderPane rootPane;
    
    @FXML
    private Label scoreLbl, timeLbl;
    
    @FXML 
    private Button B1, B2, B3, B4, B5, B6, B7, B8, B9, startRG;
	
	private static CircleGame cg;
	private static ReactionGame rg;
	private static MatchingGame mg;
	
	
	public void loadHome(ActionEvent e) throws IOException{
		BorderPane pane = FXMLLoader.load(getClass().getResource("Home.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public void loadCircle(ActionEvent e) throws IOException{
		BorderPane pane = FXMLLoader.load(getClass().getResource("Circle.fxml"));
		rootPane.getChildren().setAll(pane);
		System.out.println(pane.getChildren());
		cg = new CircleGame(rootPane);
	}
	
	public void loadReaction(ActionEvent e) throws IOException{
		BorderPane pane = FXMLLoader.load(getClass().getResource("Reaction.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public void loadMatching(ActionEvent e) throws IOException{
		BorderPane pane = FXMLLoader.load(getClass().getResource("Matching.fxml"));
		rootPane.getChildren().setAll(pane);
		mg = new MatchingGame(rootPane);
	}
	
	public void endCG (ActionEvent e) {
		if (cg.getResult() >= 75) {
			circle.setFill(Color.GREEN);
		}
		else {
			circle.setFill(Color.RED);
		}
		scoreLbl.setText("Score: " + (int)cg.getResult() + "%");
	}
	
	public void startRG(ActionEvent e) {
		//System.out.println(B1 + " " + B2 + " " + timeLbl + " " + B5.getText() + " " + e.getSource() + "\n" + e.getSource().equals(B5) + " " + B5.getText()); DEBUG LINE
		if (e.getSource().equals(B5) && B5.getText().equals("CLICK TO START")) {
			System.out.println("start");
			B5.setText("");
			rg = new ReactionGame(rootPane, B1, B2, B3, B4, B5, B6, B7, B8, B9);
		}
	}
}
