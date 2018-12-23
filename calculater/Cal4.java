package calculater;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Cal4 extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		WebOfStandard web1 = new WebOfStandard();
		Scene scene = new Scene(web1.getScene(),300,400);
		
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Calculater 5.0");
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/cal5.jpg")));
		primaryStage.show();
	}
}
