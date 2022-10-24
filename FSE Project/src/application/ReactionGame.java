package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class ReactionGame {
	private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private BorderPane rootPane;
	
	public ReactionGame(BorderPane pane, Button _b1, Button _b2, Button _b3, Button _b4, Button _b5, Button _b6, Button _b7, Button _b8, Button _b9) {
		rootPane = pane;
		b1 = _b1;
		b2 = _b2;
		b3 = _b3;
		b4 = _b4;
		b5 = _b5;
		b6 = _b6;
		b7 = _b7;
		b8 = _b8;
		b9 = _b9;
		ButtonHandler bh = new ButtonHandler();
		
		b1.setOnAction(bh);
		b2.setOnAction(bh);
		b3.setOnAction(bh);
		b4.setOnAction(bh);
		b5.setOnAction(bh);
		b6.setOnAction(bh);
		b7.setOnAction(bh);
		b8.setOnAction(bh);
		b9.setOnAction(bh);
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			System.out.println("pressed");
		}
	}
}
