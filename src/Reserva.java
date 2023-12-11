public class Reserva {
private int codiReserva;
private Usuaris usuari;
private Taller taller;
private int codiTaller; 
private int places;  

private int valoracio;

public Reserva(int codiReserva, Usuaris usuari, int codiTaller, Taller taller){

    this.codiReserva=codiReserva;
    this.codiTaller=codiTaller;
    this.usuari=usuari;
    this.taller=taller;
    places=taller.getCapacitatMaxima();
    valoracio=0;

}

public Usuaris getUsuariReserva() {
    return usuari;
}

public int getPlaces() {
    return places;
}

public int getValoracio() {
    return valoracio;
}

public Reserva copia(){
    Reserva copia=new Reserva(codiReserva,usuari,codiTaller,taller);
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
        taller.setPersonesPuntuat(taller.getPersonesPuntuat()+1);
        taller.setSumaPuntuacio(taller.getSumaPuntuacio()+valoracio);

    }
    
}

public String toString() {
    return "Reserva : places disponibles " + places + "\ncodi reserva " + codiReserva + "\ncodi taller: " + codiTaller+"\nvaloracio " +valoracio+ "del usuari"+usuari;
}


}
