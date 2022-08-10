
public class Exemplar {

    private int codigo;
    private boolean cativo;
    private boolean emprestada;
    private Livro livro;
    private Autor autor;

    public Exemplar(int codigo, boolean cativa, boolean emprestada, Livro livro, Autor autor) {
        this.codigo = codigo;
        this.cativo = cativa;
        this.emprestada = emprestada;
        this.livro = livro;
        this.autor = autor;

        livro.adicionarExemplar(1);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isCativa() {
        return cativo;
    }

    public void setCativa(boolean cativa) {
        this.cativo = cativa;
    }

    public boolean isEmprestada() {
        return emprestada;
    }

    public void setEmprestada(boolean emprestada) {
        this.emprestada = emprestada;
    }

    public String getLivro() {
        return livro.getTitulo();
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getAutor() {
        return autor.getNome();
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getQuantidadeDeExemplares() {
        return livro.getQuantidadeDeExemplares();
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "codigo=" + codigo +
                ", cativo=" + cativo +
                ", emprestada=" + emprestada +
                ", livro=" + livro +
                ", autor=" + autor +
                '}';
    }
}