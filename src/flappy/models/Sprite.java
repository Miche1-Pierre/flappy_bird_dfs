package flappy.models;

import java.awt.*;

public abstract class Sprite {

    protected int x;
    protected int y;

    public abstract void dessiner(Graphics2D dessin);

    public abstract void deplacement();


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
