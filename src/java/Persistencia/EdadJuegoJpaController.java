package Persistencia;

import Logica.EdadJuego;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Valu
 */
public class EdadJuegoJpaController implements Serializable {

    public EdadJuegoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EdadJuegoJpaController() {
        emf = Persistence.createEntityManagerFactory("tpFinalCom2_PU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EdadJuego edadJuego) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(edadJuego);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EdadJuego edadJuego) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            edadJuego = em.merge(edadJuego);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = edadJuego.getIdCategoria();
                if (findEdadJuego(id) == null) {
                    throw new NonexistentEntityException("The edadJuego with id " + id + " no longer exists.");
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
            EdadJuego edadJuego;
            try {
                edadJuego = em.getReference(EdadJuego.class, id);
                edadJuego.getIdCategoria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The edadJuego with id " + id + " no longer exists.", enfe);
            }
            em.remove(edadJuego);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EdadJuego> findEdadJuegoEntities() {
        return findEdadJuegoEntities(true, -1, -1);
    }

    public List<EdadJuego> findEdadJuegoEntities(int maxResults, int firstResult) {
        return findEdadJuegoEntities(false, maxResults, firstResult);
    }

    private List<EdadJuego> findEdadJuegoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EdadJuego.class));
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

    public EdadJuego findEdadJuego(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EdadJuego.class, id);
        } finally {
            em.close();
        }
    }

    public int getEdadJuegoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EdadJuego> rt = cq.from(EdadJuego.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
