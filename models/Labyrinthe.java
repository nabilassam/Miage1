package models;

import java.util.Arrays;
import java.util.Random;

public class Labyrinthe {
    private int longeur;
    private int entre,sortie;
    private Case[] cases;

    public Labyrinthe(int longeur) {
        cases= new Case[longeur*longeur];
        this.longeur = longeur;
        for (int i=0;i<longeur*longeur;i++){
            cases[i]= new Case(i);
        }
        this.construirelabyrinthe();
    }


    private void construirelabyrinthe(){
        int compteur=0;
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
        do{
            i=new Random().nextInt(0,longeur*longeur-1);
            int i2=new Random().nextInt(0,4);
            int i3;

            switch (i2){
                case 0:
                    //mur nord
                    i3=i-longeur;
                    if(i3<0 || cases[i].getNom()==cases[i3].getNom()||!cases[i].getN()){
                    break;}
                    else {
                        cases[i].setN(false);
                        if(!(i3+longeur>=longeur*longeur))//à corriger
                            cases[i3].setS(false);
                        changernombre(i,i3);
                        compteur++;
                        break;
                    }
                case 1:
                    //mur sud
                    i3=i+longeur;
                    if(i3>=longeur*longeur || cases[i].getNom()==cases[i3].getNom()||!cases[i].getS()) {
                        break;
                    }else{
                        cases[i].setS(false);
                        cases[i3].setN(false);
                        changernombre(i,i3);
                        compteur++;
                        break;
                    }
                case 2:
                    //mur est
                    if ((i+1)>=longeur*longeur)
                        break;
                    i3=i+1;
                    if(i%longeur==1 || cases[i].getNom()==cases[i3].getNom()||!cases[i].getE()) {
                        break;
                    }else {
                        cases[i].setE(false);
                        cases[i3].setO(false);
                        changernombre(i,i3);
                        compteur++;
                        break;
                    }
                case 3:
                    //mur ouest
                    i3=i-1;
                    if (i%longeur==0 || cases[i].getNom()==cases[i3].getNom()||!cases[i].getO())
                        break;
                    else {
                        cases[i].setO(false);
                        cases[i3].setE(false);
                        changernombre(i,i3);
                        compteur++;
                        break;
                    }
            }



        }while (compteur<longeur*longeur-1);


    }

    private void changernombre(int i3, int i){
        int min=Math.min(cases[i3].getNom(),cases[i].getNom());
        int max=Math.max(cases[i3].getNom(),cases[i].getNom());
        for(int j=0;j<longeur*longeur;j++ ){
            if(cases[j].getNom()==max)
                cases[j].setNom(min);
        }
    }

    @Override
    public String toString() {
        return "Labyrinthe{" +
                "cases=" + Arrays.toString(cases) +
                "}";
    }
    private boolean controle(){
        for (int i =0;i<=longeur*longeur-2;i++){
            if(cases[i].getNom()!=cases[i+1].getNom())
                return true;
        }
        return false;
    }

    public int getLongeur() {
        return longeur;
    }

    public Case[] getCases() {
        return cases;
    }
}
