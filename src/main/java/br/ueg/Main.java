package br.ueg;

import br.ueg.dao.DAO;
import br.ueg.dao.GenericDAO;
import br.ueg.model.Pessoa;
import br.ueg.model.enumeration.Sexo;

/**
 * Created by joel on 23/02/17.
 */
public class Main {

    public static void main(String[] args) {
        DAO<Pessoa> dao = new GenericDAO<>(Pessoa.class);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("jaskdjlakdfjalsd");
        pessoa.setSexo(Sexo.MASCULINO);
        pessoa.setCpf("123213");

        pessoa = dao.save(pessoa);
        System.out.println(pessoa);

        System.exit(0);
    }
}
