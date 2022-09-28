package org.example;


public class Coureur {
    private String nom;
    private int classement;
    private String temps;
    private String club = "non licencié";
    private String sexe;

    @Override
    public String toString() {
        return "Coureur{" +
                "name='" + nom + '\'' +
                ", classement=" + classement +
                ", temps='" + temps + '\'' +
                ", club='" + club + '\'' +
                ", sexe='" + sexe + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Coureur() {
    }


    public Coureur(String nom, int classement, String temps, String club, String sexe, String categorie) {
        this.nom = nom;
        this.classement = classement;
        this.temps = temps;
        this.club = club;
        this.sexe = sexe;
        this.categorie = categorie;
    }

    private String categorie;


    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        switch (sexe) {
            case "M":
                sexe = "Masculin";
                break;
            case "F":
                sexe = "Féminin";
                break;
        }
        this.sexe = sexe;
    }

    public Coureur(String nom, int classement, String temps, String club, String sexe) {
        this.nom = nom;
        this.classement = classement;
        this.temps = temps;
        this.club = club;
        this.sexe = sexe;
    }

    public Coureur(String nom, int classement, String temps) {
        this.nom = nom;
        this.classement = classement;
        this.temps = temps;
    }

    public String getName() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

}
