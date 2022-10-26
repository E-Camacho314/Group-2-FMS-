package application;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

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
    private Label scoreLbl;

	@FXML
	private Label timeLbl;
    
    @FXML 
    private Button B1, B2, B3, B4, B5, B6, B7, B8, B9, startRG;
	
    private long startTime, reactionTime;
    private int randomNum;
	private static CircleGame cg;
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
		
	public void rgHandler(ActionEvent e) {
		if (e.getSource().equals(B1) && randomNum == 1) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
		}
		else if (e.getSource().equals(B2) && randomNum == 2) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
		}
		else if (e.getSource().equals(B3) && randomNum == 3) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
		}
		else if (e.getSource().equals(B4) && randomNum == 4) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
		}
		else if (e.getSource().equals(B5) && randomNum == 5) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
		}
		else if (e.getSource().equals(B6) && randomNum == 6) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
		}
		else if (e.getSource().equals(B7) && randomNum == 7) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
		}
		else if (e.getSource().equals(B8) && randomNum == 8) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
		}
		else if (e.getSource().equals(B9) && randomNum == 9) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
		}
		else {
			timeLbl.setText("Incorrect - Try Again!");
		}
		
		if (e.getSource().equals(B5) && B5.getText().equals("CLICK TO START")) {
			startTime = System.currentTimeMillis();
			B5.setText("");
			randomNum =  ThreadLocalRandom.current().nextInt(1, 10); //Random int 1-9
			switch(randomNum) {
				case 1:
					timeLbl.setText("Pick the BLACK Button");
					break;
				case 2:
					timeLbl.setText("Pick the GREEN Button");
					break;
				case 3:
					timeLbl.setText("Pick the BLUE Button");
					break;
				case 4:
					timeLbl.setText("Pick the PURPLE Button");
					break;
				case 5:
					timeLbl.setText("Pick the WHITE Button");
					break;
				case 6:
					timeLbl.setText("Pick the RED Button");
					break;
				case 7:
					timeLbl.setText("Pick the YELLOW Button");
					break;
				case 8:
					timeLbl.setText("Pick the BROWN Button");
					break;
				case 9:
					timeLbl.setText("Pick the ORANGE Button");
					break;
			}
		}
	}
}
