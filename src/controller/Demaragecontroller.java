package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Demaragecontroller implements Initializable {
	
	
	
	
	@FXML
    private AnchorPane anchor;

    @FXML
    private ProgressBar progres;

    @FXML
    private ProgressIndicator indicator;
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub


		Task task= taskWorker(10);
		progres.progressProperty().unbind();
		indicator.progressProperty().unbind();
		progres.progressProperty().bind( task.progressProperty());
        indicator.progressProperty().bind( task.progressProperty());
		task.setOnSucceeded(e->{
			Stage stage = (Stage) anchor.getScene().getWindow();
			stage.close();
			try {
				Parent root=FXMLLoader.load(getClass().getResource("/view/connexionview.fxml"));
				Stage stage2 = new Stage();
				Scene scene = new Scene(root);
				stage2.setScene(scene);
				stage2.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}); 
		Thread thread = new Thread(task);
		thread.start();
		
	}
	
	
	
	private Task<Object> taskWorker(int seconds){
		return new Task<Object>(){
			@Override
			protected Object call() throws Exception{
				for(int  i = 0; i <= seconds; i++){
					updateProgress(i, seconds);
					Thread.sleep(400);
				}
				return true;
			}
		};
	}
	}


