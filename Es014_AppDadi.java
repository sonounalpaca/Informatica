/*
Modify the dice competition so that you can play through a menu:
=== Dice Race App ===
[1] - Challenge between two players
[2] - Challenge against the computer
[3] - End
*/

import java.util.Scanner;
import java.util.Random;
public class Es014_AppDadi {
    public static void main(String[] args)
    {
        int scelta;
        boolean exit=true;
        int [] ruota=new int[5];
        int valoreFaccia;
        int giocatore1=0, giocatore2=0;
        String risposta;
        Random faccia = new Random();
        do
        {
            Menu();
            System.out.println();
            //Choice
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Sceglere l'operazione da eseguire");
            scelta = keyboard.nextInt();
            ClrScr();
            //Choice loop
            switch (scelta)
            {
                case 1: //Two player
                    System.out.println("Sfida tra due giocatori");
                    ClrScr();
                    //First play
                    System.out.println("Giocatore 1:");
                    System.out.println("Lanciare dadi? (S/N)");
                    risposta=keyboard.nextLine().toUpperCase();
                    risposta=keyboard.nextLine().toUpperCase();
                    if (risposta.equals ("S"))
                    {
                        for(int i = 1; i <= 7; i++)
                        {
                            if (i == 7)
                            {
                                Wait(1000);
                                ClrScr();
                                System.out.println("E' uscito : ");
                                valoreFaccia = faccia.nextInt(0, 6) + 1;
                            } else
                            {
                                Wait(1000);
                                ClrScr();
                                valoreFaccia = i;
                            }
                            giocatore1=valoreFaccia;
                            Dadi(valoreFaccia);
                        }
                    } else
                    {
                        break;
                    }
                    //Second play
                    System.out.println("Giocatore 2 ");
                    System.out.println("Lanciare dadi? (S/N)");
                    risposta=keyboard.nextLine().toUpperCase();
                    if (risposta.equals ("S"))
                        {
                        for(int i = 1; i <= 7; i++)
                        {
                            if (i == 7)
                            {
                                Wait(1000);
                                ClrScr();
                                System.out.println("E' uscito : ");
                                valoreFaccia = faccia.nextInt(0, 6) + 1;
                            } else
                            {
                                Wait(1000);
                                ClrScr();
                                valoreFaccia = i;
                            }
                            Dadi(valoreFaccia);
                            giocatore2=valoreFaccia;
                        }
                    } else
                    {
                        break;
                    }
                    ClrScr();
                    //Winner verification
                    System.out.println("Giocatore 1: "+giocatore1);
                    System.out.println("Giocatore 2: "+giocatore2);
                    if(giocatore1<giocatore2)
                    {
                        System.out.println("Vince il Giocatore 2");
                    }else if(giocatore1==giocatore2)
                    {
                        System.out.println("Pareggio");
                    }else
                    {
                        System.out.println("Vince il Giocatore 1");
                    }
                    break;
                case 2: //Against the computer
                    System.out.println("Sfida contro il computer");
                    ClrScr();
                    //First play
                    System.out.println("Giocatore 1:");
                    System.out.println("Lanciare dadi? (S/N)");
                    risposta=keyboard.nextLine().toUpperCase();
                    risposta=keyboard.nextLine().toUpperCase();
                    if (risposta.equals ("S"))
                    {
                        for(int i = 1; i <= 7; i++)
                        {
                            if (i == 7)
                            {
                                Wait(1000);
                                ClrScr();
                                System.out.println("E' uscito : ");
                                valoreFaccia = faccia.nextInt(0, 6) + 1;
                            } else
                            {
                                Wait(1000);
                                ClrScr();
                                valoreFaccia = i;
                            }
                            giocatore1=valoreFaccia;
                            Dadi(valoreFaccia);
                        }
                    } else
                    {
                        break;
                    }
                    //Computer
                    System.out.println("Computer: ");
                    for(int i = 1; i <= 7; i++)
                    {
                        if (i == 7)
                        {
                            Wait(1000);
                            ClrScr();
                            System.out.println("E' uscito : ");
                            valoreFaccia = faccia.nextInt(0, 6) + 1;
                        } else
                        {
                            Wait(1000);
                            ClrScr();
                            valoreFaccia = i;
                        }

                        Dadi(valoreFaccia);
                        giocatore2=valoreFaccia;
                    }
                    ClrScr();
                    //Winner verification
                    System.out.println("Giocatore 1: "+giocatore1);
                    System.out.println("Computer: "+giocatore2);
                    if(giocatore1<giocatore2)
                    {
                        System.out.println("Vince il computer");
                    }else if(giocatore1==giocatore2)
                    {
                        System.out.println("Pareggio");
                    }else
                    {
                        System.out.println("Vince il Giocatore 1");
                    }
                    break;
                case 3: //Exit
                    System.out.println("Fine");
                    Wait(2000);
                    exit=false;
                    break;
                default:
                    System.out.println("Scelta non disponibile, riprovare");
                    break;
            }
        }while(exit);
    }
    //Method for choice menu
    private static void Menu()
    {
        System.out.println("=== App Dad ===");
        System.out.println("[1]-Sfida tra due giocatori");
        System.out.println("[2]-Sfida contro il computer");
        System.out.println("[3]-Fine");
    }
    //Method that prints the faces of the die
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
    //Screen clearing method
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Waiting method
    private static void Wait(int attesa)
    {
        try{
            Thread.sleep(attesa);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}