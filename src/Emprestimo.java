import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo {

    private Date dataDeEmprestimo;
    private Date dataPrevistaDeDevolucao;
    private Date dataDeEntregaReal;
    private int situacao = 0;

    private int duracaoEmprestimo = 15;

    public Emprestimo(Date dataDeEmprestimo, Date dataPrevistaDeDevolucao, Date dataDeEntregaReal, int situacao) {
        this.dataDeEmprestimo = dataDeEmprestimo;
        this.dataPrevistaDeDevolucao = dataPrevistaDeDevolucao;
        this.dataDeEntregaReal = dataDeEntregaReal;
        this.situacao = situacao;
    }

    public Date getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    public void setDataDeEmprestimo(Date dataDeEmprestimo) {
        this.dataDeEmprestimo = dataDeEmprestimo;
    }

    public Date getDataPrevistaDeDevolucao() {
        return dataPrevistaDeDevolucao;
    }

    public void setDataPrevistaDeDevolucao(Date dataPrevistaDeDevolucao) {
        this.dataPrevistaDeDevolucao = dataPrevistaDeDevolucao;
    }

    public Date getDataDeEntregaReal() {
        return dataDeEntregaReal;
    }

    public void setDataDeEntregaReal(Date dataDeEntregaReal) {
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
    public void gerarDatasEmprestimo(Date data) {
        //setar data atual
        setDataDeEmprestimo(data);

        //gerar duracao do emprestimo e adicionar na data
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DATE, getDuracaoEmprestimo());
        data = cal.getTime();

        //setar data de devolucao
        setDataPrevistaDeDevolucao(data);
    }

    //metodo para realização do empréstimo
    public void realizarEmprestimo(Usuario user, Livro livro, Exemplar exemplar, ArrayList<Exemplar> listaExemplar) {
        Date dataEmprestimo = new Date();

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

    public void emprestmoDevolvido(Date data) {
        setDataDeEntregaReal(data);
        setSituacao(0);
    }

    public void devolucaoDeEmprestimo(Usuario usuario, Livro livro, Exemplar exemplar, ArrayList<Exemplar> listaExemplar) {
        if (getSituacao() == 1) {

            Date dataDevolucao = new Date();
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
            if (dataPrevistaDeDevolucao.before(dataDeEntregaReal)) {
                long diasDeAtraso = ChronoUnit.DAYS.between((Temporal) dataPrevistaDeDevolucao, (Temporal) dataDeEntregaReal);
                double multa = diasDeAtraso * 0.50;
                System.out.println("Essa devolução gerou uma multa de " + multa + " reais");
            }
        } catch (Exception NullPointerException) {

        }
    }
}