package gestionLocation;

public class Client {
    private int IDClient;
    private String nom;
    private String Prenom;
    private String CNI;

    public Client(int IDClient, String nom, String prenom, String CNI) {
        this.IDClient = IDClient;
        this.nom = nom;
        Prenom = prenom;
        this.CNI = CNI;
    }

    @Override
    public String toString() {
        return "Client { " +
                "IDClient = " + IDClient +
                ", nom = " + nom  +
                ", Prenom = " + Prenom +
                ", CNI = " + CNI +
                '}';
    }

    public int getIDClient() {
        return IDClient;
    }

    public void setIDClient(int IDClient) {
        this.IDClient = IDClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getCNI() {
        return CNI;
    }

    public void setCNI(String CNI) {
        this.CNI = CNI;
    }
}
