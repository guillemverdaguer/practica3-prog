package prog2.model;

import java.io.Serializable;

public class Estudiant extends Usuari implements Serializable {

    public Estudiant(String email, String nom, String adreca){
        super(email, nom, adreca);
    }
    public int getMaxPrestecsNormals() {
        return 2;
    }
    public int getMaxPrestecsLlargs() {
        return 1;
    }

    @Override
    public String tipusUsuari() {
        return "Estudiant";
    }
}
