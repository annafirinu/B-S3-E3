package dao;
import entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDao {
    private EntityManager em;

    //Costruttore
    public EventoDao(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("postgres");
        em=emf.createEntityManager();
    }

    //Metodo per inserire un metodo in tabella
    public void save (Evento evento){
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    //Metodo per estrarre un evento tramite l'Id
    public Evento getById(int id){
        return em.find(Evento.class,id);
    }

    //Metodo per rimuovere un evento
    public void delete (int id){
        Evento e = getById(id);
        if(e!=null){
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        } else{
            System.out.println("Nessun evento con id "+id);
        }
    }
}

