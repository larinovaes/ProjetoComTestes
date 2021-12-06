package zup.com.br.venda;

import zup.com.br.cliente.Cliente;
import zup.com.br.vendedor.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class ServicoVenda {

    private static List<Venda> vendas = new ArrayList<>();

    public ServicoVenda() {

    }

    public static Venda cadastrarVendas(Cliente nomeDoCliente, Vendedor vendedor, String dataDeRegistro, double valorAserPago) {
        Venda venda = new Venda(nomeDoCliente, vendedor, dataDeRegistro, valorAserPago);
        vendas.add(venda);
        return venda;
    }

    public static List<Venda> exibirVendas() {
        for (Venda vendaReferencia : vendas) {
            System.out.println(vendaReferencia);
        }
        return vendas;
    }

    public static List<Venda> pesquisarCompraDeClienteEspecifico(String cpf) throws Exception {
        List<Venda> comprasDoCliente = new ArrayList<>();
        for (Venda vendaReferencia : vendas) {
            if (vendaReferencia.getCliente().getCpf().equals(cpf)) {
                comprasDoCliente.add(vendaReferencia);
            }
        }
        if (comprasDoCliente.size() == 0) {
            throw new Exception("Este cliente não possui nenhuma compra ou não está cadastado.");
        }
        return comprasDoCliente;
    }

    public static List<Venda> pesquisarVendaDeVendedorEspecifico(String email) throws Exception {
        List<Venda> vendasDoVendedor = new ArrayList<>();
        for (Venda vendaReferencia : vendas) {
            if (vendaReferencia.getVendedorResponsavel().getEmail().equalsIgnoreCase(email)) {
                vendasDoVendedor.add(vendaReferencia);
            }
        }
        if (vendasDoVendedor.size() == 0) {
            throw new Exception("Este vendedor não possui nenhuma venda ou não está cadastado.");
        }
        return vendasDoVendedor;
    }
}
