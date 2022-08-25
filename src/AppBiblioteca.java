import java.util.ArrayList;

public class AppBiblioteca {

    public static void main(String[] args) {

        // BASE DE DADOS
        var usuario = new Cliente("Daniel", "email@dominio.com.br", "1199999-9999", "111222333-88", "44555666X", "Rua da rua, numero, bairro, cidade, UF", "password@123");
        var usuario2 = new Cliente("José", "email@dominio.com.br", "1199999-9999", "111222333-88", "44555666X", "Rua da rua, numero, bairro, cidade, UF", "password@123");
        
        var autor = new Autor("Roger Lincoln");
        var autor2 = new Autor("André Silva");
        
        var livro = new Livro("Um dia antes de amanhã", autor, "20/05/2022", 2, "Ed. Livro", "987654123", 25.0, 15.0);
        var livro2 = new Livro("A Espera de Um Milagre", autor2, "20/05/2022", 2, "Ed. Livro", "987654123", 30.0, 15.0);

        // LISTA DE EXEMPLARES PARA PESQUISA
        ArrayList<Livro> busca = new ArrayList<Livro>();
        busca.add(livro);
        busca.add(livro2);

        // PESQUISA POR AUTOR
        String pesquisaPorAutor = "Roger";

        for (Livro livroParaPesquisa : busca) {
            if (livroParaPesquisa.getAutor().contains(pesquisaPorAutor)) {
                System.out.println("Autor: " + livroParaPesquisa.getAutor() + " - Título: " + livroParaPesquisa.getTitulo());
            }
        }

        // PESQUISA POR TÍTULO
        String pesquisaPorTitulo = "milagre";

        for (Livro livroParaPesquisa : busca) {
            if (livroParaPesquisa.getTitulo().contains(pesquisaPorTitulo)) {
                System.out.println("Título: " + livroParaPesquisa.getTitulo() + " - Autor: " + livroParaPesquisa.getAutor());
            }
        }

        // REALIZAR COMPRA
        System.out.println(usuario.comprarLivro(livro, true));
        System.out.println(usuario.comprarLivro(livro2, false));
        System.out.println(usuario.getListaLivrosComprados());
        System.out.println(usuario2.getListaLivrosComprados());

        }
    }
