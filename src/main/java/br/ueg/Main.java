package br.ueg;

import br.ueg.model.Pessoa;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by joel on 23/02/17.
 */
public class Main {

    public static void main(String[] args) {
        final String PERSISTENCE_UNIT = "progracaoIII";

        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

        EntityManager em = factory.createEntityManager();

        //Pessoa pessoa = new Pessoa();
        //pessoa.setNome("Joel Rodrigeus");


        Pessoa pessoa1 = null;
        try {
            pessoa1 = em.find(Pessoa.class, 1L);

            em.getTransaction().begin();
            pessoa1.setNome(pessoa1.getNome() + " 69989");
            em.merge(pessoa1);
            em.getTransaction().commit();

            em.getTransaction().begin();

            pessoa1 = em.find(Pessoa.class, 2L);
            pessoa1 = em.merge(pessoa1);
            pessoa1.setNome("lkasdkajshdkjahldf");

            em.getTransaction().commit();;

        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }


                Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Fechando a fabrica de conexão");
                factory.close();
            }
        }));

        System.exit(0);
    }
}
