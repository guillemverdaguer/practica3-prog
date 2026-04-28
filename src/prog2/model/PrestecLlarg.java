package prog2.model;

import java.io.Serializable;

public class PrestecNormal extends Prestec implements Serializable {

    public PrestecNormal(Exemplar exemplar, Usuari usuari) {
        super(exemplar, usuari);
    }
    @Override
    public String tipusPrestec() {
        return "Normal";
    }
    @Override
    public long duradaPrestec() {
        return 70000; // 70 segons en mil·lisegons
    }
}
