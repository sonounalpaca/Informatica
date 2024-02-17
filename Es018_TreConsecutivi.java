/*Scrivere un programma TreConsecutivi
*che prevede un array di 10 numeri interi
*contenente valori a piacere (senza bisogno di chiederli all’utente)
*e stampa "Tre valori consecuitivi uguali" se l’array contiene tre valori uguali
*in tre posizioni consecutive
*oppure stampa "NO" altrimenti.
*/

import java.util.Random;

public class Es018_TreConsecutivi {
    public static void main(String[] args)
    {
        int [] numeri = new int [10];
        Random casuale=new Random();
        int n=0; //Indice array

        //Genero causalmente dieci numeri compresi tra 1 e 20
        //E li utilizzo per riempire l'array
        for (int indice=0; indice<numeri.length; indice++)
        {
            numeri[indice]=casuale.nextInt(1, 20) + 1;
        }

        //Controllo se tra i dieci numeri ce ne sono tre uguali consegutivi
       for (int i=0; i<numeri.length-2; i++)
       {
           if (numeri[i] == numeri[i + 1] && numeri[i + 1] == numeri[i + 2])
           {
               //Numeri consecutivi uguali
               System.out.println("Tre numeri consecutivi uguali");
               return; //Esco dal metodo dopo aver trovato il risultato
           }
       }
        //Se non sono stati trovati tre numeri consecutivi uguali
        System.out.println("NO");
    }
}