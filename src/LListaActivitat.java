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

    public void donarBaixaTaller(Taller taller){
        if(taller.getCapacitatActual()==0){
            boolean trobat=false;
            int i=0;
            while(!trobat && i<nElem){
                Activitat activitat=getActivitatPosicio(i);
                if(activitat instanceof Taller && taller.equals(activitat)){
                    for(int j=i;j<nElem-1;j++){
                        llista[j]=llista[j+1];
                    }
                    nElem--;
                    trobat=true;
                }
                i++;
            }
        }
    }

    public LListaActivitat dadesXerradaUsuari (String nom){
        LListaActivitat xerradesUsuari = new LListaActivitat(nElem);
        for(int i=0;i<nElem;i++){
            Activitat activitat=getActivitatPosicio(i);
            if(activitat instanceof Xerrada){
                Xerrada xerrada=(Xerrada) activitat;
                if(xerrada.getNomConferenciant().equals(nom)){
                        xerradesUsuari.afegirActivitat(xerrada);
                }
            }
        }
        return xerradesUsuari;
    }

    public LListaActivitat activitatEntitatConcreta(Entitat entitat){
        LListaActivitat entitats= new LListaActivitat(nElem);
        for(int i=0;i<nElem;i++){
            Activitat activitat=getActivitatPosicio(i);
            if(activitat.getEntitat().equals(entitat)){
                entitats.afegirActivitat(activitat);
            }
        }

        return entitats;
    }

    public LListaActivitat activitatEntitatConcreta(int dia){
        LListaActivitat activitatsDia= new LListaActivitat(nElem);
        for(int i=0;i<nElem;i++){
            Activitat activitat=getActivitatPosicio(i);
            if(Integer.parseInt(activitat.getDia())==dia){
                activitatsDia.afegirActivitat(activitat);
            }
        }

        return activitatsDia;
    }

    public LListaActivitat activitatEntitatConcreta(Entitat entitat,String tipus){
        LListaActivitat visitesEntitat= new LListaActivitat(nElem);
        boolean audioguia=false;
        if(tipus.equals("audioguia")){
            audioguia=true;
        }
        for(int i=0;i<nElem;i++){
            Activitat activitat=getActivitatPosicio(i);
            if(activitat instanceof Visita){
                Visita visita=(Visita) activitat;
                if(audioguia && visita.getAudioguia()){
                    visitesEntitat.afegirActivitat(activitat);
                }
            }
        }

        return visitesEntitat;
    }

    public String toString(){
        String frase="Llista Activitats:";
        for(int i=0; i<nElem; i++){
            frase += llista[i].toString()+ "\n";
        }
        return frase;
    }

}
