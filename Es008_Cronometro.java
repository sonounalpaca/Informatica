/*
Create the algorithm for a stopwatch
*/

import java.util.Scanner;

public class Es008_Cronometro {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Cronometro");

        // Start the stopwatch
        String start;
        System.out.println("Per iniziare a cronometrare premere S");
        start = keyboard.nextLine().toUpperCase();

        while (!start.equals("S")) {
            System.out.println("Valore non valido");
            System.out.println("Per iniziare a cronometrare premere S");
            start = keyboard.nextLine().toUpperCase();
        }
        // Stopwatch time counting
        int cent=0, sec=0, min=0, ore=0;
        do {
            cent=cent+1;

            if (cent==110)
            {
                sec=sec+1;
                cent=cent-110;

                if (sec==60)
                {
                    min=min+1;
                    sec=sec-60;

                    if (min==60)
                    {
                        ore=ore+1;
                        min=min-60;
                        if (ore==24)
                        {
                            cent=0;
                            sec=0;
                            min=0;
                            ore=0;
                        }
                    }
                }
            }
            System.out.println("Tempo:");
            System.out.println(ore + ":" + min + ":" + sec + ":" + cent);
            Wait();
        } while (true);
    }
    // Waiting method
    private static void Wait() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}