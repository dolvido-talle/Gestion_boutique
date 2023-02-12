package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Commande {

	
	
	private final IntegerProperty idcom;
	private final IntegerProperty idclient;
	private final IntegerProperty idproduit;
	private final ObjectProperty<String>datecom ;
	private final ObjectProperty<String>datelivraison ;
	private final ObjectProperty<String>delaisconception ;
	private final IntegerProperty quantitees;
	
	
	
	
	
	
	public Commande(Integer idcom, Integer idclient,Integer idproduit, String datecom,String datelivraison, String delaisconception,Integer quantitees) {
		this.idcom = new SimpleIntegerProperty(idcom);
		this.idclient = new SimpleIntegerProperty(idclient);
		this.idproduit = new SimpleIntegerProperty(idproduit);
		this.datecom =new SimpleObjectProperty<String>(datecom);
		this.datelivraison =new SimpleObjectProperty<String>(datelivraison);
		this.delaisconception =new SimpleObjectProperty<String>(delaisconception);
		this.quantitees =new SimpleIntegerProperty (quantitees);
		
	}


	
	public Commande() {
		
		
		this.idcom = new SimpleIntegerProperty();
		this.idclient = new SimpleIntegerProperty();
		this.idproduit = new SimpleIntegerProperty();
		this.datecom =new SimpleObjectProperty<String>();
		this.datelivraison =new SimpleObjectProperty<String>();
		this.delaisconception =new SimpleObjectProperty<String>();
		this.quantitees =new SimpleIntegerProperty ();
		
	}



	public final IntegerProperty idcomProperty() {
		return this.idcom;
	}
	



	public final int getIdcom() {
		return this.idcomProperty().get();
	}
	



	public final void setIdcom(final int idcom) {
		this.idcomProperty().set(idcom);
	}
	



	public final IntegerProperty idclientProperty() {
		return this.idclient;
	}
	



	public final int getIdclient() {
		return this.idclientProperty().get();
	}
	



	public final void setIdclient(final int idclient) {
		this.idclientProperty().set(idclient);
	}
	



	public final IntegerProperty idproduitProperty() {
		return this.idproduit;
	}
	



	public final int getIdproduit() {
		return this.idproduitProperty().get();
	}
	



	public final void setIdproduit(final int idproduit) {
		this.idproduitProperty().set(idproduit);
	}



	public final ObjectProperty<String> datecomProperty() {
		return this.datecom;
	}
	



	public final String getDatecom() {
		return this.datecomProperty().get();
	}
	



	public final void setDatecom(final String datecom) {
		this.datecomProperty().set(datecom);
	}
	



	public final ObjectProperty<String> datelivraisonProperty() {
		return this.datelivraison;
	}
	



	public final String getDatelivraison() {
		return this.datelivraisonProperty().get();
	}
	



	public final void setDatelivraison(final String datelivraison) {
		this.datelivraisonProperty().set(datelivraison);
	}
	



	public final ObjectProperty<String> delaisconceptionProperty() {
		return this.delaisconception;
	}
	



	public final String getDelaisconception() {
		return this.delaisconceptionProperty().get();
	}
	



	public final void setDelaisconception(final String delaisconception) {
		this.delaisconceptionProperty().set(delaisconception);
	}



	public final IntegerProperty quantiteesProperty() {
		return this.quantitees;
	}
	



	public final int getQuantitees() {
		return this.quantiteesProperty().get();
	}
	



	public final void setQuantitees(final int quantitees) {
		this.quantiteesProperty().set(quantitees);
	}
	



	
	




	
	
}
