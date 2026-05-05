package prog2.model;

import java.io.Serializable;

public abstract class Usuari implements InUsuari, Serializable {
    private String email;
    private String nom;
    private String adreca;
    private int numPrestecsNormals;
    private int numPrestecsLlargs;

    public Usuari(String email, String nom, String adreca) {
        this.email = email;
        this.nom = nom;
        this.adreca = adreca;
        this.numPrestecsNormals = 0;
        this.numPrestecsLlargs = 0;

    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdreca() {
        return adreca;
    }
    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }
    public abstract String tipusUsuari();

    public int getNumPrestecsNormals() {
        return numPrestecsNormals;
    }
    public void setNumPrestecsNormals(int numPrestecsNormals) {
        this.numPrestecsNormals = numPrestecsNormals;
    }
    public int getNumPrestecsLlargs() {
        return numPrestecsLlargs;
    }
    public void setNumPrestecsLlargs(int numPrestecsLlargs) {
        this.numPrestecsLlargs = numPrestecsLlargs;
    }
    @Override
    public String toString(){
        return "Tipus=" + tipusUsuari() + ", Email=" + email + ", Nom=" + nom +", Adreca=" + adreca +
                ", Num. prestecs normals=" + numPrestecsNormals + ", Num. prestecs llargs=" + numPrestecsLlargs;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuari)) return false;
        Usuari u = (Usuari) o;
        return u.getEmail().equals(email);
    }
}
