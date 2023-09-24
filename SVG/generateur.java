package SVG;

import models.Case;

import java.io.FileWriter;
import java.io.IOException;

public class generateur {

   public static void generer(Case[] cases, int longeur){
      StringBuilder svgContent = new StringBuilder();
      svgContent.append("<svg xmlns='http://www.w3.org/2000/svg' width='"+longeur*10+"' height='"+(longeur*10+10)+"'>");
      // Dessiner les éléments du labyrinthe
      int y=0;
      int x=0;
      Case c;

      for (int i = 0; i < longeur * longeur; i++) {
         c = cases[i];

         if (c.getN()) {
            svgContent.append("<line x1='" + x + "' y1='" + y + "' x2='" + (x + 10) + "' y2='" + y + "' stroke='black' />");
         }

         if (c.getS()) {
            svgContent.append("<line x1='" + x + "' y1='" + (y + 10) + "' x2='" + (x + 10) + "' y2='" + (y + 10) + "' stroke='black' />");
         }

         if (c.getO()) {
            svgContent.append("<line x1='" + x + "' y1='" + y + "' x2='" + x + "' y2='" + (y + 10) + "' stroke='black' />");
         }

         if (c.getE()) {
            svgContent.append("<line x1='" + (x + 10) + "' y1='" + y + "' x2='" + (x + 10) + "' y2='" + (y + 10) + "' stroke='black' />");
         }

         x += 10;

         if (i % longeur == longeur - 1) {
            y += 10;
            x = 0;
         }
      }


      // Fin du document SVG
      svgContent.append("</svg>");

      try {
         FileWriter fileWriter = new FileWriter("labyrinth.svg");
         fileWriter.write(svgContent.toString());
         fileWriter.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

}

