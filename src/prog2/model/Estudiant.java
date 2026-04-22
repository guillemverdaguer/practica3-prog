package prog2.model;

public class Estudiant extends Usuari{

    public Estudiant(String email, String nom, String adreca){
        super(email, nom, adreca);
    }
    public int getMaxPrestecsNormals() {
        return 2;
    }
    public int getMaxPrestecsLlargs() {
        return 1;
    }

}
