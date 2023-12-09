public class Xerrada extends Activitat {
    private String nomConferenciant;

    public Xerrada(String nom, String lloc, int codiPostal, int dia, Entitat entitat, String nomConferenciant) {
        super(nom, lloc, codiPostal, dia, entitat);
        this.nomConferenciant = nomConferenciant;
    }

    public String getNomConferenciant() {
        return nomConferenciant;
    }

    public void setNomConferenciant(String nomConferenciant) {
        this.nomConferenciant = nomConferenciant;
    }
    
    public String toString() {
        return super.toString() + "\nNom del Conferenciant: " + nomConferenciant;
    }
}
