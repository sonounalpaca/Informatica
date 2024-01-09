/*
Create a software that works as follows:
- Menu with the option to perform Job 1, Job 2, or Job 3
- Job 1: Cook as many Christmas eggs as the user wants until they are tired
- Job 2: Pay the bill for vegan hamburgers
  and reindeer burgers (cost twice as much)
  and non-alcoholic and alcoholic Christmas drinks (cost twice as much),
  provided by the individual user.
  If the total exceeds 10 euros, there is a 15% discount for amounts over 10 euros.
- Job 3: Print the total earnings for the day.
 */

import java.util.Scanner;
public class Es009_Esercizioquasinatalizio {
    public static void main(String[] args)
    {
        System.out.println("Benvenuti");
        Scanner keyboard=new Scanner(System.in);
        int scelta;
        int count=0;
        int tipo1, tipo2;
        double uova=0.00, hamburger=0.00, sconto, totale;
        String risposta;
        do
        {
            //Operation choice
            System.out.println("Sceglire il lavoro da svolgere:");
            System.out.println("Cottura uova di Natale____1");
            System.out.println("Pagare il conto dell'ordinazione____2");
            System.out.println("Stampare il totale incassi del giorno____3");
            scelta=keyboard.nextInt();
            while(scelta!=1 && scelta!=2 && scelta!=3)
            {
                System.out.println("Opzione non valida");
                System.out.println("Reinserire la scelta:");
                scelta= keyboard.nextInt();
            }
            //Perform operations
            switch(scelta)
            {
                //Eggs
                case 1:
                    System.out.println("Cuociamo delle uova di Natale");
                    System.out.println("Costo uova: €1.50");
                    do
                    {
                        System.out.println("Cottura uovo in corso");
                        Wait();
                        System.out.println("Uovo pronto");
                        count++;
                        System.out.println("Cuocere un altro uovo? (S/N)");
                        risposta=keyboard.nextLine().toUpperCase();
                        risposta=keyboard.nextLine().toUpperCase();
                    }while(risposta.equals("S"));
                    uova=1.50+count;
                    break;
                //Hamburger
                case 2:
                    System.out.println("Cosa desidera ordinare?");
                    System.out.println("Menù");
                    System.out.println("-*********************-");
                    System.out.println("Hamburger:");
                    System.out.println("1.Hamburger vegano__€4.50");
                    System.out.println("2.Hamburger di renna__€9.00");
                    tipo1= keyboard.nextInt();
                    while(tipo1!=1 && tipo1!=2)
                    {
                        System.out.println("Scelta non valida");
                        System.out.println("Reinserire la scelta:");
                        tipo1= keyboard.nextInt();
                    }
                    System.out.println("-*********************-");
                    System.out.println("Bevande natalizie:");
                    System.out.println("1.Analcoliche__€2.50");
                    System.out.println("2.Alcoliche__€5.00");
                    tipo2=keyboard.nextInt();
                    while(tipo2!=1 && tipo2!=2)
                    {
                        System.out.println("Scelta non valida");
                        System.out.println("Reinserire la scelta:");
                        tipo2= keyboard.nextInt();
                    }
                    System.out.println("-*********************-");
                    if (tipo1==1 && tipo2==1)
                    {
                        System.out.println("Sceltà:");
                        System.out.println("Hamburger vegano");
                        System.out.println("Bevanda analcolica");
                        hamburger=4.50+2.50;
                    }
                    else if(tipo1==1 && tipo2==2)
                    {
                        System.out.println("Sceltà:");
                        System.out.println("Hamburger vegano");
                        System.out.println("Bevanda alcolica");
                        hamburger=4.50+5.00;
                        System.out.println("Totale: €"+hamburger);
                    }
                    else if(tipo1==2 && tipo2==1)
                    {
                        System.out.println("Sceltà:");
                        System.out.println("Hamburger di renna");
                        System.out.println("Bevanda analcolica");
                        hamburger=9.00+2.50;
                        System.out.println("Totale: €"+hamburger);
                    }
                    else if(tipo1==2 && tipo2==2)
                    {
                        System.out.println("Sceltà:");
                        System.out.println("Hamburger di renna");
                        System.out.println("Bevanda alcolica");
                        hamburger=9.00+5.00;
                    }
                    // 15% discount
                    if (hamburger>10.0) {
                        sconto=hamburger*0.15;
                        hamburger=hamburger-sconto;
                    }
                    System.out.println("Totale: €"+hamburger);
                    break;
                //Total
                case 3:
                    totale=uova+hamburger;
                    System.out.println("Totale incassi della giornata: €"+totale);
                    break;
                default:
                    System.out.println("Scelta non disponibile");
                    break;
            }
        //Choose a new job
        System.out.println("Svolgere altri lavori? (S/N)");
        risposta=keyboard.nextLine().toUpperCase();
        risposta=keyboard.nextLine().toUpperCase();
        } while(risposta.equals("S"));
    }
    //Waiting method
    private static void Wait()
    {
        try{
            Thread.sleep(10000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}