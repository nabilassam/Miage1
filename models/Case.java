package models;

import java.util.ArrayList;

public class Case {
    Boolean n,s,e,o;
    ArrayList<Case> c;
    int nom;
    Case pere;


    public Case(int n){
        this.pere=null;
     this.n=true;
     this.s=true;
     this.e=true;
     this.o=true;
     this.nom=n;
        this.c=new ArrayList<Case>();
        this.c.add(this);
    }
    public void fusion(Case c1){
        if (this.pere!=null){
            this.pere.fusion(c1);
        }else
      if (c1.getPere()==null){
          c1.setPere(this);
          for (Case tmp:c1.getC()){
              tmp.setNom(this.nom);
          }
          this.c.addAll(c1.getC());
      }else{
          fusion(c1.getPere());
      }

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

    public ArrayList<Case> getC() {
        return c;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    public Case getPere() {
        return pere;
    }

    public void setPere(Case pere) {
        this.pere = pere;
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
