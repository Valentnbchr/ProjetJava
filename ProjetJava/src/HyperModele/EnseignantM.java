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
public class EnseignantM {
    private int ID;
    private int IDcours;
    private String nom;
    private String prenom;
    
    public EnseignantM(int ID, int IDcours, String nom, String prenom)
    {
        this.ID = ID;
        this.IDcours = IDcours;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public int getID()
    {
        return ID;
    }
    public int getIDcours()
    {
        return IDcours;
    }
    public String getNom()
    {
        return nom;
    }
    public String getPrenom()
    {
        return prenom;
    }
    
}
