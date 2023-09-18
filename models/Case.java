package models;

public class Case {
    Boolean n,s,e,o;
    int nom;
    public Case(int n){
     this.n=true;
     this.s=true;
     this.e=true;
     this.o=true;
     this.nom=n;
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
}
