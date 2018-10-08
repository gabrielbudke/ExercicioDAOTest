package dao;

import bean.FilmeBean;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Gabriel Budke
 */
public class FilmeDAO {

    public int adicionar(FilmeBean vingadores) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO filmes (nome, diretor, categoria, ano, atorPrincipal, tempoFilme, "
                    + "orcamento, faturamento, faixa etaria, legenda, dublado, idiomaOriginal) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            
            try{
                PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, vingadores.getNome());
                    }
            
            
            
            
            
            
        }
        

    }

}
