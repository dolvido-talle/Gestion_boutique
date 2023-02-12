package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.connexionDB;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class connexioncontroller implements Initializable {
	
	
	
	
	
	
	
	 
		// @FXML ;cest un mot cle permettant de lier un composant graphique a la classe controller
		 @FXML
		private TextField login;

		    @FXML
		    private Label etat;

		    @FXML
		    private Button conecter;

		    @FXML
		    private PasswordField password;

		   
		    
		    
		    @FXML
		    void connexion(ActionEvent event) throws SQLException {

	  Connection conn=connexionDB.connect();
		    	
		    	PreparedStatement stat=null;// objet qui transforme la requete en sqlvgrace a preparedstatement
		    	ResultSet rs=null;//resulset permet de creer une table permettant de stoquer le resultat de la table
		    	String sql="SELECT * FROM user WHERE login= ? AND password= ?";
		    	
		    		try {
		    			
		    			
		    			stat=conn.prepareStatement(sql);
		    			stat.setString(1,login.getText().toString());
		    			stat.setString(2, password.getText().toString());
		    			
		    			rs=stat.executeQuery();// executeQuery execute les taches commencant pas SELECT
	                                           // executeUpdate pour les taches commencant par DELETE, RESET,UPDATE	    			
		    			if(rs.next()) {// boucle qui verifie si rs est vide ou pas
		    				
		    				etat.setText("connecté!");//setText ajoute un text si cest pas vide
		    				
		    				
		    				 conecter.getScene().getWindow().hide();// cacher une fenetre// devant pour afficher connecter
		    				Stage stage= new Stage();// pour creer une fenetre
		    				
		    				FXMLLoader loader= new FXMLLoader();
		    				loader.setLocation(getClass().getResource("/view/Accueilview.fxml"));
		    			Parent	main=loader.load();
		    				
		    				Scene scene= new Scene(main);
		    				stage.setScene(scene);
		    				stage.show();
		    				
		    				
		    				
		    				
		    				

		    				//connexion.getScene().getWindow().hide();
		    				
		    				
		    			}else {
		    				etat.setText("non connecté!");
		    				
		    				
		    				Alert alert= new Alert(AlertType.ERROR);// alert permet de gerer une boite de dialogue de type ERROR
		    				// informations boite de dialogue qui affiche une information
		    				// affiche une confirmation
		    				alert.setTitle("Alert");//setTitle met le titre de la boite
		    				alert.setHeaderText("Erreur");
		    				alert.setContentText("mot de pass ou login incorrect");//setContentText permet de saisi le message
		    				alert.showAndWait();//showAndWait() permet de lancer la boite de dialogue
		    				
		    				
		    			}
		    			
		    			
		    			
		    		}catch (Exception e) {
		    			// TODO: handle exception
		    			
		    		}
		    	


		    	
		    	
		    	
		    }
		
		
		
		
		
		
		
		
		    
		    
		    
		    
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
