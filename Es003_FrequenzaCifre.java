
// Read a sequence of numbers that ends with 0
// Read the frequency of each digit in the sequence

import java.util.Scanner;
public class Es003_FrequenzaCifre {
    public static void main(String[] args)
    {
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Inserire una sequenza di numeri");
        int numero, n2;
        int resto;
        int conta0=0;
        int conta1=0, conta2=0, conta3=0;
        int conta4=0, conta5=0, conta6=0;
        int conta7=0, conta8=0, conta9=0;
        //Number Input
        System.out.println("Inserire un numero");
        numero=keyboard.nextInt();
        if (numero==0) {
            System.out.println("Sequenza vuota");
        }
        else{
            do
            {
                n2=numero;
                // Count Frequency
                do
                {
                    resto=n2%10;
                    n2=n2/10;
                    if (resto==0) {
                        conta0++;
                    } else if (resto==1) {
                        conta1++;
                    } else if (resto==2) {
                        conta2++;
                    } else if (resto==3) {
                        conta3++;
                    } else if (resto==4) {
                        conta4++;
                    } else if (resto==5) {
                        conta5++;
                    } else if (resto==6) {
                        conta6++;
                    } else if (resto==7) {
                        conta7++;
                    } else if (resto==8) {
                        conta8++;
                    } else if (resto==9) {
                        conta9++;
                    }
                } while (n2 != 0);
                // Insert New Number
                numero = keyboard.nextInt();
            } while (numero != 0);
        }
        //Print results
        if (conta0>0) {
            System.out.println("La cifra 0 è ripetuta: " + conta0 + " volte");
        }
        if (conta1>0) {
            System.out.println("La cifra 1 è ripetuta: " + conta1 + " volte");
        }
        if (conta2>0) {
            System.out.println("La cifra 2 è ripetuta: " + conta2 + " volte");
        }
        if (conta3>0) {
            System.out.println("La cifra 3 è ripetuta: " + conta3 + " volte");
        }
        if (conta4>0) {
            System.out.println("La cifra 4 è ripetuta: " + conta4 + " volte");
        }
        if (conta5>0) {
            System.out.println("La cifra 5 è ripetuta: " + conta5 + " volte");
        }
        if (conta6>0) {
            System.out.println("La cifra 6 è ripetuta: " + conta6 + " volte");
        }
        if (conta7>0) {
            System.out.println("La cifra 7 è ripetuta: " + conta7 + " volte");
        }
        if (conta8>0) {
            System.out.println("La cifra 8 è ripetuta: " + conta8 + " volte");
        }
        if (conta9>0) {
            System.out.println("La cifra 9 è ripetuta: " + conta9 + " volte");
        }
    }
}