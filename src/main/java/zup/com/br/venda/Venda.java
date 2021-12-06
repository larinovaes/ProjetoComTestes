package zup.com.br.venda;

import zup.com.br.cliente.Cliente;
import zup.com.br.vendedor.Vendedor;

public class Venda {
    private Cliente cliente;
    private Vendedor vendedorResponsavel;
    private String dataDeRegistro;
    private double valorAserPago;


    public Venda(Cliente cliente, Vendedor vendedorResponsavel, String dataDeRegistro, double valorAserPago) {
        this.cliente = cliente;
        this.vendedorResponsavel = vendedorResponsavel;
        this.dataDeRegistro = dataDeRegistro;
        this.valorAserPago = valorAserPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedorResponsavel() {
        return vendedorResponsavel;
    }

    @Override
    public String toString() {
        StringBuilder dados = new StringBuilder();
        dados.append("\n============= VENDAS ================ ");
        dados.append("\n Cliente: " + cliente.getNome());
        dados.append("\n Vendedor: " + vendedorResponsavel.getNome());
        dados.append("\n Valor a pagar: R$" + valorAserPago);
        dados.append("\n Data de registro: " + dataDeRegistro);
        return dados.toString();
    }
}
