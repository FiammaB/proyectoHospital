
package com.mycompany.finalprogjpapractica.persistencia;

import com.mycompany.finalprogjpapractica.logica.RevicionMedica;
import com.mycompany.finalprogjpapractica.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class RevicionMedicaJpaController implements Serializable {

    public RevicionMedicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
        public RevicionMedicaJpaController() {
        emf = Persistence.createEntityManagerFactory("UPfinalPractica");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RevicionMedica revicionMedica) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(revicionMedica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RevicionMedica revicionMedica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            revicionMedica = em.merge(revicionMedica);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = revicionMedica.getId();
                if (findRevicionMedica(id) == null) {
                    throw new NonexistentEntityException("The revicionMedica with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RevicionMedica revicionMedica;
            try {
                revicionMedica = em.getReference(RevicionMedica.class, id);
                revicionMedica.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The revicionMedica with id " + id + " no longer exists.", enfe);
            }
            em.remove(revicionMedica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RevicionMedica> findRevicionMedicaEntities() {
        return findRevicionMedicaEntities(true, -1, -1);
    }

    public List<RevicionMedica> findRevicionMedicaEntities(int maxResults, int firstResult) {
        return findRevicionMedicaEntities(false, maxResults, firstResult);
    }

    private List<RevicionMedica> findRevicionMedicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RevicionMedica.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public RevicionMedica findRevicionMedica(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RevicionMedica.class, id);
        } finally {
            em.close();
        }
    }

    public int getRevicionMedicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RevicionMedica> rt = cq.from(RevicionMedica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
