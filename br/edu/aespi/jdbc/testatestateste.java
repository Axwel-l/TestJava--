
package br.edu.aespi.jdbc;

import java.util.List;

public class testatestateste {

    public static void main(String[] args) throws ClassNotFoundException {
        Contato c1 = new Contato();//c1 = contato1
        Contato c02 = new Contato();
        ContatoDao cd1 = new ContatoDao();
        
        /*c1.setNome("luffy");
        c1.setEmail("futuroreidospiratas@gmail.com");
        c1.setEndereco("thousandsunny");
        c1.setTelefone("23930823");
        cd1.adiciona(c1);*/

        List<Contato> contatos = cd1.getLista();
    
        for(Contato contato: contatos){
            System.out.println("Nome: "+ contato.getNome());
            System.out.println("Email: "+ contato.getEmail());
            System.out.println("Endereço: "+ contato.getEndereco());
            System.out.println("Telefone: "+ contato.getTelefone());
        }
        //cd1.remove(Long.parseLong("2"));
        

        c02.setNome("robin-chwan");
        c02.setEmail("dresshsheshe@gmail.com");
        c02.setEndereco("thousandsunny");
        c02.setTelefone("1920987");
        c02.setId(Long.parseLong("5"));
 
        cd1.altera(c02);
        
        cd1.getContatoporId(Long.parseLong("3"));
        System.out.println("Nome: "+ cd1.getContatoporId(Long.parseLong("3")).getNome());
        System.out.println("Email: "+ cd1.getContatoporId(Long.parseLong("3")).getEmail());
        System.out.println("Endereço: "+ cd1.getContatoporId(Long.parseLong("3")).getEndereco());
        System.out.println("Telefone: "+ cd1.getContatoporId(Long.parseLong("3")).getTelefone());

        
    }
    
}
