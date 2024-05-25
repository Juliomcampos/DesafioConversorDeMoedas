package br.com.alura.conversormoedas.principal;
import br.com.alura.conversormoedas.conversao.Conversao;
import br.com.alura.conversormoedas.conversao.ConversaoRealizada;
import br.com.alura.conversormoedas.historico.HistoricoConversoes;
import br.com.alura.conversormoedas.moedas.Moedas;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        List<ConversaoRealizada> conversoes = new ArrayList<>();
        HistoricoConversoes historico = new HistoricoConversoes(conversoes);
        Scanner scanner = new Scanner(System.in);

        String[] opcoes = {"USD para BRL", "BRL para USD", "EUR para BRL", "BRL para EUR", "GBP para BRL", "BRL para GBP"};

        boolean continuar = true;
        while (continuar) {
            try {
                System.out.println("Escolha a conversão desejada:");
                for (int i = 0; i < opcoes.length; i++) {
                    System.out.println((i + 1) + ". " + opcoes[i]);
                }

                int escolha = scanner.nextInt();
                scanner.nextLine();
                String daMoeda;
                String paraMoeda;

                switch (escolha) {
                    case 1:
                        daMoeda = Moedas.USD;
                        paraMoeda = Moedas.BRL;
                        break;
                    case 2:
                        daMoeda = Moedas.BRL;
                        paraMoeda = Moedas.USD;
                        break;
                    case 3:
                        daMoeda = Moedas.EUR;
                        paraMoeda = Moedas.BRL;
                        break;
                    case 4:
                        daMoeda = Moedas.BRL;
                        paraMoeda = Moedas.EUR;
                        break;
                    case 5:
                        daMoeda = Moedas.GBP;
                        paraMoeda = Moedas.BRL;
                        break;
                    case 6:
                        daMoeda = Moedas.BRL;
                        paraMoeda = Moedas.GBP;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        continue;
                }

                System.out.println("Digite o valor a ser convertido:");
                String input = scanner.nextLine().replace(",", ".");
                double valor = Double.parseDouble(input);

                double taxa = Conversao.obterTaxaConversao(daMoeda, paraMoeda);
                double resultado = Conversao.calcularConversao(valor, taxa);

                System.out.println("Valor convertido: " + resultado);

                // Registra a conversão no histórico
                historico.adicionarConversao(new ConversaoRealizada(daMoeda, paraMoeda, valor, resultado, LocalDateTime.now()));

                // Pergunta ao usuário se deseja continuar
                System.out.println("Deseja realizar outra conversão? (S/N)");
                String resposta = scanner.nextLine();
                if (!resposta.equalsIgnoreCase("S")) {
                    continuar = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Não digite '.' para separar os números.");
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao fazer a requisição HTTP: " + e.getMessage());
            }
        }

        // Exibe o histórico de conversões ao final
        historico.exibirHistorico();
        historico.salvarHistorico("historico.txt");
    }
}
