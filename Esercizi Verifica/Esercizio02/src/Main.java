import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int[] array = new int[10];

        // Inserimento degli elementi
        System.out.println("Inserire elementi nell'array (compresi tra 1 e 30): ");
        for (int i = 0; i < array.length; i++) {
            int numero = tastiera.nextInt();
            while (numero < 1 || numero > 30 || controllo(array, numero, i)) {
                if (numero < 1 || numero > 30) {
                    System.out.println("Errore: il numero deve essere compreso tra 1 e 30. Riprova:");
                } else {
                    System.out.println("Errore: numero duplicato. Riprova:");
                }
                numero = tastiera.nextInt();
            }
            array[i] = numero;
        }

        // Pulire il buffer prima di leggere la stringa di risposta
        tastiera.nextLine();

        // Richiesta per inserire l'11esimo elemento o meno
        System.out.println("Inserire un ultimo elemento? (S/N)");
        String risposta = tastiera.nextLine();

        if (risposta.equalsIgnoreCase("S")) {
            int[] nuovoArray = new int[array.length + 1];
            System.arraycopy(array, 0, nuovoArray, 0, array.length);

            // Inserire l'11esimo elemento
            System.out.println("Inserire l'ultimo elemento (compreso tra 1 e 30): ");
            int numero = tastiera.nextInt();
            while (numero < 1 || numero > 30 || controllo(nuovoArray, numero, array.length)) {
                if (numero < 1 || numero > 30) {
                    System.out.println("Errore: il numero deve essere compreso tra 1 e 30. Riprova:");
                } else {
                    System.out.println("Errore: numero duplicato. Riprova:");
                }
                numero = tastiera.nextInt();
            }
            nuovoArray[nuovoArray.length - 1] = numero;
            array = nuovoArray;
        }

        // Suddivisione dell'array
        int[] numeriPari = pari(array);

        // Ordinamento array
        ordinamento(numeriPari);

        //Copia degli elementi pari nell'array inizale
        int indice = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] % 2 == 0) {
                array [i] = numeriPari [indice];
                indice ++;
            }
        }

        //Stampa
        for (int i = 0; i < array.length; i++)
        {
            System.out.print (array[i] +" ");
        }
    }

    private static boolean controllo(int[] array, int numero, int lunghezza) {
        for (int i = 0; i < lunghezza; i++) {
            if (array[i] == numero) {
                return true;
            }
        }
        return false;
    }

    private static int[] pari(int[] array) {
        int conteggio = 0;
        for (int numero : array) {
            if (numero % 2 == 0) {
                conteggio++;
            }
        }

        int[] numeriPari = new int[conteggio];
        int indice = 0;
        for (int numero : array) {
            if (numero % 2 == 0) {
                numeriPari[indice++] = numero;
            }
        }

        return numeriPari;
    }

    public static void ordinamento(int[] arrayPari) {
        sort(arrayPari, 0, arrayPari.length - 1);
    }

    private static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = ordina(array, low, high);
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    private static int ordina(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
