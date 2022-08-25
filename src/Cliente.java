import java.util.ArrayList;

public class Cliente {

	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private String rg;
	private String endereco;
	private String senha;
	private ArrayList<String> listaLivrosComprados = new ArrayList<String>();
	private ArrayList<String> listaLivrosEmprestados = new ArrayList<String>();

	public Cliente(String nome, String email, String telefone, String cpf, String rg, String endereco, String senha) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ArrayList<String> getListaLivrosComprados() {
		return listaLivrosComprados;
	}

	public void setListaLivrosComprados(ArrayList<String> listaLivrosComprados) {
		this.listaLivrosComprados = listaLivrosComprados;
	}

	public ArrayList<String> getListaLivrosEmprestados() {
		return listaLivrosEmprestados;
	}

	public void setListaLivrosEmprestados(ArrayList<String> listaLivrosEmprestados) {
		this.listaLivrosEmprestados = listaLivrosEmprestados;
	}

	public String comprarLivro(Livro livro, boolean pagamentoAprovado) {
		if (pagamentoAprovado) {
			this.listaLivrosComprados.add(livro.toString());
			return "Livro comprado com sucesso!";
		}
		return "Compra não aprovada!";
	}

	public String realizarOuRenovarEmprestimo(Cliente cliente, Livro livro, boolean pagamentoAprovado) {

		var emprestimo = new Emprestimo(cliente, livro);

		if (pagamentoAprovado) {
			if (emprestimo.livroJaEmprestado(cliente, livro) == false) {
				emprestimo.confirmarEmprestimo(cliente, livro);
				this.listaLivrosEmprestados.add(livro.toString());
				return "Livro emprestado com sucesso! Data de término: " + emprestimo.getDataPrevistaDeDevolucao();
			} else if (emprestimo.livroJaEmprestado(cliente, livro) == true) {
				emprestimo.confirmarEmprestimo(cliente, livro);
				return "Empréstimo renovado com sucesso! Nova data de término: "
						+ emprestimo.getDataPrevistaDeDevolucao();
			}
		}
		return "Pagamento não aprovado!";
	}
}