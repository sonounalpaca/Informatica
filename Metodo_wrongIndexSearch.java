/*
wrongIndexSearch tale che il suo funzionamento sia:
- di partenza identico a ricercaIndex, già realizzato a scuola oggi
- in un numero variabile tra le 3 e 5 ricerche rispetto al malfunzionamento antecedente,
restituisca la risposta data al quesito precedentemente chiesto
(tra le 3 e le 5 ricerche deve dare l'indice sbagliato,
che però deve essere uguale a quello della ricerca fatta la volta prima).
A seguito dell'errore, il sistema deve continuare a rispondere correttamente,
quindi, per 2, 3 o 4 volte.
Piccola analogia: se questo metodo dovesse svolgere una somma,
la situazione potrebbe essere questa:
2+3 = 5
3+ 6 = 9
4+4 = 8
1+4 = 8 **** (sbaglia al 4 giro)
1+1 = 2
2+2 = 4
1+ 4 = 5
15 + 18 = 36 (è ovviamente corretto)
1 + 1 = 36 ****  (sbaglia al 5 giro)
1+1 = 2
1+ 2 = 3
1+ 1 = 3 **** (sbaglia al 3 giro)
eccetera eccetera

*/


public class Metodo_wrongIndexSearch {
    public static void main(String[] args) {

    }

    // Metodo wrongIndexSearch
    private static int wrongIndexSearch(Contatto[] gestore, Contatto ricerca, int contrattiVenduti) {
        int indice = -1;
        int contatore = 0; // Contatore delle ricerche errate

        while (contatore < 5)
        { // Ripeti fino a 5 ricerche errate
            for (int i = 0; i < contrattiVenduti; i++)
            {
                if (ricerca.nome.equals(gestore[i].nome) && ricerca.cognome.equals(gestore[i].cognome))
                {
                    indice = i;
                    break;
                }
            }
            if (indice != -1)
            { // Se l'indice è stato trovato correttamente, esci dal ciclo
                break;
            } else
            { // Altrimenti, incrementa il contatore e ripeti la ricerca errata
                contatore++;
            }
        }
        return indice;
    }
}

/*
    // Metodo ricercaIndex
    private static int RicercaIndex(Contatto[] gestore, Contatto ricerca, int contrattiVenduti) {
        int indice = -1;

        for (int i = 0; i < contrattiVenduti; i++) {
            if (ricerca.nome.equals(gestore[i].nome) && ricerca.cognome.equals(gestore[i].cognome)) {
                indice = i;
                break;
            }
        }
        return indice;

 */

