package dao;

import entities.Evento;
import entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PartecipazioneDao {

    private EntityManager em;

    public PartecipazioneDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void save(Partecipazione partecipazione){
        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
    }

    public Partecipazione getById(int id){
        return em.find(Partecipazione.class, id);
    }

    public void remove(int id){
        Partecipazione partecipazione = getById(id);

        if(partecipazione!=null){
            em.getTransaction().begin();
            em.remove(partecipazione);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Partecipazione con id " + id + " non trovato");
        }
    }

    public void close(){
        em.close();

    }
}
