package aplicacao;

import java.io.IOException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Aplicacao;
import dominio.Empresa;

public class AdicionarAplicacao {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		
		Empresa empresa = new Empresa();
			
		Aplicacao aplicacao = new Aplicacao();
		
		System.out.print("Codigo da aplicacao: ");
	    int codigo = scanner.nextInt();

	    System.out.print("Codigo da empresa: ");
	    int codigoEmpresa = scanner.nextInt();
	    
	    System.out.print("Nome da aplicacao: ");
		String nome = scanner.next();
		
		
		System.out.print("Botoes: ");
		int botoes = scanner.nextInt();
		
		System.out.print("Links: ");
		int links = scanner.nextInt();

		System.out.print("Entrada de dados: ");
	    int entradaDados = scanner.nextInt();
	    
	    try {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			
			empresa.setCodigo(codigoEmpresa);
			
			aplicacao.setCodigo(codigo);
			aplicacao.setEmpresa(empresa);
			aplicacao.setNome(nome);
			aplicacao.setBotoes(botoes);
			aplicacao.setEntradaDados(entradaDados);
			aplicacao.setLinks(links);

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