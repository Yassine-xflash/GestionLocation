package gestionLocation;

public class Vehicule {
    private int IDVehicule;
    private String marque;
    private String modele;
    private int anee;


    public Vehicule(int IDVehicule, String marque, String modele, int anee) {
        this.IDVehicule = IDVehicule;
        this.marque = marque;
        this.modele = modele;
        this.anee = anee;
    }

    @Override
    public String toString() {
        return "Vehicule { " +
                "IDVehicule =" + IDVehicule +
                ", marque =" + marque  +
                ", modele =" + modele +
                ", anee =" + anee +
                '}';
    }

    public int getIDVehicule() {
        return IDVehicule;
    }

    public void setIDVehicule(int IDVehicule) {
        this.IDVehicule = IDVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getAnee() {
        return anee;
    }

    public void setAnee(int anee) {
        this.anee = anee;
    }

}

