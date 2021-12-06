package zup.com.br;

public class Main {
    public static void main(String[] args) {

        boolean menuDeRepeticao = true;

        while (menuDeRepeticao) {
            try {
                menuDeRepeticao = Sistema.executarSistem();
            } catch (Exception mensagemDeErro) {
                System.out.println(mensagemDeErro.getMessage());
            }
        }
    }
}
