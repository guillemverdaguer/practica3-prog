package prog2.model;

import java.io.Serializable;

public class Exemplar implements InExemplar, Serializable {
    private String id;
    private String autor;
    private String titol;
    private boolean admetPrestecLlarg;
    private boolean disponible;

    public Exemplar(String id, String autor, String titol, boolean admetPrestecLlarg, boolean disponible) {
        this.id = id;
        this.autor = autor;
        this.titol = titol;
        this.admetPrestecLlarg = admetPrestecLlarg;
        this.disponible = disponible;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getTitol() { return titol; }
    public void setTitol(String titol) { this.titol = titol; }
    public  boolean getAdmetPrestecLlarg() { return admetPrestecLlarg; }
    public void setAdmetPrestecLlarg(boolean admetPrestecLlarg) {
        this.admetPrestecLlarg = admetPrestecLlarg;
    }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exemplar)) return false;
        Exemplar e = (Exemplar) o;
        return e.getId().equals(id);
    }

    @Override
    public String toString(){
        return "Id=" + id + ", Titol=" + titol + ", Autor=" + autor +
                ", Admet Prestec Llarg=" + admetPrestecLlarg + ", Disponible=" +  disponible;
    }
}
