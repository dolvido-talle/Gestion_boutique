package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import DAO.GestionclientDAO;
import Model.Client;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class Gestionclientcontroller<JFXTextField> implements Initializable {
	
	
	
	  

    @FXML
    private TableView<Client> tabcl;

    @FXML
    private TableColumn<Client, Integer> Idet;

    @FXML
    private TableColumn<Client, String> namet;

    @FXML
    private TableColumn<Client, String> prenomt;

    @FXML
    private TableColumn<Client, String>adrset;
 
    @FXML
    private TableColumn<Client, String> sexet;

    @FXML
    private TableColumn<Client, Integer> telt;

    @FXML
    private JFXTextField textf;
    @FXML
    private JFXButton text;

    @FXML
    private TextField idclt;

    @FXML
    private TextField nam;
    
    @FXML
    private TextField sex;

    @FXML
    private TextField preno;

    @FXML
    private TextField adr;

    @
    FXML
    private TextField tel;

    @FXML
    private JFXButton rt;
  
    @FXML
    void Affiche() throws SQLException {
    	ObservableList<Client> liste=FXCollections.observableArrayList();
    	Connection con = connexionDB.connect();
		
		String sql = "SELECT * FROM Client";
    	
    	Statement stat=null;
    	ResultSet rs=null;
    	
    	try {
    		
			 stat =con.createStatement();
			
			 rs = stat.executeQuery(sql);
			while(rs.next()) {
				
			Client cl=new Client(rs.getInt("idclient"),rs.getString("nom"), rs.getString("prenom"),rs.getString("sexe"),rs.getInt("tel"),rs.getString("adresse"));
			liste.add(cl);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
    	
    	
    	
    	Idet.setCellValueFactory(new PropertyValueFactory<Client,Integer>("idclient"));
        namet.setCellValueFactory(new PropertyValueFactory<Client,String>("Nom"));
    	prenomt.setCellValueFactory(new PropertyValueFactory<Client,String>("Prenom"));
    	 adrset.setCellValueFactory(new PropertyValueFactory<Client,String>("Adresse"));
    	sexet.setCellValueFactory(new PropertyValueFactory<Client,String>("sexe"));
    	telt.setCellValueFactory(new PropertyValueFactory<Client,Integer>("Tel"));
    	tabcl.setItems(liste);
 	    
   	
  
    	
    	
    
    	
     
     
      
      
    	}

    	
    	
    @FXML
    void Selectioner(ActionEvent event) {
    	Client cl=tabcl.getSelectionModel().getSelectedItem();
    	
    	idclt.setText(""+cl.getIdclient());
    	nam.setText(cl.getNom());
    	preno.setText(cl.getPrenom());
    	sex.setText(cl.getSexe());
    	adr.setText(cl.getAdresse());
    	tel.setText(""+cl.getTel());
    	
    	
    	
    	
    	
    }

    

    @FXML
    void Modifier(ActionEvent event) throws SQLException {
    	
    	 String sql= " UPDATE client SET Nom='"+nam.getText()+"',Prenom='"+preno.getText()+"',Adresse='"+adr.getText()+"',Tel="+tel.getText()+",sexe='"+sex.getText()+"' WHERE idclient="+idclt.getText()+"";	
     	executeQuery(sql);
    	Affiche();
    	
	    idclt.clear();
    	nam.clear();
    	preno.clear();
    	adr.clear();
    	tel.clear();
    	sex.clear();
    	

    }

    @FXML
    void Supprimer(ActionEvent event) throws SQLException {

    	String sql ="DELETE FROM client WHERE idclient="+idclt.getText()+"";
    	executeQuery(sql);
    	tabcl.getItems().clear();
    	Affiche();
    	
	    idclt.clear();
    	nam.clear();
    	preno.clear();
    	adr.clear();
    	tel.clear();
    	sex.clear();
    	
    }

   @FXML
   void recherche() throws SQLException {
//    	
//    	String sql ="SELECT * FROM client WHERE idclient="+idclt.getText()+"?"; 
//    	executeQuery(sql);
//    	
//    	
//   	//String textf=idclt.getText();
//// 	int ide= Integer.parseInt(idclt);
//    	
//  Client etu= GestionclientDAO.rechercheDAO(2id);
//   nam.setText(etu.getNom());
//   preno.setText(etu.getPrenom());
//   adr.setText(etu.getAdresse());
//   sex.setText(etu.getSexe());
//   int telok=etu.getTel();
//
//    TextFormatter<Integer> n = new TextFormatter<>(new IntegerStringConverter(),telok);
//    tel.setTextFormatter(n);
//  idclt.clear();
//Affiche();
//     
//
//
    }
   
	
    
    @FXML
    void enregistrer(ActionEvent event) throws SQLException {

    String sql= "INSERT INTO client VALUES("+idclt.getText()+",'"+nam.getText()+"','"+preno.getText()+"','"+adr.getText()+"',"+tel.getText()+",'"+sex.getText()+"')";	
    	executeQuery(sql);
    	Client cl = new Client();
    	
    	
    
    	
    	
    
    	
    	
    	int status =GestionclientDAO.enregistrer(cl);
    	
    	if(status>0) {
    		
    		Alert alert= new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information");
    		alert.setHeaderText("Enregistrement");
    		alert.setContentText("client NON ajouté");
    		alert.showAndWait();
    		
    		
        	
        	
    	    idclt.clear();
        	nam.clear();
        	preno.clear();
        	adr.clear();
        	tel.clear();
        	sex.clear();
        	
        	 
        	 
        	 
    		
    	}else {
    		
    		Alert alert= new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information");
    		alert.setHeaderText("Enregistrement");
    		alert.setContentText("client ajouté");
    		alert.showAndWait();	
    		
    		 idclt.clear();
        	nam.clear();
        	preno.clear();
        	adr.clear();
        	tel.clear();
        	sex.clear();

    		
    	} 	


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




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
