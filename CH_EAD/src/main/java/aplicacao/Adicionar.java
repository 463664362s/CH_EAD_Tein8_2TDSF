package aplicacao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Aplicacao;
import dominio.Empresa;

public class Adicionar {

	public static void main(String[] args) throws IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
		EntityManager em = emf.createEntityManager();
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("\n Oque gostaria de fazer: \n 1 - Cadastrar Empresa \n 2 - Cadastrar Aplicacao \n 0 - Fechar \nOpção: ");
		    int opcao = scanner.nextInt();
		    
		    if(opcao == 1) {
				
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

					System.out.println("\n Empresa adicionada com sucesso");

				} catch (Exception erro) {

					System.out.println(erro);
					System.out.println("Erro para persistir os dados");

				}

		    } else if (opcao == 2) {
				
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

					System.out.println("\n Aplicacao adicionada com sucesso");

					
				} catch (Exception erro) {
					
					System.out.println(erro);
					System.out.println("Erro para persistir os dados");
					
				}  

			} else if (opcao == 0) {
				System.out.println("Programa finalizado");
				em.close();
				emf.close();
				break;
				
			}  else {
				System.out.println("Opcao invalida");

		    }	
		}
		

	}
}