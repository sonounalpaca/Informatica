/*
---METODO 1---
Creare il metodo evenOddSearch che dato un vettore,
ordini i numeri pari in modo crescente e i dispari in modo decrescente,
disposti nella sequenza:
- pari crescente
- dispari decrescente
Esempio del contenuto dell'array:
3, 4, 2, 5, 6, 1, 7, 8, 9 --> 2, 4, 6, 8, 9, 7, 5, 3, 1
*/

/*
---METODO 2---
Creare il metodo biBinarySearch che,
applicato dopo aver invocato evenOddSearch sia in grado
di verificare velocemente la presenza di un dato valore restituendone la posizione.
Dal nome del metodo si evince la necessità di dover modificare
il metodo della ricerca dicotomica (detta anche ricerca binaria, per gli amici)
Esempio:2, 4, 6, 8, 9, 7, 5, 3, 1 - Cerco 0' restituisce -1
2, 4, 6, 8, 9, 7, 5, 3, 1 - Cerco 6 restituisce 2
*/

import java.util.Scanner;
public class Metodi_evenOddSearch_biBinarySearch {

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int numeri = 0;
        System.out.println("Quanti numeri vuoi inserire?");
        numeri = tastiera.nextInt();
        int[] vettore = new int[numeri];
        // Array, se lo dichiaro prima non mi prende la lunghezza N
        for (int i = 0; i < numeri; i++)
        {
            System.out.println("Inserire numero in posizione " + (i + 1) + ":");
            vettore[i] = tastiera.nextInt();
        }

        evenOddSearch(vettore, numeri);
        for (int i : vettore)
        {
            System.out.print(i + " "); // Stampa su una sola riga
        }

        System.out.println("\nQuale numero vuoi cercare?");
        int ricerca = tastiera.nextInt();
        System.out.println("Posizione del numero: " + biBinarySearch(vettore, numeri, ricerca));
    }


    // Metodo per ordinare i numeri pari in modo crescente e i dispari in modo decrescente
    public static void evenOddSearch(int[] vettore, int numeri)
    {
        int pari = 0;
        int dispari = 0;
        // Conteggio gli elementi per ottenere le lunghezze dei due array
        for (int i = 0; i < numeri; i++)
        {
            if (vettore[i] % 2 == 0)
            {
                // Numero pari
                pari++;
            } else
            {
                // Numero dispari
                dispari++;
            }
        }
        int[] arrayPari = new int[pari]; // Numeri pari
        int[] arrayDispari = new int[dispari]; // Numeri dispari

        // Copia gli elementi nei rispettivi array
        int indicePari = 0; // Indice per non lasciare spazi vuoti nei vettori
        int indiceDispari = 0;
        for (int i = 0; i < numeri; i++)
        {
            if (vettore[i] % 2 == 0)
            {
                // Numero pari
                arrayPari[indicePari] = vettore[i];
                indicePari++;
            } else
            {
                // Numero dispari
                arrayDispari[indiceDispari] = vettore[i];
                indiceDispari++;
            }
        }

        // Ordina i numeri pari in ordine crescente con il Bubble Sort
        for (int i = 0; i < pari - 1; i++)
        {
            for (int j = 0; j < pari - i - 1; j++)
            {
                if (arrayPari[j] > arrayPari[j + 1])
                {
                    int temp = arrayPari[j];
                    arrayPari[j] = arrayPari[j + 1];
                    arrayPari[j + 1] = temp;
                }
            }
        }

        // Ordina i numeri dispari in ordine decrescente
        for (int i = 0; i < dispari - 1; i++)
        {
            for (int j = 0; j < dispari - i - 1; j++)
            {
                if (arrayDispari[j] < arrayDispari[j + 1])
                {
                    int temp = arrayDispari[j];
                    arrayDispari[j] = arrayDispari[j + 1];
                    arrayDispari[j + 1] = temp;
                }
            }
        }

        // Copia i due array ordinati nel vettore originale
        int k = 0;
        for (int i = 0; i < pari; i++)
        {
            vettore[k++] = arrayPari[i];
        }
        for (int i = 0; i < dispari; i++)
        {
            vettore[k++] = arrayDispari[i];
        }
    }

    // Metodo per la ricerca dicotomica in un vettore di numeri pari o dispari
    private static int biBinarySearch(int[] vettore, int numeri, int ricerca)
    {
        // Separazione degli elementi pari e dispari per semplificare la ricerca
        int pari = 0;
        int dispari = 0;
        // Conteggio gli elementi per ottenere le lunghezze dei due array
        for (int i = 0; i < numeri; i++)
        {
            if (vettore[i] % 2 == 0)
            {
                // Numero pari
                pari++;
            } else
            {
                // Numero dispari
                dispari++;
            }
        }
        int[] arrayPari = new int[pari]; // Numeri pari
        int[] arrayDispari = new int[dispari]; // Numeri dispari

        // Copia gli elementi nei rispettivi array
        int indicePari = 0; // Indice per non lasciare spazi vuoti nei vettori
        int indiceDispari = 0;
        for (int i = 0; i < numeri; i++)
        {
            if (vettore[i] % 2 == 0)
            {
                // Numero pari
                arrayPari[indicePari] = vettore[i];
                indicePari++;
            } else
            {
                // Numero dispari
                arrayDispari[indiceDispari] = vettore[i];
                indiceDispari++;
            }
        }

        // Applica la ricerca dicotomica su ciascuno dei due array
        int sinistra = 0;
        int destra;
        if (ricerca % 2 == 0)
        {
            destra = arrayPari.length - 1;
            // Nel caso il numero sia pari, cerca solo nell'array pari
            while (sinistra <= destra)
            {
                int medio = sinistra + (destra - sinistra) / 2;
                // Elemento presente nel mezzo
                if (arrayPari[medio] == ricerca)
                {
                    return medio;
                }
                // Elemento maggiore del valore nel mezzo, cerca a destra
                if (arrayPari[medio] < ricerca)
                {
                    sinistra = medio + 1;
                }
                // Elemento minore del valore nel mezzo, cerca a sinistra
                else
                {
                    destra = medio - 1;
                }
            }
            // Elemento non presente
            return -1;
        } else
        {
            // Il numero è dispari quindi cerca nell'array dei numeri dispari
            destra = arrayDispari.length - 1;
            while (sinistra <= destra)
            {
                int medio = sinistra + (destra - sinistra) / 2;
                // Elemento presente nel mezzo
                if (arrayDispari[medio] == ricerca)
                {
                    return medio;
                }
                // Elemento maggiore del valore nel mezzo, cerca a destra
                if (arrayDispari[medio] < ricerca)
                {
                    sinistra = medio + 1;
                }
                // Elemento minore del valore nel mezzo, cerca a sinistra
                else
                {
                    destra = medio - 1;
                }
            }
            // Elemento non presente
            return -1;
        }
    }
}
