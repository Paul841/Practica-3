public class Taller extends Activitat {
    private int hora;
    private int durada;
    private int capacitat;

        public Taller(String nom, String lloc, int codiPostal, int dia, Entitat entitat,
                   int hora, int durada, int capacitat) {
        super(nom, lloc, codiPostal, dia, entitat);
        this.hora = hora;
        this.durada = durada;
        this.capacitat = capacitat;
    }

    public int getHora() {
        return hora;
    }

    public int getDurada() {
        return durada;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public String toString() {
        return super.toString() +"\nHora: " + hora + "\nDurada: " + durada +"\nCapacitat: " + capacitat;
    }
}
