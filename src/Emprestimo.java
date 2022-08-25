import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Emprestimo {
	
	private Cliente cliente;
    private Livro livro;
	private LocalDateTime dataDeEmprestimo;
    private LocalDateTime dataPrevistaDeDevolucao;
    private LocalDateTime dataDeEntregaReal;
    private int duracaoEmprestimo = 15;

//    Exemplar exemplarEmprestado;

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

    //metodo para geração de datas no empréstimo - data atual e data de devolução
    public void gerarDatasEmprestimo(LocalDateTime data) {
        //setar data atual
        setDataDeEmprestimo(data);

        //gerar duracao do emprestimo e adicionar na data
        data = data.plusDays(getDuracaoEmprestimo());

        //setar data de devolucao
        setDataPrevistaDeDevolucao(data);
    }

    //metodo para realização do empréstimo
    public void confirmarEmprestimo(Cliente cliente, Livro livro) {
        LocalDateTime dataEmprestimo = LocalDateTime.now();
        gerarDatasEmprestimo(dataEmprestimo);
    }

    public void emprestimoDevolvido(LocalDateTime data) {
        setDataDeEntregaReal(data);
    }


//    TimeUnit timeUnit;
//    public void devolucaoDeEmprestimo(Cliente usuario, Livro livro, Exemplar exemplar, ArrayList<Exemplar> listaExemplar) {
//        if (getSituacao() == 1 && livroJaEmprestado(exemplar)) {
//
//            LocalDateTime dataDevolucao = LocalDateTime.now();
//            livro.adicionarExemplar(1);
//            emprestimoDevolvido(dataDevolucao);
//            exemplar.setEmprestada(false);
//            exemplar.setCativa(true);
//            usuario.desassociarUsuarioComExemplar(exemplar);
////            System.out.println("Exemplar devolvido com sucesso");
//
//            try {
//                if (dataPrevistaDeDevolucao.isBefore(dataDeEntregaReal)) {
//                    Period tempoAtraso = Period.between(dataPrevistaDeDevolucao.toLocalDate(), dataDeEntregaReal.toLocalDate());
//                    int diasDeAtraso = tempoAtraso.getDays();
//                    System.out.println(diasDeAtraso);
//                    double multa = diasDeAtraso * 0.50;
//                    System.out.println("Essa devolução gerou uma multa de " + multa + " reais");
//                }
//            } catch (Exception NullPointerException) {
//
//            }
//
//        } else if(livroJaEmprestado(exemplar) == false) {
//            System.out.println("O exemplar do livro não condiz com o empréstimo");
//        }else{
//            System.out.println("O exemplar do livro não possui empréstimo");
//        }
//
//    }

}