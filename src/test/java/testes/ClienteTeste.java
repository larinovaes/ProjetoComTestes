package testes;

import org.junit.Assert;
import org.junit.Test;
import zup.com.br.cliente.Cliente;
import zup.com.br.cliente.ServicoCliente;
import zup.com.br.Sistema;

import java.util.List;

public class ClienteTeste {

    @Test
    public void testarValidacaoDeEmail() {
        Assert.assertThrows(Exception.class, () -> {
            ServicoCliente.validarEmail("miguel");
        });
    }

    @Test
    public void testarCadastroDeCliente() {
        Cliente resultado = ServicoCliente.cadastrarCliente("joao", "73256346", "Miguel@miguel.com");
        Assert.assertNotNull(resultado);
    }

    @Test
    public void testarPesquisarClienteParaAdiconarAvEnda() {
        Assert.assertThrows(Exception.class, () -> {
            ServicoCliente.pesquisarClienteParaAdicionarAVenda("Miguel");
        });
    }

  @Test
  public void testarexibirCliente() {
    List<Cliente> clientes = ServicoCliente.exibirClientes();
    Assert.assertNotNull(clientes);
  }

    @Test
    public void testarCadastroDeClienteComTodasAsValidacoes() {
        Assert.assertThrows(Exception.class, () -> { Sistema.cadastrarCliente();});
    }
}

