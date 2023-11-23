import models.Labyrinthe;
import SVG.generateur;
import vue.Main;

import javax.swing.*;


public class main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Labyrinthe l=new Labyrinthe( 5);
        System.out.println("Temps d'exécution "+(System.currentTimeMillis()-startTime));
        l.getCases();
        generateur.generer(l);

        final Main main = new Main(l.getCases(),l.getLongeur());
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                main.createAndShowGUI();
            }
        });

    }


}

