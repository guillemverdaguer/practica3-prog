package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Dades implements InDades, Serializable {
    private LlistaExemplars llistaExemplars;
    private LlistaPrestecs llistaPrestecs;
    private LlistaUsuaris llistaUsuaris;

    public Dades(LlistaExemplars llistaExemplars, LlistaPrestecs llistaPrestecs, LlistaUsuaris llistaUsuaris) {
        this.llistaExemplars = llistaExemplars;
        this.llistaPrestecs = llistaPrestecs;
        this.llistaUsuaris = llistaUsuaris;
    }

    @Override
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        Exemplar exemplar = new Exemplar(id, titol, autor, admetPrestecLlarg, true);
        llistaExemplars.afegir(exemplar);
    }

    @Override
    public ArrayList<Exemplar> recuperaExemplars() {
        return llistaExemplars.getArrayList();
    }

    @Override
    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        if (esEstudiant) {
            Estudiant estudiant = new Estudiant(email, nom, adreca);
            llistaUsuaris.afegir(estudiant);
        } else {
            Professor professor = new Professor(email, nom, adreca);
            llistaUsuaris.afegir(professor);
        }
    }

    @Override
    public ArrayList<Usuari> recuperaUsuaris() {
        return llistaUsuaris.getArrayList();
    }

    @Override
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        if(esLlarg && !(llistaExemplars.getAt(exemplarPos).getAdmetPrestecLlarg())) {
            throw new BiblioException("L'exemplar no admet prestecs llargs");
        }
        if(!llistaExemplars.getAt(exemplarPos).isDisponible()){
            throw  new BiblioException("L'exemplar no està disponible");
        }
        Date date;

        if(llistaUsuaris.getAt(usuariPos).){

        }
    }

    @Override
    public void retornarPrestec(int position) throws BiblioException {

    }

    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        return null;
    }

    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        return null;
    }
}
