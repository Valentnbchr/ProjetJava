/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HyperModele;

/**
 *
 * @author valentinbchr
 */
public class GroupeM {
    private int ID;
    private String nom;
    private int IDpromo;
    
    public GroupeM(int ID, String nom, int IDpromo)
    {
        this.ID = ID;
        this.nom = nom;
        this.IDpromo = IDpromo;
    }
    
    public int getID()
    {
        return ID;
    }
    public String getNom()
    {
        return nom;
    }
    public int getIDpromo()
    {
        return IDpromo;
    }
}
