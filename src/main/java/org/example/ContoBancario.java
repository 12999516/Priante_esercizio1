package org.example;

public class ContoBancario {
    private double saldo;

    public ContoBancario(double saldoIniziale) {
        if (saldoIniziale < 0) {
            throw new ImportoNonValidoException("Il saldo iniziale non può essere negativo.");
        }
        this.saldo = saldoIniziale;
    }

    public double getSaldo() {
        return saldo;
    }

    public void preleva(double importo) throws SaldoInsufficienteException {
        if (importo <= 0) {
            throw new ImportoNonValidoException(
                    "L'importo da prelevare deve essere maggiore di zero. Valore inserito: " + importo + "€"
            );
        }

        if (importo > saldo) {
            throw new SaldoInsufficienteException(
                    "Operazione negata: fondi insufficienti.",
                    this.saldo,
                    importo
            );
        }

        this.saldo -= importo;
        System.out.printf("Prelievo di %.2f€ completato con successo. Nuovo saldo: %.2f€%n", importo, this.saldo);
    }
}