package br.com.alura.conversormoedas.conversao;

import java.time.LocalDateTime;

public class ConversaoRealizada {
    private String origem;
    private String destino;
    private double valorOriginal;
    private double valorConvertido;
    private LocalDateTime momento;

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    public ConversaoRealizada(String origem, String destino, double valorOriginal, double valorConvertido, LocalDateTime momento) {
        this.origem = origem;
        this.destino = destino;
        this.valorOriginal = valorOriginal;
        this.valorConvertido = valorConvertido;
        this.momento = momento;
    }

    @Override
    public String toString() {
        return "Conversão de " + origem + " para " + destino + ": " + valorOriginal + " = " + valorConvertido + " em " + momento;
    }
}
