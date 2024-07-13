/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprogjpapractica.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.finalprogjpapractica.logica.Doctor;
import com.mycompany.finalprogjpapractica.logica.Hospital;
import java.util.ArrayList;
import com.mycompany.finalprogjpapractica.logica.Paciente;
import com.mycompany.finalprogjpapractica.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brizu
 */
public class HospitalJpaController implements Serializable {

    public HospitalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     public HospitalJpaController() {
        emf = Persistence.createEntityManagerFactory("UPfinalPractica");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Hospital hospital) {
        if (hospital.getListaDoctores() == null) {
            hospital.setListaDoctores(new ArrayList<Doctor>());
        }
        if (hospital.getListaPacientes() == null) {
            hospital.setListaPacientes(new ArrayList<Paciente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Doctor> attachedListaDoctores = new ArrayList<Doctor>();
            for (Doctor listaDoctoresDoctorToAttach : hospital.getListaDoctores()) {
                listaDoctoresDoctorToAttach = em.getReference(listaDoctoresDoctorToAttach.getClass(), listaDoctoresDoctorToAttach.getId());
                attachedListaDoctores.add(listaDoctoresDoctorToAttach);
            }
            hospital.setListaDoctores(attachedListaDoctores);
            ArrayList<Paciente> attachedListaPacientes = new ArrayList<Paciente>();
            for (Paciente listaPacientesPacienteToAttach : hospital.getListaPacientes()) {
                listaPacientesPacienteToAttach = em.getReference(listaPacientesPacienteToAttach.getClass(), listaPacientesPacienteToAttach.getId());
                attachedListaPacientes.add(listaPacientesPacienteToAttach);
            }
            hospital.setListaPacientes(attachedListaPacientes);
            em.persist(hospital);
            for (Doctor listaDoctoresDoctor : hospital.getListaDoctores()) {
                Hospital oldHospitalOfListaDoctoresDoctor = listaDoctoresDoctor.getHospital();
                listaDoctoresDoctor.setHospital(hospital);
                listaDoctoresDoctor = em.merge(listaDoctoresDoctor);
                if (oldHospitalOfListaDoctoresDoctor != null) {
                    oldHospitalOfListaDoctoresDoctor.getListaDoctores().remove(listaDoctoresDoctor);
                    oldHospitalOfListaDoctoresDoctor = em.merge(oldHospitalOfListaDoctoresDoctor);
                }
            }
            for (Paciente listaPacientesPaciente : hospital.getListaPacientes()) {
                Hospital oldHospitalOfListaPacientesPaciente = listaPacientesPaciente.getHospital();
                listaPacientesPaciente.setHospital(hospital);
                listaPacientesPaciente = em.merge(listaPacientesPaciente);
                if (oldHospitalOfListaPacientesPaciente != null) {
                    oldHospitalOfListaPacientesPaciente.getListaPacientes().remove(listaPacientesPaciente);
                    oldHospitalOfListaPacientesPaciente = em.merge(oldHospitalOfListaPacientesPaciente);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Hospital hospital) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Hospital persistentHospital = em.find(Hospital.class, hospital.getId());
            ArrayList<Doctor> listaDoctoresOld = persistentHospital.getListaDoctores();
            ArrayList<Doctor> listaDoctoresNew = hospital.getListaDoctores();
            ArrayList<Paciente> listaPacientesOld = persistentHospital.getListaPacientes();
            ArrayList<Paciente> listaPacientesNew = hospital.getListaPacientes();
            ArrayList<Doctor> attachedListaDoctoresNew = new ArrayList<Doctor>();
            for (Doctor listaDoctoresNewDoctorToAttach : listaDoctoresNew) {
                listaDoctoresNewDoctorToAttach = em.getReference(listaDoctoresNewDoctorToAttach.getClass(), listaDoctoresNewDoctorToAttach.getId());
                attachedListaDoctoresNew.add(listaDoctoresNewDoctorToAttach);
            }
            listaDoctoresNew = attachedListaDoctoresNew;
            hospital.setListaDoctores(listaDoctoresNew);
            ArrayList<Paciente> attachedListaPacientesNew = new ArrayList<Paciente>();
            for (Paciente listaPacientesNewPacienteToAttach : listaPacientesNew) {
                listaPacientesNewPacienteToAttach = em.getReference(listaPacientesNewPacienteToAttach.getClass(), listaPacientesNewPacienteToAttach.getId());
                attachedListaPacientesNew.add(listaPacientesNewPacienteToAttach);
            }
            listaPacientesNew = attachedListaPacientesNew;
            hospital.setListaPacientes(listaPacientesNew);
            hospital = em.merge(hospital);
            for (Doctor listaDoctoresOldDoctor : listaDoctoresOld) {
                if (!listaDoctoresNew.contains(listaDoctoresOldDoctor)) {
                    listaDoctoresOldDoctor.setHospital(null);
                    listaDoctoresOldDoctor = em.merge(listaDoctoresOldDoctor);
                }
            }
            for (Doctor listaDoctoresNewDoctor : listaDoctoresNew) {
                if (!listaDoctoresOld.contains(listaDoctoresNewDoctor)) {
                    Hospital oldHospitalOfListaDoctoresNewDoctor = listaDoctoresNewDoctor.getHospital();
                    listaDoctoresNewDoctor.setHospital(hospital);
                    listaDoctoresNewDoctor = em.merge(listaDoctoresNewDoctor);
                    if (oldHospitalOfListaDoctoresNewDoctor != null && !oldHospitalOfListaDoctoresNewDoctor.equals(hospital)) {
                        oldHospitalOfListaDoctoresNewDoctor.getListaDoctores().remove(listaDoctoresNewDoctor);
                        oldHospitalOfListaDoctoresNewDoctor = em.merge(oldHospitalOfListaDoctoresNewDoctor);
                    }
                }
            }
            for (Paciente listaPacientesOldPaciente : listaPacientesOld) {
                if (!listaPacientesNew.contains(listaPacientesOldPaciente)) {
                    listaPacientesOldPaciente.setHospital(null);
                    listaPacientesOldPaciente = em.merge(listaPacientesOldPaciente);
                }
            }
            for (Paciente listaPacientesNewPaciente : listaPacientesNew) {
                if (!listaPacientesOld.contains(listaPacientesNewPaciente)) {
                    Hospital oldHospitalOfListaPacientesNewPaciente = listaPacientesNewPaciente.getHospital();
                    listaPacientesNewPaciente.setHospital(hospital);
                    listaPacientesNewPaciente = em.merge(listaPacientesNewPaciente);
                    if (oldHospitalOfListaPacientesNewPaciente != null && !oldHospitalOfListaPacientesNewPaciente.equals(hospital)) {
                        oldHospitalOfListaPacientesNewPaciente.getListaPacientes().remove(listaPacientesNewPaciente);
                        oldHospitalOfListaPacientesNewPaciente = em.merge(oldHospitalOfListaPacientesNewPaciente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = hospital.getId();
                if (findHospital(id) == null) {
                    throw new NonexistentEntityException("The hospital with id " + id + " no longer exists.");
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
            Hospital hospital;
            try {
                hospital = em.getReference(Hospital.class, id);
                hospital.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The hospital with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Doctor> listaDoctores = hospital.getListaDoctores();
            for (Doctor listaDoctoresDoctor : listaDoctores) {
                listaDoctoresDoctor.setHospital(null);
                listaDoctoresDoctor = em.merge(listaDoctoresDoctor);
            }
            ArrayList<Paciente> listaPacientes = hospital.getListaPacientes();
            for (Paciente listaPacientesPaciente : listaPacientes) {
                listaPacientesPaciente.setHospital(null);
                listaPacientesPaciente = em.merge(listaPacientesPaciente);
            }
            em.remove(hospital);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Hospital> findHospitalEntities() {
        return findHospitalEntities(true, -1, -1);
    }

    public List<Hospital> findHospitalEntities(int maxResults, int firstResult) {
        return findHospitalEntities(false, maxResults, firstResult);
    }

    private List<Hospital> findHospitalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Hospital.class));
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

    public Hospital findHospital(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Hospital.class, id);
        } finally {
            em.close();
        }
    }

    public int getHospitalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Hospital> rt = cq.from(Hospital.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
