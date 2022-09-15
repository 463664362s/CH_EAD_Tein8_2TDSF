package aplicacao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Empresa;

public class AdicionarEmpresa {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		
		Empresa empresa = new Empresa();
		
		System.out.print("Codigo da empresa: ");
	    int codigo = scanner.nextInt();

	    System.out.print("Nome da empresa: ");
		String nome = scanner.next();

		System.out.print("Cnpj da empresa: ");
		String cnpj = scanner.next();
		
		System.out.print("Email da empresa: ");
		String email = scanner.next();
		
		System.out.print("Senha da empresa: ");
		String senha = scanner.next();
		
		System.out.print("Status da empresa: ");
		String status = scanner.next();

		System.out.print("Valor: ");
	    int valor = scanner.nextInt();
	
	    try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			
			empresa.setCodigo(codigo);
			empresa.setNome(nome);
			empresa.setCnpj(cnpj);
			empresa.setEmail(email);
			empresa.setSenha(senha);
			empresa.setDataCompra(LocalDate.now());
			empresa.setValorCompra(valor);
			empresa.setStatusCompra(status);
			
			em.persist(empresa);

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