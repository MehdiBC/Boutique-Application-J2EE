package com.dao;
import com.metier.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class GestionUserDAO {
    public Utilisateur loadUser(String email, String password){
        Connection conn= Utilitaire.getConnection();
        Utilisateur u=null;
        try {
            PreparedStatement ps=conn.prepareStatement("select * from utilisateur where email like ? and password like ? ");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rsUser=ps.executeQuery();
            if(rsUser.next()){
                u=new Utilisateur(rsUser.getInt("id"),
                        rsUser.getString("nom"),
                        rsUser.getString("prenom"),
                        rsUser.getString("email"),
                        rsUser.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    public Utilisateur loadUser(int id){
        Connection conn= Utilitaire.getConnection();
        Utilisateur u=null;
        try {
            PreparedStatement ps=conn.prepareStatement("select * from utilisateur where id like ? ");
            ps.setString(1,Integer.toString(id));
            ResultSet rsUser=ps.executeQuery();
            if(rsUser.next()){
                u=new Utilisateur(rsUser.getInt("id"),
                        rsUser.getString("nom"),
                        rsUser.getString("prenom"),
                        rsUser.getString("email"),
                        rsUser.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
    public Vector<Utilisateur> selectAll(){
        Connection conn= Utilitaire.getConnection();
        Vector users=new Vector();
        Utilisateur u=null;
        try {
            PreparedStatement ps=conn.prepareStatement("select * FROM utilisateur");
            ResultSet rsUser=ps.executeQuery();
            while(rsUser.next()){
                u=new Utilisateur(rsUser.getInt("id"),
                        rsUser.getString("nom"),
                        rsUser.getString("prenom"),
                        rsUser.getString("email"),
                        rsUser.getString("password"));
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void addUser(String nom,String prenom, String email,String password){
        Connection conn= Utilitaire.getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement("insert into utilisateur (nom,prenom,email,password) values(?,?,?,?)");
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setString(3,email);
            ps.setString(4,password);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(int id, String nom, String prenom, String email, String password){
        Connection conn= Utilitaire.getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement("UPDATE utilisateur SET nom= ?, prenom= ?, email= ?, password= ? Where id = ?");
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setString(3,email);
            ps.setString(4,password);
            ps.setString(5,Integer.toString(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUser(int id){
        Connection conn= Utilitaire.getConnection();
        try {
            PreparedStatement ps=conn.prepareStatement("DELETE FROM utilisateur Where id = ?");
            ps.setString(1, Integer.toString(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
