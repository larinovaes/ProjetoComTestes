package testes;

import org.junit.Assert;
import org.junit.Test;
import zup.com.br.Sistema;
import zup.com.br.cliente.ServicoCliente;
import zup.com.br.venda.ServicoVenda;
import zup.com.br.venda.Venda;
import zup.com.br.vendedor.ServicoVendedor;

import java.util.List;

public class VendaTeste {

    @Test
    public void testarCadastrarVenda() {
        Venda resultado =
       ServicoVenda.cadastrarVendas(
       ServicoCliente.cadastrarCliente("Joao","782.118.236-54", "joao@gamil.com")
       , ServicoVendedor.cadastrarVendedor("Miguel", "293.275.439-84","miguel@gmail.com")
      , "12/03/2018", 290);
    }

    @Test
    public void testarExibirVendas() {
        List<Venda> resultado = ServicoVenda.exibirVendas();
    }

    @Test
    public void testarPesquisaDeCompraDeClienteEspecificoPorCPF() {
        Assert.assertThrows(Exception.class, () ->
          ServicoVenda.pesquisarCompraDeClienteEspecifico("782.118.236-54"));
    }

    @Test
    public void testarPesquisaDeVendaDeVendedorEspecificoPorEmail() {
        Assert.assertThrows(Exception.class, () ->
          ServicoVenda.pesquisarVendaDeVendedorEspecifico("miguel@gmail.com"));
    }

    @Test
    public void testarCadastroDeVendaNoSistema() {
     Assert.assertThrows(Exception.class, () -> Sistema.cadastrarVendas());
    }
}
