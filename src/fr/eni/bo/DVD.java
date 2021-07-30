package fr.eni.bo;

public class DVD {
    private int id;
    private String title;
    private int year;
    private String actor;
    private int price;
    private int id_cat;

    public DVD(int id, String title, int year, String actor, int price, int id_cat) {
        this.id = id;
        this.title= title;
        this.year = year;
        this.actor = actor;
        this.price = price;
        this.id_cat = id_cat;
    }

    public DVD(String title, int year, String actor, int price, int id_cat) {
        this.title = title;
        this.year = year;
        this.actor = actor;
        this.price = price;
        this.id_cat = id_cat;
    }

    public DVD(String title, int year, String actor, int price) {
        this.title = title;
        this.year = year;
        this.actor = actor;
        this.price = price;
    }


    public DVD() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitre(String titre) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setAnnee(int year) {
        this.year = year;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }
}
