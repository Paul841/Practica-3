import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Arxius {

    //metode que guarda en un arxiu els objectes de classes serialitzades
    public static void escriureArxiuReserva(LlistaReserva llista) {
        ObjectOutputStream outputFile;
        try {
            outputFile = new ObjectOutputStream(new FileOutputStream("C:\\Users\\proon\\Javaprojects\\PRACTICA 3\\prAACtica 3\\data\\arxiuReserva.ser"));
            for (int i=0; i<llista.getNumReserves(); i++) {
            outputFile.writeObject(llista.getReserva(i));
            }
            outputFile.close();
        }
        catch (IOException e) {
        System.out.println("Error en l'arxiu de sortida.");
        e.printStackTrace();
        }


    }

    //metode per llegir els objectes de arxius seralitzats
    public static void llegirArxiuReserva (LlistaReserva llista) {
        ObjectInputStream inputFile;
        try {
            inputFile = new ObjectInputStream(new FileInputStream("C:\\Users\\proon\\Javaprojects\\PRACTICA 3\\prAACtica 3\\data\\arxiuReserva.ser"));
            while (true) {
                try {
                    Reserva reserva = (Reserva) inputFile.readObject();
                    llista.afegirReserva(reserva);
                }   
                catch (EOFException e) {
                    break; 
                }
        }
            inputFile.close();
        }
        catch (IOException e) {
            System.out.println("Error en l'arxiu d'entrada.");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error, no es troba la classe."+e);
        }
        catch (ClassCastException e){
            System.out.println("Error, el format de l'arxiu no és correcte per la definició actual de la classe."+e);
        }
    }


    //metode per escriure en un arxiu de text no serialitzat
    public static void escriureArxiuEntitat(LlistaEntitat llista){
        try{
            BufferedWriter g = new BufferedWriter(new FileWriter("C:\\Users\\proon\\Javaprojects\\PRACTICA 3\\prAACtica 3\\data\\entitat.txt"));
            for (int i=0; i<llista.getnEntitats(); i++){ 
                g.write(llista.getEntitatsPosicio(i).getNom() + ";" + llista.getEntitatsPosicio(i).getTelefon() + ";" + llista.getEntitatsPosicio(i).getCorreu()+ ";");
            }
            g.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("L'arxiu d'entrada no existeix");
        }
        catch(IOException e) {
            System.out.println("S'ha produit un error en els arxius");
        }
    }



    //metode per llegir un Arxiu de text no serialitzat
    public static void llegirArxiuEntitat(LlistaEntitat llista){
        try{
            Scanner f=new Scanner(new File("C:\\Users\\proon\\Javaprojects\\PRACTICA 3\\prAACtica 3\\data\\entitat.txt"));
            String textentitat;
            Entitat entitat;

            f.useDelimiter(";");
            int cont=0;
            entitat = new Entitat();
            while (f.hasNext()) {
                textentitat = f.next();
                
                
                switch (cont % 3) {
                    case 0:
                        entitat.setNom(textentitat);
                        break;
                    case 1:
                        entitat.setTelefon(textentitat);
                        break;
                    case 2:
                        entitat.setCorreu(textentitat);
                        llista.afegirEntitat(entitat);
                        entitat = new Entitat();
                        break;
                }
                cont++;
            }
            f.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error.");
        }

    }

    //metode per escriure en l'arxiu activitat 
    public static void escriureArxiuActivitat(LlistaActivitat llista){
        try{
            BufferedWriter g = new BufferedWriter(new FileWriter("C:\\Users\\proon\\Javaprojects\\PRACTICA 3\\prAACtica 3\\data\\Activitat.txt"));
            for (int i=0; i<llista.getnActivitats(); i++){ 
                Activitat activitat = llista.getActivitatPosicio(i);

                if (activitat instanceof Taller){
                    Taller taller = (Taller) llista.getActivitatPosicio(i);
                    g.write("Taller" + ";" + taller.getCodi() + ";" + taller.getNom() + ";" + taller.getLloc() + ";" +
                            taller.getCodiPostal() + ";" + taller.getDia() + ";" + taller.getEntitat() + ";" +
                            taller.getHora() + ";" + taller.getDurada()+ ";" + taller.getCapacitatActual()+ ";" + 
                            taller.getCapacitatMaxima()+ ";" + taller.getSumaPuntuacio()+  ";" + taller.getPersonesPuntuat()+";");
                }
                else if(activitat instanceof Visita){
                    Visita visita = (Visita) llista.getActivitatPosicio(i);
                    g.write( "Visita" + ";" + visita.getCodi() + ";" + visita.getNom() + ";" + visita.getLloc() + ";" +
                            visita.getCodiPostal() + ";" + visita.getDia() + ";" + visita.getEntitat() + ";" 
                            + visita.getAudioguia() + ";" + visita.getAdaptadaCegues()+";");
                }
                else if(activitat instanceof Xerrada){
                    Xerrada xerrada = (Xerrada) llista.getActivitatPosicio(i);
                    g.write( "Xerrada" + ";" + xerrada.getCodi() + ";" + xerrada.getNom() + ";" + xerrada.getLloc() + ";" +
                            xerrada.getCodiPostal() + ";" + xerrada.getDia() + ";" + xerrada.getEntitat() + ";"
                             + xerrada.getNomConferenciant()+";");
                }
            }
            g.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("L'arxiu d'entrada no existeix");
        }
        catch(IOException e) {
            System.out.println("S'ha produit un error en els arxius");
        }
    }
    



    //metode per llegir un Arxiu de text no serialitzat
    public static void llegirArxiuActivitat(LlistaActivitat llista) {
        try {
            Scanner f = new Scanner(new File("C:\\Users\\proon\\Javaprojects\\PRACTICA 3\\prAACtica 3\\data\\Activitat.txt"));
            String textactivitat;
            Activitat activitat = null;
            String tipusactivitat = "X";
            boolean acabat=false;
            f.useDelimiter(";");
            int cont = 0;

            while (f.hasNext()) {
                textactivitat = f.next();
                acabat=false;
                if (cont == 0) {
                    switch (textactivitat) {
                        case "Taller":
                            tipusactivitat = "Taller";
                            activitat = new Taller();
                            break;
                        case "Visita":
                            tipusactivitat = "Visita";
                            activitat = new Visita();
                            break;
                        case "Xerrada":
                            tipusactivitat = "Xerrada";
                            activitat = new Xerrada();
                            break;
                    }
                } else {
                    switch (tipusactivitat) {
                        case "Taller":
                            Taller taller = (Taller) activitat;
                            switch (cont) {
                                case 1:
                                    activitat.setCodi(textactivitat);
                                    break;
                                case 2:
                                    activitat.setNom(textactivitat);
                                    break;
                                case 3:
                                    activitat.setLloc(textactivitat);
                                    break;
                                case 4:
                                    activitat.setCodiPostal(textactivitat);
                                    break;
                                case 5:
                                    activitat.setDia(textactivitat);
                                    break;
                                case 6:
                                    activitat.setEntitat(textactivitat);
                                    break;
                                case 7:
                                    taller.setHora(Integer.parseInt(textactivitat));
                                    break;
                                case 8:
                                    taller.setDurada(Integer.parseInt(textactivitat));
                                    break;
                                case 9:
                                    taller.setCapacitatActual(Integer.parseInt(textactivitat));
                                    break;
                                case 10:
                                    taller.setCapacitatMaxima(Integer.parseInt(textactivitat));
                                    break;
                                case 11:
                                    taller.setSumaPuntuacio(Integer.parseInt(textactivitat));
                                    break;
                                case 12:
                                    taller.setPersonesPuntuat(Integer.parseInt(textactivitat));
                                    cont=0;
                                    acabat=true;
                                    break;
                            }
                            break;
                        case "Visita":
                            Visita visita = (Visita) activitat;

                            switch (cont) {
                            case 1:
                                activitat.setCodi(textactivitat);
                                break;
                            case 2:
                                activitat.setNom(textactivitat);
                                break;
                            case 3:
                                activitat.setLloc(textactivitat);
                                break;
                            case 4:
                                activitat.setCodiPostal(textactivitat);
                                break;
                            case 5:
                                activitat.setDia(textactivitat);
                                break;
                            case 6:
                                activitat.setEntitat(textactivitat);
                                break;
                            case 7:
                                visita.setAudioguia(Boolean.parseBoolean(textactivitat));
                                break;
                            case 8:
                                visita.setAdaptadaCegues(Boolean.parseBoolean(textactivitat));
                                cont=0;
                                acabat=true;
                                break;
                            }
                            break;
                        case "Xerrada":
                            Xerrada xerrada = (Xerrada) activitat;

                            switch (cont) {
                            case 1:
                                activitat.setCodi(textactivitat);
                                break;
                            case 2:
                                activitat.setNom(textactivitat);
                                break;
                            case 3:
                                activitat.setLloc(textactivitat);
                                break;
                            case 4:
                                activitat.setCodiPostal(textactivitat);
                                break;
                            case 5:
                                activitat.setDia(textactivitat);
                                break;
                            case 6:
                                activitat.setEntitat(textactivitat);
                                break;
                            case 7:
                                xerrada.setNomConferenciant(textactivitat);
                                cont=0;
                                acabat=true;
                                break;
                            }
                                break;
                    }
                }   

           
            if (acabat) {
                llista.afegirActivitat(activitat);
            }
            else{
                cont++;
            }
        }

        f.close();
    } catch (FileNotFoundException e) {
        System.out.println("Error.");
    }
}




    //metode per escriure en un arxiu de text no serialitzat per a Usuaris
    public static void escriureArxiuUsuari(LlistaUsuaris llista){
        try{
            BufferedWriter g = new BufferedWriter(new FileWriter("C:\\Users\\proon\\Javaprojects\\PRACTICA 3\\prAACtica 3\\data\\usuaris.txt"));
            for (int i=0; i<llista.getnUsuaris(); i++){ 
                g.write(llista.getUsuariPosicio(i).getAlias() + ";" + llista.getUsuariPosicio(i).getCorreuElectronic() + ";" + llista.getUsuariPosicio(i).getCodiPostal()+ ";");
            }
            g.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("L'arxiu d'entrada no existeix");
        }
        catch(IOException e) {
            System.out.println("S'ha produit un error en els arxius");
        }
    }

    //metode per llegir un Arxiu de text no serialitzat Usuari
    public static void llegirArxiuUsuari(LlistaUsuaris llista){
        try{
            Scanner f=new Scanner(new File("C:\\Users\\proon\\Javaprojects\\PRACTICA 3\\prAACtica 3\\data\\entitat.txt"));
            String textusuari;
            Usuaris usuari;

            f.useDelimiter(";");
            int cont=0;
            usuari = new Usuaris();
            while (f.hasNext()) {
                textusuari = f.next();
                
                switch (cont % 3) {
                    case 0:
                        usuari.setAlias(textusuari);
                        break;
                    case 1:
                        usuari.setCorreuElectronic(textusuari);
                        break;
                    case 2:
                        usuari.setCodiPostal(textusuari);
                        llista.afegirUsuari(usuari);
                        usuari = new Usuaris();
                        break;
                }
                cont++;
            }
            f.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error.");
        }

    }





}
