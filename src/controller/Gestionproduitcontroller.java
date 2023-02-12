package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import DAO.GestionproduitDAO;
import Model.Produit;
import application.connexionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Gestionproduitcontroller implements Initializable {
	   @FXML
	    private TextField txtmodel2;
	   
	   @FXML
	    private TextField a;
	    
	    @FXML
	    private TextField txtqa2;
	    
	    

	    @FXML
	    private TextField txtre2;

	    @FXML
	    private TextField txtpri2;

	    @FXML
	    private TextField txttail2;

	    @FXML
	    private TextField txttva2;
	    @FXML
	    private TextField txtcolor2;


	    @FXML
	    private JFXButton enregistrer;

	   
	    @FXML
	    private JFXButton select;

	    @FXML
	    private JFXButton affich;

	    @FXML
	    private JFXButton modifi;
	    @FXML
	    private JFXButton rt;


	    @FXML
	    private TableView<Produit> tablecom;

	    @FXML
	    private TableColumn<Produit, Integer> idttbcom;

	    @FXML
	    private TableColumn<Produit, String> desitb;

	    @FXML
	    private TableColumn<Produit, Integer> prixtb;

	    @FXML
	    private TableColumn<Produit, Double> tvatb;

	    @FXML
	    private TableColumn<Produit, Integer> tailTB;

	    @FXML
	    private TableColumn<Produit, String> coulTB;

	    @FXML
	    private TableColumn<Produit, String> modelTB;

	    @FXML
	    private TableColumn<Produit, Integer> quantb;

	    @FXML
	    void Affiche() throws SQLException {
	    	
	    	
	    	ObservableList<Produit> liste=FXCollections.observableArrayList();
	    	Connection con = connexionDB.connect();
			
			String sql = "SELECT * FROM produit";
	    	
	    	Statement stat=null;
	    	ResultSet rs=null;
	    	
	    	try {
	    		
				 stat =con.createStatement();
				
				 rs = stat.executeQuery(sql);
				while(rs.next()) {
					
				Produit pr=new Produit(rs.getInt("idproduit"),rs.getString("designation"), rs.getString("modele"),rs.getInt("taille"),rs.getString("couleur"),rs.getInt("quantitées"),rs.getInt("prixachat"),rs.getDouble("tva"));
				liste.add(pr);
				}
				
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
	    	
	    	
	    	
	    	idttbcom.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("idproduit"));
	    	desitb.setCellValueFactory(new PropertyValueFactory<Produit,String>("designation"));
	    	prixtb.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("prixachat"));
	    	tvatb.setCellValueFactory(new PropertyValueFactory<Produit,Double>("tva"));
	    	tailTB.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("taille"));
	    	coulTB.setCellValueFactory(new PropertyValueFactory<Produit,String>("couleur"));
	    	modelTB.setCellValueFactory(new PropertyValueFactory<Produit,String>("modele"));
	    	quantb.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("quantitées"));
	    	tablecom.setItems(liste);
	 	    
	    	
	    	
	    	

	    }

	    @FXML
	    void Enregistre(ActionEvent event) throws SQLException {
	    	 String sql= "INSERT INTO produit VALUES("+txtre2.getText()+",'"+a.getText()+"','"+txtmodel2.getText()+"',"+txttail2.getText()+",'"+txtcolor2.getText()+"',"+txtqa2.getText()+","+txtpri2.getText()+","+txttva2.getText()+")";	
	     	executeQuery(sql);
	     	Produit pro = new Produit();
	     	
	     	
	     	
	     	vider();
	     	
	     
	     	
	     	
	     	int status =GestionproduitDAO.enregistrer(pro);
	     	
	     	if(status>0) {
	     		
	     		Alert alert= new Alert(AlertType.INFORMATION);
	     		alert.setTitle("Information");
	     		alert.setHeaderText("Enregistrement");
	     		alert.setContentText("produit non ajouté");
	     		alert.showAndWait();
	     		
	     		
	   
	         	
	         	 
	         	 
	         	 
	     		
	     	}else {
	     		
	     		Alert alert= new Alert(AlertType.INFORMATION);
	     		alert.setTitle("Information");
	     		alert.setHeaderText("Enregistrement");
	     		alert.setContentText("produit  ajouté");
	     		alert.showAndWait();	
	     		

	     		
	     	    txtre2.clear();
	         	
	         	txtmodel2.clear();
	         	txttail2.clear();
	         	txtcolor2.clear();
	         	txtqa2.clear();
	         	txtpri2.clear();
	         	txttva2.clear();
	         	a.clear();
	     		
	     	} 	

	    }
	    
	    public void vider() {     	
         	
     	    txtre2.clear();
         	
         	txtmodel2.clear();
         	txttail2.clear();
         	txtcolor2.clear();
         	txtqa2.clear();
         	txtpri2.clear();
         	txttva2.clear();
         	a.clear();
         	
    } 	

	    private void executeQuery(String sql) throws SQLException {
			// TODO Auto-generated method stub
	    	Connection con = connexionDB.connect();
			
			
	    	
	    	Statement stat;
	    	try {
	    		stat=con.createStatement();
	    		stat.executeUpdate(sql);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
			
		}

		@FXML
	    void Modifie(ActionEvent event) throws SQLException {
			 String sql= " UPDATE produit SET designation='"+a.getText()+"',modele='"+txtmodel2.getText()+"',taille="+txttail2.getText()+",couleur='"+txtcolor2.getText()+"',quantitées="+txtqa2.getText()+",prixachat="+txtpri2.getText()+",tva="+txttva2.getText()+" WHERE idproduit="+txtre2.getText()+"";	
		     	executeQuery(sql);
		    	Affiche();

	     	    txtre2.clear();
	         	a.clear();
	         	txtmodel2.clear();
	         	txttail2.clear();
	         	txtcolor2.clear();
	         	txtqa2.clear();
	         	txtpri2.clear();
	         	txttva2.clear();

	    }

	    @FXML
	    void Selection(ActionEvent event) {
	    	Produit pr=tablecom.getSelectionModel().getSelectedItem();
	    	
	    	txtre2.setText(""+pr.getIdproduit());
	    	txtmodel2.setText(pr.getModele());
	    	txttail2.setText(""+pr.getTaille());
	    	txtcolor2.setText(pr.getCouleur());
	    	txtqa2.setText(""+pr.getQuantitées());
	    	txtpri2.setText(""+pr.getPrixachat());
	    	txttva2.setText(""+pr.getTva());
	    	
	    	a.setText(pr.getDesignation());
	    	

	    }

	    @FXML
	    void retour(ActionEvent event) throws IOException {
	    	 rt.getScene().getWindow().hide();
		    	Stage stage= new Stage();
				
				FXMLLoader loader= new FXMLLoader();
				loader.setLocation(getClass().getResource("/view/Accueilview.fxml"));
			Parent	main1=loader.load();
				
				Scene scene= new Scene(main1);
				stage.setScene(scene);
				stage.show(); 

	    }
	    
	    @FXML
	    void suppimer(ActionEvent event) throws SQLException {
	    	String sql ="DELETE FROM produit WHERE idproduit="+txtre2.getText()+"";
	    	executeQuery(sql);
	    	tablecom.getItems().clear();
	    	Affiche();

     	    txtre2.clear();
            
         	txtmodel2.clear();
         	txttail2.clear();
         	txtcolor2.clear();
         	txtqa2.clear();
         	txtpri2.clear();
         	txttva2.clear();
         	a.clear();
	    }
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
