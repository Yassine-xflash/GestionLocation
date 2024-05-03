package gestionLocation;

import java.util.Date;

public class Location {
    private int IDLocation;
    private int IDClient;
    private int IDVehicule;
    private Date DateLocation;
    private Date DateRevenu;
    private int Kilometrage;
    
    public Location(int IDLocation, int IDClient, int IDVehicule, Date dateLocation, Date dateRevenu, int kilometrage) {
        this.IDLocation = IDLocation;
        this.IDClient = IDClient;
        this.IDVehicule = IDVehicule;
        DateLocation = dateLocation;
        DateRevenu = dateRevenu;
        Kilometrage = kilometrage;
    }

    @Override
    public String toString() {
        return "Location{" +
                "IDLocation=" + IDLocation +
                ", IDClient=" + IDClient +
                ", IDVehicule=" + IDVehicule +
                ", DateLocation=" + DateLocation +
                ", DateRevenu=" + DateRevenu +
                ", Kilometrage=" + Kilometrage +
                '}';
    }

    public int getIDLocation() {
        return IDLocation;
    }

    public void setIDLocation(int IDLocation) {
        this.IDLocation = IDLocation;
    }

    public int getIDClient() {
        return IDClient;
    }

    public void setIDClient(int IDClient) {
        this.IDClient = IDClient;
    }

    public int getIDVehicule() {
        return IDVehicule;
    }

    public void setIDVehicule(int IDVehicule) {
        this.IDVehicule = IDVehicule;
    }

    public Date getDateLocation() {
        return DateLocation;
    }

    public void setDateLocation(Date dateLocation) {
        DateLocation = dateLocation;
    }

    public Date getDateRevenu() {
        return DateRevenu;
    }

    public void setDateRevenu(Date dateRevenu) {
        DateRevenu = dateRevenu;
    }

    public int getKilometrage() {
        return Kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        Kilometrage = kilometrage;
    }
}
