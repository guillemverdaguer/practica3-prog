package prog2.adaptador;
import prog2.model.Dades;
import prog2.model.Exemplar;
import prog2.model.Prestec;
import prog2.model.Usuari;
import prog2.vista.BiblioException;

import java.io.*;
import java.util.ArrayList;

public class Adaptador {
    private Dades dades;

    public Adaptador() {
        this.dades = new Dades();
    }
    public void afegirExemplar(String id, String titol, String autor, boolean admetPrestecLlarg) throws BiblioException {
        dades.afegirExemplar(id, titol, autor, admetPrestecLlarg);
    }
    public ArrayList<String> recuperaExemplars(){
        ArrayList<String> exemplars = new ArrayList<>();
        for(Exemplar exemplar : dades.recuperaExemplars()) {
            exemplars.add(exemplar.toString());
        }
        return exemplars;
    }

    public void afegirUsuari(String email, String nom, String adreca, boolean esEstudiant) throws BiblioException {
        dades.afegirUsuari(email, nom, adreca, esEstudiant);
    }
    public ArrayList<String> recuperaUsuaris() {
        ArrayList<String> usuaris = new ArrayList<>();
        for(Usuari usuari : dades.recuperaUsuaris()) {
            usuaris.add(usuari.toString());
        }
        return usuaris;
    }
    public void afegirPrestec(int exemplarPos, int usuariPos, boolean esLlarg) throws BiblioException {
        dades.afegirPrestec(exemplarPos, usuariPos, esLlarg);
    }
    public void retornarPrestec(int position) throws BiblioException {
        dades.retornarPrestec(position);
    }
    public ArrayList<String> recuperaPrestecs() {
        ArrayList<String> prestecs = new ArrayList<>();
        for(Prestec prestec : dades.recuperaPrestecs()) {
            prestecs.add(prestec.toString());
        }
        return prestecs;
    }
    public ArrayList<String> recuperaPrestecsNoRetornats() {
        ArrayList<String> prestecs = new ArrayList<>();
        for(Prestec prestec : dades.recuperaPrestecsNoRetornats()) {
            prestecs.add(prestec.toString());
        }
        return prestecs;
    }
    public void guardaDades(String camiDesti) throws BiblioException {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(camiDesti));
            oos.writeObject(dades);
            oos.close();
        } catch (IOException e) {
            throw new BiblioException("Error al guardar les dades: " + e.getMessage());
        }
    }

    public void carregaDades(String camiOrigen) throws BiblioException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(camiOrigen));
            dades = (Dades) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new BiblioException("Error al carregar les dades: " + e.getMessage());
        }
    }


}
