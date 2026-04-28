package prog2.model;

import java.io.Serializable;

public class PrestecLlarg extends Prestec implements Serializable {

    public PrestecLlarg(Exemplar exemplar, Usuari usuari) {
        super(exemplar, usuari);
    }
    @Override
    public String tipusPrestec() {
        return "Llarg";
    }
    @Override
    public long duradaPrestec() {
        return 140000; // 140 segons en mil·lisegons
    }
}
