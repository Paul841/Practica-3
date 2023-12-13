public class App {
    public static void main(String[] args) throws Exception {
        //Creem les llistes
        LlistaUsuaris llistaUsuaris = new LlistaUsuaris(10);
        LlistaActivitat llistaActivitat = new LlistaActivitat(10);
        LlistaReserva llistaReserva = new LlistaReserva(10);
        LlistaEntitat llistaEntitat = new LlistaEntitat(10);

        //Llegim la informacio dels arxius
        Arxius.llegirArxiuUsuari(llistaUsuaris);
        Arxius.llegirArxiuActivitat(llistaActivitat);
        Arxius.llegirArxiuReserva(llistaReserva);
        Arxius.llegirArxiuEntitat(llistaEntitat);

        //Per a comprovar per pantalla que s'hagin llegit be
       System.out.println(llistaActivitat.getActivitatPosicio(0));
       System.out.println(llistaUsuaris.getUsuariPosicio(0));
       System.out.println(llistaReserva.getReservaPosicio(0));
       System.out.println(llistaEntitat.getEntitatsPosicio(0));

        
    }
}
