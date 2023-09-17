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
    }

    private static void drawLabyrinth(StringBuilder svgContent) {
        // Dessinez les murs du labyrinthe (exemple)
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                // Dessinez un mur à chaque coordonnée
                if (x % 2 == 0 || y % 2 == 0) {
                    svgContent.append("<rect x='" + x * 4 + "' y='" + y * 4 + "' width='4' height='4' fill='black' />");
                }
            }
        }
    }
}

