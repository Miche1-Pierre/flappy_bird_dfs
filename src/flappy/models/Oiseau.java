package flappy.models;

import flappy.Principal;
import flappy.utils.Utils;

import java.awt.*;

public class Oiseau extends Sprite {

    protected float gravite = 1.0f;

    public Oiseau() {
        largeur = 50;
        this.couleur = Color.RED;
        this.vitesse = 5;
    }

    public void deplacement(){
        this.y += gravite;
        this.gravite += 0.2;
    }

    public void deplacerDroite() {
        this.x += vitesse;
    }

    public void deplacerGauche() {
        this.x -= vitesse;
    }

    public void dessiner(Graphics2D dessin){
        dessin.setColor(couleur);
        dessin.fillOval(x,y, largeur, largeur);

        int becLargeur = largeur / 3;
        int becHauteur = largeur / 4;
        int centreY = y + largeur / 2;

        int[] xs = { x + largeur, x + largeur, x + largeur + becLargeur };
        int[] ys = { centreY - becHauteur / 2, centreY + becHauteur / 2, centreY };

        dessin.setColor(Color.BLACK);
        dessin.fillPolygon(xs, ys, 3);
    }

    @Override
    public Zone[] getZones() {
        int becLargeur = largeur / 3;
        int becHauteur = largeur / 4;
        int centreY = y + largeur / 2;

        Zone corps = new Zone(
                new Point(x, y),
                new Point(x + largeur, y),
                new Point(x, y + largeur),
                new Point(x + largeur, y + largeur)
        );

        Zone bec = new Zone(
                new Point(x + largeur, centreY - becHauteur / 2),
                new Point(x + largeur + becLargeur, centreY - becHauteur / 2),
                new Point(x + largeur, centreY + becHauteur / 2),
                new Point(x + largeur + becLargeur, centreY + becHauteur / 2)
        );

        return new Zone[]{corps, bec};
    }

    // GETTER & SETTER
    public void saut(){
       this.gravite = -5;
    }

    public float getGravite() {
        return gravite;
    }

    public void setGravite(float gravite) {
        this.gravite = gravite;
    }
}
