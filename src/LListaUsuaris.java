public class LListaUsuaris {
    private Usuaris [] llista;
    private int nElem;

    public LListaUsuaris (int nUsuaris){
        llista = new Usuaris[nUsuaris];
        nElem=0;
    }

    public int getnUsuaris(){
        return nElem;
    }

    public Usuaris getUsuariPosicio (int posicio){
        if(posicio>=0 && posicio<llista.length){
            return llista[posicio];
        }
        else{
            return null;
        }
    }

    public LListaUsuaris copia(){
        LListaUsuaris copia = new LListaUsuaris(nElem);
        for(int i=0;i<nElem;i++){
            copia.llista[i]=llista[i].copia();
        }
        return copia; 
    }
}
