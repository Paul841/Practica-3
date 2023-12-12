public class LListaActivitat {
    private Activitat [] llista;
    private int nElem;

    public LListaActivitat (int nActivitat){
        llista = new Activitat[nActivitat];
        nElem=0;
    }

    public int getnActivitats(){
        return nElem;
    }

    public Activitat getActivitatPosicio (int posicio){
        if(posicio>=0 && posicio<llista.length){
            return llista[posicio];
        }
        else{
            return null;
        }
    }

    public LListaActivitat copia(){
        LListaActivitat copia = new LListaActivitat(nElem);
        for(int i=0;i<nElem;i++){
            copia.llista[i]=llista[i].copia();
        }
        return copia; 
    }

    public void afegirActivitat(Activitat activitat){
        if(nElem<llista.length)     {
            llista[nElem]=activitat.copia();
            nElem++;    
        }   
    }

    public LListaActivitat llistaTallersDisponibles(){

        LListaActivitat tallersDisponibles = new LListaActivitat(nElem);
        for(int i=0;i<nElem;i++){
            Activitat activitat=getActivitatPosicio(i);
            if( activitat instanceof Taller)  {
                Taller taller=(Taller) activitat;
                int valorActual=taller.getCapacitatActual();
                int valorMaxim=taller.getCapacitatMaxima();
                if(valorActual<valorMaxim){
                    tallersDisponibles.afegirActivitat(activitat);
                }
            }
        }
        return tallersDisponibles;
    }

    public Taller tallerMesExit(){
         Taller taller=null;
        for(int i=0;i<nElem;i++){
           Activitat activitat=getActivitatPosicio(i);
            if(activitat instanceof Taller){
                Taller tallerActual=(Taller) activitat;
                if( taller==null || tallerActual.getCapacitatActual()>taller.getCapacitatActual()){
                    taller=tallerActual;
                }
            }
        
        }
        return taller;
    }

    

}
