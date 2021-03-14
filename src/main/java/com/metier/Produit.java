package com.metier;

public class Produit implements Comparable {
    private int code, quantite;
    private String nom, description;
    private float prix;

    public Produit(int code, String nom, String description, int quantite, float prix) {
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public int compareTo(Object o) {
        Produit prod = (Produit) o;
        if(prod.prix < prix) return 1;
        else if(prod.prix > prix) return -1;
        else return 0;
    }
}
