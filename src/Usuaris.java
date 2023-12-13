import java.io.Serializable;

public class Usuaris implements Serializable{
    private String alias;
    private String correuElectronic;
    private String codiPostal;

    public Usuaris(){
        this.alias = "X";
        this.correuElectronic = "X";
        this.codiPostal = "X";
    }
    
    public Usuaris(String alias, String correuElectronic, String codiPostal) {
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

    public String getCodiPostal() {
        return codiPostal;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setCorreuElectronic(String correuElectronic) {
        this.correuElectronic = correuElectronic;
    }

    public void setCodiPostal(String codiPostal) {
        this.codiPostal = codiPostal;
    }

    public Usuaris copia(){
        Usuaris copia=new Usuaris(alias,correuElectronic,codiPostal);
        return copia;
    }

    public String toString() {
        return "Alias: " + alias + "\nCorreu Electronic: " + correuElectronic + "\nCodi Postal: " + codiPostal;
    }

}
