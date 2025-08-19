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
                    3 - Real Brasileiro ==> Euro
                    4 - Euro ==> Real Brasileiro
                    5 - Real Brasileiro ==> Iene
                    6 - Iene ==> Real Brasileiro
                    
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();
            var json = "";

            switch (opcao) {
                case 1:
                    json = consumo.obterDados(ENDERECO + apiKey + "/pair/BRL/USD" );
                    converter(json);
                    break;
                case 2:
                    json = consumo.obterDados(ENDERECO + apiKey + "/pair/USD/BRL" );
                    converter(json);
                    break;
                case 3:
                    json = consumo.obterDados(ENDERECO + apiKey + "/pair/BRL/EUR" );
                    converter(json);
                    break;
                case 4:
                    json = consumo.obterDados(ENDERECO + apiKey + "/pair/EUR/BRL" );
                    converter(json);
                    break;
                case 5:
                    json = consumo.obterDados(ENDERECO + apiKey + "/pair/BRL/JPY" );
                    converter(json);
                    break;
                case 6:
                    json = consumo.obterDados(ENDERECO + apiKey + "/pair/JPY/BRL" );
                    converter(json);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public void leituraExibValor(Conversao conversao){
        System.out.println(conversao);
        var texto = "\nDigite o valor que deseja converter: (obs: separe decimais com vírgula ,)";

        System.out.println(texto);
        var valor = leitura.nextDouble();
        leitura.nextLine();
        var resultado = calcularTaxa(valor, conversao.getTaxaConv());
        texto = "\n\nValor " + valor + " [" + conversao.getCodBase() + "] " + " Corresponde ao valor de ==> " + resultado + " [" + conversao.getCodAlvo() + "] \n\n";
        System.out.println(texto);
    }

    public Double calcularTaxa (Double valor, Double taxa){
        return valor * taxa;
    }

    public void converter (String json){
        ConversaoER conversaoER = converteDados.converterDados(json, ConversaoER.class);
        Conversao conversao = new Conversao(conversaoER);
        //                System.out.println(conversao);
        leituraExibValor(conversao);
    }

}
