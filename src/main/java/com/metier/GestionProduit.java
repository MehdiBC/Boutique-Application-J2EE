package com.metier;

import com.dao.GestionProduitDAO;

import java.util.Collections;
import java.util.Vector;

public class GestionProduit {
    private GestionProduitDAO dao;
    public GestionProduit(){
        dao=new GestionProduitDAO();
    }
    public Produit find(int code){
        return dao.loadProd(code);
    }
    public Vector<Produit> list(){
        return dao.selectAll();
    }
    public void add(int code, String nom, String description, int quantite, float prix){
        dao.addProd(code, nom, description, quantite, prix);
    }
    public void update(int code, String nom, String description, int quantite, float prix){
        dao.updateProd(code, nom, description, quantite, prix);
    }
    public void delete(int code){
        dao.deleteProd(code);
    }
    public Vector<Produit> sort(){
        Vector<Produit> products = list();
        Collections.sort(products);
        return products;
    }
}
