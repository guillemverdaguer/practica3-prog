package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Dades implements InDades, Serializable {
    private LlistaExemplars llistaExemplars;
    private LlistaPrestecs llistaPrestecs;
    private LlistaUsuaris llistaUsuaris;

    public Dades() {
        this.llistaExemplars = new LlistaExemplars();
        this.llistaPrestecs = new LlistaPrestecs();
        this.llistaUsuaris = new LlistaUsuaris();
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
            for(Prestec prestec : llistaPrestecs.getArrayList()){
                if(prestec.getUsuari().equals(llistaUsuaris.getAt(usuariPos)) && prestec.prestecEndarrerit()){
                    throw new BiblioException("L'usuari té prestecs endarrerits");
                }
            }
            if(llistaUsuaris.getAt(usuariPos).getNumPrestecsLlargs() >= llistaUsuaris.getAt(usuariPos).getMaxPrestecsLlargs() && esLlarg){
                throw new BiblioException("L'usuari ha arribat al màxim de prestecs llargs");
            }
            if (!esLlarg && llistaUsuaris.getAt(usuariPos).getNumPrestecsNormals() >=
                    llistaUsuaris.getAt(usuariPos).getMaxPrestecsNormals()) {
                throw new BiblioException("L'usuari ha arribat al màxim de prestecs normals");
            }
            if(esLlarg) {
                PrestecLlarg prestec = new PrestecLlarg(llistaExemplars.getAt(exemplarPos), llistaUsuaris.getAt(usuariPos));
                llistaPrestecs.afegir(prestec);
                llistaUsuaris.getAt(usuariPos).setNumPrestecsLlargs(llistaUsuaris.getAt(usuariPos).getNumPrestecsLlargs() + 1);

            } else {
                PrestecNormal prestec = new PrestecNormal(llistaExemplars.getAt(exemplarPos), llistaUsuaris.getAt(usuariPos));
                llistaPrestecs.afegir(prestec);
                llistaUsuaris.getAt(usuariPos).setNumPrestecsNormals(llistaUsuaris.getAt(usuariPos).getNumPrestecsNormals() + 1);

            }
    }

    @Override
    public void retornarPrestec(int position) throws BiblioException {
        if(llistaPrestecs.getAt(position).getRetornat()) {
           throw new BiblioException("El prestec ja ha estat retornat");
        }
        llistaPrestecs.getAt(position).setRetornat(true);
        llistaPrestecs.getAt(position).getExemplar().setDisponible(true);
        if(llistaPrestecs.getAt(position).tipusPrestec().equals("Normal")) {
            llistaPrestecs.getAt(position).getUsuari().setNumPrestecsNormals(llistaPrestecs.getAt(position).getUsuari().getNumPrestecsNormals() - 1);
        } else {
            llistaPrestecs.getAt(position).getUsuari().setNumPrestecsLlargs(llistaPrestecs.getAt(position).getUsuari().getNumPrestecsLlargs() - 1);
        }
    }

    @Override
    public ArrayList<Prestec> recuperaPrestecs() {
        return llistaPrestecs.getArrayList();
    }

    @Override
    public ArrayList<Prestec> recuperaPrestecsNoRetornats() {
        ArrayList<Prestec> llistaPrestecsNoRetornats = new ArrayList<>();
        for(Prestec prestec : llistaPrestecs.getArrayList()) {
            if(!prestec.getRetornat()) {
                llistaPrestecsNoRetornats.add(prestec);
            }
        }
        return llistaPrestecsNoRetornats;
    }
}
