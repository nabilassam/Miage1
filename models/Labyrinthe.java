package models;

import java.util.Random;

public class Labyrinthe {
    private int longeur;
    private int entre,sortie;
    private Case[] cases;

    public Labyrinthe(int longeur) {
        this.longeur = longeur;
        for (int i=0;i<longeur*longeur;i++){
            cases[i]= new Case(i);
        }
        this.construirelabyrinthe();
    }


    private void construirelabyrinthe(){

        //entré
        int i=new Random().nextInt(longeur-1);
        i=i*longeur;
        this.entre=i;
        Case c=cases[i];
        c.setO(false);
        //sortie
        i=new Random().nextInt(1,longeur);
        i=i*longeur-1;
        c=cases[i];
        this.sortie=i;
        c.setE(false);

        boolean b=true;
        while (b){
            i=new Random().nextInt(longeur*2-1);
            int i2=new Random().nextInt(3);
            int i3;
            switch (i2){
                case 0:
                    i3=i-longeur;
                    if(i3<0 && cases[i].getNom()==cases[i].getNom()){
                    break;}
                    else {
                        cases[i].setN(false);
                        changernombre(i,i3);
                        break;
                    }
            }
        }
    }

    private void changernombre(int i, int i3){
        for(int j=0;j<longeur*longeur;j++ ){
            if(cases[j].getNom()==i)
                cases[j].setNom(i3);
        }
    }


}
