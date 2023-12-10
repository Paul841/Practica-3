public class Taller extends Activitat {
    private int hora;
    private int durada;
    private int capacitatActual;
    private int capacitatMaxima;

        public Taller(String nom, String lloc, int codiPostal, int dia, Entitat entitat,
                   int hora, int durada, int capacitat) {
        super(nom, lloc, codiPostal, dia, entitat);
        this.hora = hora;
        this.durada = durada;
        capacitatMaxima=capacitat;
        capacitatActual=0;
    }

    public int getHora() {
        return hora;
    }

    public int getDurada() {
        return durada;
    }

    public int getCapacitatActual() {
        return capacitatActual;
    }
    public int getCapacitatMaxima() {
        return capacitatMaxima;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public void setCapacitatActual(int capacitat) {
        this.capacitatActual = capacitat;
    }

    public void setCapacitatMaxima(int capacitat) {
        this.capacitatMaxima = capacitat;
    }

    public Taller copia(){
        Taller copia=new Taller(getNom(),getLloc(),getCodiPostal(),getDia(),getEntitat(),hora,durada,capacitatMaxima);
        return copia;
    }


    public String toString() {
        return super.toString() +"\nHora: " + hora + "\nDurada: " + durada +"\nCapacitat màxima: " + capacitatMaxima + "\n" + //
                "Capacitat actual:"+capacitatActual;
    }

    
}
