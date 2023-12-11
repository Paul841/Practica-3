public class LListaReserva {
    private Reserva [] llista;
    private int nElem;

    public LListaReserva (int nReserva){
        llista = new Reserva[nReserva];
        nElem=0;
    }

    public int getnReserves(){
        return nElem;
    }

    public Reserva getReservaPosicio (int posicio){
        if(posicio>=0 && posicio<llista.length){
            return llista[posicio];
        }
        else{
            return null;
        }
    }

    public LListaReserva copia(){
        LListaReserva copia = new LListaReserva(nElem);
        for(int i=0;i<nElem;i++){
            copia.llista[i]=llista[i].copia();
        }
        return copia; 
    }

    public void afegirReserva(Reserva reserva){
        if(nElem<llista.length) {
            llista[nElem]=reserva.copia();
            nElem++;    
        }   
    }

    public Usuaris usuariMesTallers(){
        Usuaris persona;
        int max=0;
        int total;
        Usuaris personaMesAssist=new Usuaris(getReservaPosicio(0).getUsuariReserva().getAlias(),getReservaPosicio(0).getUsuariReserva().getCorreuElectronic(),getReservaPosicio(0).getUsuariReserva().getCodiPostal());
        for (int j=0;j<nElem;j++){
            persona=getReservaPosicio(j).getUsuariReserva();
            total=0;
            for(int i=0;i<nElem;i++){
        
                if(getReservaPosicio(i).getUsuariReserva().equalsIgnoreCase(persona)){
                    total++;
                }

            }
            if(total>max){
                max=total;
                personaMesAssist=persona;
             }

        }
        return personaMesAssist;
    }
}
