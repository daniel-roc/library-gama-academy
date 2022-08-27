package br.com.xbookmarket;
import java.util.ArrayList;

public class AppBiblioteca {

    public static void main(String[] args) {

        // BASE DE DADOS
        Cliente usuario = new Cliente("Daniel", "email@dominio.com.br", "11 99999-9999", "111222333-88", "44555666X", "Rua da rua, numero, bairro, cidade, UF", "password@123");
        Cliente usuario2 = new Cliente("José", "email@dominio.com.br", "11 99999-9999", "111222333-88", "44555666X", "Rua da rua, numero, bairro, cidade, UF", "password@123");
        
        Autor autor = new Autor("Roger Lincoln");
        Autor autor2 = new Autor("André Silva");
        
        Livro livro = new Livro("Um dia antes de amanhã", autor, "20/05/2022", 2, "Ed. Livro", "987654123", 25.0, 15.0);
        Livro livro2 = new Livro("A Espera de Um Milagre", autor2, "20/05/2022", 2, "Ed. Livro", "987654123", 30.0, 15.0);

        // LISTA DE EXEMPLARES PARA PESQUISA
        ArrayList<Livro> busca = new ArrayList<Livro>();
        busca.add(livro);
        busca.add(livro2);

        // PESQUISA POR AUTOR
        System.out.println();
        System.out.println("- Resultado de pesquisa pelo nome do Autor:");
        System.out.println();
        String pesquisaPorAutor = "Roger";

        for (Livro livroParaPesquisa : busca) {
            if (livroParaPesquisa.getAutor().contains(pesquisaPorAutor)) {
                System.out.println("Autor: " + livroParaPesquisa.getAutor() + " - Título: " + livroParaPesquisa.getTitulo());
            }
        }

        // PESQUISA POR TÍTULO
        System.out.println();
        System.out.println("- Resultado de pesquisa pelo Título do livro:");
        System.out.println();
        
        String pesquisaPorTitulo = "Milagre";

        for (Livro livroParaPesquisa : busca) {
            if (livroParaPesquisa.getTitulo().contains(pesquisaPorTitulo)) {
                System.out.println("Título: " + livroParaPesquisa.getTitulo() + " - Autor: " + livroParaPesquisa.getAutor());
            }
        }

        // COMPRA APROVADA
        System.out.println();
        System.out.println("- Retorno da compra de livro após aprovação de pagamento:");
        System.out.println();
        
        System.out.println(usuario.comprarLivro(livro, true));
        
        // COMPRA NÃO AUTORIZADA
        System.out.println();
        System.out.println("- Retorno da compra de livro após reprovação de pagamento:");
        System.out.println();
        
        System.out.println(usuario.comprarLivro(livro2, false));
        
        // LISTAGEM DE LIVROS COMPRADOS
        System.out.println();
        System.out.println("- Listagem dos livros comprados pelo usuário: ");
        System.out.println();
        
        System.out.println(usuario.getListaLivrosComprados());
        
        // NOVO EMPRÉSTIMO
        System.out.println();
        System.out.println("- Solicitação de novos empréstimos: ");
        System.out.println();
        
        System.out.println(usuario2.realizarOuRenovarEmprestimo(usuario2, livro, true));
        System.out.println(usuario2.realizarOuRenovarEmprestimo(usuario2, livro2, true));
        
        // RENOVAÇÃO DE EMPRÉSTIMO
        System.out.println();
        System.out.println("- Solicitação de renovação de empréstimo: ");
        System.out.println();
        
        System.out.println(usuario2.realizarOuRenovarEmprestimo(usuario2, livro, true));
        
        // LISTAGEM DE LIVROS EMPRESTADOS
        System.out.println();
        System.out.println("- Listagem dos livros emprestados ao usuário:");
        System.out.println();
        
        System.out.println(usuario2.getListaLivrosEmprestados());

        }
    }
