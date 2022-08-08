import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Emprestimo {

    private LocalDateTime dataDeEmprestimo;
    private LocalDateTime dataPrevistaDeDevolucao;
    private LocalDateTime dataDeEntregaReal;
    private int situacao = 0;

    private int duracaoEmprestimo = 15;

    public Emprestimo(LocalDateTime dataDeEmprestimo, LocalDateTime dataPrevistaDeDevolucao, LocalDateTime dataDeEntregaReal, int situacao) {
        this.dataDeEmprestimo = dataDeEmprestimo;
        this.dataPrevistaDeDevolucao = dataPrevistaDeDevolucao;
        this.dataDeEntregaReal = dataDeEntregaReal;
        this.situacao = situacao;
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

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public int getDuracaoEmprestimo() {
        return duracaoEmprestimo;
    }

    public void setDuracaoEmprestimo(int duracaoEmprestimo) {
        this.duracaoEmprestimo = duracaoEmprestimo;
    }

    //metodo para geração de datas no empréstimo - data atual e data de devolução
    public void gerarDatasEmprestimo(LocalDateTime data) {
        //setar data atual
        setDataDeEmprestimo(data);

        //gerar duracao do emprestimo e adicionar na data
        data.plusDays(getDuracaoEmprestimo());

//        Calendar cal = Calendar.getInstance();
//        cal.setTime(data);
//        cal.add(Calendar.DATE, getDuracaoEmprestimo());
//        data = cal.getTime();

        //setar data de devolucao
        setDataPrevistaDeDevolucao(data);
    }

    //metodo para realização do empréstimo
    public void realizarEmprestimo(Usuario user, Livro livro, Exemplar exemplar, ArrayList<Exemplar> listaExemplar) {
        LocalDateTime dataEmprestimo = LocalDateTime.now();

        if (livro.exemplarEstaDisponivel() && exemplar.isEmprestada() == false) {

            exemplar.setEmprestada(true);
            exemplar.setCativa(false);
            gerarDatasEmprestimo(dataEmprestimo);
            setSituacao(1);

            livro.removerExemplar(1);

            user.associarUsuarioComExemplar(exemplar);

            System.out.printf("Emprestimo do livro '%s' gerado com sucesso\n", livro.getTitulo());

        } else {
            System.out.println("O exemplar do livro não está disponível"); //verificar mensagem junto com verificarSeUsuarioPossuiExemplarDoLivro
        }
    }

    public void emprestmoDevolvido(LocalDateTime data) {
        setDataDeEntregaReal(data);
        setSituacao(0);
    }


    TimeUnit timeUnit;


    public void devolucaoDeEmprestimo(Usuario usuario, Livro livro, Exemplar exemplar, ArrayList<Exemplar> listaExemplar) {
        if (getSituacao() == 1) {

            LocalDateTime dataDevolucao = LocalDateTime.now();
            livro.adicionarExemplar(1);
            emprestmoDevolvido(dataDevolucao);
            exemplar.setEmprestada(false);
            exemplar.setCativa(true);
            usuario.desassociarUsuarioComExemplar(exemplar);
//            System.out.println("Exemplar devolvido com sucesso");

        } else {

            System.out.println("O exemplar do livro não possui empréstimo");

        }
        try {
            if (dataPrevistaDeDevolucao.isBefore(dataDeEntregaReal)) {
                Period tempoAtraso = Period.between(dataPrevistaDeDevolucao.toLocalDate(), dataDeEntregaReal.toLocalDate());
                int diasDeAtraso = tempoAtraso.getDays();
                System.out.println(diasDeAtraso);
                double multa = diasDeAtraso * 0.50;
                System.out.println("Essa devolução gerou uma multa de " + multa + " reais");
            }
        } catch (Exception NullPointerException) {

        }
    }

}