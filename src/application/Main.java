package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			AnchorPane	p = new AnchorPane();
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Demarageview.fxml"));
			p=loader.load();
	//AnchorPane root=FXMLLoader.load(getClass().getResource("/View/DemarrageView.fxml"));
			Scene scene = new Scene(p);
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
