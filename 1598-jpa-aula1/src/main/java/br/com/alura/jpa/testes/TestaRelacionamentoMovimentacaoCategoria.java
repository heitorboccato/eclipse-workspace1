package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TestaRelacionamentoMovimentacaoCategoria {

	public static void main(String[] args) {
		Categoria categoria = new Categoria();
		categoria.setNome("viagem");
		
		Categoria categoria2 = new Categoria();
		categoria2.setNome("negocios");
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setDescricao("Viagem a SP");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(300.0));
		List<Categoria> categorias = new ArrayList<Categoria>();
		movimentacao.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacao.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setDescricao("Viagem a MG");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setData(LocalDateTime.now());
		movimentacao2.setValor(new BigDecimal(150.0));
		movimentacao2.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacao2.setConta(conta);
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
	     EntityManager em = emf.createEntityManager();
	     
	     em.getTransaction().begin();

	     em.persist(categoria);
	     em.persist(categoria2);
	     em.persist(movimentacao);
	     em.persist(movimentacao2);
	     em.getTransaction().commit();
		
	}
}
