package prog2.model;

import java.io.Serializable;

public class Professor extends Usuari implements Serializable {

    public Professor(String email, String nom, String adreca){
        super(email, nom, adreca);
    }
    public int getMaxPrestecsNormals() {
        return 2;
    }
    public int getMaxPrestecsLlargs() {
        return 2;
    }
    @Override
    public String tipusUsuari() {
        return "Professor";
    }
}
