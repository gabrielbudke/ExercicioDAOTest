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
    
    @Test
    public void testarCadastro(){
        
        FilmeBean vingadores = new FilmeBean();
        vingadores.setNome("Os Vingadores");
        vingadores.setDiretor("Joe Russo");
        vingadores.setCategoria("Aventura");
        vingadores.setAno(2018);
        vingadores.setAtorPrincipal("Cris");
        vingadores.setDublado(true);
        vingadores.setLegenda(true);
        vingadores.setFaixaEtaria("Doze anos");
        vingadores.setFaturamento(1_000_000.00);
        vingadores.setOrcamento(1_000_000.00);
        vingadores.setIdiomaOriginal("Ingles");
        vingadores.setTempoFilme(16);
        
        int id = new FilmeDAO().adicionar(vingadores);
        assertNotSame(id, -1);
        
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
    
}
