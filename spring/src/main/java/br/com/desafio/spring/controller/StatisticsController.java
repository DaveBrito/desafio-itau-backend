package br.com.desafio.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.DoubleSummaryStatistics;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.desafio.spring.service.TransactionService;
import br.com.desafio.spring.dto.StatisticsResponse; 


@RestController 
@RequestMapping("/estatistica")
public class StatisticsController {
    // Atributo para armazenar o serviço de transações
    private final TransactionService transactionService;

    // Injeção de dependência do TransactionService
    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Método de GET para obter as estatísticas
    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics() {
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticsResponse(stats));
    }
    
}
