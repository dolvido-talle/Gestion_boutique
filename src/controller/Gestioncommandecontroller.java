package controller;


import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.mysql.jdbc.Messages;

import DAO.GestionclientDAO;
import DAO.GestioncommandeDAO;
import Model.Client;
import Model.Commande;
import application.connexionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Gestioncommandecontroller implements Initializable {


   

    @FXML
    private JFXDatePicker dateconcep1;

    @FXML
    private JFXDatePicker datelivrai1;

    @FXML
    private JFXDatePicker datecom1;

    @FXML
    private TextField idcom1;
    @FXML
    private TextField qtecom;


    @FXML
    private ComboBox<Integer> idclient1;

    @FXML
    private ComboBox<Integer> idpro1;

    @FXML
    private JFXButton ajout;

    @FXML
    private JFXButton delete;

    @FXML
    private JFXButton modif;

    @FXML
    private TableView<Commande> tablec;

    @FXML
    private TableColumn<Commande, Integer> idcome;

    @FXML
    private TableColumn<Commande, Integer> idcliene;

    @FXML
    private TableColumn<Commande,Integer> idproduite;

    @FXML
    private TableColumn<Commande, String> datecome;

    @FXML
    private TableColumn<Commande,String> datlivrai;

    @FXML
    private TableColumn<Commande,String> delaiss;
    @FXML
    private TextField numfac;

    @FXML
    private TextField nom;

    @FXML
    private TextField prixu;

    @FXML
    private TextField design;

    @FXML
    private TextField qte;

   

    @FXML
    private JFXButton affich;

    @FXML
    private JFXButton select;
    
    @FXML
    private JFXButton rt;
    private ObservableList<Integer> liste1=FXCollections.observableArrayList();
    private ObservableList<Integer> liste2=FXCollections.observableArrayList();

    @FXML
    void Affiche() throws SQLException {
    	ObservableList<Commande> liste=FXCollections.observableArrayList();
    	Connection con = connexionDB.connect();
		
		String sql = "SELECT * FROM commande";
    	
    	Statement stat=null;
    	ResultSet rs=null;
    	
    	try {
    		
			 stat =con.createStatement();
			
			 rs = stat.executeQuery(sql);
			while(rs.next()) {
				
			Commande em=new Commande(rs.getInt("idcom"),rs.getInt("idclient"), rs.getInt("idproduit"),rs.getString("datecom"),rs.getString("datelivraison"),rs.getString("delaisconception"),rs.getInt("quantitees"));
			liste.add(em);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
    	
    	
    	
    	idcome.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idcom"));
        idcliene.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idclient"));
    	idproduite.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idproduit"));
    	 datecome.setCellValueFactory(new PropertyValueFactory<Commande,String>("datecom"));
    	delaiss.setCellValueFactory(new PropertyValueFactory<Commande,String>("datelivraison"));
    	datlivrai.setCellValueFactory(new PropertyValueFactory<Commande,String>("delaisconception"));
    	
    	tablec.setItems(liste);
 	    
   	
  
    	
    	
    
    	
     
     
      
      
    	}

    	

    

   
@FXML
    void Ajout(ActionEvent event) throws SQLException {
    	
      	LocalDate a=datecom1.getValue();
    	LocalDate b=datelivrai1.getValue();
    	LocalDate c=dateconcep1.getValue();
      
    	 String sql= "INSERT INTO commande VALUES("+idcom1.getText()+","+idclient1.getValue()+","+idpro1.getValue()+",'"+a.toString()+"','"+b.toString()+"','"+c.toString()+"',"+qtecom.getText()+")";	
     	executeQuery(sql);
     	Commande em = new Commande();
     	
     	
     
     	
     	
     
     	
     	
     	int status =GestioncommandeDAO.enregistrer(em);
     	
     	if(status>0) {
     		
     		Alert alert= new Alert(AlertType.INFORMATION);
     		alert.setTitle("Information");
     		alert.setHeaderText("Enregistrement");
     		alert.setContentText("commande non ajouté");
     		alert.showAndWait();
     		
     		
         	
         	
     	    idcom1.clear();
         	idclient1.setValue(null);
         	idpro1.setValue(null);
         	datecom1.setValue(null);
         	datelivrai1.setValue(null);
         	dateconcep1.setValue(null);
            
            qtecom.clear();

         	
         	 
         	 
         	 
     		
     	}else {
     		
     		Alert alert= new Alert(AlertType.INFORMATION);
     		alert.setTitle("Information");
     		alert.setHeaderText("Enregistrement");
     		alert.setContentText("commande  ajouté");
     		alert.showAndWait();	
     		 idcom1.clear();
          	idclient1.setValue(null);
          	idpro1.setValue(null);
          	datecom1.setValue(null);
          	datelivrai1.setValue(null);
         	dateconcep1.setValue(null);
         	qtecom.clear();
     		
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
    void Modifie(ActionEvent event) throws SQLException {
		LocalDate a=datecom1.getValue();
    	LocalDate b=datelivrai1.getValue();
    	LocalDate c=dateconcep1.getValue();
      

   	 String sql= " UPDATE commande SET idclient="+idclient1.getValue()+",idproduit="+idpro1.getValue()+",datecom='"+a.toString()+"',datelivraison='"+b.toString()+"',delaisconception='"+c.toString()+"' WHERE idcom="+idcom1.getText()+"";	
    	executeQuery(sql);
   	Affiche();
    idcom1.clear();
  	idclient1.setValue(null);
  	idpro1.setValue(null);
  	datecom1.setValue(null);
  	datelivrai1.setValue(null);
 	dateconcep1.setValue(null);
 	qtecom.clear();
    }

    @FXML
    void Selection(ActionEvent event) {
    	
      
    	
Commande em=tablec.getSelectionModel().getSelectedItem();
    	
    	idcom1.setText(""+em.getIdcom());
    	idclient1.setValue(em.getIdclient());
    	idpro1.setValue(em.getIdproduit());
    	LocalDate a=LocalDate.parse(em.getDatecom().toString());
    	datecom1.setValue(a);
    	LocalDate b=LocalDate.parse(em.getDatelivraison().toString());
    	datelivrai1.setValue(b);
    	LocalDate c=LocalDate.parse(em.getDelaisconception().toString());
    	dateconcep1.setValue(c);
    	

    }

    @FXML
    void Supprime(ActionEvent event) throws SQLException {
    	String sql ="DELETE FROM commande WHERE idcom="+idcom1.getText()+"";
    	executeQuery(sql);
    	tablec.getItems().clear();
    	Affiche();
    	 idcom1.clear();
    	 idclient1.setValue(null);
    	  	idpro1.setValue(null);
       	datecom1.setValue(null);
       	datelivrai1.setValue(null);
      	dateconcep1.setValue(null);
      	qtecom.clear();

    }

    @FXML
    void imprimer(ActionEvent event) {
    	//ActionEvent event
//		String name= nom.getText();	
//				File file = new File("Facture/" + name + ".pdf");
//				OutputStream out = null;
//	try {
//					 out = new FileOutputStream(file);
//		String text = "\t \t \t Facture à l'attention de Msr/Mme " + name + "\n";
//					out.write(text.getBytes());
//					text = "\t ACHAT DE : \n";
//					out.write(text.getBytes());
//					int pr =0 ;
//
//					 int n2 =tablec.getSelectionModel().getSelectedIndex();
//
//						ObservableList<Commande> l =tablec.getItems();
//						Commande p = l.get(n2);
//					   
//						
//						text = "\t - Numéro facture " +numfac.getText() + " désignation "+ design.getText() +" Date Facture : "+p.getDatecom() +" Quantité : " + p.getQuantitees() + " Prix Unitaire : " + Integer.parseInt(prixu.getText())+ " FCFA\n";
//						
//						
//						
//					pr = Integer.parseInt(prixu.getText())*p.getQuantitees();
//						out.write(text.getBytes());
//						text = "--------------------------------------------------------------------------------------------\n";
//						out.write(text.getBytes());
//					
//					text = "\t\t\t\t Prix Total A Payer : " + pr + " FCFA";
//					out.write(text.getBytes());
//					
//					Desktop d = Desktop.getDesktop();
//					d.print(file);
//						
//					
//				} catch (FileNotFoundException e) {
//					e.printStackTrace();
//					
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
    	PrinterJob pj=PrinterJob.createPrinterJob();
    
   	TextArea textarea=new TextArea("Facturre ");
    	
    	if (pj !=null) {
    		boolean success =pj.showPrintDialog(null);
    		if(success) {
    			boolean printed=pj.printPage(textarea);
    			if (printed) {
    				pj.endJob();
    				

    			}
    		
    		
 			
		boolean proceed =pj.showPrintDialog(null);
				
    		}
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
		
		try {
			Connection conn=connexionDB.connect();
			String sql = "SELECT idproduit FROM produit";
		
			PreparedStatement stat=conn.prepareStatement(sql);
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				liste1.add(rs.getInt("idproduit"));
			}
			conn.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
		try {
			Connection conn=connexionDB.connect();
			String sql = "SELECT idclient  FROM client";
		
			PreparedStatement stat=conn.prepareStatement(sql);
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				liste2.add(rs.getInt("idclient"));
			}
			conn.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
		idpro1.setItems(liste1);
		idclient1.setItems(liste2);
		
	}
		

	

}
