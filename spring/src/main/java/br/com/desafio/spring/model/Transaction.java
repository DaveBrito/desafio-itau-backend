package br.com.desafio.spring.model;
import java.time.OffsetDateTime;

public class Transaction {

    // Atributos da classe Transaction
    private double valor;
    private OffsetDateTime dataHora;

    // Construtor padrão de inicialização de valores
    public Transaction(final double valor,final OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }
    // Construtor padrão de inicialização de valores
    public double getValor() {
        return valor;
    }
    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
