/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.persistencia;

import com.mycompany.finalprogjpapractica.logica.Doctor;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.finalprogjpapractica.logica.Hospital;
import com.mycompany.finalprogjpapractica.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brizu
 */
public class DoctorJpaController implements Serializable {

    public DoctorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
        public DoctorJpaController() {
        emf = Persistence.createEntityManagerFactory("proyectoFinalPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Doctor doctor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Hospital hospital = doctor.getHospital();
            if (hospital != null) {
                hospital = em.getReference(hospital.getClass(), hospital.getId());
                doctor.setHospital(hospital);
            }
            em.persist(doctor);
            if (hospital != null) {
                hospital.getListaDoctores().add(doctor);
                hospital = em.merge(hospital);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Doctor doctor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Doctor persistentDoctor = em.find(Doctor.class, doctor.getId());
            Hospital hospitalOld = persistentDoctor.getHospital();
            Hospital hospitalNew = doctor.getHospital();
            if (hospitalNew != null) {
                hospitalNew = em.getReference(hospitalNew.getClass(), hospitalNew.getId());
                doctor.setHospital(hospitalNew);
            }
            doctor = em.merge(doctor);
            if (hospitalOld != null && !hospitalOld.equals(hospitalNew)) {
                hospitalOld.getListaDoctores().remove(doctor);
                hospitalOld = em.merge(hospitalOld);
            }
            if (hospitalNew != null && !hospitalNew.equals(hospitalOld)) {
                hospitalNew.getListaDoctores().add(doctor);
                hospitalNew = em.merge(hospitalNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = doctor.getId();
                if (findDoctor(id) == null) {
                    throw new NonexistentEntityException("The doctor with id " + id + " no longer exists.");
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
            Doctor doctor;
            try {
                doctor = em.getReference(Doctor.class, id);
                doctor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The doctor with id " + id + " no longer exists.", enfe);
            }
            Hospital hospital = doctor.getHospital();
            if (hospital != null) {
                hospital.getListaDoctores().remove(doctor);
                hospital = em.merge(hospital);
            }
            em.remove(doctor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Doctor> findDoctorEntities() {
        return findDoctorEntities(true, -1, -1);
    }

    public List<Doctor> findDoctorEntities(int maxResults, int firstResult) {
        return findDoctorEntities(false, maxResults, firstResult);
    }

    private List<Doctor> findDoctorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Doctor.class));
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

    public Doctor findDoctor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Doctor.class, id);
        } finally {
            em.close();
        }
    }

    public int getDoctorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Doctor> rt = cq.from(Doctor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
