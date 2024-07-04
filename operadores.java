public class Operadores { // Public: pode ser acessada por fora, outras classes podem acessar
    // class declara um novo objeto  por exemplo nome : Operadores
    // {  } as chaves são para abrir um bloco de códigos 
    public static void main(String[] args) throws Exception {
        //static pertence a classe
        // void não retorna nem um valor
        //throws exception é utilizado para declarar um  ou mais metodos
    
        System.out.println("Operador de atribuição: =");
        // system.out é uma classe de entrada e saida // println serve para imprimir o valor  no terminal e pula 1 linha

        String texto = "Texto";
        //String é uma classe para manipular somente textos e declara uma variavel e texto nome da variavel = aperador de atribuição 
        // "" oque tiver dentro é String
        //; Fecha linha de código

    
        System.out.println("String texto = \"Texto\";");
        System.out.println(texto);
        // \  Barra invertida e aspas serve para poder imprimir as aspas

        System.out.println("Operador de soma: +");
        // () parenteses invoca um metodo
        int soma = 1 + 1;
        // = operador de atribuição
        System.out.println("int soma = 1 + 1;");
        System.out.println(soma);

        System.out.println("Operador de subtração: -");
        int subtracao = 1 - 1;
        System.out.println("int subtracao = 1 - 1;");
        System.out.println(subtracao);

        System.out.println("Operador de divisão: /");
        int divisao = 1 / 1;
        System.out.println("int divisao = 1 / 1;");
        System.out.println(divisao);

        System.out.println("Operador de multiplicação: *");
        int multiplicacao = 1 * 1;
        System.out.println("int multiplicacao = 1 * 1;");
        System.out.println(multiplicacao);

        System.out.println("Operador de concatenação de strings: +");
        String concatenacao = "Texto 1 + " + "Texto 2";
        // + operador de concatenação
        System.out.println("String concatenacao = \"Texto 1 + \" + \"Texto 2\";");
        System.out.println(concatenacao);
    }
}