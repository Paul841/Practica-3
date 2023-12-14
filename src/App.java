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


    Scanner scanner = new Scanner(System.in);
    int opcio;

        do {
            System.out.println("\nMenú d'opcions:");
            System.out.println("1. Mostrar les dades de qualsevol llista que tingueu definida.\r");
            System.out.println("2. Obtenir i mostrar la llista d'activitats que ofereix una entitat concreta.");
            System.out.println("3. Obtenir i mostrar la llista de les activitats que es duen a terme en un dia indicat per teclat.");
            System.out.println("4. Obtenir i mostrar la llista dels tallers que tenen places disponibles. ");
            System.out.println("15. Sortir");
            System.out.print("Escull una opció: ");

            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    int triarllista;
                    System.out.println("Tria la llista que vols visualitzar:");
                    System.out.println("1. Llista Activitats:");
                    System.out.println("2. Llista Entitats:");
                    System.out.println("3. Llista Reserves:");
                    System.out.println("4. Llista Usuaris:");

                    triarllista = scanner.nextInt();
                    scanner.nextLine();

                    switch (triarllista) {
                        case 1:
                            System.out.println(llistaActivitat.toString());
                            break;
                    
                        case 2:
                            System.out.println(llistaEntitat.toString());
                            break;
                        case 3:
                            System.out.println(llistaReserva.toString());
                            break;
                        case 4:
                            System.out.println(llistaUsuaris.toString());
                            break;
                        default:
                            break;
                    }


                    break;
                case 2:
                    System.out.println("Indica la entitat:");
                    String triarentitat = scanner.nextLine();
                    System.out.println(llistaActivitat.activitatsPerNomEntitat(triarentitat));
                    break;
                case 3:
                    System.out.println("Indica el dia:");
                    String triardia = scanner.nextLine();
                    System.out.println(llistaActivitat.activitatDiaConcret(triardia));
                    break;
                case 4:
                    System.out.println(llistaUsuaris.toString());

                            /*S'ha afegir a la classe taller 
                             *  public boolean tePlacesDisponibles(){
                                    if(capacitatActual<capacitatMaxima){
                                        return true;
                                    }
                                    else return false;
                                }
                             */

                            /*S'ha d'afegir a la classe LListaActivitat:
                             *  public LListaActivitat tallersPlacesDisponibles() throws TaulaPlena{
        
                                    LListaActivitat llistatallersDisp = new LListaActivitat(nElem);
                                    for(int i=0;i<nElem;i++){
                                        if(llista[i] instanceof Taller){
                                            Taller taller = (Taller) llista[i];
                                            if(taller.tePlacesDisponibles()){
                                                llistatallersDisp.afegirActivitat(llista[i]);
                                            }
                                        }
                                    }
                                    return llistatallersDisp;
        
                                }
                             * 
                             */
                    break;
                case 15:
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("Opció no vàlida. Torna a provar.");
            }
        } while (opcio != 15);

        scanner.close();
    }

        
    }
}
