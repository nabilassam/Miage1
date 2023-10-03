import models.Labyrinthe;
import SVG.generateur;


public class main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Labyrinthe l=new Labyrinthe( 5);
        System.out.println("Temps d'exécution "+(System.currentTimeMillis()-startTime));

        generateur.generer(l);

    }


}

