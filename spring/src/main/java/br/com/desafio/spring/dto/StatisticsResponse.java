package br.com.desafio.spring.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsResponse {
    //Estatística
    //Criação de variaveis para armazenar os valores de cada atributo
    private long count;
    private double sum;
    private double min;
    private double max;
    private double avg;

    //Construtor de inicialização recebendo o DoubleSummaryStatistics como parâmetro
    public StatisticsResponse(DoubleSummaryStatistics statistics) {
        this.count = statistics.getCount();
        this.sum = statistics.getSum();
        this.min = statistics.getMin();
        this.max = statistics.getMax();
        this.avg = statistics.getAverage();
    }
    //Getters
    public long getCount() {
        return count;
    }
    public double getAvg() {
        return avg;
    }
    public double getMax() {
        return max;
    }
    public double getMin() {
        return min;
    }
    public double getSum() {
        return sum;
    }

}
