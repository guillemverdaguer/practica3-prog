package prog2.model;

import java.io.Serializable;
import java.util.Date;

public abstract class Prestec implements InPrestec, Serializable {
    private Exemplar exemplar;
    private Usuari usuari;
    private Date dataCreacio;
    private Date dataLimitRetorn;
    private boolean retornat;

    // El constructor solo necesita exemplar y usuari, el resto se calcula
    public Prestec(Exemplar exemplar, Usuari usuari) {
        this.exemplar = exemplar;
        this.usuari = usuari;
        this.dataCreacio = new Date();
        this.dataLimitRetorn = new Date(dataCreacio.getTime() + duradaPrestec());
        this.retornat = false;
        exemplar.setDisponible(false);
    }
    public Exemplar getExemplar() { return exemplar; }
    public void setExemplar(Exemplar exemplar) { this.exemplar = exemplar; }
    public Usuari getUsuari() { return usuari; }
    public void setUsuari(Usuari usuari) { this.usuari = usuari; }
    public Date getDataCreacio() { return dataCreacio; }
    public void setDataCreacio(Date dataCreacio) { this.dataCreacio = dataCreacio; }
    public Date getDataLimitRetorn() { return dataLimitRetorn; }
    public void setDataLimitRetorn(Date dataLimitRetorn) { this.dataLimitRetorn = dataLimitRetorn; }
    public boolean getRetornat() { return retornat; }
    public void setRetornat(boolean retornat) { this.retornat = retornat; }
    public abstract String tipusPrestec();
    public abstract long duradaPrestec();
    @Override
    public void retorna() {
        this.retornat = true;
        exemplar.setDisponible(true);
    }
    @Override
    public boolean prestecEndarrerit() {
        return !retornat && new Date().after(dataLimitRetorn);
    }
    @Override
    public String toString() {
        return "Tipus=" + tipusPrestec() + ", Exemplar=" + exemplar.getTitol() + ", Usuari=" + usuari.getNom() +
                ", Data de creacio=" + dataCreacio + ", Data límit retorn=" + dataLimitRetorn + ", Retornat=" + retornat;
    }
}