package aplicacao;

import java.io.IOException;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ExcluirTabelas {

	public static void main(String[] args) throws IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch-tein8-ead");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

        try {
            em.createNativeQuery("drop table tab_t8_aplicacao").executeUpdate();
            em.createNativeQuery("drop table tab_t8_empresa").executeUpdate();
        } catch (Exception e) {
            System.out.println("Deu erro!" + e);
            em.getTransaction().rollback(); 
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().commit();
                System.out.println("Tabelas Excluidas!");
            }
			em.close();
			emf.close();
        }
    }
}