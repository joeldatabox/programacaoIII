package br.ueg.dao;

import br.ueg.infra.Migrations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by joel on 02/03/17.
 */
public class JPAUtil {
    static final String PERSISTENCE_UNIT = "progracaoIII";

    //EntityManager em = factory.createEntityManager();
    private static EntityManagerFactory factory;


    private static EntityManagerFactory getFactory() {
        if (factory == null) {
            //Devemos migrar o banco antes mesmo de criar a fabrica de EntityManager
            Migrations.executeMigrations();
            //cria a fabrica de entityManager
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
                @Override
                public void run() {
                    JPAUtil.factory.close();
                }
            }));
        }
        return factory;
    }

    public static EntityManager createEntityManager() {
        return getFactory().createEntityManager();
    }

    public static void close(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
