package application;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleGame {
	private ArrayList<Circle> dots = new ArrayList<Circle>();
	private BorderPane rootPane;
	private boolean finished;
	private double total;
	private double accurate;
	private double distance;
	private double totalScore;
	
	public CircleGame(BorderPane pane) {
		total = 0;
		totalScore = 0;
		accurate = 0;
		distance = 0;
		finished = false;
		rootPane = pane;
	    rootPane.addEventHandler(MouseEvent.ANY, new MouseHandler());
	}
	
	public double getResult() {
		total = 0;
		accurate = 0;
		rootPane.getChildren().removeAll(dots);
		dots.removeAll(dots);
		
		return totalScore;
	}
	
	public void setFinished(boolean state) {
		finished = state;
	}
	
	private class MouseHandler implements EventHandler<MouseEvent>
	{
	   public void handle(MouseEvent event) {
		   if (finished == false) {
				if (MouseEvent.MOUSE_CLICKED == event.getEventType() || MouseEvent.MOUSE_DRAGGED == event.getEventType()) {
					Circle dot = new Circle(event.getX(), event.getY(), 2.5, Color.YELLOW);
					dots.add(dot);
					rootPane.getChildren().add(dot);
				}
				if (MouseEvent.MOUSE_RELEASED == event.getEventType()){
					for (int i = 0; i < dots.size(); i++) {
						Circle c = dots.get(i);
						
						distance = Math.sqrt(Math.pow((double)c.getCenterY()-475, 2) + Math.pow((double)c.getCenterX()-200, 2));
						total ++;
						
						if (distance >= 150 && distance <= 160) { //difficulty can change based on leniency of distance
							accurate ++;
						}
					}
					totalScore = (accurate/total)*100;
				}
		   }
	   }
	}
}