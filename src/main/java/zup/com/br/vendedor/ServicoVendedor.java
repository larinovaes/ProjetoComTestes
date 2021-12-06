package zup.com.br.vendedor;

import java.util.ArrayList;
import java.util.List;

public class ServicoVendedor {
    private static List<Vendedor> vendedores = new ArrayList<>();

    public ServicoVendedor() {

    }

    public static Vendedor cadastrarVendedor(String nome, String cpf, String email) {
        Vendedor vendedor = new Vendedor(nome, cpf, email);
        vendedores.add(vendedor);
        return vendedor;
    }

    public static List<Vendedor> exibirVendedores() {
        for (Vendedor vendedorReferencia : vendedores) {
            System.out.println(vendedorReferencia);
        }
        return vendedores;
    }

    public static void verificarEmail(String email) throws Exception {
        for (Vendedor vendedorReferencia : vendedores) {
            if (vendedorReferencia.getEmail().equalsIgnoreCase(email)) {
                throw new Exception("Este e-mail já está cadastrado. Por favor faça o cadastro novamente! ");
            }
        }
    }

    public static Vendedor pesquisarVendedorParaAdicionarNaVenda(String nome) throws Exception {

        for (Vendedor vendedorReferencia : vendedores) {
            if (vendedorReferencia.getNome().equalsIgnoreCase(nome)) {
                return vendedorReferencia;
            }
        }
        throw new Exception("Este vendedor não está cadastrado.");
    }

    public static void verificarCPF(String cpf) throws Exception {
        for (Vendedor cpfReferencia : vendedores) {
            if (cpfReferencia.getCpf().equals(cpf)) {
                throw new Exception("Este CPF já está cadastrado. Por favor faça o cadastro novamente! ");
            }
        }
    }
}

