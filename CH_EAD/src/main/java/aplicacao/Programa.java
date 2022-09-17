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

		aplicacao.setCodigo(8);
		aplicacao.setEmpresa(empresa);
		aplicacao.setNome("CARRINHO");
		aplicacao.setBotoes(5);
		aplicacao.setEntradaDados(6);
		aplicacao.setLinks(7);
		
		em.persist(empresa);
		em.persist(aplicacao);

		Empresa empresa2 = new Empresa();
		Aplicacao aplicacao2 = new Aplicacao();
		
		empresa2.setCodigo(2);
		empresa2.setNome("FIAP");
		empresa2.setCnpj("28.252.381/0001-15");
		empresa2.setEmail("contato@fiap.com.br");
		empresa2.setSenha("fpp172407");
		empresa2.setDataCompra(LocalDate.now());
		empresa2.setValorCompra(1600);
		empresa2.setStatusCompra("comfirmado");

		aplicacao2.setCodigo(7);
		aplicacao2.setEmpresa(empresa2);
		aplicacao2.setNome("Boletim");
		aplicacao2.setBotoes(2);
		aplicacao2.setEntradaDados(1);
		aplicacao2.setLinks(0);
		
		em.persist(empresa2);
		em.persist(aplicacao2);
		
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