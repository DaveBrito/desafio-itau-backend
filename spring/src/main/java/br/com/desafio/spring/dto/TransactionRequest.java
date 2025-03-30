package br.com.desafio.spring.dto;


import java.time.OffsetDateTime;
import io.micrometer.common.lang.NonNull;

public class TransactionRequest {
    //Mesmas atribuições da classe model Transaction


    @NonNull 
    private Double valor;

    @NonNull
    private OffsetDateTime dataHora;



    public Double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
 
}

