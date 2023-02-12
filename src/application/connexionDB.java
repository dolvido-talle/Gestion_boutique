package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connexionDB {
	
	
	private static final  String url ="jdbc:mysql://localhost:3306/myapplication";
	private static final  String user = "root";
	private static final String password ="";

	public static Connection connect() throws SQLException{ // methode qui permet de se connecter a la base de d...
                                                           // cette methode renvoie un objet

		try {



			Class.forName("com.mysql.jdbc.Driver");// permet au driver de se connecter a la bd
			Connection con=DriverManager.getConnection(url, user, password);
			return con;

		}catch (ClassNotFoundException | SQLException e) {

			Logger.getLogger(connexionDB.class.getName()).log(Level.SEVERE, null, e);	

			e.printStackTrace();

		}

		return null;

	}



}
