/*
I randomly generate five numbers ranging from 1 to 90,
 place them in a vector, and print them.
 I check that the extracted numbers do not repeat
 by creating a method
*/

import java.util.Random;
public class Es012_Estrazione {
    public static void main(String[] args)
    {
        //Variables
        int [] ruota=new int[5];
        int numero;
        System.out.println("Benvenuti alle estrazioni del lotto");
        System.out.println("Estrazione numeri:");
        //Check method
        Controllo(ruota);
        //Print Numbers
        for(int index=0; index<ruota.length; index++)
        {
            System.out.println("Numero estratto:"+ruota[index]);
        }
    }
    //Method that generates random values and checks for repetitions
    private static void Controllo(int[] ruota)
    {
        boolean duplicato;
        for(int i=0; i<ruota.length; i++)
        {
            do {
                Random casuale=new Random();
                duplicato=false;
                ruota[i]=casuale.nextInt(1, 90) + 1;

                //Check if the number is already present in the vector
                for (int j = 0; j < i; j++) {
                    if (ruota[j]==ruota[i]) {
                        duplicato=true;
                        break;
                    }
                }
            } while (duplicato);
        }
    }
}