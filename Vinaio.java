//Wine Shop: Wine Type Selection
import java.util.Scanner;
public class Vinaio {
    public static void main(String[] args)
    {
        Scanner keyboard=new Scanner (System.in);
        System.out.println("Benvenuti alla vendita di Vini");
        //Variable Declaration
        int bottiglie;
        double litri, costo, iva;
        double totale, totalegiorno=0;
        int cont=0;
        String risposta = "", vino = "";
        //Repetition Loop for New Customers
        do{
            //Wine Selection
            System.out.println("Quale vino desidera acquistare?");
            System.out.println("Barbera (B)");
            System.out.println("Lugana (L)");
            System.out.println("Merlot (M)");
            vino= keyboard.nextLine().toUpperCase();
            //Insertion Verification
            while(!vino.equals("B")&&!vino.equals("M")&&!vino.equals("L")) {
                System.out.println("Vino non disponibile");
                System.out.println("Quale vino desidera acquistare?");
                vino= keyboard.nextLine().toUpperCase();
            }
            //Number of Bottles Insertion
            System.out.println("Quante bottiglie desidera acquistare?");
            bottiglie= keyboard.nextInt();
            //Insertion Verification
            while(bottiglie<1) {
                System.out.println("Valore no valido");
                System.out.println("Quante bottiglie desidera acquistare?");
                bottiglie= keyboard.nextInt();
            }
            if (vino.equals("B")) {
                //Calculations
                litri= bottiglie*1.5;
                costo= litri*1.5;
                iva= costo*21/100;
                totale= costo+iva;
                //Receipt Printing
                System.out.println("------------------------------");
                System.out.println("Scontrino");
                System.out.println("Numero bottiglie acquistate: "+bottiglie);
                System.out.println("Totale: "+costo);
                System.out.println("Iva: "+iva);
                System.out.println("Totale con Iva: "+totale);
                System.out.println("------------------------------");
                cont=cont+1;
                totalegiorno= totalegiorno+totale;
            }
            else {
                if(vino.equals("M")) {
                    //Calculations
                    litri= bottiglie*1.5;
                    costo= litri*1;
                    iva= costo*21/100;
                    totale= costo+iva;
                    //Receipt Printing
                    System.out.println("------------------------------");
                    System.out.println("Scontrino");
                    System.out.println("Numero bottiglie acquistate: "+bottiglie);
                    System.out.println("Totale: "+costo);
                    System.out.println("Iva: "+iva);
                    System.out.println("Totale con Iva: "+totale);
                    System.out.println("------------------------------");
                    cont=cont+1;
                    totalegiorno= totalegiorno+totale;
                }
                else {
                    if(vino.equals("L")) {
                        //Calculations
                        litri= bottiglie*1.5;
                        costo= litri*2;
                        iva= costo*21/100;
                        totale= costo+iva;
                        //Receipt Printing
                        System.out.println("------------------------------");
                        System.out.println("Scontrino");
                        System.out.println("Numero bottiglie acquistate: "+bottiglie);
                        System.out.println("Totale: "+costo);
                        System.out.println("Iva: "+iva);
                        System.out.println("Totale con Iva: "+totale);
                        System.out.println("------------------------------");
                        cont=cont+1;
                        totalegiorno= totalegiorno+totale;

                    }
                }
            }
            //New Customer Reading
            risposta= keyboard.nextLine().toUpperCase();
            System.out.println("Nuovo cliente? (S/N)");
            risposta= keyboard.nextLine().toUpperCase();
        }
        while(risposta.equals("S"));
        System.out.println("Numero clienti della giornata: "+cont);
        System.out.println("Totale vendite: "+totalegiorno);
    }
}