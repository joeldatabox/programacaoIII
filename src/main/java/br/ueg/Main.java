package br.ueg;

import br.ueg.dao.DAO;
import br.ueg.dao.GenericDAO;
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
        DAO<Pessoa> dao = new GenericDAO<>(Pessoa.class);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("jaskdjlakdfjalsd");

        pessoa = dao.save(pessoa);
        System.out.println(pessoa);

        System.exit(0);
    }
}
