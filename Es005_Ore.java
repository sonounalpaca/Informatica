/*
Enter an integer representing the seconds elapsed since the beginning of today.
Display the current time in the format hh:mm:ss (hours:minutes:seconds).
If the user enters a null value or a value exceeding one day,
ask for re-entry.
 */

import java.util.Scanner;

public class Es005_Ore {
    public static void main(String[] args)
    {
        Scanner keyboard=new Scanner(System.in);
        System.out.println("Inserire i secondi trascorisi");
        int ore=0, minuti=0, secondi;
        //Enter seconds
        secondi=keyboard.nextInt();
        while (secondi<=0 || secondi>86400) {
            System.out.println("Il valore inserito è nullo");
            System.out.println("Inserire i secondi trascorsi");
            secondi = keyboard.nextInt();
        }
        //Calculate time
        while (secondi>=60){
            minuti=minuti+1;
            secondi=secondi-60;
        }
        while (minuti>=60){
            ore=ore+1;
            minuti=minuti-60;
        }
        //Return the time
        System.out.println("Sono trascorsi: ");
        System.out.println(ore+" ore "+minuti+" minuti "+secondi+" secondi");
    }
}