public class Usuaris{
    private String alias;
    private String correuElectronic;
    private int codiPostal;

    public Usuaris(String alias, String correuElectronic, int codiPostal) {
        this.alias = alias;
        this.correuElectronic = correuElectronic;
        this.codiPostal = codiPostal;
    }

    public String getAlias() {
        return alias;
    }

    public String getCorreuElectronic() {
        return correuElectronic;
    }

    public int getCodiPostal() {
        return codiPostal;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setCorreuElectronic(String correuElectronic) {
        this.correuElectronic = correuElectronic;
    }

    public void setCodiPostal(int codiPostal) {
        this.codiPostal = codiPostal;
    }

    public String toString() {
        return "Alias: " + alias + "\nCorreu Electronic: " + correuElectronic + "\nCodi Postal: " + codiPostal;
    }
}