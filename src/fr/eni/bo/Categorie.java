package fr.eni.bo;

import java.io.Serializable;

public class Categorie implements Serializable {
    private Integer id_cat;
    private String libelle;

    public Categorie(Integer id_cat) {
        this.id_cat = id_cat;
    }

    public Categorie(Integer id_cat, String libelle) {
        this.id_cat = id_cat;
        this.libelle = libelle;
    }

    public Integer getId_cat() {
        return id_cat;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
