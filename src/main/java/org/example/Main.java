package org.example;

public class Main {
    public static void main(String[] args) {
        ContoBancario conto = new ContoBancario(500.00);
        System.out.printf("aperto conto con questo saldo" + conto.getSaldo());

        System.out.println("--- SCENARIO 1: Prelievo eccessivo ---");
        try {
            conto.preleva(750.00);
        } catch (SaldoInsufficienteException e) {
            System.out.println("errore " + e.getMessage());
            System.out.printf("hai questo saldo" + e.getSaldoAttuale() + "hai chiesto questo movimento" + e.getImportoRichiesto());
            System.out.printf("in rosso di", e.getDeficit());
        } finally {
            System.out.printf("entrato nel finally conto " + conto.getSaldo());
        }

        System.out.println("prelievo negativo");
        try {
            conto.preleva(-50.00);
        } catch (ImportoNonValidoException e) {
            System.out.println("errore quando si valuta " + e.getMessage());
        } catch (SaldoInsufficienteException e) {
            System.out.println("errore " + e.getMessage());
        }
        System.out.println();

        System.out.println("prelievo");
        try {
            conto.preleva(200.00);
        } catch (SaldoInsufficienteException e) {
            System.out.println("errore " + e.getMessage());
        }
    }
}