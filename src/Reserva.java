public class Reserva {
private int codiReserva;
private Usuaris usuari;
private Taller taller;
private int codiTaller; 
private int places;  

private int valoracio;
private int sumaPuntuacions;
private int personesPuntuat;


public Reserva(int codiReserva, Usuaris usuari, int codiTaller){

    this.codiReserva=codiReserva;
    this.codiTaller=codiTaller;
    this.usuari=usuari;
    places=taller.getCapacitatMaxima();

    sumaPuntuacions=0;
    personesPuntuat=0;

}

public int getSumaPuntuacio() {
    return sumaPuntuacions;
}

public Usuaris getUsuariReserva() {
    return usuari;
}

public int getpersonesPuntuat() {
    return personesPuntuat;
}

public int getPlaces() {
    return places;
}


public Reserva copia(){
    Reserva copia=new Reserva(codiReserva,usuari,codiTaller);
    return copia;
}

public void nouAssistent(){
    if(taller.getCapacitatActual()<taller.getCapacitatMaxima()){
        taller.setCapacitatActual(taller.getCapacitatActual()+1);
        places--;
    }
}

public void valoracioUsuari(int valor){
    if(valor<10 && valor>1){
        valoracio=valor;
        personesPuntuat++;
        sumaPuntuacions+=valor;
    }
    
}

public String toString() {
    return "Reserva : places disponibles " + places + "\ncodi reserva " + codiReserva + "\ncodi taller: " + codiTaller+"\nvaloracio " +valoracio+ "del usuari"+usuari+ "\npersones totals que han votat"+personesPuntuat+"\npuntuacio total taller"+sumaPuntuacions;
}

}
