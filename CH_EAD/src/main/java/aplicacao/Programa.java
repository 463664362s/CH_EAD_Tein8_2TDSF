package aplicacao;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Aplicacao;
import dominio.Empresa;


public class Programa {

public static void main(String[] args) throws IOException {

	try {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();		
		
		Empresa empresa = new Empresa();
		Aplicacao aplicacao = new Aplicacao();

		empresa.setCodigo(1);
		empresa.setNome("Amazom");
		empresa.setCnpj("12.416.910/0001-03");
		empresa.setEmail("amazomlogin@gmail.com");
		empresa.setSenha("amzpass12416");
		empresa.setDataCompra(LocalDate.now());
		empresa.setValorCompra(1600);
		empresa.setStatusCompra("comfirmado");

		aplicacao.setCodigo(10);
		aplicacao.setEmpresa(empresa);
		aplicacao.setNome("CARRINHO");
		aplicacao.setBotoes(5);
		aplicacao.setEntradaDados(6);
		aplicacao.setLinks(7);
		
		em.persist(empresa);
		em.persist(aplicacao);

		
		em.getTransaction().commit();

		System.out.println("OK");
		em.close();
		emf.close();
		
	} catch (Exception erro) {
		
		System.out.println(erro);
		System.out.println("Erro para persistir os dados");

		}
	}
}