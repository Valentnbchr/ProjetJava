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
public class UtilisateurM {
    int ID;
    String nom, prenom, email, mdp;
    int droit;
    
    public UtilisateurM(int ID, String nom, String prenom, String email, String mdp, int droit)
    {
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.droit = droit;
    }
    
    public int getID()
    {
        return ID;
    }
    public String getnom()
    {
        return nom;
    }
    public String getprenom()
    {
        return prenom;
    }
    public String getemail()
    {
        return email;
    }
    public String getmdp()
    {
        return mdp;
    }
    public int getdoit()
    {
        return droit;
    }
}
