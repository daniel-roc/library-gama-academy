
public class Emprestimo {

    private String dataDeEmprestimo;
    private String dataPrevistaDeDevolucao;
    private String dataDeEntregaReal;
    private int situacao;

    public Emprestimo(String dataDeEmprestimo, String dataPrevistaDeDevolucao, String dataDeEntregaReal, int situacao) {
        super();
        this.dataDeEmprestimo = dataDeEmprestimo;
        this.dataPrevistaDeDevolucao = dataPrevistaDeDevolucao;
        this.dataDeEntregaReal = dataDeEntregaReal;
        this.situacao = situacao;
    }

    public String getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    public void setDataDeEmprestimo(String dataDeEmprestimo) {
        this.dataDeEmprestimo = dataDeEmprestimo;
    }

    public String getDataPrevistaDeDevolucao() {
        return dataPrevistaDeDevolucao;
    }

    public void setDataPrevistaDeDevolucao(String dataPrevistaDeDevolucao) {
        this.dataPrevistaDeDevolucao = dataPrevistaDeDevolucao;
    }

    public String getDataDeEntregaReal() {
        return dataDeEntregaReal;
    }

    public void setDataDeEntregaReal(String dataDeEntregaReal) {
        this.dataDeEntregaReal = dataDeEntregaReal;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public void realizarEmprestimo(Livro livro, Exemplar exemplar) {
        livro.setQuantidadeDeExemplares(livro.getQuantidadeDeExemplares() -1);
        exemplar.setCativa(false);
        exemplar.setEmprestada(true);
    }

    public void devolucaoDeEmprestimo(Livro livro, Exemplar exemplar, String dataDeEntregaReal) {
        livro.setQuantidadeDeExemplares(livro.getQuantidadeDeExemplares() +1);
        exemplar.setCativa(true);
        exemplar.setEmprestada(false);
        this.setDataDeEntregaReal(dataDeEntregaReal);
    }


}