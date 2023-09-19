import models.Labyrinthe;

import java.io.FileWriter;
import java.io.IOException;

public class main {

    public static void main(String[] args) {
        StringBuilder svgContent = new StringBuilder();
        svgContent.append("<svg xmlns='http://www.w3.org/2000/svg' width='400' height='400'>");

        // Dessinez les éléments du labyrinthe
        drawLabyrinth(svgContent);

        // Fin du document SVG
        svgContent.append("</svg>");

        // Enregistrez le document SVG dans un fichier
        try {
            FileWriter fileWriter = new FileWriter("labyrinth.svg");
            fileWriter.write(svgContent.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Labyrinthe l=new Labyrinthe( 3);
        System.out.println(l.toString());
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

