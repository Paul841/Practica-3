public class LListaEntitat {
    private Entitat [] llista;
    private int nElem;

    public LListaEntitat (int nEntitats){
        llista = new Entitat[nEntitats];
        nElem=0;
    }

    public Entitat[] getmidaLlista(){
        return llista;
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

    public void afegirEntitat(Entitat novaEntitat) {
        if (nElem < llista.length) {
            llista[nElem] = novaEntitat;
            nElem++;
        }
    }
    
    public LListaEntitat copia(){
        LListaEntitat copia = new LListaEntitat(nElem);
        for(int i=0;i<nElem;i++){
            copia.llista[i]=llista[i].copia();
        }
        return copia; 
    }

    public String toString(){
        String frase="Llista Entitat:\n";
        for(int i=0;i<nElem;i++){
            frase += llista[i].toString() + "\n";
        }
        return frase;
    }
    
}
