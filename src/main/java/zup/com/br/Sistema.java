package zup.com.br;

import zup.com.br.cliente.Cliente;
import zup.com.br.cliente.ServicoCliente;
import zup.com.br.venda.ServicoVenda;
import zup.com.br.venda.Venda;
import zup.com.br.vendedor.ServicoVendedor;
import zup.com.br.vendedor.Vendedor;

import java.util.Scanner;

public class Sistema {
    public static Scanner dadosUsarios(String mensagem) {
        System.out.println(mensagem);
        return new Scanner(System.in);
    }

    public static Cliente cadastrarCliente() throws Exception {
        String nome = dadosUsarios("Digite o nome do cliente: ").nextLine();
        String cpf = dadosUsarios("Digite o CPF do cliente: ").nextLine();
        String email = dadosUsarios("Digite o E-mail do cliente: ").nextLine();
        ServicoCliente.verificarCPF(cpf);
        ServicoCliente.validarEmail(email);
        ServicoCliente.verificarEmail(email);
        return ServicoCliente.cadastrarCliente(nome, cpf, email);
    }

    public static Vendedor cadastrarVendedor() throws Exception {
        String nome = dadosUsarios("Digite o nome do vendedor: ").nextLine();
        String cpf = dadosUsarios("Digite o CPF do vendedor: ").nextLine();
        String email = dadosUsarios("Digite o E-mail do vendedor: ").nextLine();
        ServicoVendedor.verificarCPF(cpf);
        ServicoCliente.validarEmail(email);
        ServicoVendedor.verificarEmail(email);
        return ServicoVendedor.cadastrarVendedor(nome, cpf, email);
    }

    public static Venda cadastrarVendas() throws Exception {
        String nomeDeVendedor = dadosUsarios("Digite o nome do vendedor: ").nextLine();
        String nomeDoCliente = dadosUsarios("Digite o nome do cliente: ").nextLine();
        String dataDeRegistro = dadosUsarios("Digite a data que a compra foi efetuada: ").nextLine();
        double valorAserPago = dadosUsarios("Digite o valor a ser pago: ").nextDouble();
        Vendedor vendedor = ServicoVendedor.pesquisarVendedorParaAdicionarNaVenda(nomeDeVendedor);
        Cliente cliente = ServicoCliente.pesquisarClienteParaAdicionarAVenda(nomeDoCliente);
        return ServicoVenda.cadastrarVendas(cliente, vendedor, dataDeRegistro, valorAserPago);
    }

    public static void pesquisarCompraDeCliente() throws Exception {
        String cpf = dadosUsarios("Digite o CPF do cliente: ").nextLine();
        System.out.println(ServicoVenda.pesquisarCompraDeClienteEspecifico(cpf));
    }

    public static void pesquisarVendaDeVendedor() throws Exception {
        String email = dadosUsarios("Digite o E-mail do vendedor: ").nextLine();
        System.out.println(ServicoVenda.pesquisarVendaDeVendedorEspecifico(email));
    }

    public static void menu() {
        System.out.println("================ REGISTRO DE VENDAS SANTA LUCIA ==================");
        System.out.println("Digite [1] para cadastrar um vendedor: ");
        System.out.println("Digite [2] para cadastrar um cliente: ");
        System.out.println("Digite [3] para cadastrar venda: ");
        System.out.println("Digite [4] para ver todos os vendedores cadastrados: ");
        System.out.println("Digite [5] para ver todos os clientes cadastrados: ");
        System.out.println("Digite [6] para ver todas as vendas: ");
        System.out.println("Digite [7] para pesquisar vendas de vendedores específicos: ");
        System.out.println("Digite [8] para pesquisar por compras de clientes específicos: ");
        System.out.println("Digite [9] para sair do programa: ");
    }

    public static boolean executarSistem() throws Exception {

        boolean repeticao = true;

        while (repeticao) {
            menu();
            int opcoesDeMenu = dadosUsarios("Digite sua opção:").nextInt();

            if (opcoesDeMenu == 1) {
                cadastrarVendedor();
            } else if (opcoesDeMenu == 2) {
                cadastrarCliente();
            } else if (opcoesDeMenu == 3) {
                cadastrarVendas();
            } else if (opcoesDeMenu == 4) {
                ServicoVendedor.exibirVendedores();
            } else if (opcoesDeMenu == 5) {
                ServicoCliente.exibirClientes();
            } else if (opcoesDeMenu == 6) {
                ServicoVenda.exibirVendas();
            } else if (opcoesDeMenu == 7) {
                pesquisarVendaDeVendedor();
            } else if (opcoesDeMenu == 8) {
                pesquisarCompraDeCliente();
            } else if (opcoesDeMenu == 9) {
                System.out.println("Você saiu do programa.");
                repeticao = false;
            } else {
                System.out.println("Digite um valor válido.");
            }
        }
        return repeticao;
    }
}
