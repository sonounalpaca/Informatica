/*
Rock-Paper-Scissors
Rules:
-Paper wins against rock
-Rock wins against scissors
-Scissors win against paper
First player: A = paper, S = rock, D = scissors
Second player: J = paper, K = rock, L = scissors
Keystrokes should not be visible.
The game is valid only if the input values belong to the valid set.
The program should repeat until one of the two players enters "X".
 */
import java.util.Scanner;
public class Es006_MorraCinese {
    public static void main(String[] args)
    {
        System.out.println("Benvenuti al gioco della Morra Cinese");
        Scanner keyboard=new Scanner(System.in);
        //Variable
        String giocatore1, giocatore2;
        int punti1=0, punti2=0;
        String risposta;
        //Game
        do{
            //Player  1
            System.out.println("Giocatore uno inserire la giocata: ");
            System.out.println("A = carta,S = sasso,D = forbici");
            giocatore1=keyboard.nextLine().toUpperCase();
            //Player  2
            System.out.println("Giocatore due inserire la giocata: ");
            System.out.println("J = carta,K = sasso,L = forbici");
            giocatore2=keyboard.nextLine().toUpperCase();
            if (!(giocatore1.equals("A") || giocatore1.equals("S") || giocatore1.equals("D"))){
                System.out.println("Giocata non valida");
            }
            else{
                if (!(giocatore2.equals("J") || giocatore2.equals("K") || giocatore2.equals("L"))){
                    System.out.println("Giocata non valida");
                }
                else{
                    //Calculate winner of the game
                    if(giocatore1.equals('A') && giocatore2.equals('J')){
                        punti1=punti1;
                        punti2= punti2;
                    }
                    else{
                        if(giocatore1.equals('S') && giocatore2.equals('K')){
                            punti1=punti1;
                            punti2= punti2;
                        }
                        else {
                            if(giocatore1.equals('D') && giocatore2.equals('L')){
                                punti1=punti1;
                                punti2= punti2;
                            }
                            else {
                                if(giocatore1.equals('A') && giocatore2.equals('K')){
                                    punti1++;
                                }
                                else {
                                    if(giocatore1.equals('A') && giocatore2.equals('L')){
                                        punti2++;
                                    }
                                    else {
                                        if(giocatore1.equals('S') && giocatore2.equals('J')){
                                            punti2++;
                                        }
                                        else {
                                            if(giocatore1.equals('S') && giocatore2.equals('L')){
                                                punti1++;
                                            }
                                            else {
                                                if(giocatore1.equals('D') && giocatore2.equals('J')){
                                                    punti1++;
                                                }
                                                else {
                                                    if(giocatore1.equals('D') && giocatore2.equals('K')){
                                                        punti2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //Game repetition
            System.out.println("Volete continuare a giocare? (S/X)");
            risposta=keyboard.nextLine().toUpperCase();
        } while (!risposta.equals("X"));
        //Print game results
        System.out.println("Giocatore 1: "+punti1);
        System.out.println("Giocatore 2: "+punti2);
        System.out.println("Vincitore:");
        if (punti1>punti2){
            System.out.println("Giocatore 1");
        }
        else{
            if (punti1==punti2){
                System.out.println("Parità");
            }
            else{
                System.out.println("Giocatore 2");
            }
        }
    }
}