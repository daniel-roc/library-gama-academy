import java.util.ArrayList;

public class Usuario {

    private String nome;
    private String cpf;
    private String telefone;
    private String matricula;

    private ArrayList<Integer> listaCodigosExemplares = new ArrayList<Integer>(); //talvez usar um map para linkar usuario + codigo ?

    public Usuario(String nome, String cpf, String telefone, String matricula) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Integer> getListaCodigosExemplares() {
        return listaCodigosExemplares;
    }

    public void setListaCodigosExemplares(ArrayList<Integer> listaCodigosExemplares) {
        this.listaCodigosExemplares = listaCodigosExemplares;
    }

    public void associarUsuarioComExemplar(Exemplar exemplar){
//        exemplarEmprestado++;
        listaCodigosExemplares.add(exemplar.getCodigo());
    }

    public void desassociarUsuarioComExemplar(Exemplar exemplar){
        if(listaCodigosExemplares.contains(exemplar.getCodigo())){
            listaCodigosExemplares.remove(listaCodigosExemplares.indexOf(exemplar.getCodigo()));
            System.out.println("Exemplar devolvido com sucesso");
        }else{
            System.out.println("Esse usuario não está com esse exemplar");
        }
    }


//        listaCodigosExemplares.contains(listaExemplar.get(i).getCodigo());
//        for (Exemplar exemplarPesquisa : listaExemplar) {
//            for(int i = 0; i <listaExemplar.size(); i++) {
//                for (int j = 0; j < listaExemplar.size(); j++) {
//                    if (lista.getCodigo(i) == user.getListaCodigosExemplares().get(j)) {
//                        return true;
//                    }
//                }
//            }
//        }

}