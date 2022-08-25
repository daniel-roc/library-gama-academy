import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String rg;
    private String endereco;
    private String senha;
    
    private ArrayList<Integer> listaCodigosExemplares = new ArrayList<Integer>(); //talvez usar um map para linkar usuario + codigo ?
    
    private ArrayList<String> listaLivrosComprados = new ArrayList<String>();
    
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

	public ArrayList<Integer> getListaCodigosExemplares() {
        return listaCodigosExemplares;
    }

    public void setListaCodigosExemplares(ArrayList<Integer> listaCodigosExemplares) {
        this.listaCodigosExemplares = listaCodigosExemplares;
    }
    
    public ArrayList<String> getListaLivrosComprados() {
		return listaLivrosComprados;
	}

	public void setListaLivrosComprados(ArrayList<String> listaLivrosComprados) {
		this.listaLivrosComprados = listaLivrosComprados;
	}


    public void associarUsuarioComExemplar(Exemplar exemplar){
//        exemplarEmprestado++;
        listaCodigosExemplares.add(exemplar.getCodigo());
    }

    public void desassociarUsuarioComExemplar(Exemplar exemplar){
        if(listaCodigosExemplares.contains(exemplar.getCodigo())){
            listaCodigosExemplares.remove(listaCodigosExemplares.indexOf(exemplar.getCodigo()));
            System.out.println("Exemplar devolvido com sucesso");
        }else{
            System.out.println("Esse usuario não está com esse exemplar");
        }
    }
    
    public String comprarLivro(Livro livro, boolean pagamentoAprovado) {
    	if (pagamentoAprovado) {
    		this.listaLivrosComprados.add(livro.toString());
    		return "Livro comprado com sucesso!";
		}
    	return "Compra não aprovada!";
    }


//        listaCodigosExemplares.contains(listaExemplar.get(i).getCodigo());
//        for (Exemplar exemplarPesquisa : listaExemplar) {
//            for(int i = 0; i <listaExemplar.size(); i++) {
//                for (int j = 0; j < listaExemplar.size(); j++) {
//                    if (lista.getCodigo(i) == user.getListaCodigosExemplares().get(j)) {
//                        return true;
//                    }
//                }
//            }
//        }

}