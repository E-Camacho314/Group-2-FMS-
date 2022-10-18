package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SampleController{
	@FXML
	private BorderPane rootPane;
	private ArrayList<Circle> dots;
	private int circleScore;
	
	public void loadHome(ActionEvent event) throws IOException{
		BorderPane pane = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	public void loadCircle(ActionEvent event) throws IOException{
		BorderPane pane = FXMLLoader.load(getClass().getResource("Circle.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	

	public void draw(MouseEvent event)
	{
		circleScore = 0;
		boolean firstClick = true;
		if (firstClick = true) {
			dots = new ArrayList<Circle>();
		}
		if (MouseEvent.MOUSE_CLICKED == event.getEventType() || MouseEvent.MOUSE_DRAGGED == event.getEventType()) {
			if (MouseEvent.MOUSE_CLICKED == event.getEventType() && firstClick == true) {
				firstClick = false;
			}
			Circle dot = new Circle(event.getX(), event.getY(), 2.5, Color.YELLOW);
			dots.add(dot);
			rootPane.getChildren().add(dot);
			firstClick = false;
			System.out.println("clicked/dragged");
		}
		if (firstClick == false && !(MouseEvent.MOUSE_DRAGGED == event.getEventType())){
			System.out.println("finished");
			firstClick = true;
			int total = 0;
			int accurate = 0;
			double distance = 0;
			for (int i = 0; i < dots.size(); i++) {
				Circle c = dots.get(i);
				
				distance = Math.sqrt(Math.pow((double)c.getCenterY()-425, 2) + Math.pow((double)c.getCenterX()-200, 2));
				System.out.print("Distance: " + distance);
				total ++;
				
				if (distance >= 150 && distance >= 160) {
					accurate ++;
				}
				//rootPane.getChildren().remove(c);
			}
			
			if (!(total == 0)) {
				circleScore = (int)(accurate/total)*100;
				System.out.println(circleScore);
			}
		}
	}
}
