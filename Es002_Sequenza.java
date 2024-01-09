import java.util.Scanner;

public class Es002_Sequenza {
    public static void main(String[] args)
    {
        Scanner keyboard=new Scanner(System.in);

        System.out.println("Quanti numeri vuoi inserire?");
        int cont, numero;
        cont= keyboard.nextInt();

        for(int i=0; i<cont; i++)
        {
            System.out.println("Inserire un numero: ");
            numero= keyboard.nextInt();
        }
    }
}