/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciointegrador2.persistence;

import com.mycompany.ejerciciointegrador2.logica.Equipo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.ejerciciointegrador2.logica.Partido;
import com.mycompany.ejerciciointegrador2.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Adrian
 */
public class EquipoJpaController implements Serializable {

    public EquipoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EquipoJpaController() {
         emf = Persistence.createEntityManagerFactory("UnidadEquipos");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Equipo equipo) {
        if (equipo.getPartidos() == null) {
            equipo.setPartidos(new ArrayList<Partido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Partido> attachedPartidos = new ArrayList<Partido>();
            for (Partido partidosPartidoToAttach : equipo.getPartidos()) {
                partidosPartidoToAttach = em.getReference(partidosPartidoToAttach.getClass(), partidosPartidoToAttach.getId());
                attachedPartidos.add(partidosPartidoToAttach);
            }
            equipo.setPartidos(attachedPartidos);
            em.persist(equipo);
            for (Partido partidosPartido : equipo.getPartidos()) {
                Equipo oldEquipoOfPartidosPartido = partidosPartido.getEquipo();
                partidosPartido.setEquipo(equipo);
                partidosPartido = em.merge(partidosPartido);
                if (oldEquipoOfPartidosPartido != null) {
                    oldEquipoOfPartidosPartido.getPartidos().remove(partidosPartido);
                    oldEquipoOfPartidosPartido = em.merge(oldEquipoOfPartidosPartido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Equipo equipo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Equipo persistentEquipo = em.find(Equipo.class, equipo.getIdEquipo());
            ArrayList<Partido> partidosOld = persistentEquipo.getPartidos();
            ArrayList<Partido> partidosNew = equipo.getPartidos();
            ArrayList<Partido> attachedPartidosNew = new ArrayList<Partido>();
            for (Partido partidosNewPartidoToAttach : partidosNew) {
                partidosNewPartidoToAttach = em.getReference(partidosNewPartidoToAttach.getClass(), partidosNewPartidoToAttach.getId());
                attachedPartidosNew.add(partidosNewPartidoToAttach);
            }
            partidosNew = attachedPartidosNew;
            equipo.setPartidos(partidosNew);
            equipo = em.merge(equipo);
            for (Partido partidosOldPartido : partidosOld) {
                if (!partidosNew.contains(partidosOldPartido)) {
                    partidosOldPartido.setEquipo(null);
                    partidosOldPartido = em.merge(partidosOldPartido);
                }
            }
            for (Partido partidosNewPartido : partidosNew) {
                if (!partidosOld.contains(partidosNewPartido)) {
                    Equipo oldEquipoOfPartidosNewPartido = partidosNewPartido.getEquipo();
                    partidosNewPartido.setEquipo(equipo);
                    partidosNewPartido = em.merge(partidosNewPartido);
                    if (oldEquipoOfPartidosNewPartido != null && !oldEquipoOfPartidosNewPartido.equals(equipo)) {
                        oldEquipoOfPartidosNewPartido.getPartidos().remove(partidosNewPartido);
                        oldEquipoOfPartidosNewPartido = em.merge(oldEquipoOfPartidosNewPartido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = equipo.getIdEquipo();
                if (findEquipo(id) == null) {
                    throw new NonexistentEntityException("The equipo with id " + id + " no longer exists.");
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
            Equipo equipo;
            try {
                equipo = em.getReference(Equipo.class, id);
                equipo.getIdEquipo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipo with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Partido> partidos = equipo.getPartidos();
            for (Partido partidosPartido : partidos) {
                partidosPartido.setEquipo(null);
                partidosPartido = em.merge(partidosPartido);
            }
            em.remove(equipo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Equipo> findEquipoEntities() {
        return findEquipoEntities(true, -1, -1);
    }

    public List<Equipo> findEquipoEntities(int maxResults, int firstResult) {
        return findEquipoEntities(false, maxResults, firstResult);
    }

    private List<Equipo> findEquipoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Equipo.class));
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

    public Equipo findEquipo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Equipo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquipoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Equipo> rt = cq.from(Equipo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
