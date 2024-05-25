package br.com.alura.conversormoedas.historico;

import br.com.alura.conversormoedas.conversao.ConversaoRealizada;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HistoricoConversoes {
    private final List<ConversaoRealizada> conversoes;

    public HistoricoConversoes(List<ConversaoRealizada> conversoes) {
        this.conversoes = conversoes;
    }

    public void adicionarConversao(ConversaoRealizada conversao) {
        conversoes.add(conversao);
    }

    public void exibirHistorico() {
        if (conversoes.isEmpty()) {
            System.out.println("Nenhuma conversão registrada.");
            return;
        }

        System.out.println("Histórico de Conversões:");
        for (ConversaoRealizada conversao : conversoes) {
            System.out.println(conversao);
        }
    }

    public void salvarHistorico(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            writer.println("Histórico de Conversões:");
            for (ConversaoRealizada conversao : conversoes) {
                writer.println("Origem: " + conversao.getOrigem());
                writer.println("Destino: " + conversao.getDestino());
                writer.println("Valor Original: " + conversao.getValorOriginal());
                writer.println("Valor Convertido: " + conversao.getValorConvertido());
                writer.println("Data e Hora: " + conversao.getMomento().format(formatter));
                writer.println();
            }

            System.out.println("Histórico salvo com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o histórico: " + e.getMessage());
        }
    }
}
