# Conversor de Moedas

O Conversor de Moedas é um programa Java simples que permite aos usuários converter valores entre diferentes moedas. 
Ele utiliza a API de Taxas de Câmbio para obter as taxas de conversão em tempo real e fornece uma interface de linha de comando para interação com o usuário.

## Funcionalidades

- Conversão entre as seguintes moedas:
  - USD para BRL (Dólar Americano para Real Brasileiro)
  - BRL para USD (Real Brasileiro para Dólar Americano)
  - EUR para BRL (Euro para Real Brasileiro)
  - BRL para EUR (Real Brasileiro para Euro)
  - GBP para BRL (Libra Esterlina para Real Brasileiro)
  - BRL para GBP (Real Brasileiro para Libra Esterlina)
- Exibição do histórico de conversões realizadas.
- Salvar o histórico de conversões em um arquivo de texto.


## Exemplo de Uso

Suponha que você queira converter $100 (Dólares Americanos) para Real Brasileiro (BRL). Aqui está um exemplo de como você pode usar o programa:

1. Você executa o programa e escolhe a opção de conversão "USD para BRL".
2. O programa solicita que você digite o valor a ser convertido. Você digita `100` e pressiona Enter.
3. O programa calcula a conversão e exibe o resultado no console, por exemplo: `Valor convertido: 520.00`.
4. O programa pergunta se você deseja realizar outra conversão. Você pode optar por continuar ou encerrar o programa.
5. Após encerrar o programa, você pode verificar o arquivo `historico.txt` para ver o histórico de todas as conversões realizadas durante a execução.
