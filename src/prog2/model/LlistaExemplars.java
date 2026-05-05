package prog2.model;

import prog2.vista.BiblioException;

import java.io.Serializable;

public class LlistaExemplars extends Llista<Exemplar> implements Serializable {
    @Override
    public void afegir(Exemplar exemplar) throws BiblioException {
        for (Exemplar exemplar2 : llista) {
            if (exemplar.equals(exemplar2)) {
                throw new BiblioException("L'exemplar ja existeix");
            }
        }
        llista.add(exemplar);
    }
}
