public class Entitat {
    private String nom;
    private String telefon;
    private String correu;

    public Entitat() {
        this.nom = "X";
        this.telefon = "X";
        this.correu = "X";
    }

    public Entitat(String nom, String telefon, String correu) {
        this.nom = nom;
        this.telefon = telefon;
        this.correu = correu;
    }

    public String getNom() {
        return nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getCorreu() {
        return correu;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setTelefon(String telefon){
        this.telefon = telefon;
    }

    public void setCorreu(String correu){
        this.correu = correu;
    }


    public String toString() {
        return nom +";" + telefon + ';' + correu + '\n';
    }

    public Entitat copia(){
        Entitat copia=new Entitat(nom,telefon,correu);
        return copia;
    }

}
