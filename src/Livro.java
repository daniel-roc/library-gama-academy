
public class Livro {

    private String titulo;
    private Autor autor;
    private String ano;
    private int edicao;
    private String editora;
    private String ISBN;
    private double precoCompra;
    private double precoEmprestimo;

	public Livro(String titulo, Autor autor, String ano, int edicao, String editora, String iSBN, double precoCompra, double precoEmprestimo) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.edicao = edicao;
        this.editora = editora;
        ISBN = iSBN;
        this.precoCompra = precoCompra;
        this.precoEmprestimo = precoEmprestimo;
    }
	
    @Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", ano=" + ano + ", edicao=" + edicao + ", editora="
				+ editora + ", ISBN=" + ISBN + "]";
	}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor.getNome();
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}
	
	public double getPrecoEmprestimo() {
		return precoEmprestimo;
	}

	public void setPrecoEmprestimo(double precoEmprestimo) {
		this.precoEmprestimo = precoEmprestimo;
	}

}
