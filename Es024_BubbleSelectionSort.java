import java.util.*;

public class Es024_BubbleSelectionSort
{
    public static void main(String[] args)
    {
        int nElementi = 10;
        int[] array = new int[nElementi];
        Random numero = new Random(); //Genero i valori degli elementi in maniera randomica

        //Genero in maniera random i valori degli elementi dell'array
        randomDoppioni(array, numero);

        //Duplico l'array
        int[] copiaArray = array.clone();

        //Stampo l'array originale
        System.out.println("Array: ");
        for (int i = 0; i < nElementi; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        //Contatori degli ordinamenti
        int contaBubble = 0;
        int contaSelection = 0;

        //Metodi di ordinamento degli array
        contaBubble = bubble(array);
        contaSelection = selection(copiaArray);

        //Stampa dell'array ordinato
        System.out.println("Array ordinato: ");
        for (int i = 0; i < nElementi; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        //Stampa dei contatori
        System.out.println("Contatore Bubble sort: " + contaBubble);
        System.out.println("Contatore Selection sort: " + contaSelection);
    }

    public static int bubble(int[] array)
    {
        int contaBubble = 0;
        //Ordino un array con il metodo bubble sort
        for (int i = 0; i < array.length - 1; i++)
        {
            contaBubble++;
            for (int j = 0; j < array.length - i - 1; j++)
            {
                contaBubble++;
                if (array[j] > array[j + 1])
                {
                    contaBubble++;
                    //Scambio gli elementi
                    int temp = array[j];
                    contaBubble++;
                    array[j] = array[j + 1];
                    contaBubble++;
                    array[j + 1] = temp;
                    contaBubble++;
                }
            }
        }
        return contaBubble;
    }

    public static int selection(int[] array)
    {
        int contaSelection = 0;
        //Ordino un array con il metodo selection sort
        for (int i = 0; i < array.length; i++)
        {
            contaSelection++;
            int miniIndex = i; //Indice corrente come indice minimo
            contaSelection++;
            for (int j = i + 1; j < array.length; j++)
            {
                contaSelection++;
                if (array[j] < array[miniIndex])
                {
                    contaSelection++;
                    miniIndex = j;
                    contaSelection++;
                }
            }
            //Scambio l'elemento più piccolo trovato con il primo dell'array non ordinato
            int temporanea = array[miniIndex];
            contaSelection++;
            array[miniIndex] = array[i];
            contaSelection++;
            array[i] = temporanea;
            contaSelection++;
        }
        return contaSelection;
    }

    private static void randomDoppioni(int[] array, Random numero) {
        //Controllo che i vari elementi che inserisco non si ripetano man mano che vengono generati
        for (int i = 0; i < array.length; i++)
        {
            boolean doppione;
            do
            {
                doppione = false;
                array[i] = numero.nextInt(90) + 1;

                //Controlla se il numero è già presente nell'array
                for (int j = 0; j < i; j++)
                {
                    if (array[j] == array[i])
                    {
                        doppione = true;
                        break;
                    }
                }
            } while (doppione);
        }
    }
}
