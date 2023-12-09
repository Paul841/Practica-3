public class Visita extends Activitat {
    private boolean audioguia;
    private boolean adaptadaCegues;

    public Visita(String nom, String lloc, int codiPostal, int dia, Entitat entitat,
                    boolean audioguia, boolean adaptadaCegues) {
        super(nom, lloc, codiPostal, dia, entitat);
        this.audioguia = audioguia;
        this.adaptadaCegues = adaptadaCegues;
    }

    public boolean getAudioguia() {
        return audioguia;
    }

    public boolean getAdaptadaCegues() {
        return adaptadaCegues;
    }

    public void setAudioguia(boolean audioguia) {
        this.audioguia = audioguia;
    }

    public void setAdaptadaCegues(boolean adaptadaCegues) {
        this.adaptadaCegues = adaptadaCegues;
    }

    public String toString() {
        return super.toString() +"\nAudioguia: " + audioguia + "\nAdaptada per Cegues: " + adaptadaCegues;
    }
}
