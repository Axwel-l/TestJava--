
package br.edu.aespi.jdbc;

public class TestaInsere {

    public static void main(String[] args) throws ClassNotFoundException {
        Contato contato = new Contato();
        ContatoDao contatoDao = new ContatoDao();
        contato.setNome("ax");
        contato.setEmail("Ax@gmail.com");
        contato.setEndereco("Casarai");
        contato.setTelefone("90028922");
        contatoDao.adiciona(contato);
        
    }
    
}
