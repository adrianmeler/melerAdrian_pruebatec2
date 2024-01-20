/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebatecnica2.persistence;

import com.mycompany.pruebatecnica2.logica.Citizen;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.pruebatecnica2.logica.Turn;
import com.mycompany.pruebatecnica2.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Adrian
 */
public class CitizenJpaController implements Serializable {

    public CitizenJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public CitizenJpaController() {
        emf = Persistence.createEntityManagerFactory("turnsUnit");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Citizen citizen) {
        if (citizen.getTurns() == null) {
            citizen.setTurns(new ArrayList<Turn>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Turn> attachedTurns = new ArrayList<Turn>();
            for (Turn turnsTurnToAttach : citizen.getTurns()) {
                turnsTurnToAttach = em.getReference(turnsTurnToAttach.getClass(), turnsTurnToAttach.getIdTurn());
                attachedTurns.add(turnsTurnToAttach);
            }
            citizen.setTurns(attachedTurns);
            em.persist(citizen);
            for (Turn turnsTurn : citizen.getTurns()) {
                Citizen oldCitizenOfTurnsTurn = turnsTurn.getCitizen();
                turnsTurn.setCitizen(citizen);
                turnsTurn = em.merge(turnsTurn);
                if (oldCitizenOfTurnsTurn != null) {
                    oldCitizenOfTurnsTurn.getTurns().remove(turnsTurn);
                    oldCitizenOfTurnsTurn = em.merge(oldCitizenOfTurnsTurn);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Citizen citizen) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Citizen persistentCitizen = em.find(Citizen.class, citizen.getIdCitizen());
            ArrayList<Turn> turnsOld = persistentCitizen.getTurns();
            ArrayList<Turn> turnsNew = citizen.getTurns();
            ArrayList<Turn> attachedTurnsNew = new ArrayList<Turn>();
            for (Turn turnsNewTurnToAttach : turnsNew) {
                turnsNewTurnToAttach = em.getReference(turnsNewTurnToAttach.getClass(), turnsNewTurnToAttach.getIdTurn());
                attachedTurnsNew.add(turnsNewTurnToAttach);
            }
            turnsNew = attachedTurnsNew;
            citizen.setTurns(turnsNew);
            citizen = em.merge(citizen);
            for (Turn turnsOldTurn : turnsOld) {
                if (!turnsNew.contains(turnsOldTurn)) {
                    turnsOldTurn.setCitizen(null);
                    turnsOldTurn = em.merge(turnsOldTurn);
                }
            }
            for (Turn turnsNewTurn : turnsNew) {
                if (!turnsOld.contains(turnsNewTurn)) {
                    Citizen oldCitizenOfTurnsNewTurn = turnsNewTurn.getCitizen();
                    turnsNewTurn.setCitizen(citizen);
                    turnsNewTurn = em.merge(turnsNewTurn);
                    if (oldCitizenOfTurnsNewTurn != null && !oldCitizenOfTurnsNewTurn.equals(citizen)) {
                        oldCitizenOfTurnsNewTurn.getTurns().remove(turnsNewTurn);
                        oldCitizenOfTurnsNewTurn = em.merge(oldCitizenOfTurnsNewTurn);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = citizen.getIdCitizen();
                if (findCitizen(id) == null) {
                    throw new NonexistentEntityException("The citizen with id " + id + " no longer exists.");
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
            Citizen citizen;
            try {
                citizen = em.getReference(Citizen.class, id);
                citizen.getIdCitizen();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The citizen with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Turn> turns = citizen.getTurns();
            for (Turn turnsTurn : turns) {
                turnsTurn.setCitizen(null);
                turnsTurn = em.merge(turnsTurn);
            }
            em.remove(citizen);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Citizen> findCitizenEntities() {
        return findCitizenEntities(true, -1, -1);
    }

    public List<Citizen> findCitizenEntities(int maxResults, int firstResult) {
        return findCitizenEntities(false, maxResults, firstResult);
    }

    private List<Citizen> findCitizenEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Citizen.class));
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

    public Citizen findCitizen(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Citizen.class, id);
        } finally {
            em.close();
        }
    }

    public int getCitizenCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Citizen> rt = cq.from(Citizen.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
