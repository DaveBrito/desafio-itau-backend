package br.com.desafio.spring.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import br.com.desafio.spring.model.Transaction;


@Service
public class TransactionService {
    
    //Atributo para armazenar as transações em fila
    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    //Método para adicionar uma transação
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    
    //Método para obter as estatísticas das transações
    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream()
                .filter(transaction -> transaction.getDataHora().isAfter(now.minusMinutes(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }

    //Limpeza da fila de transações
    public void clearTransactions() {
        transactions.clear();
    }

}
