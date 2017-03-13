package br.ueg.dao;

import br.ueg.model.Model;

public interface DAO<T extends Model> {

    T findById(Long id);

    Long count();

    T save(T value);

    T update(T value);

    boolean remove(T value);

    boolean remove(Long id);
}
