package aplicacao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Empresa;

public class Atualizar {

	 static void valor(int codigoE) {
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin(); 

		Scanner scanner = new Scanner(System.in);

		
	    
	    System.out.print("Novo valor para nome: ");
	    int valor = scanner.nextInt();
	    
		Empresa empresa = em.find(Empresa.class, codigoE);
		
		empresa.setValorCompra(valor);

		em.getTransaction().commit();

		System.out.println("pronto!");	
		em.close(); 
		emf.close();
		
		}
	
	 static void nome(int codigoE) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin(); 

			Scanner sc = new Scanner(System.in);

		
		    
		    System.out.print("Novo valor para nome: ");
		    String nome = sc.next();
		    
			Empresa empresa = em.find(Empresa.class, codigoE);
			
			empresa.setNome(nome);

			em.getTransaction().commit();

			System.out.println("pronto!");	
			em.close(); 
			emf.close();
			
			}
	
	 static void cnpj(int codigoE) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin(); 

			Scanner sc = new Scanner(System.in);

		    
		    System.out.print("Novo cnpj: ");
		    String cnpj = sc.next();
		    
			Empresa empresa = em.find(Empresa.class, codigoE);
			
			empresa.setCnpj(cnpj);

			em.getTransaction().commit();

			System.out.println("pronto!");	
			em.close(); 
			emf.close();
			
			}
	
	 
	 static void email(int codigoE) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin(); 

			Scanner sc = new Scanner(System.in);

			
		    System.out.print("Novo email: ");
		    String email = sc.next();
		    
			Empresa empresa = em.find(Empresa.class, codigoE);
			
			empresa.setEmail(email);

			em.getTransaction().commit();

			System.out.println("pronto!");	
			em.close(); 
			emf.close();
			
			}
	
	 
	 static void senha(int codigoE) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin(); 

			Scanner sc = new Scanner(System.in);

		    System.out.print("Nova senha: ");
		    String senha = sc.next();
		    
			Empresa empresa = em.find(Empresa.class, codigoE);
			
			empresa.setSenha(senha);

			em.getTransaction().commit();

			System.out.println("pronto!");	
			em.close(); 
			emf.close();
			
			}
	
	 
	 static void status(int codigoE) {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin(); 

			Scanner sc = new Scanner(System.in);
		    
		    System.out.print("Novo Status: ");
		    String nome = sc.next();
			Empresa empresa = em.find(Empresa.class, codigoE);
			empresa.setStatusCompra(nome);
			em.getTransaction().commit();
			em.close(); 
			emf.close();
			
			}
	
	
	
	
	public static void main(String[] args)  {
		

		
		while(true) {

			Scanner scanner = new Scanner(System.in);

			System.out.print("\nCodigo da empresa que quer editar: ");
			int codigoE = scanner.nextInt();
			
			System.out.println("\nOque quer editar \nNome - 1 \nCNPJ - 2 \nEmail - 3 \nSenha - 4 \nValor - 5 \nStatus - 6");
		    int opcao = scanner.nextInt();
		    
			    if(opcao == 1) {
			    	nome(codigoE);
			    	
			    } else if (opcao == 2) {
			    	cnpj(codigoE);
	
			    } else if (opcao == 3) {
	                email(codigoE);
	                
			    } else if (opcao == 4) {
			    	senha(codigoE);
			    	
			    } else if (opcao == 5) {;
			    	valor(codigoE);
					
			    } else if (opcao == 6) {
			    	status(codigoE);
	
				} else if (opcao == 0) {
					System.out.println("Programa finalizado");
					break;
					
				}  else {
					System.out.println("Opcao invalida");
	
			    }
			}
		
	}

}
