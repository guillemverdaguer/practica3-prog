package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;

public class LlistaUsuaris extends Llista<Usuari> implements Serializable {
    @Override
    public void afegir(Usuari usuari) throws BiblioException {
        for (Usuari usuari2 : llista) {
            if (usuari.equals(usuari2)) {
                throw new BiblioException("L'usuari ja existeix");
            }
        }
        llista.add(usuari);
    }
}
