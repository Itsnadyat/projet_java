package entity;

public class Article {
    private String nom;
    private double prix;
    private int quantiteStock;

    public Article(String nom, double prix, int quantiteStock) {
        this.nom = nom;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public void mettreAJourQuantite(int nouvelleQuantite) {
        this.quantiteStock = nouvelleQuantite;
    }
}