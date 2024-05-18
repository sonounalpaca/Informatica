enum tipoContatto { visibile, nascosto }

class Contatto {
    public String nome;
    public String cognome;
    public String telefono;
    public int chiamate;
    public tipoContatto tipo;

    public String stampa() {
        return String.format("Nome: %s Cognome: %s Telefono: %s, Tipo: %s, Chiamate: %d", nome, cognome, telefono, tipo.toString(), chiamate);
    }

    public String stampaChiamate() {
        return String.format("Nome: %s Cognome: %s Tipo: %s", nome, cognome, tipo.toString());
    }
}