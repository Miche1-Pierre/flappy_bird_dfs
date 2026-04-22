package flappy.models;

import flappy.Principal;

import java.awt.*;

public class Projectile extends Sprite {

    public Projectile(int x, int y) {
        this.x = x;
        this.y = y;
        this.largeur = 10;
        this.vitesse = 10;
        this.couleur = Color.ORANGE;
    }

    @Override
    public void deplacement() {
        x += vitesse;
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x, y, largeur, largeur);
    }

    public boolean estHorsEcran(){
        return x > Principal.LARGEUR;
    }
}
