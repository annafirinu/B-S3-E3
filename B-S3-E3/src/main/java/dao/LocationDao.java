package dao;

import entities.Evento;
import entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDao {

    private EntityManager em;

    public LocationDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void save(Location location){
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }

    public Location getById(int id){
        return em.find(Location.class, id);
    }

    public void remove(int id){
        Location location = getById(id);

        if(location!=null){
            em.getTransaction().begin();
            em.remove(location);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Location con id " + id + " non trovato");
        }
    }

    public void close(){
        em.close();

    }
}
