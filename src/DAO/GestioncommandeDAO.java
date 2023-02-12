package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Client;
import Model.Commande;
import application.connexionDB;

public class GestioncommandeDAO {
	
	

	public static int enregistrer(Commande cm) {
		//cl ici n'est pas 1e variable mais 1 objet client
	
		int et=0;
		
		try {
			
			
		String sql ="INSERT INTO commande (idcom,idclient,idproduit,datecom,datelivraison,delaisconception,quantitees) VALUES (?, ?, ?,?,?, ?,?) ";
			Connection con=connexionDB.connect();
			PreparedStatement stat;
			stat = con.prepareStatement(sql);
			stat.setInt(1, cm.getIdcom());
			stat.setInt(2, cm.getIdclient());
			stat.setInt(3, cm.getIdproduit());
			stat.setString(4, cm.getDatecom());
			stat.setString(5, cm.getDatelivraison());
			stat.setString(6, cm.getDelaisconception());
			stat.setInt(7, cm.getQuantitees());
			
			
			
			 et =stat.executeUpdate();
			
			con.close();
		}catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
		return et;
		
	}
	


public static int update(Commande e1) {
	
	int et1=0;
	
	try {
	String sql ="UPDATE commande SET idcom=?,idclient=? ,idproduit=?,datecom=?,datelivraison=?,delaisconception=? WHERE idcom=?";
		Connection con=connexionDB.connect();
		PreparedStatement stat;
		stat = con.prepareStatement(sql);
		stat.setInt(1, e1.getIdcom());
		stat.setInt(2, e1.getIdclient());
		stat.setInt(3, e1.getIdproduit());
		stat.setString(4, e1.getDatecom());
		stat.setString(5, e1.getDatelivraison());
		stat.setString(6, e1.getDelaisconception());
		
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
String sql ="DELETE FROM commande WHERE idcom=?";
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

public static Commande rechercheDAO(Integer id) {
	
	Commande ets1 =  new Commande();

try {
String sql ="SELECT * FROM commande WHERE idcom=?"; 
	Connection con=connexionDB.connect();
	PreparedStatement stat;
	stat = con.prepareStatement(sql);
	
	stat.setInt(1, id);
	ResultSet rs=stat.executeQuery();
	 if(rs.next()) {
		 ets1.setIdcom(rs.getInt(1));
		 ets1.setIdclient(rs.getInt(2));
		 ets1.setIdproduit(rs.getInt(3));
		 ets1.setDatecom(rs.getString(4));
		 ets1.setDatelivraison(rs.getString(5));
		 ets1.setDelaisconception(rs.getString(6));
		
		 
		 
	 }
	
	con.close();
}catch (SQLException e2) {
	// TODO: handle exception
	e2.printStackTrace();   
}

return ets1;

	

}
}
