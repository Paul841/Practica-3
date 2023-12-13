public class Activitat {
    private String codi;
    private String nom;
    private String lloc;
    private String codiPostal;
    private String dia;
    private String entitat;

    public Activitat(){
        this.nom = "X";
        this.lloc = "X";
        this.codiPostal = "X";
        this.dia = "X";
        this.entitat = "XXXXXXX";
    }

    public Activitat(String nom, String lloc, String codiPostal, String dia, String entitat) {
        this.nom = nom;
        this.lloc = lloc;
        this.codiPostal = codiPostal;
        this.dia = dia;
        this.entitat = entitat;

        // Generar el codi automáticamente (primeres 3 lletres del nom de l'entitat + número)
        this.codi = generarCodi();
    }

    public String generarCodi(){
        String codi = entitat.getNom().substring(0, 2);
        return codi;
    }


    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public String getLloc() {
        return lloc;
    }

    public String getCodiPostal() {
        return codiPostal;
    }

    public String getDia() {
        return dia;
    }

    public Entitat getEntitat() {
        return entitat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public void setCodiPostal(int codiPostal) {
        this.codiPostal = codiPostal;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setEntitat(String entitat) {
        this.entitat = entitat;
    }
    
    public void setCodi(String codi){
        this.codi=codi;
    }
    
    
    public Activitat copia(){
        Activitat copia=new Activitat(nom,lloc,codiPostal,dia,entitat);
        return copia;
    }
    
    public String toString() {
        return "Activitat{" + "codi='" + codi + '\'' +", nom='" + nom + '\'' +", lloc='" + lloc + '\'' +", codiPostal='" + codiPostal + '\'' +", dia='" + dia + '\'' +", entitat=" + entitat.getNom() +'}';
    }
}
