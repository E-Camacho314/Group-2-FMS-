package application;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
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
    private Button B1, B2, B3, B4, B5, B6, B7, B8, B9;
    
    @FXML
    private Button M1, M2, M3, M4, M5, M6, M7, M8, M9, M10, M11, M12, M13, M14, M15, M16;
    
    @FXML
    private Button startRG, finishCG, startMG;
	
    private String[] shapes = {"▲", "■", "▰", "◆", "◕", "◍", "▬", "▼"};
    private long startTime, reactionTime;
    private int randomNum;
    private boolean endRG;
	private static CircleGame cg;
	
	
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
		endRG = false;
	}
	
	public void loadMatching(ActionEvent e) throws IOException{
		BorderPane pane = FXMLLoader.load(getClass().getResource("Matching.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public void endCG (ActionEvent e) {
		if (cg.getResult() >= 75) {
			circle.setFill(Color.GREEN);
			finishCG.setStyle("-fx-background-color:#00FF00");
		}
		else {
			circle.setFill(Color.RED);
			finishCG.setStyle("-fx-background-color:#FF0000");		
		}
		scoreLbl.setText("Score: " + (int)cg.getResult() + "%");
		cg.setFinished(true);
	}
	
	
	
	public void rgHandler(ActionEvent e) {
		if (e.getSource().equals(B1) && randomNum == 1 && endRG == false) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
			endRG = true;
		}
		else if (e.getSource().equals(B2) && randomNum == 2 && endRG == false) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
			endRG = true;
		}
		else if (e.getSource().equals(B3) && randomNum == 3 && endRG == false) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
			endRG = true;
		}
		else if (e.getSource().equals(B4) && randomNum == 4 && endRG == false) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
			endRG = true;
		}
		else if (e.getSource().equals(B5) && randomNum == 5 && endRG == false) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
			endRG = true;
		}
		else if (e.getSource().equals(B6) && randomNum == 6 && endRG == false) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
			endRG = true;
		}
		else if (e.getSource().equals(B7) && randomNum == 7 && endRG == false) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
			endRG = true;
		}
		else if (e.getSource().equals(B8) && randomNum == 8 && endRG == false) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
			endRG = true;
		}
		else if (e.getSource().equals(B9) && randomNum == 9 && endRG == false) {
			reactionTime = System.currentTimeMillis() - startTime;
			timeLbl.setText("Reaction Time: " + reactionTime + "ms");
			endRG = true;
		}
		else {
			if (endRG == false) {
				timeLbl.setText("Incorrect - Try Again!");
			}
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
	
	public void MatchingGame(ActionEvent e) {
		startMG.setText("Game in progress...");
		startMG.setAlignment(Pos.CENTER_LEFT);
		MatchingGameButton(e);
		startMG.setOnAction(null);
	}
	
	public void MatchingGameButton(ActionEvent e) {
		if (startMG.getText().equals("Game in progress...")) {
			randomNum =  ThreadLocalRandom.current().nextInt(0, 8); //Random 0-7
			M1.setText(shapes[randomNum]);
		}
	}
}
