package com.dao;

import com.metier.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class GestionProduitDAO {
    public Produit loadProd(int code){
        Connection conn= Utilitaire.getConnection();
        Produit p=null;
        try {
            PreparedStatement ps=conn.prepareStatement("select * from article where code like ?");
            ps.setString(1,Integer.toString(code));
            ResultSet rsProd=ps.executeQuery();
            if(rsProd.next()){
                p=new Produit(Integer.parseInt(rsProd.getString("code")),
                        rsProd.getString("nom"),
                        rsProd.getString("description"),
                        Integer.parseInt(rsProd.getString("quantite")),
                        Float.parseFloat(rsProd.getString("prix")) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    public Vector<Produit> selectAll(){
        Connection conn= Utilitaire.getConnection();
        Vector<Produit> products=new Vector<Produit>();
        Produit p=null;
        try {
            PreparedStatement ps=conn.prepareStatement("select * FROM article");
            ResultSet rsProd=ps.executeQuery();
            while(rsProd.next()){
                p=new Produit(Integer.parseInt(rsProd.getString("code")),
                        rsProd.getString("nom"),
                        rsProd.getString("description"),
                        Integer.parseInt(rsProd.getString("quantite")),
                        Float.parseFloat(rsProd.getString("prix")) );
                products.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public void addProd(int code, String nom,String description, int quantite, float prix){
        Connection conn= Utilitaire.getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement("insert into article (code,nom,description,quantite,prix) values(?,?,?,?,?)");
            ps.setString(1,Integer.toString(code));
            ps.setString(2,nom);
            ps.setString(3,description);
            ps.setString(4,Integer.toString(quantite));
            ps.setString(5,Float.toString(prix));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateProd(int code, String nom, String description, int quantite, float prix){
        Connection conn= Utilitaire.getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement("UPDATE article SET nom= ?, description= ?, quantite= ?, prix= ? Where code = ?");
            ps.setString(1,nom);
            ps.setString(2,description);
            ps.setString(3,Integer.toString(quantite));
            ps.setString(4,Float.toString(prix));
            ps.setString(5,Integer.toString(code));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteProd(int code){
        Connection conn= Utilitaire.getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement("DELETE FROM article Where code = ?");
            ps.setString(1, Integer.toString(code));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
