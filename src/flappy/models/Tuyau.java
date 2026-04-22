package flappy.models;

import flappy.Principal;
import flappy.utils.Utils;

import java.awt.*;

public class Tuyau extends Sprite{

    protected int ecartement = 200;
    protected int marge = 50;
    private int vies = 3;

    public Tuyau(){
        largeur = 100;
        this.vitesse = 4;
        this.couleur = Color.GREEN;
    }

    public void deplacement(){
        x -= vitesse;

        if(x < -largeur) {
            x = Principal.LARGEUR;
            y = Utils.aleatoire(marge + ecartement, Principal.HAUTEUR - marge);
        }
    }

    public void dessiner(Graphics2D dessin){
        dessin.setColor(couleur);
        dessin.fillRect(x,y, largeur, Principal.HAUTEUR);
        dessin.fillRect(x,y-ecartement-Principal.HAUTEUR, largeur, Principal.HAUTEUR);
    }

    @Override
    public Zone[] getZones() {

        Zone zoneTuyauBas = new Zone(
                new Point(x, y),
                new Point(x + largeur, y),
                new Point(x, y + Principal.HAUTEUR),
                new Point(x+ largeur, y + Principal.HAUTEUR));

        Zone zoneTuyauHaut = new Zone(
                new Point(x, y - Principal.HAUTEUR),
                new Point(x + largeur, y - Principal.HAUTEUR),
                new Point(x, y - ecartement),
                new Point(x+ largeur, y - ecartement));

        return new Zone[]{zoneTuyauBas, zoneTuyauHaut};
    }

    public void recevoirImpact() {
        vies--;
    }

    public boolean estDetruit() {
        return vies <= 0;
    }

    // GETTER & SETTER
    public int getEcartement() {
        return ecartement;
    }

    public void setEcartement(int ecartement) {
        this.ecartement = ecartement;
    }

    public int getMarge() {
        return marge;
    }

    public void setMarge(int marge) {
        this.marge = marge;
    }
}
