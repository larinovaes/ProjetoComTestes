package testes;

import org.junit.Assert;
import org.junit.Test;
import zup.com.br.Sistema;
import zup.com.br.vendedor.ServicoVendedor;
import zup.com.br.vendedor.Vendedor;

import java.util.List;

public class VendedorTeste {

    @Test
    public void testarCadastrarVendedor() {
        Vendedor resultado = ServicoVendedor.cadastrarVendedor("joao", "8236475326","joao@gamcil.com");
    }

    @Test
    public void testarExibirVendedores() {
       List<Vendedor> resultado = ServicoVendedor.exibirVendedores();
    }

    @Test
    public void testarvalidacaoDeEmailDeVendedor() {
        Assert.assertThrows(Exception.class, () -> ServicoVendedor.verificarEmail("larissa@gmail.com"));
    }

    @Test
    public void testarPesquisaDeVendedorParaAdicionarNaVenda() {
        Assert.assertThrows(Exception.class, () ->
                ServicoVendedor.pesquisarVendedorParaAdicionarNaVenda("joao"));
    }

    @Test
     public void testarVerificacaoDeCPF() {
        Assert.assertThrows(Exception.class, () -> ServicoVendedor.verificarCPF("81234732712"));
    }


    @Test
    public void testarCadastrarVendedorNoSistema() {
        Assert.assertThrows(Exception.class, () -> Sistema.cadastrarVendedor());
    }

}
