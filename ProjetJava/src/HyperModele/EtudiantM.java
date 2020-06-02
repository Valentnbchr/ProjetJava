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
public class EtudiantM {
    private int ID;
    private int numero;
    private int IDgroupe;
    
    public EtudiantM(int ID, int numero, int IDgroupe, String nom, String prenom)
    {
        this.ID = ID;
        this.numero = numero;
        this.IDgroupe = IDgroupe;

    }
    
    public int getID()
    {
        return ID;
    }
    public int getnumero()
    {
        return numero;
    }
    public int getIDgroupe()
    {
        return IDgroupe;
    }
    
}
