package prog2.model;

public class Professor extends Usuari{

    public Professor(String email, String nom, String adreca){
        super(email, nom, adreca);
    }
    public int getMaxPrestecsNormals() {
        return 2;
    }
    public int getMaxPrestecsLlargs() {
        return 2;
    }

}
