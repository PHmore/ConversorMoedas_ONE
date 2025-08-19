package br.com.conversor.principal;

import br.com.conversor.model.Conversao;
import br.com.conversor.model.ConversaoER;
import br.com.conversor.service.ConsumoApi;
import br.com.conversor.service.ConverteDados;

import java.util.Scanner;

public class Principal {

    private ConverteDados converteDados = new ConverteDados();

private ConsumoApi consumo = new ConsumoApi();

private Scanner leitura = new Scanner(System.in);

private  String apiKey = System.getenv("APIKEY");

private String ENDERECO = "https://v6.exchangerate-api.com/v6/";

public void exibeMenu(){
    var opcao = -1;
    while (opcao != 0) {
        var menu = """
                    Conversor de Moedas
                    
                    1 - Real Brasileiro ==> Dólar
                    2 - Dólar ==> Real Brasileiro
                    3 - 
                    4 - 
                    5 - 
                    6 - 
                    
                    0 - Sair                                 
                    """;

        System.out.println(menu);
        opcao = leitura.nextInt();
        leitura.nextLine();

        switch (opcao) {
            case 1:
                consumo.obterDados(ENDERECO + apiKey + "/pair/USD/BRL" );
                break;
            case 2:
                var json = consumo.obterDados(ENDERECO + apiKey + "/pair/USD/BRL" );
                System.out.println(json);
                ConversaoER conversaoER = converteDados.converterDados(json, ConversaoER.class);
                Conversao conversao = new Conversao(conversaoER);
                System.out.println(conversao);

                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 0:
                System.out.println("Saindo...");
                break;

            default:
                System.out.println("Opção inválida");
        }
    }
}

    public void leituraExibValor(float taxaConver,
                                 String antes,
                                 String depois){
        var texto = "Digite o valor que deseja converter";
        System.out.println(texto);
        var valor = leitura.nextFloat();
        leitura.nextLine();

        texto = "Valor " + valor + antes + " Corresponde ao valor de ==> " + valor * taxaConver + depois;
    }

}
