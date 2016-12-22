package application;

import business.CalenderController;
import business.Door;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 * 
 * @author Chiara-Marie Zok
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		CalenderController controller = new CalenderController();
		primaryStage.setTitle("Advent Calender");
		try {
			FlowPane root = new FlowPane();
			Scene scene = new Scene(root, 6 * 210, 4 * 110);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(0, 10, 0, 10));

			controller.init("calender.txt");
			Door[] doors = controller.getDoors();
			DoorButton door;
			for (int i = 0; i < doors.length; i++) {
				door = new DoorButton(doors[i]);
				door.setMinSize(200, 100);
				door.setText(Integer.toString(doors[i].getNumber()));

				door.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						DoorButton button = (DoorButton) e.getSource();
						// sees if door is already open
						if (!button.hodor.getOpen()) {
							// sees if door can be opened
							if (controller.open(button.hodor)) {
								button.setText(button.hodor.getMovie() + "\n" + button.hodor.getDirector());
							}
							// if door is open, close it
						} else {
							button.setText(Integer.toString(button.hodor.getNumber()));
							button.hodor.setOpen(false);
						}
					}
				});

				grid.add(door, i % 6, i / 6);

			}
			// adds grid pane to root
			root.getChildren().add(grid);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
