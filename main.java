import models.Labyrinthe;
import SVG.generateur;
import java.io.FileWriter;
import java.io.IOException;

public class main {

    public static void main(String[] args) {

        Labyrinthe l=new Labyrinthe( 500);
        System.out.println("l");
        generateur.generer(l.getCases(),l.getLongeur());
    }

    private static void drawLabyrinth(StringBuilder svgContent) {
        // Dessinez les murs du labyrinthe (exemple)
        for (int x = 0; x < 10; x++) {
            svgContent.append("<rect x='" + 0 + "' y='" + 0 + "' width='" + 1000 + "' height='" + 1000 + "' fill='white' />");
            for (int y = 0; y < 10; y++) {
                // Dessinez un mur à chaque coordonnée
                if (x % 2 == 0 || y % 2 == 0) {

                    svgContent.append("<line x1='" + x + "' y1='" + y + "' x2='" + x+2 + "' y2='" + y+2 + "' stroke='black' />");
                }
            }
        }
    }
}

