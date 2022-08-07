import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;

public class AppBiblioteca {

    public static void main(String[] args) {

        // DECLARAÇÃO DE VARIÁVEIS
        var usuario = new Usuario("Daniel", "12345678999", "11 94548-4449", "M282214");

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

        //GERAR EMPRESTIMO
        var emprestimo = new Emprestimo(null, null, null, 0);
        emprestimo.realizarEmprestimo(usuario, livro, exemplar3, busca);
        emprestimo.realizarEmprestimo(usuario, livro, exemplar2, busca);
        emprestimo.realizarEmprestimo(usuario, livro, exemplar2, busca);
        emprestimo.devolucaoDeEmprestimo(usuario, livro, exemplar, busca);


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
