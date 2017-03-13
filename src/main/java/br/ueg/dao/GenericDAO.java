package br.ueg.dao;

import br.ueg.model.Model;

import javax.persistence.EntityManager;

/**
 * Created by joel on 02/03/17.
 */
public class GenericDAO<T extends Model> implements DAO<T> {
    protected Class clazz;

    public GenericDAO(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public T findById(Long id) {
        EntityManager em = null;
        try {
            em = JPAUtil.createEntityManager();
            return (T) em.find(clazz, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JPAUtil.close(em);
        }
        return null;
    }

    @Override
    public Long count() {
        EntityManager em = null;
        try {
            em = JPAUtil.createEntityManager();
            String q = "SELECT COUNT(c) FROM " + clazz.getSimpleName() + " AS c";
            return (Long) em.createQuery(q).getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JPAUtil.close(em);
        }
        return null;
    }

    @Override
    public T save(T value) {
        return merge(value);
    }

    @Override
    public T update(T value) {
        return merge(value);
    }

    private T merge(T value) {
        EntityManager em = null;

        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            value = em.merge(value);
            em.getTransaction().commit();
            return value;
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
            JPAUtil.close(em);
        } finally {
            JPAUtil.close(em);
        }
        return null;
    }

    @Override
    public boolean remove(T value) {
        EntityManager em = null;
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(value));
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            JPAUtil.close(em);
        }
        return false;
    }

    @Override
    public boolean remove(Long id) {
        String q = "DELETE FROM " + this.clazz.getSimpleName() + " AS m WHERE m.id = :id";
        EntityManager em = null;
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.createQuery(q)
                    .setParameter("id", id)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            JPAUtil.close(em);
        }
        return remove(findById(id));
    }

}
