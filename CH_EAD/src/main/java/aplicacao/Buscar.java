package aplicacao;

import java.io.IOException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Aplicacao;
import dominio.Empresa;

public class Buscar {

	public static void main(String[] args) throws IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
		EntityManager em = emf.createEntityManager();
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("\nOque gostaria de fazer: \n1 - Buscar Empresas \n2 - Buscar Aplicações \n0 - Finalizar programa \nOpção: ");
		    int opcao = scanner.nextInt();
		    
		    if(opcao == 1 ) {
		    	
			    try {
			    	
			    	System.out.print("Codigo da empresa que gostaria de procurar: ");
				    int codigoE = scanner.nextInt();
				    Empresa empresa = em.getReference(Empresa.class, codigoE);
					System.out.println("\n"
					+ "Codigo: " 			+ empresa.getCodigo() 
					+ " - Nome: "			+ empresa.getNome()
					+ " - CNPJ: "			+ empresa.getCnpj()
					+ " - Email: "			+ empresa.getEmail() 
					+ " - Data da compra: "	+ empresa.getDataCompra() 
					+ " - Status compra: "  + empresa.getStatusCompra());
				    
				} catch (Exception e) {
					System.out.println("\n!ERRO! - Empresa nao encontrada no banco");
				}

			

		    } else if (opcao == 2) {
			
			 
			    try {
			    	
			    	System.out.print("Codigo da aplicação que gostaria de procurar: ");
				    int codigoAp = scanner.nextInt();
				    Aplicacao aplicacao = em.getReference(Aplicacao.class, codigoAp);
				    System.out.println("\n"
							+ "Codigo: " 		+ aplicacao.getCodigo() 
							+ " - Nome: " 		+ aplicacao.getNome() 
							+ " - Botoes: " 	+ aplicacao.getBotoes() 
							+ " - Entradas: " 	+ aplicacao.getEntradaDados() 
							+ " - Links: " 		+ aplicacao.getLinks()  
							+ " - Empresa: " 	+ aplicacao.getEmpresa());
		
				    
				} catch (Exception e) {
					System.out.println("\n!ERRO! - Aplicação nao encontrada no banco");
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

		