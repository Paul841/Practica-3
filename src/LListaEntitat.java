public class LListaEntitat {
    private Entitat [] llista;
    private int nElem;

    public LListaEntitat (int nEntitats){
        llista = new Entitat[nEntitats];
        nElem=0;
    }

    public int getnEntitats(){
        return nElem;
    }

    public Entitat getEntitatsPosicio (int posicio){
        if(posicio>=0 && posicio<llista.length){
            return llista[posicio];
        }
        else{
            return null;
        }
    }

    public LListaEntitat copia(){
        LListaEntitat copia = new LListaEntitat(nElem);
        for(int i=0;i<nElem;i++){
            copia.llista[i]=llista[i].copia();
        }
        return copia; 
    }
    
}
