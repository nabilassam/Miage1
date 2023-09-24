package models;

import java.util.ArrayList;

public class Case {
    Boolean n,s,e,o;
    ArrayList<Case> c;
    int nom;
    private boolean ouverte;

    public Case(int n){
     this.n=true;
     this.s=true;
     this.e=true;
     this.o=true;
     this.nom=n;
        this.c=new ArrayList<Case>();
        this.c.add(this);
    }
    public void fusion(Case c1){
        c1.setNom(this.nom);
        this.c.add(c1);
    }

    public Boolean getN() {
        return n;
    }

    public void setN(Boolean n) {
        this.n = n;
    }

    public Boolean getS() {
        return s;
    }

    public void setS(Boolean s) {
        this.s = s;
    }

    public Boolean getE() {
        return e;
    }

    public void setE(Boolean e) {
        this.e = e;
    }

    public Boolean getO() {
        return o;
    }

    public void setO(Boolean o) {
        this.o = o;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Case{" +
                "n=" + n +
                ", s=" + s +
                ", e=" + e +
                ", o=" + o +
                ", nom=" + nom +
                '}';
    }
}
