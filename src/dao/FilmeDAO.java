package dao;

import bean.FilmeBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel Budke
 */
public class FilmeDAO {

    public int adicionar(FilmeBean filme) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {
            String sql = "INSERT INTO filmes (nome, diretor, categoria, ano, ator_principal, tempo_filme, "
                    + "orcamento, faturamento, faixa_etaria, legenda, dublado, idioma_original) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement ps = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                int posicao = 1;
                ps.setString(posicao++, filme.getNome());
                ps.setString(posicao++, filme.getDiretor());
                ps.setString(posicao++, filme.getCategoria());
                ps.setShort(posicao++, filme.getAno());
                ps.setString(posicao++, filme.getAtorPrincipal());
                ps.setShort(posicao++, filme.getTempoFilme());
                ps.setDouble(posicao++, filme.getOrcamento());
                ps.setDouble(posicao++, filme.getFaturamento());
                ps.setString(posicao++, filme.getFaixaEtaria());
                ps.setBoolean(posicao++, filme.isLegenda());
                ps.setBoolean(posicao++, filme.isDublado());
                ps.setString(posicao++, filme.getIdiomaOriginal());
                ps.execute();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }

        }
        return -1;
    }

    public FilmeBean obterPeloId(int id) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {

            String sql = "SELECT * FROM filmes WHERE id = ?";

            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    FilmeBean filme = new FilmeBean();
                    filme.setId(id);
                    filme.setNome(rs.getString("nome"));
                    filme.setDiretor(rs.getString("diretor"));
                    filme.setCategoria(rs.getString("categoria"));
                    filme.setAtorPrincipal(rs.getString("ator_principal"));
                    filme.setFaixaEtaria(rs.getString("faixa_etaria"));
                    filme.setDublado(rs.getBoolean("dublado"));
                    filme.setLegenda(rs.getBoolean("legenda"));
                    filme.setOrcamento(rs.getDouble("orcamento"));
                    filme.setFaturamento(rs.getDouble("faturamento"));
                    filme.setIdiomaOriginal(rs.getString("idioma_original"));
                    filme.setAno(rs.getShort("ano"));
                    filme.setTempoFilme(rs.getShort("tempo_filme"));
                    return filme;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }

        }
        return null;
    }

    public boolean alterar(FilmeBean avatar) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {

            String sql = "UPDATE filmes SET nome = ?, diretor = ?, categoria = ?, ano = ?, ator_principal = ?, "
                    + "tempo_filme = ?, orcamento = ?, faturamento = ?, faixa_etaria = ?, legenda = ?,"
                    + "dublado = ?, idioma_original = ? WHERE id = ?";

            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                int posicao = 1;
                ps.setString(posicao++, avatar.getNome());
                ps.setString(posicao++, avatar.getDiretor());
                ps.setString(posicao++, avatar.getCategoria());
                ps.setShort(posicao++, avatar.getAno());
                ps.setString(posicao++, avatar.getAtorPrincipal());
                ps.setShort(posicao++, avatar.getTempoFilme());
                ps.setDouble(posicao++, avatar.getOrcamento());
                ps.setDouble(posicao++, avatar.getFaturamento());
                ps.setString(posicao++, avatar.getFaixaEtaria());
                ps.setBoolean(posicao++, avatar.isLegenda());
                ps.setBoolean(posicao++, avatar.isDublado());
                ps.setString(posicao++, avatar.getIdiomaOriginal());
                ps.setInt(posicao++, avatar.getId());
                return ps.executeUpdate() == 1;

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }

        }
        return false;

    }

    public boolean excluir(int id) {
        Connection conexao = Conexao.conectar();
        if (conexao != null) {

            String sql = "DELETE FROM filmes WHERE id = ?";

            try {
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                return ps.executeUpdate() == 1;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Conexao.desconectar();
            }

        }
        return false;

    }

}
