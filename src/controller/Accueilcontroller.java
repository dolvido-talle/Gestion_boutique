package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Accueilcontroller implements Initializable {


    @FXML
    private AnchorPane AP;
    @FXML
    private Button Gcl;

    @FXML
    private Button Gcommand;

    
    

    @FXML
    private Button Gp;
	
	  @FXML
	    void ConexIionCLIENT(ActionEvent event) throws IOException {
		  Gcl.getScene().getWindow().hide();
	    	Stage stage= new Stage();// stage permet de creer une fenetre
			
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/Gestionclientview.fxml"));
		Parent	main1=loader.load();
			
			Scene scene= new Scene(main1);
			stage.setScene(scene);
			stage.show();
			stage.setResizable(false);
	    }

	    @FXML
	    void ConnexionCommande(ActionEvent event) throws IOException {
	    	  Gcommand.getScene().getWindow().hide();
		    	Stage stage= new Stage();// stage permet de creer une fenetre
				
				FXMLLoader loader= new FXMLLoader();
				loader.setLocation(getClass().getResource("/view/Gestioncommandeview.fxml"));
			Parent	main1=loader.load();
				
				Scene scene= new Scene(main1);
				stage.setScene(scene);
				stage.show();
				stage.setResizable(false);
	    }

	   

	    @FXML
	    void ConnexionPRODUIT(ActionEvent event) throws IOException {
	    	  Gp.getScene().getWindow().hide();
		    	Stage stage= new Stage();// stage permet de creer une fenetre
				
				FXMLLoader loader= new FXMLLoader();
				loader.setLocation(getClass().getResource("/view/Gestionproduitview.fxml"));
			Parent	main1=loader.load();
				
				Scene scene= new Scene(main1);
				stage.setScene(scene);
				stage.show();
				stage.setResizable(false);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
