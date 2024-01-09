import java.util.Scanner;
import java.util.Random;

public class Es010_Dadi {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random faccia = new Random();
        int valoreFaccia;
        int giocatore1=0, giocatore2=0;
        int cont1=0, cont2=0;
        String risposta;
        do
        {
            //First move
            System.out.println("Giocatore 1:");
            for(int i = 1; i <= 7; i++)
            {
                if (i == 7)
                {
                    Wait();
                    ClrScr();
                    System.out.println("E' uscito : ");
                    valoreFaccia = faccia.nextInt(0, 6) + 1;
                } else
                {
                    Wait();
                    ClrScr();
                    valoreFaccia = i;
                }
                giocatore1=valoreFaccia;
                Dadi(valoreFaccia);
            }
            //Second move
            System.out.println("Giocatore 2 ");
            for(int i = 1; i <= 7; i++)
            {
                if (i == 7)
                {
                    Wait();
                    ClrScr();
                    System.out.println("E' uscito : ");
                    valoreFaccia = faccia.nextInt(0, 6) + 1;
                } else
                {
                    Wait();
                    ClrScr();
                    valoreFaccia = i;
                }

                Dadi(valoreFaccia);
                giocatore2=valoreFaccia;
            }
            //Winner of the play
            System.out.println("Giocatore 1: "+giocatore1);
            System.out.println("Giocatore 2: "+giocatore2);
            if(giocatore1<giocatore2)
            {
                System.out.println("Vince la giocata: Giocatore 2");
                cont2++;
            }else if(giocatore1==giocatore2)
            {
                System.out.println("Pareggio");
                cont1++;
                cont2++;
            }else
            {
                System.out.println("Vince la giocata: Giocatore 1");
                cont1++;
            }
            System.out.println("Nuova giocata? (S/N)");
            risposta=keyboard.nextLine().toUpperCase();
        } while(risposta.equals("S"));
        //Check winner
        if(cont1<cont2)
        {
            System.out.println("Vince il Giocatore 2");
        }else if(cont1==cont2)
        {
            System.out.println("Pareggio");
        }
        else
        {
            System.out.println("Vince il Giocatore 1");
        }
    }
    //Dice drawing method
    private static void Dadi(int valoreFaccia) {
        switch (valoreFaccia) {
            case 1 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 2 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 3 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 4 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 5 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 6 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
        }
    }
    //Screen clear method
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Wait method
    private static void Wait() {
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}