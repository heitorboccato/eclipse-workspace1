package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestaRelacionamentoClienteConta {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(1L);

		Cliente cliente = new Cliente();
		cliente.setNome("Heitor");
		cliente.setEndereco("Rua Adalberto Pajuaba");
		cliente.setProfissao("Programador");
		cliente.setConta(conta);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(cliente);
		em.getTransaction().commit();
	}
}
