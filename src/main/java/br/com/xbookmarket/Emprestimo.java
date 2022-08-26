package br.com.xbookmarket;
import java.time.LocalDateTime;

public class Emprestimo {
	
	private Cliente cliente;
    private Livro livro;
	private LocalDateTime dataDeEmprestimo;
    private LocalDateTime dataPrevistaDeDevolucao;
    private LocalDateTime dataDeEntregaReal;
    private int duracaoEmprestimo = 15;

    public Emprestimo(Cliente cliente, Livro livro) {
    	this.cliente = cliente;
        this.livro = livro;
    }

    public LocalDateTime getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    public void setDataDeEmprestimo(LocalDateTime dataDeEmprestimo) {
        this.dataDeEmprestimo = dataDeEmprestimo;
    }

    public LocalDateTime getDataPrevistaDeDevolucao() {
        return dataPrevistaDeDevolucao;
    }

    public void setDataPrevistaDeDevolucao(LocalDateTime dataPrevistaDeDevolucao) {
        this.dataPrevistaDeDevolucao = dataPrevistaDeDevolucao;
    }

    public LocalDateTime getDataDeEntregaReal() {
        return dataDeEntregaReal;
    }

    public void setDataDeEntregaReal(LocalDateTime dataDeEntregaReal) {
        this.dataDeEntregaReal = dataDeEntregaReal;
    }

    public int getDuracaoEmprestimo() {
        return duracaoEmprestimo;
    }

    public void setDuracaoEmprestimo(int duracaoEmprestimo) {
        this.duracaoEmprestimo = duracaoEmprestimo;
    }

    public boolean livroJaEmprestado(Cliente cliente, Livro livro){
        if(cliente.getListaLivrosEmprestados().contains(livro.toString())){
            return true;
        }
        return false;
    }

    public void gerarDatasEmprestimo(LocalDateTime data) {
        //setar data atual
        setDataDeEmprestimo(data);

        //gerar duracao do emprestimo e adicionar na data
        data = data.plusDays(getDuracaoEmprestimo());

        //setar data de devolucao
        setDataPrevistaDeDevolucao(data);
    }

    public void confirmarEmprestimo(Cliente cliente, Livro livro) {
        LocalDateTime dataEmprestimo = LocalDateTime.now();
        gerarDatasEmprestimo(dataEmprestimo);
    }

    public void emprestimoDevolvido(LocalDateTime data) {
        setDataDeEntregaReal(data);
    }

}