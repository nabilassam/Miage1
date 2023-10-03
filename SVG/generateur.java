package SVG;

import models.Case;
import models.Labyrinthe;

import java.io.FileWriter;
import java.io.IOException;

public class generateur {

   public static void generer(Labyrinthe labyrinthe){


      // Dessiner les éléments du labyrinthe
      int longeur=labyrinthe.getLongeur();
      Case cases[]=labyrinthe.getCases();
      int entre=labyrinthe.getEntre();
      int sortie=labyrinthe.getSortie();
      int y=0;
      int x=0;
      Case c;
      try {
         FileWriter fileWriter = new FileWriter("labyrinth.svg");
         fileWriter.write("<svg xmlns='http://www.w3.org/2000/svg' width='"+longeur*10+5+"' height='"+(longeur*10+10)+5+"'>");
         for (int i = 0; i < longeur * longeur; i++) {
            if (i==entre)
               fileWriter.write("<line x1='" + x + "' y1='" + y + "' x2='" + x + "' y2='" + (y + 10) + "' stroke='green' stroke-width='3' />");
            if(i==sortie)
               fileWriter.write("<line x1='" + (x + 10) + "' y1='" + y + "' x2='" + (x + 10) + "' y2='" + (y + 10) + "' stroke='red' stroke-width='3' />");
            c = cases[i];

            if (c.getN()) {
               fileWriter.write("<line x1='" + x + "' y1='" + y + "' x2='" + (x + 10) + "' y2='" + y + "' stroke='black' />");
            }

            if (c.getS()) {
               fileWriter.write("<line x1='" + x + "' y1='" + (y + 10) + "' x2='" + (x + 10) + "' y2='" + (y + 10) + "' stroke='black' />");
            }

            if (c.getO()) {
               fileWriter.write("<line x1='" + x + "' y1='" + y + "' x2='" + x + "' y2='" + (y + 10) + "' stroke='black' />");
            }

            if (c.getE()) {
               fileWriter.write("<line x1='" + (x + 10) + "' y1='" + y + "' x2='" + (x + 10) + "' y2='" + (y + 10) + "' stroke='black' />");
            }

            x += 10;

            if (i % longeur == longeur - 1) {
               y += 10;
               x = 0;
            }
         }
         fileWriter.write("</svg>");
         fileWriter.close();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }

      // Fin du document SVG






   }

}

