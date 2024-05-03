package gestionLocation;
import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class GestionLocationVehicule {
    private String user="root";
    private String pass="";
    private String url = "jdbc:mysql://localhost:3306/agencelocation";
    Connection myConnection;

    public GestionLocationVehicule() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        myConnection = DriverManager.getConnection(url,user,pass);
        System.out.println("Connection stablie");
    }
    //========================= Vehicule ======================================
    public void AjouterVehicule(Vehicule v ) throws SQLException{
        String Requette = "INSERT INTO vehicule (IDVehicule,Marque,Modele,Annee) VALUES (?,?,?,?);";

        PreparedStatement pr = myConnection.prepareStatement(Requette);
        pr.setInt(1,v.getIDVehicule());
        pr.setString(2,v.getMarque());
        pr.setString(3,v.getModele());
        pr.setInt(4,v.getAnee());
        pr.executeUpdate();
        System.out.println("Vehicule ajouté avec succes !!\n");
    }
    public void SupprimerVehicule(int id) throws SQLException{
        String Requette = "DELETE FROM Vehicule WHERE IDVehicule = ?;";
        PreparedStatement pr = myConnection.prepareStatement(Requette);
        pr.setInt(1,id);

        pr.executeUpdate();
        System.out.println("Vehicule supprimé avec succes !!\n");
    }
    public void ModifierVehicule(int IDAncient,Vehicule Nouveau) throws SQLException{
        String Requette = "UPDATE Vehicule SET Marque = ?,Modele = ?,Annee = ? WHERE IDVehicule = ?; ";
        PreparedStatement pr = myConnection.prepareStatement(Requette);
        pr.setString(1,Nouveau.getMarque());
        pr.setString(2, Nouveau.getModele());
        pr.setInt(3, Nouveau.getAnee());
        pr.setInt(4,IDAncient);

        pr.executeUpdate();
        System.out.println("Vehicule modifié avec succes !!\n");
    }
    public void RechercherVehicule(String marque,String modele) throws SQLException {
        String Requette = "SELECT * FROM Vehicule WHERE Marque = ? AND Modele = ?;";
        PreparedStatement pr = myConnection.prepareStatement(Requette);
        pr.setString(1,marque);
        pr.setString(2,modele);

        ResultSet r = pr.executeQuery();

        while (r.next()) {
            Vehicule v = new Vehicule(r.getInt("IDVehicule"), r.getString("Marque"), r.getString("Modele"), r.getInt("Annee"));
            System.out.println(v);
        }
    }
    
    //========================= Client ======================================
    public void AjouterClient(Client c ) throws SQLException{
        String Requette = "INSERT INTO Client (IDClient,Nom,Prenom,CNI) VALUES (?,?,?,?);";
        PreparedStatement pr = myConnection.prepareStatement(Requette);
        pr.setInt(1,c.getIDClient());
        pr.setString(2, c.getNom());
        pr.setString(3, c.getPrenom());
        pr.setString(4,c.getCNI());

        pr.executeUpdate();
        System.out.println("Client ajouté avec succes !!\n");
    }
    public void SupprimerClient(int id) throws SQLException{
        String Requette = "DELETE FROM Client WHERE IDClient = ?;";
        PreparedStatement pr = myConnection.prepareStatement(Requette);
        pr.setInt(1,id);

        pr.executeUpdate();
        System.out.println("Client supprimé avec succes !!\n");
    }
    public void ModifierClient(int IDAncient,Client Nouveau) throws SQLException{
        String Requette = "UPDATE Client SET Nom = ?,Prenom = ?,CNI = ? WHERE IDClient = ?; ";
        PreparedStatement pr = myConnection.prepareStatement(Requette);
        pr.setString(1,Nouveau.getNom());
        pr.setString(2, Nouveau.getPrenom());
        pr.setString(3, Nouveau.getCNI());
        pr.setInt(4,IDAncient);

        pr.executeUpdate();
        System.out.println("Client modifié avec succes !!\n");
    }
    public void RechercherClient(String CNI) throws SQLException {
        String Requette = "SELECT * FROM Client WHERE CNI = ? ;";
        PreparedStatement pr = myConnection.prepareStatement(Requette);
        pr.setString(1,CNI);
        ResultSet r = pr.executeQuery();

        while (r.next()) {
            Client c = new Client(r.getInt("IDClient"), r.getString("Nom"), r.getString("Prenom"), r.getString("CNI"));
            System.out.println(c);
        }
    }
    
    //========================= Location ======================================
    public void EnregisterLocation(String CNI,String Marque,String Modele) throws SQLException {
    	String ReqCl = "SELECT IDClient FROM Client Where CNI = ? ;";
        PreparedStatement pr = myConnection.prepareStatement(ReqCl);
        pr.setString(1,CNI);
        ResultSet rClient = pr.executeQuery();
        int idClient = 0;
        if(rClient.next()) {
        	idClient = rClient.getInt("IDClient");
        }
        String ReqVl = "SELECT IDVehicule FROM Vehicule Where Marque = ? AND Modele = ?;";
        PreparedStatement prV = myConnection.prepareStatement(ReqVl);
        prV.setString(1,Marque);
        prV.setString(2,Modele);
        ResultSet rVehicule = prV.executeQuery();
        int idVehicule = 0;
        if(rVehicule.next()) {
        	idVehicule = rVehicule.getInt("IDVehicule");
        }
        String ReqI = "SELECT MAX(IDLocation) AS C FROM location;";
        PreparedStatement prLI = myConnection.prepareStatement(ReqI);
        ResultSet rIDL = prLI.executeQuery();
        int IDL = 0;
        if(rIDL.next()) {
        	IDL = rIDL.getInt("C");
        }
        String ReqLoc = "INSERT INTO location (IDLocation,IDVehicule,IDClient,DateLocation) VALUES(?,?,?,?);";
        PreparedStatement prL = myConnection.prepareStatement(ReqLoc);
        prL.setInt(1,IDL+1);
        prL.setInt(2,idVehicule);
        prL.setInt(3,idClient);
        Date d =  new Date(System.currentTimeMillis());
        prL.setDate(4, d);  			
        prL.executeUpdate();
        System.out.println("Location Enregisté avec succes !!\n");
    }
    
    public void VisualiserLocation() throws SQLException {
    	String Requette = "SELECT l.IDLocation, v.Marque AS vehicule, c.Nom AS clientNom, c.Prenom AS PrenomClient,l.KilometrageRetour,l.EtatVehicule "+
    "FROM location l "+
    			"JOIN vehicule v ON l.IDVehicule = v.IDVehicule "+
    "JOIN client c ON l.IDClient = c.IDClient "+
    			" WHERE l.DateRetour IS NULL OR l.DateRetour >= CURRENT_DATE";
        PreparedStatement pr = myConnection.prepareStatement(Requette);
        ResultSet r = pr.executeQuery();
        System.out.println("Location en Cours .......");
        while (r.next()) {
            System.out.println("Location N°: "+r.getInt("IDLocation")+" | de Client: "+ r.getString("PrenomClient")+"  "+ r.getString("clientNom")+ " | "+
            		" de Kilometrage: "+r.getInt("KilometrageRetour")+" | "+" d'etat: "+r.getString("EtatVehicule"));
        }
    }
      
    public void CloturerLocation(int ID,int Kil,String etat) throws SQLException {
        
        String Requette = "UPDATE location SET KilometrageRetour = ?, EtatVehicule = ?, DateRetour = CURRENT_DATE WHERE IDLocation = ?; ";
        PreparedStatement pr = myConnection.prepareStatement(Requette);
        pr.setInt(1, Kil);
        pr.setString(2, etat);
        pr.setInt(3, ID);
        
        int test = pr.executeUpdate();
        if (test > 0) {
            System.out.println("Location cloture avec succes !!");
        } else {
            System.out.println("Echec de la cloture de la location x!, Verifier l'ID de la location!");
        }
    
    }
    public void getConn() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			myConnection = DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Connection stablie");
    }
}

