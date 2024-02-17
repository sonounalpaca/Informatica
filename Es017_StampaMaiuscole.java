/*Inserire in vettore una sequenza di stringhe,
*stampare a video solamente quelle che iniziano con la lettera maiuscola
*/

import java.util.Scanner;

public class Es017_StampaMaiuscole {
    public static void main(String[] args) {
        // Dichiarazione variabili
        String parola;
        int n = 1;
        int indice = 0;
        String[] arrayFrasi = new String[n];
        Scanner tastiera = new Scanner(System.in);

        // Utilizzo un ciclo do-while per inserire le stringhe
        // Se inserisco la parola 'terminato' finisco l'inserimento
        do {
            ClrScr();
            System.out.println("Inserire parola (inserire 'terminato' per finire l'inserimento):");
            parola = tastiera.nextLine();
            arrayFrasi[indice] = parola;

            // Incremento l'indice per poter inserire nell'elemento successivo
            indice++;

            // Incremento la grandezza dell'array per inserire nuove parole
            n++;
            String[] newArrayFrasi = new String[n];
            // Copio i valori dall'array originale al nuovo array
            for (int i = 0; i < arrayFrasi.length; i++) {
                newArrayFrasi[i] = arrayFrasi[i];
            }
            arrayFrasi = newArrayFrasi;
        } while (!parola.equals("terminato"));

        // Elimino la parola 'terminato' dall'array
        arrayFrasi[indice - 1] = null;

        // Controllo quali stringhe tra quelle inserite iniziano con la maiuscola
        System.out.println("Le stringhe che cominciano con la lettera maiuscola sono:");
        for (indice = 0; indice < n; indice++) {
            if (arrayFrasi[indice] != null && Character.isUpperCase(arrayFrasi[indice].charAt(0))) {
                System.out.println(arrayFrasi[indice]);
            }
        }
        tastiera.close();
    }

    // Metodo per pulire lo schermo
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}