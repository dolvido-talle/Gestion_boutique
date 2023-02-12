package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Model.Produit;
import application.connexionDB;

public class GestionproduitDAO {
	
	
	
	public static int enregistrer(Produit pr) {
		
	
		int et=0;
		
		try {
			
			
		String sql ="INSERT INTO produit (idproduit,  reference, modele,  taille, couleur,  quantitées, prixachat, tva) VALUES (?, ?, ?,?,?, ?,?,?) ";
			Connection con=connexionDB.connect();
			PreparedStatement stat;
			stat = con.prepareStatement(sql);
			stat.setInt(1, pr.getIdproduit());
			stat.setString(2, pr.getDesignation());
			stat.setString(3, pr.getModele());
			stat.setInt(4, pr.getTaille());
			stat.setInt(6, pr.getQuantitées());
			stat.setInt(7, pr.getPrixachat());
			stat.setDouble(8, pr.getTva());
			
			
			 et =stat.executeUpdate();
			
			con.close();
		}catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
		return et;
		
	}
	


public static int update(Produit e1) {
	
	int et1=0;
	
	try {
	String sql ="UPDATE produit SET (idproduit=?,  reference=?, modele=?,  taille=?, couleur=?,  quantitées=?, prixachat=?, tva=? WHERE idproduit=?";
		Connection con=connexionDB.connect();
		PreparedStatement stat;
		stat = con.prepareStatement(sql);
		
		stat.setInt(1, e1.getIdproduit());
		stat.setString(2, e1.getDesignation());
		stat.setString(3, e1.getModele());
		stat.setInt(4, e1.getTaille());
		stat.setInt(6, e1.getQuantitées());
		stat.setInt(7, e1.getPrixachat());
		stat.setDouble(8, e1.getTva());
		 et1 =stat.executeUpdate();
		
		con.close();
	}catch (SQLException e2) {
		// TODO: handle exception
		e2.printStackTrace();
	}
	
	return et1;
	
}


public static int delete(int ide) {

int et1=0;

try {
String sql ="DELETE FROM produit WHERE idproduit=?";
	Connection con=connexionDB.connect();
	PreparedStatement stat;
	stat = con.prepareStatement(sql);
	
	stat.setInt(1, ide);
	 et1 =stat.executeUpdate();
	
	con.close();
}catch (SQLException e2) {
	// TODO: handle exception
	e2.printStackTrace();
}

return et1;

}

public static Produit rechercheDAO(Integer id) {
	
	Produit ets2 =  new Produit();

try {
String sql ="SELECT * FROM produit WHERE idclient=?"; 
	Connection con=connexionDB.connect();
	PreparedStatement stat;
	stat = con.prepareStatement(sql);
	
	stat.setInt(1, id);
	ResultSet rs=stat.executeQuery();
	 if(rs.next()) {
		 
		 ets2.setIdproduit(rs.getInt(1));
		 ets2.setDesignation(rs.getString(2));
		 ets2.setModele( rs.getString(3));
		 ets2.setTaille( rs.getInt(4));
		 ets2.setQuantitées(rs.getInt(6));
		 ets2.setPrixachat(rs.getInt(7));
		 ets2.setTva( rs.getDouble(8));
		 
		 
	 }
	
	con.close();
}catch (SQLException e2) {
	// TODO: handle exception
	e2.printStackTrace();   
}

return ets2;

}
	

}
