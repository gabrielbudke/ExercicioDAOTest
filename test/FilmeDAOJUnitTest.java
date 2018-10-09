/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.FilmeDAO;
import bean.FilmeBean;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gabriel Budke
 */
public class FilmeDAOJUnitTest {
    
    //Instacia o FilmeDAO
    FilmeDAO dao = new FilmeDAO();
    
    
    @Test
    public void testarCadastro(){
        
        //Cria um objeto Java
        FilmeBean vingadores = new FilmeBean();
        vingadores.setNome("Os Vingadores");
        vingadores.setDiretor("Joe Russo");
        vingadores.setCategoria("Aventura");
        vingadores.setAno((short)2018);
        vingadores.setAtorPrincipal("Cris");
        vingadores.setDublado(true);
        vingadores.setLegenda(true);
        vingadores.setFaixaEtaria("Doze anos");
        vingadores.setFaturamento(1_000_000.00);
        vingadores.setOrcamento(1_000_000.00);
        vingadores.setIdiomaOriginal("Ingles");
        vingadores.setTempoFilme((short)160);
        
        //Envia o objeto Java para o método adicionar da classe FilmeDAO.
        int id = new FilmeDAO().adicionar(vingadores);
        assertNotSame(id, -1);
        
        //Verifica se o que foi guardado em um objeto Java
        //foi o que realmente foi armazenado no banco, ou seja, 
        //verifica se as informações ão iguais
        FilmeBean filmeBuscado = new FilmeDAO().obterPeloId(id);
        assertEquals(vingadores.getNome(), filmeBuscado.getNome());
        assertEquals(vingadores.getDiretor(), filmeBuscado.getDiretor());
        assertEquals(vingadores.getCategoria(), filmeBuscado.getCategoria());
        assertEquals(vingadores.getAno(), filmeBuscado.getAno());
        assertEquals(vingadores.getAtorPrincipal(), filmeBuscado.getAtorPrincipal());
        assertEquals(vingadores.isDublado(), filmeBuscado.isDublado());
        assertEquals(vingadores.isLegenda(), filmeBuscado.isLegenda());
        assertEquals(vingadores.getFaixaEtaria(), filmeBuscado.getFaixaEtaria());
        assertEquals(vingadores.getFaturamento(), filmeBuscado.getFaturamento(),0);
        assertEquals(vingadores.getOrcamento(), filmeBuscado.getOrcamento(),0);
        assertEquals(vingadores.getTempoFilme(), filmeBuscado.getTempoFilme());
        
    }
    
    @Test
    public void testarEditar(){
        
        //Cria um novo objeto Java
        FilmeBean avatar = new FilmeBean();
        avatar.setNome("Avatar");
        avatar.setDiretor("James Cameron");
        avatar.setCategoria("Aventura");
        avatar.setAno((short)2010);
        avatar.setAtorPrincipal("Fulano");
        avatar.setDublado(false);
        avatar.setLegenda(true);
        avatar.setFaixaEtaria("16 Anos");
        avatar.setFaturamento(1_050_270.00);
        avatar.setOrcamento(1_500_005.08);
        avatar.setIdiomaOriginal("Grego");
        avatar.setTempoFilme((short)230);
        
        //Chama o método 'adicionar' da classe FilmeDAO 
        //para adicionar o obejto no banco de dados
        int id = dao.adicionar(avatar);
        avatar.setId(id);
        
        //Define os novos atributos
        avatar.setNome("Avatar");
        avatar.setDiretor("James Cameron");
        avatar.setCategoria("Comédia");
        avatar.setAno((short)2015);
        avatar.setAtorPrincipal("Beltrano");
        avatar.setDublado(false);
        avatar.setLegenda(true);
        avatar.setFaixaEtaria("12 Anos");
        avatar.setFaturamento(1_050_270.00);
        avatar.setOrcamento(1_500_005.08);
        avatar.setIdiomaOriginal("Ingles");
        avatar.setTempoFilme((short)230);
        
        //Envia os novos atributos para o método alterar da Classe FilmeDAO
        boolean alterado = dao.alterar(avatar);
        assertTrue(alterado);

        //Verifica se o que foi alterado em um objeto Java
        //foi o que realmente armazenado no banco, ou seja, 
        //verifica se informaçoes são iguais; 
        FilmeBean filmeBuscado = dao.obterPeloId(id);
        assertEquals(avatar.getNome(), filmeBuscado.getNome());
        assertEquals(avatar.getDiretor(), filmeBuscado.getDiretor());
        assertEquals(avatar.getCategoria(), filmeBuscado.getCategoria());
        assertEquals(avatar.getAno(), filmeBuscado.getAno());
        assertEquals(avatar.getAtorPrincipal(), filmeBuscado.getAtorPrincipal());
        assertEquals(avatar.isDublado(), filmeBuscado.isDublado());
        assertEquals(avatar.isLegenda(), filmeBuscado.isLegenda());
        assertEquals(avatar.getFaixaEtaria(), filmeBuscado.getFaixaEtaria());
        assertEquals(avatar.getFaturamento(), filmeBuscado.getFaturamento(),0);
        assertEquals(avatar.getOrcamento(), filmeBuscado.getOrcamento(),0);
        assertEquals(avatar.getTempoFilme(), filmeBuscado.getTempoFilme());
        
    }

    @Test
    public void testarExcluir(){
        
        //Cria um novo obejto Java
        FilmeBean avatar = new FilmeBean();
        avatar.setNome("Avatar");
        avatar.setDiretor("James Cameron");
        avatar.setCategoria("Aventura");
        avatar.setAno((short)2010);
        avatar.setAtorPrincipal("Fulano");
        avatar.setDublado(false);
        avatar.setLegenda(true);
        avatar.setFaixaEtaria("16 Anos");
        avatar.setFaturamento(1_050_270.00);
        avatar.setOrcamento(1_500_005.08);
        avatar.setIdiomaOriginal("Grego");
        avatar.setTempoFilme((short)230);
        
        //Envia o objeto Java para o método excluir da classe FilmeDAO
        int id = dao.adicionar(avatar);
        boolean excluir = dao.excluir(id);
        assertTrue(excluir);
        
        //Compara se o objeto que foi buscado existe
        //se ele retornar null, é porque foi excluído
        FilmeBean filmeBuscado = dao.obterPeloId(id);
        assertNull(filmeBuscado);
        
        
        
        
        
        
        
    }




}
