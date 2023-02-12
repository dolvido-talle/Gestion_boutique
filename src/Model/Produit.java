package Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produit {
	private final IntegerProperty idproduit;
	private final StringProperty designation;
	private final StringProperty modele;
	private final IntegerProperty taille;
	private final StringProperty couleur;
	private final IntegerProperty quantitées;
	private final IntegerProperty prixachat;
	private final DoubleProperty tva;
	
	
	
	
	
	public Produit (Integer  idproduit, String designation, String modele, Integer taille,String couleur,Integer  quantitées,Integer prixachat,Double tva) {
		this. idproduit = new SimpleIntegerProperty(idproduit);
		this. designation = new SimpleStringProperty(designation);
		this.modele = new SimpleStringProperty(modele);
		this.taille = new SimpleIntegerProperty(taille);
		this.couleur = new SimpleStringProperty(couleur);
		this.quantitées = new SimpleIntegerProperty(quantitées);
		this.prixachat = new SimpleIntegerProperty(prixachat);
		this.tva =new SimpleDoubleProperty (tva);
		
	}
	
	
	
	
	public Produit() {// constructeur par defaut
		this.idproduit = new SimpleIntegerProperty();
		this.designation = new SimpleStringProperty();
		this.modele = new SimpleStringProperty();
		this.taille = new SimpleIntegerProperty();
		this.couleur = new SimpleStringProperty();
		this.quantitées = new SimpleIntegerProperty();
		this.prixachat = new SimpleIntegerProperty();
		this.tva =new SimpleDoubleProperty ();
		
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
	




	
	




	public final StringProperty modeleProperty() {
		return this.modele;
	}
	




	public final String getModele() {
		return this.modeleProperty().get();
	}
	




	public final void setModele(final String modele) {
		this.modeleProperty().set(modele);
	}
	




	public final IntegerProperty tailleProperty() {
		return this.taille;
	}
	




	public final int getTaille() {
		return this.tailleProperty().get();
	}
	




	public final void setTaille(final int taille) {
		this.tailleProperty().set(taille);
	}
	




	public final StringProperty couleurProperty() {
		return this.couleur;
	}
	




	public final String getCouleur() {
		return this.couleurProperty().get();
	}
	




	public final void setCouleur(final String couleur) {
		this.couleurProperty().set(couleur);
	}
	




	public final IntegerProperty quantitéesProperty() {
		return this.quantitées;
	}
	




	public final int getQuantitées() {
		return this.quantitéesProperty().get();
	}
	




	public final void setQuantitées(final int quantitées) {
		this.quantitéesProperty().set(quantitées);
	}
	




	public final IntegerProperty prixachatProperty() {
		return this.prixachat;
	}
	




	public final int getPrixachat() {
		return this.prixachatProperty().get();
	}
	




	public final void setPrixachat(final int prixachat) {
		this.prixachatProperty().set(prixachat);
	}
	




	public final DoubleProperty tvaProperty() {
		return this.tva;
	}
	




	public final double getTva() {
		return this.tvaProperty().get();
	}
	




	public final void setTva(final double tva) {
		this.tvaProperty().set(tva);
	}




	public final StringProperty designationProperty() {
		return this.designation;
	}
	




	public final String getDesignation() {
		return this.designationProperty().get();
	}
	




	public final void setDesignation(final String designation) {
		this.designationProperty().set(designation);
	}





	
	
	
	
	
	
	
	
	
	
}
