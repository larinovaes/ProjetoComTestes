package zup.com.br.vendedor;

public class Vendedor {
    private String nome;
    private String cpf;
    private String email;


    public Vendedor(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        StringBuilder dados = new StringBuilder();
        dados.append("============= VENDEDOR ================ ");
        dados.append("\n Nome: " + nome);
        dados.append("\n CPF: " + cpf);
        dados.append("\n Email: " + email);
        return dados.toString();
    }
}
