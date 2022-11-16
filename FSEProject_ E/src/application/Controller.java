package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

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
    private ArrayList<Button> mgButtons, matchTestArray;
    private long startTime, reactionTime;
    private int randomNum, randomButton, cardsFlipped, matched;
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
	
	public void MatchingGame(ActionEvent e) throws InterruptedException {
		if (startMG.getText().equals("CLICK TO RANDOMIZE CARDS")) {
			MatchingGameButton(e);
			matchTestArray = new ArrayList<Button>();
			cardsFlipped = 0;
			matched = 0;
		}
		else if (startMG.getText().equals("CLICK TO BEGIN MATCHING")) {
			System.out.println("start");
			startTime = System.currentTimeMillis();
			
			M1.setStyle("-fx-text-fill: transparent");
			M2.setStyle("-fx-text-fill: transparent");
			M3.setStyle("-fx-text-fill: transparent");
			M4.setStyle("-fx-text-fill: transparent");
			M5.setStyle("-fx-text-fill: transparent");
			M6.setStyle("-fx-text-fill: transparent");
			M7.setStyle("-fx-text-fill: transparent");
			M8.setStyle("-fx-text-fill: transparent");
			M9.setStyle("-fx-text-fill: transparent");
			M10.setStyle("-fx-text-fill: transparent");
			M11.setStyle("-fx-text-fill: transparent");
			M12.setStyle("-fx-text-fill: transparent");
			M13.setStyle("-fx-text-fill: transparent");
			M14.setStyle("-fx-text-fill: transparent");
			M15.setStyle("-fx-text-fill: transparent");
			M16.setStyle("-fx-text-fill: transparent");
			startMG.setText("GAME IN PROGRESS...");
		}
	}
	
	public void MatchingGameButton(ActionEvent e) throws InterruptedException {
		if (startMG.getText().equals("CLICK TO RANDOMIZE CARDS")) {
			mgButtons = new ArrayList<Button>(List.of(M1, M2, M3, M4, M5, M6, M7, M8, M9, M10, M11, M12, M13, M14, M15, M16)); //intialize arraylist of buttons
			//Randomize position of buttons/pairs of buttons
			for (int i = 0; i < 8; i++) {
				randomButton =  ThreadLocalRandom.current().nextInt(0, mgButtons.size()); //Random 0-16
				mgButtons.get(randomButton).setText(shapes[i]);
				mgButtons.remove(randomButton);
				randomButton =  ThreadLocalRandom.current().nextInt(0, mgButtons.size()); //Random 0-15
				mgButtons.get(randomButton).setText(shapes[i]);
				mgButtons.remove(randomButton);
			}
			startMG.setText("CLICK TO BEGIN MATCHING");
		}
		
		if (e.getSource().equals(M1)) {
			M1.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M1);
		}
		if (e.getSource().equals(M2)) {
			M2.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M2);
		}
		if (e.getSource().equals(M3)) {
			M3.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M3);
		}
		if (e.getSource().equals(M4)) {
			M4.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M4);
		}
		if (e.getSource().equals(M5)) {
			M5.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M5);
		}
		if (e.getSource().equals(M6)) {
			M6.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M6);
		}
		if (e.getSource().equals(M7)) {
			M7.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M7);
		}
		if (e.getSource().equals(M8)) {
			M8.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M8);
		}
		if (e.getSource().equals(M9)) {
			M9.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M9);
		}
		if (e.getSource().equals(M10)) {
			M10.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M10);
		}
		if (e.getSource().equals(M11)) {
			M11.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M11);
		}
		if (e.getSource().equals(M12)) {
			M12.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M12);
		}
		if (e.getSource().equals(M13)) {
			M13.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M13);
		}
		if (e.getSource().equals(M14)) {
			M14.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M14);
		}
		if (e.getSource().equals(M15)) {
			M15.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M15);
		}
		if (e.getSource().equals(M16)) {
			M16.setStyle("-fx-text-fill: black");
			cardsFlipped += 1;
			matchTestArray.add(M16);
		}
		
		//Check if matching or not
		if (cardsFlipped == 2 && matchTestArray.get(0).getText().equals(matchTestArray.get(1).getText())) {
			cardsFlipped = 0;
			matched += 1;
			matchTestArray.get(1).setOnAction(null);
			matchTestArray.get(0).setOnAction(null);
			matchTestArray.remove(1);
			matchTestArray.remove(0);
		}
		else if (cardsFlipped == 2) {
			KeyFrame k01 = new KeyFrame(Duration.seconds(0), new KeyValue(matchTestArray.get(0).styleProperty(), "-fx-text-fill: black"));
			KeyFrame k02 = new KeyFrame(Duration.seconds(1), new KeyValue(matchTestArray.get(0).styleProperty(), "-fx-text-fill: transparent"));
			KeyFrame k11 = new KeyFrame(Duration.seconds(0), new KeyValue(matchTestArray.get(1).styleProperty(), "-fx-text-fill: black"));
			KeyFrame k12 = new KeyFrame(Duration.seconds(1), new KeyValue(matchTestArray.get(1).styleProperty(), "-fx-text-fill: transparent"));
			
			Timeline anim0 = new Timeline(k01, k02);
			Timeline anim1 = new Timeline(k11, k12);
			anim0.play();
			anim1.play();
			
			cardsFlipped = 0;
			matchTestArray.remove(1);
			matchTestArray.remove(0);
		}
		
		//Check completion
		if (matched == 8) {
			reactionTime = System.currentTimeMillis() - startTime;
			startMG.setText("COMPLETE: " + (reactionTime/1000) + "s");
		}
	}
}