package br.com.desafio.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import br.com.desafio.spring.dto.TransactionRequest;
import br.com.desafio.spring.service.TransactionService;
import br.com.desafio.spring.model.Transaction;
import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
    
    private final TransactionService transactionService;

    // Injeção de dependência do TransactionService
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Método de POST para adicionar uma transação
    @PostMapping
    public ResponseEntity<Void> createTransaction(@Validated @RequestBody TransactionRequest transactionRequest) {
        if (transactionRequest.getDataHora().isAfter(OffsetDateTime.now()) || transactionRequest.getValor() <= 0) {
            return ResponseEntity.unprocessableEntity().build();
        }
        // Cria um objeto Transaction e o adiciona
        Transaction transaction = new Transaction(transactionRequest.getValor(), transactionRequest.getDataHora());
        transactionService.addTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}