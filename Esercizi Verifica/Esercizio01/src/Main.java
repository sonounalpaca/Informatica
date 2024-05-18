import static Tools.Utility.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String[] operazioni =
                {"RUBRICA",
                "[1] Modifica Password",
                "[2] Inserimento Contatti",
                "[3] Visualizzazione Contatti",
                "[4] Modifica Contatti",
                "[5] Cancellazione",
                "[6] Chiamate",
                "[7] Fine"};

        String[] listaStampa =
                {"Stampa",
                "1] Contatti Visibili",
                "2] Contatti Nascosti",
                "3] Tutti i contatti"};

        final int nMax = 5;
        int contattiInseriti = 0;
        Contatto[] gestore = new Contatto[nMax];
        int eliminaContatto;
        int modificaContatto;
        int chiamaContatto;
        String svuotaBuffer;

        int[] password = {0};
        creazionePassword(password, keyboard);
        ClrScr();

        boolean fine = true;
        do
        {
            switch (menu(operazioni, keyboard))
            {
                case 1: {
                    System.out.println("Modifica Password");
                    modificaPassword(password, keyboard);
                    break;
                }

                case 2: {
                    System.out.println("Inserimento Contatti");
                    if (contattiInseriti < nMax)
                    {
                        gestore[contattiInseriti] = leggiPersona(keyboard);
                        contattiInseriti++;
                    } else
                    {
                        System.out.println("Non c'è più posto nella rubrica");
                    }
                    break;
                }

                case 3: {
                    visualizza(gestore, contattiInseriti, listaStampa, keyboard, password[0]);
                    break;
                }

                case 4: {
                    if (contattiInseriti == 0)
                    {
                        System.out.println("Nessun contatto inserito");
                    } else
                    {
                        do
                        {
                            System.out.println("Inserimento password per accesso completo ai contatti");
                            inserimentoPassword(password[0], keyboard);
                            System.out.println("Quale contatto vuole modificare? Da 1 a " + contattiInseriti);
                            modificaContatto = keyboard.nextInt() - 1;

                            if (modificaContatto < 0 || modificaContatto >= contattiInseriti)
                            {
                                System.out.println("Il contatto inserito non esiste, RINSERIRE");
                            }

                        } while (modificaContatto < 0 || modificaContatto >= contattiInseriti);
                        svuotaBuffer = keyboard.nextLine();
                        gestore[modificaContatto] = leggiPersona(keyboard);
                    }
                    break;
                }

                case 5: {
                    if (contattiInseriti == 0) {
                        System.out.println("Non sono ancora stati inseriti Contatti");
                    } else {
                        do {
                            System.out.println("Inserimento password per accesso completo ai contatti");
                            inserimentoPassword(password[0], keyboard);
                            System.out.println("Quale contatto vuole Eliminare? Da 1 a " + contattiInseriti);
                            eliminaContatto = keyboard.nextInt() - 1;

                            if (eliminaContatto < 0 || eliminaContatto >= contattiInseriti) {
                                System.out.println("Il contatto inserito non esiste, RINSERIRE");
                            }

                        } while (eliminaContatto < 0 || eliminaContatto >= contattiInseriti);
                        svuotaBuffer = keyboard.nextLine();
                        contattiInseriti--;

                        gestore[eliminaContatto] = cancellaContratto(gestore, eliminaContatto);
                        spostaContratti(gestore, contattiInseriti);

                        System.out.println("Contatto eliminato: \n");
                    }
                    break;
                }

                case 6: {
                    if (contattiInseriti == 0) {
                        System.out.println("Nessun contatto inserito");
                    } else {
                        System.out.println("Inserimento password per accesso completo ai contatti");
                        inserimentoPassword(password[0], keyboard);
                        System.out.println ("Lista Contatti");
                        visualizzaContatti(gestore, contattiInseriti);
                        System.out.println("Quale contatto si desidera chiamare? Da 1 a \" + contattiInseriti");
                        chiamaContatto = keyboard.nextInt() - 1;

                        if (chiamaContatto < 0 || chiamaContatto >= contattiInseriti) {
                            System.out.println("Il contatto inserito non esiste, RINSERIRE");
                        } else {
                            System.out.println("Chiamata effettuata con successo");
                            gestore[chiamaContatto].chiamate++;
                        }
                    }
                    break;
                }

                default: {
                    fine = false;
                    break;
                }
            }
        } while (fine);
    }

    public static void creazionePassword(int[] password, Scanner keyboard)
    {
        int conferma;
        boolean pin = true;
        System.out.println("Creazione PIN numerico per la gestione dei contatti nascosti");
        do
        {
            System.out.println("Inserimento PIN:");
            password[0] = keyboard.nextInt();
            System.out.println("Conferma PIN:");
            conferma = keyboard.nextInt();
            if (password[0] == conferma)
            {
                pin = false;
            } else
            {
                System.out.println("ERRORE: i due PIN non coincidono");
                System.out.println("Ripetere Inserimento");
            }
        } while (pin);
    }

    public static void modificaPassword(int[] password, Scanner keyboard)
    {
        int conferma;
        int modifica = 0;
        boolean pin = true;
        do {
            System.out.println("Inserimento vecchio PIN:");
            conferma = keyboard.nextInt();
            if (password[0] == conferma)
            {
                System.out.println("Inserimento nuovo PIN:");
                modifica = keyboard.nextInt();
                System.out.println("Conferma PIN:");
                conferma = keyboard.nextInt();
                if (modifica == conferma)
                {
                    pin = false;
                    password[0] = modifica;
                } else
                {
                    System.out.println("ERRORE: i due PIN non coincidono");
                    System.out.println("Ripetere Inserimento");
                }
            } else
            {
                System.out.println("ERRORE: il PIN non coincide con quello vecchio");
                System.out.println("Ripetere Inserimento");
            }
        } while (pin);

    }

    public static void inserimentoPassword(int password, Scanner keyboard)
    {
        int conferma;
        boolean pin = true;
        do {
            System.out.println("Inserire PIN:");
            conferma = keyboard.nextInt();
            if (password == conferma)
            {
                pin = false;
            } else
            {
                System.out.println("ERRORE: PIN errato");
                System.out.println("Riprova");
            }
        } while (pin);
    }

    private static Contatto leggiPersona(Scanner keyboard)
    {
        String[] tipoC = {"Contatto", "1] visibile", "2] nascosto"};
        Contatto persona = new Contatto();
        System.out.println("\nInserisci il nome: ");
        persona.nome = keyboard.nextLine();
        persona.nome = keyboard.nextLine();
        System.out.println("\nInserisci il cognome: ");
        persona.cognome = keyboard.nextLine();
        System.out.println("\nInserisci il numero di telefono: ");
        persona.telefono = keyboard.nextLine();
        switch (menu(tipoC, keyboard))
        {
            case 1 -> persona.tipo = tipoContatto.visibile;
            default -> persona.tipo = tipoContatto.nascosto;
        }
        return persona;
    }

    private static void visualizza(Contatto[] gestore, int contrattiVenduti, String[] listaStampa, Scanner keyboard, int password)
    {
        switch (menu(listaStampa, keyboard))
        {
            case 1:
                for (int i = 0; i < contrattiVenduti; i++) {
                    if (gestore[i].tipo == tipoContatto.visibile)
                    {
                        System.out.println(gestore[i].stampa());
                    }
                }
                break;
            case 2:
                inserimentoPassword(password, keyboard);
                for (int i = 0; i < contrattiVenduti; i++)
                {
                    if (gestore[i].tipo == tipoContatto.nascosto)
                    {
                        System.out.println(gestore[i].stampa());
                    }
                }
                break;
            case 3:
                inserimentoPassword(password, keyboard);
                for (int i = 0; i < contrattiVenduti; i++)
                {
                    System.out.println(gestore[i].stampa());
                }
                break;
        }
    }

    private static Contatto cancellaContratto(Contatto[] gestore, int elimContratto)
    {
        gestore[elimContratto].nome = null;
        gestore[elimContratto].cognome = null;
        gestore[elimContratto].telefono = null;
        gestore[elimContratto].tipo = null;
        return gestore[elimContratto];
    }

    private static void spostaContratti(Contatto[] gestore, int contrattiVenduti)
    {
        for (int i = 0; i < contrattiVenduti; i++)
        {
            if (gestore[i].nome == null && gestore[i].cognome == null && gestore[i].telefono == null && gestore[i].tipo == null)
            {
                for (int j = i; j < contrattiVenduti; j++)
                {
                    gestore[j] = gestore[j + 1];
                }
                gestore[contrattiVenduti] = null;
            }
        }
    }

    private static void visualizzaContatti (Contatto[] gestore, int contattiInseriti)
    {
        for (int i = 0; i < contattiInseriti; i++)
        {
            System.out.println(gestore[i].stampaChiamate());
        }
    }
}