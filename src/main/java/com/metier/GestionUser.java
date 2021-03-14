package com.metier;

import com.dao.GestionUserDAO;

import java.util.Vector;

public class GestionUser {
    private final GestionUserDAO dao;
    public GestionUser(){
        dao=new GestionUserDAO();
    }
    public Utilisateur find(String email, String password){
        return dao.loadUser(email, password);
    }
    public Utilisateur find(int id){
        return dao.loadUser(id);
    }
    public Vector<Utilisateur> list(){
        return dao.selectAll();
    }
    public void add(String nom, String prenom, String email, String password){
        dao.addUser(nom, prenom, email, password);
    }
    public void update(int id, String nom, String prenom, String email, String password){
        dao.updateUser(id, nom, prenom, email, password);
    }
    public void delete(int id){
        dao.deleteUser(id);
    }
}