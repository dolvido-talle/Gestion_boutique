package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Client;
import application.connexionDB;

public class GestionclientDAO {

	
	
	public static int enregistrer(Client cl) {
		//cl ici n'est pas 1e variable mais 1 objet client
	
		int et=0;
		
		try {
			
			
		String sql ="INSERT INTO client (idclient, nom, prenom,sexe, tel, adresse) VALUES (?, ?, ?,?,?, ?) ";
			Connection con=connexionDB.connect();
			PreparedStatement stat;
			stat = con.prepareStatement(sql);
			stat.setInt(1, cl.getIdclient());
			stat.setString(2, cl.getNom());
			stat.setString(3, cl.getPrenom());
			stat.setString(4, cl.getSexe());
			stat.setInt(6, cl.getTel());
			stat.setString(7, cl.getAdresse());
			
			
			 et =stat.executeUpdate();
			
			con.close();
		}catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
		return et;
		
	}
	


public static int update(Client e1) {
	
	int et1=0;
	
	try {
	String sql ="UPDATE client SET idclient=?,nom=?,prenom=?,sexe=?,tel=?,adresse=? WHERE idclient=?";
		Connection con=connexionDB.connect();
		PreparedStatement stat;
		stat = con.prepareStatement(sql);
		stat = con.prepareStatement(sql);
		stat.setInt(1, e1.getIdclient());
		stat.setString(2, e1.getNom());
		stat.setString(3, e1.getPrenom());
		stat.setString(4, e1.getSexe());
		stat.setInt(6, e1.getTel());
		stat.setString(7, e1.getAdresse());
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
String sql ="DELETE FROM client WHERE idclient=?";
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

public static Client rechercheDAO(Integer id) {
	
	Client ets =  new Client();

try {
String sql ="SELECT * FROM client WHERE idclient=?"; 
	Connection con=connexionDB.connect();
	PreparedStatement stat;
	stat = con.prepareStatement(sql);
	
	stat.setInt(1, id);
	ResultSet rs=stat.executeQuery();
	 if(rs.next()) {
		 ets.setIdclient(rs.getInt(1));
		 ets.setNom(rs.getString(2));
		 ets.setPrenom(rs.getString(3));
		 ets.setSexe(rs.getString(4));
		 ets.setTel(rs.getInt(5));
		 ets.setAdresse(rs.getString(6));
		
		 
		 
	 }
	
	con.close();
}catch (SQLException e2) {
	// TODO: handle exception
	e2.printStackTrace();   
}

return ets;

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
