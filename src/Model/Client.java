package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
	private final SimpleIntegerProperty idclient;
	private final StringProperty nom;
	private final StringProperty prenom;
	private final StringProperty sexe;
	private final IntegerProperty tel;
	private final StringProperty adresse;
	
	
	public Client(int  idclient, String nom, String prenom,String sexe, Integer tel,String adresse) {
		this. idclient = new SimpleIntegerProperty(idclient);
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.sexe = new SimpleStringProperty(sexe);
		this.tel = new SimpleIntegerProperty(tel);
		this.adresse =new SimpleStringProperty (adresse);
		
	}
	
	public Client() {// constructeur par defaut
		this. idclient = new SimpleIntegerProperty();
		this.nom = new SimpleStringProperty();
		this.prenom = new SimpleStringProperty();
		this.sexe = new SimpleStringProperty();
		this.tel = new SimpleIntegerProperty();
		this.adresse =new SimpleStringProperty ();
		
	}

	
	
	

	public final StringProperty nomProperty() {
		return this.nom;
	}
	

	public final String getNom() {
		return this.nomProperty().get();
	}
	

	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	

	public final StringProperty prenomProperty() {
		return this.prenom;
	}
	

	public final String getPrenom() {
		return this.prenomProperty().get();
	}
	

	public final void setPrenom(final String prenom) {
		this.prenomProperty().set(prenom);
	}
	

	public final StringProperty sexeProperty() {
		return this.sexe;
	}
	

	public final String getSexe() {
		return this.sexeProperty().get();
	}
	

	public final void setSexe(final String sexe) {
		this.sexeProperty().set(sexe);
	}
	

	public final IntegerProperty telProperty() {
		return this.tel;
	}
	

	public final int getTel() {
		return this.telProperty().get();
	}
	

	public final void setTel(final int tel) {
		this.telProperty().set(tel);
	}
	

	public final StringProperty adresseProperty() {
		return this.adresse;
	}
	

	public final String getAdresse() {
		return this.adresseProperty().get();
	}
	

	public final void setAdresse(final String adresse) {
		this.adresseProperty().set(adresse);
	}

	public final SimpleIntegerProperty idclientProperty() {
		return this.idclient;
	}
	

	public final int getIdclient() {
		return this.idclientProperty().get();
	}
	

	public final void setIdclient(final int idclient) {
		this.idclientProperty().set(idclient);
	}
	

	
	
	
	
	
	
	
}
