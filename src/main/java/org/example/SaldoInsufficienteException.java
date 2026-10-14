package org.example;

public class SaldoInsufficienteException extends Exception {
    private final double saldoAttuale;
    private final double importoRichiesto;

    public SaldoInsufficienteException(String messaggio, double saldoAttuale, double importoRichiesto) {
        super(messaggio);
        this.saldoAttuale = saldoAttuale;
        this.importoRichiesto = importoRichiesto;
    }

    public double getSaldoAttuale() {
        return saldoAttuale;
    }

    public double getImportoRichiesto() {
        return importoRichiesto;
    }

    public double getDeficit() {
        return importoRichiesto - saldoAttuale;
    }
}