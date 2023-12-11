public class LListaActivitat {
    private Taller [] llista;
    private int nElem;

    public LListaActivitat (int nActivitat){
        llista = new Taller[nActivitat];
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

    public LListaTaller tallersDisponibles(){

        LListaTaller tallersDisponibles = new LListaTaller(nElem);
        for(int i=0;i<nElem;i++){
        if(getTallerPosicio(i).getCapacitatActual()<getTallerPosicio(i).getCapacitatMaxima()){
            tallersDisponibles.afegirTaller(getTallerPosicio(i));
        }
        }
        return tallersDisponibles;
    }

    public Taller tallerMesExit(){
        Taller taller=getTallerPosicio(0);
        for(int i=1;i<nElem;i++){
            Taller tallerActual= getTallerPosicio(i);
        if(tallerActual.getCapacitatActual()>taller.getCapacitatActual()){
            taller=tallerActual;
        }

        }
        return taller;
    }
}
