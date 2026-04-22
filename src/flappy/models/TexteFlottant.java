package flappy.models;

import java.awt.*;

public class TexteFlottant {

    private int x;
    private int y;
    private String text;
    private int duree;

    public TexteFlottant(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.duree = duree = 180;
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(Color.YELLOW);
        dessin.setFont(new Font("Arial", Font.BOLD, 30));
        dessin.drawString(text, x, y);
        duree--;
    }

    public boolean estExpire() {
        return duree <= 0;
    }
}
