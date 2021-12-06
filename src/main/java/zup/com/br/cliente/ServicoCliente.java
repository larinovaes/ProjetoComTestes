package zup.com.br.cliente;

import java.util.ArrayList;
import java.util.List;

public class ServicoCliente {
    private static List<Cliente> clientes = new ArrayList<>();

    public ServicoCliente() {

    }

    public static Cliente cadastrarCliente(String nome, String cpf, String email) {
        Cliente cliente = new Cliente(nome, cpf, email);
        clientes.add(cliente);
        return cliente;
    }

    public static List<Cliente> exibirClientes() {
        for (Cliente clienteReferencia : clientes) {
            System.out.println(clienteReferencia);
        }
        return clientes;
    }

    public static void validarEmail(String email) throws Exception {
        if (!email.contains("@") | !email.contains(".com")) {
            throw new Exception("E-mail inválido. ");
        }
    }

    public static void verificarEmail(String email) throws Exception {
        for (Cliente clienteReferencia : clientes) {
            if (clienteReferencia.getEmail().equals(email)) {
                throw new Exception("Este e-mail já está cadastrado. Por favor faça o cadastro novamente! ");
            }
        }
    }

    public static void verificarCPF(String cpf) throws Exception {
        for (Cliente cpfReferencia : clientes) {
            if (cpfReferencia.getCpf().equals(cpf)) {
                throw new Exception("Este CPF já está cadastrado. Por favor faça o cadastro novamente! ");
            }
        }
    }

    public static Cliente pesquisarClienteParaAdicionarAVenda(String nome) throws Exception {

        for (Cliente clienteReferencia : clientes) {
            if (clienteReferencia.getNome().equalsIgnoreCase(nome)) {
                return clienteReferencia;
            }
        }
        throw new Exception("Este cliente não está cadastrado.");
    }
}
