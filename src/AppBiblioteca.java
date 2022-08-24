import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppBiblioteca {

    public static void main(String[] args) {

        // DECLARAÇÃO DE VARIÁVEIS
        var usuario = new Cliente("Daniel", "email@dominio.com.br", "1199999-9999", "111222333-88", "44555666X", "Rua da rua, numero, bairro, cidade, UF", "password@123");

        var autor = new Autor("Roger Lincoln");
        var livro = new Livro("Um dia antes de amanhã", autor, "20/05/2022", 2, "Ed. Livro", "987654123");
        var autor2 = new Autor("Roger Silva");
        var livro2 = new Livro("A Espera de Um Milagre", autor, "20/05/2022", 2, "Ed. Livro", "987654123");
        var exemplar = new Exemplar(1, true, false, livro, autor);
        var exemplar2 = new Exemplar(2, true, false, livro2, autor2);
        var exemplar3 = new Exemplar(3, true, false, livro, autor);

        // LISTA DE EXEMPLARES PARA PESQUISA
        ArrayList<Exemplar> busca = new ArrayList<Exemplar>();
        busca.add(exemplar);
        busca.add(exemplar2);
        busca.add(exemplar3);

        // PESQUISA POR AUTOR
        String pesquisaAutor = "Roger";

        for (Exemplar exemplarPesquisa : busca) {
            if (exemplarPesquisa.getAutor().contains(pesquisaAutor)) {
                System.out.println("Autor: " + exemplarPesquisa.getAutor() + " - Título: " + exemplarPesquisa.getLivro() + " - Quantidade de exemplares disponíveis: " + exemplarPesquisa.getQuantidadeDeExemplares());
            }
        }

        // PESQUISA POR TÍTULO
        String pesquisaTitulo = "milagre";

        for (Exemplar exemplarPesquisa : busca) {
            if (exemplarPesquisa.getLivro().contains(pesquisaTitulo)) {
                System.out.println("Título: " + exemplarPesquisa.getLivro() + " - Autor: " + exemplarPesquisa.getAutor() + " - Quantidade de exemplares disponíveis: " + exemplarPesquisa.getQuantidadeDeExemplares());
            }
        }

        //dados para gerar multa no empréstimo
        LocalDateTime dataEmprestimoFake = LocalDateTime.now();
        LocalDateTime dataEmprestimoPrevistaFake = LocalDateTime.now();
        LocalDateTime dataEntregaRealFake = LocalDateTime.now();

        dataEmprestimoFake = dataEmprestimoFake.minusDays(18);
        dataEmprestimoPrevistaFake = dataEmprestimoPrevistaFake.minusDays(10);



        //GERAR EMPRESTIMO
        var emprestimo = new Emprestimo();
        var emprestimoAtrasado = new Emprestimo(dataEmprestimoFake, dataEmprestimoPrevistaFake, dataEntregaRealFake, 1);
        emprestimo.realizarEmprestimo(usuario, livro, exemplar3, busca); // emprestimo - exemplar3 - dia 5 pego - dia 20 entrega
        emprestimo.realizarEmprestimo(usuario, livro2, exemplar2, busca);
//        emprestimo.realizarEmprestimo(usuario, livro, exemplar2, busca);
//        emprestimo.realizarEmprestimo(usuario, livro, exemplar2, busca);
//        emprestimo.devolucaoDeEmprestimo(usuario, livro, exemplar, busca);
        emprestimoAtrasado.devolucaoDeEmprestimo(usuario, livro, exemplar3, busca); // <= problema, pode-se gerar uma devolucao de um exemplar que foi gerado por outro emprestimo

        // REALIZAR COMPRA
        System.out.println(livro.getQuantidadeDeExemplares());
        System.out.println(usuario.comprarLivro(livro)); 
        System.out.println(livro.getQuantidadeDeExemplares());


//        // PESQUISA DE LIVRO POR AUTOR
//        String pesquisaAutor = "Daniel Silva";
//        boolean resultado = busca.stream().anyMatch(exemplarPesquisa -> exemplarPesquisa.getAutor().equalsIgnoreCase(pesquisaAutor));
//        System.out.println(resultado);

        // EMPRÉSTIMO DE LIVRO
//        if (exemplar.isCativa() && livro.getQuantidadeDeExemplares() >= 1) {
//
//
//
//            System.out.println("Sr. "+ usuario.getNome() + ", o exemplar do livro '" + livro.getTitulo() + "' está emprestado até: "
//                    + emprestimo.getDataPrevistaDeDevolucao());
//
//            emprestimo.realizarEmprestimo(usuario, livro, exemplar, busca);
//
//            boolean livroDevolvido = false;
//
//            if (livroDevolvido) {
//                emprestimo.devolucaoDeEmprestimo(livro, exemplar, "05/08/2022");
//                System.out.println("Exemplar devolvido em: " + emprestimo.getDataDeEntregaReal());
//            } else {
//                System.out.println("Livro segue emprestado!");
//            }
//
//        } else {
//
//            System.out.println("Exemplar não disponível!");
//        }
//
//        System.out.println("Total de exemplares disponíveis: " + livro.getQuantidadeDeExemplares());
//
//        }

        }
    }
