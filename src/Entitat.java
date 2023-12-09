public class Entitat {
    private String nom;
    private String telefon;
    private String correu;

    public Entitat(String nom, String telefon, String correu) {
        this.nom = nom;
        this.telefon = telefon;
        this.correu = correu;
    }

    public String getNombre() {
        return nom;
    }

    public String getTelefono() {
        return telefon;
    }

    public String getCorreo() {
        return correu;
    }

    public String toString() {
        return "Entitat{" + "nom='" + nom + '\'' +", telefon='" + telefon + '\'' +", correu='" + correu + '\'' +'}';
    }

    

}
