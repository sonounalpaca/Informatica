// Inserisci un numero e verifica se è un byte
// Se è un byte, convertilo in binario

import java.util.Scanner;

public class Es004_Byte {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String numero;
        boolean flagByte = true;
        System.out.println("Inserisci un numero binario:");
        numero = keyboard.nextLine();
        System.out.println("Numero di cifre: " + numero.length()); // .length string size
        //  Check the validity of the number
        for (int i=0; i<numero.length(); i++) {
            System.out.println(numero.charAt(i));
            if (!(numero.charAt(i)=='1' || numero.charAt(i)=='0')) {
                flagByte=false;
                break; // exit the loop if an invalid character is found
            }
        }
        if (flagByte && numero.length()==8) {
            System.out.println("Il numero è un byte");
            //  Conversion to integer
            int decimale = Integer.parseInt(numero, 2);
            System.out.println("Il numero in decimale è: " + decimale);
        } else {
            System.out.println("Il numero non è un byte");
        }
    }
}