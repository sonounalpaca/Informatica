/*
To cook an egg, it takes 3 minutes.
Using the method developed in the lab,
create a program that allows you to time the egg cooking,
simulating the cooking stages with ASCII art created using characters.
 */

public class Es007_CotturaUovo {
    public static void main(String[] args)
    {
       int tempo=180;
       System.out.println("Cottura uovo");
       System.out.println("Tempo cottura 3 minuti");
       System.out.println("Attendere");
       for(int i=0; i<=90; i++)
       {
           //Draw a boiling egg
           System.out.println("Cottura uovo in corso...");
           System.out.println("   . ---- .");
           System.out.println("  *        *");
           System.out.println(" (	    )");
           System.out.println("(	     )");
           System.out.println(" (	    )");
           System.out.println("  (	   )");
           System.out.println("    - .. - ");
           Wait();
           ClrScr();
       }
       //Ready egg
        System.out.println("Uovo pronto");
        System.out.println("   .----.");
        System.out.println("  *       *");
        System.out.println(" (	   )");
        System.out.println("(    .-.    )");
        System.out.println(" (  (   )  )");
        System.out.println("  (  *.*  )");
        System.out.println("    - .. - ");

    }
    //Waiting method
    private static void Wait()
    {
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //Clear screen
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}