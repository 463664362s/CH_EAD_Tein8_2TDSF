package aplicacao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Aplicacao;
import dominio.Empresa;

public class Listar {

	public static void main(String[] args) throws IOException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
		EntityManager em = emf.createEntityManager();
		
		while(true) {
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("\nOque gostaria de fazer: \n1 - Listar Empresas \n2 - Listar Aplicações \n0 - Finalizar programa \nOpção: ");
		    int opcao = scanner.nextInt();
		    
		    if(opcao == 1) {
				
				try {
					
					Query query = em.createQuery("select v from Empresa v");
					
					List<Empresa> empresas = query.getResultList();
					for (Empresa empresa : empresas) {
						System.out.println("\n"
						+ "Codigo: " 			+ empresa.getCodigo() 
						+ " - Nome: "			+ empresa.getNome()
						+ " - CNPJ: "			+ empresa.getCnpj()
						+ " - Email: "			+ empresa.getEmail() 
						+ " - Data da compra: "	+ empresa.getDataCompra() 
						+ " - Status compra: "  + empresa.getStatusCompra());
					}
					
					System.out.println("");
					
				} catch (Exception e) {
					
		            System.out.println("Deu erro!" + e);
		            
				}

		    } else if (opcao == 2) {
				
		    try {
		    	
				Query query = em.createQuery("select v from Aplicacao v");
				
				List<Aplicacao> aplicacoes = query.getResultList();
				for (Aplicacao aplicacao : aplicacoes) {
					System.out.println("\n"
					+ "Codigo: " 		+ aplicacao.getCodigo() 
					+ " - Nome: " 		+ aplicacao.getNome() 
					+ " - Botoes: " 	+ aplicacao.getBotoes() 
					+ " - Entradas: " 	+ aplicacao.getEntradaDados() 
					+ " - Links: " 		+ aplicacao.getLinks()  
					+ " - Empresa: " 	+ aplicacao.getEmpresa()  );
				}
				
				System.out.println("");

			} catch (Exception e) {
				
	            System.out.println("Deu erro!" + e);
	            
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
		