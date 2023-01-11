package br.edu.aespi.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao {
    
    private final Connection connection;
    
    public ContatoDao() throws ClassNotFoundException{
        this.connection= new ConnectionFactory().getConnection();
    }
    public List<Contato> getLista() {
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from contatos");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Contato contato = new Contato();
            contato.setId(rs.getLong("id"));
            contato.setNome(rs.getString("nome"));
            contato.setEmail(rs.getString("email"));
            contato.setEndereco(rs.getString("endereco"));
            contato.setTelefone(rs.getString("telefone"));
            
            contatos.add(contato);
            
        }
        rs.close();
        stmt.close();
        return contatos;
        }catch(SQLException e){
            throw  new RuntimeException(e);
        }
    }
        
    public void adiciona ( Contato contato ) {
    String sql = " insert into contatos " +
            " ( nome , email , endereco , Telefone) " +
            " values ( ? , ? , ? , ? ) " ;
    

    try {
        // prepared statement para inserção
        PreparedStatement stmt = connection.prepareStatement ( sql ) ;
        
        // seta os valores
        stmt.setString ( 1 , contato.getNome ( ) ) ;
        stmt.setString ( 2 , contato.getEmail ( ) ) ;
        stmt.setString ( 3 , contato.getEndereco ( ) ) ;
        stmt.setString ( 4 , contato.getTelefone ( )  ) ;
        
        // executa
        stmt.execute ( ) ;
        stmt.close ( ) ;
    } catch ( SQLException e ) {
    
        throw new RuntimeException ( e ) ;
    }
}

    public void altera ( Contato contato ) {
        String sql = "update contatos set nome=?, email=?,endereco=?,telefone=? where id=?";
    

    try {
        PreparedStatement stmt = connection.prepareStatement ( sql ) ;
        
        // seta os valores
        stmt.setString ( 1 , contato.getNome ( ) ) ;
        stmt.setString ( 2 , contato.getEmail ( ) ) ;
        stmt.setString ( 3 , contato.getEndereco ( ) ) ;
        stmt.setString ( 4 , contato.getTelefone ( )  ) ;
        stmt.setLong ( 5 , contato.getId ( )  ) ;
        // executa
        stmt.execute ( ) ;
        stmt.close ( ) ;
    } catch ( SQLException e ) {
    
        throw new RuntimeException ( e ) ;
    }
}
    
    public void remove ( Long Id ) {
 
    try {
        try(PreparedStatement stmt = connection.
                prepareStatement ( "delete from contatos where id=?" )) {

        stmt.setLong ( 1 , Id ) ;
        // executa
        stmt.execute ( ) ;
        }
    } catch ( SQLException ex ) {
    
        throw new RuntimeException ( ex ) ;
    }
}
    
    public Contato getContatoporId(Long Id) {
        try {
            Contato contatos = new Contato();
            PreparedStatement stmt = this.connection.
                    prepareStatement("select * from contatos where id=?");
            stmt.setLong(1,Id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {           
            contatos.setId(rs.getLong("id"));
            contatos.setNome(rs.getString("nome"));
            contatos.setEmail(rs.getString("email"));
            contatos.setEndereco(rs.getString("endereco"));
            contatos.setTelefone(rs.getString("telefone"));            
        }
        return contatos;
        }catch(SQLException batata){
            throw  new RuntimeException(batata);
        }
    }

    
    
}