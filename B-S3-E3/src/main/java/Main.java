import dao.EventoDao;
import dao.LocationDao;
import dao.PartecipazioneDao;
import dao.PersonaDao;
import entities.Evento;
import entities.Location;
import entities.Partecipazione;
import entities.Persona;
import enumeration.Sesso;
import enumeration.Stato;
import enumeration.TipoEvento;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EventoDao eventoDao = new EventoDao();
        PersonaDao personaDao = new PersonaDao();
        PartecipazioneDao partecipazioneDao= new PartecipazioneDao();
        LocationDao locationDao = new LocationDao();


        Evento e1 = new Evento("fiera", LocalDate.of(2025,10,10),
                "fiera del mobile", TipoEvento.PUBBLICO, 10000);

        Evento e2 = new Evento("concerto", LocalDate.of(2025,8,10),
                "concerto piazza del popolo", TipoEvento.PUBBLICO, 100000);

        eventoDao.save(e1);
        eventoDao.save(e2);

        Location l1 = new Location("Fiera Rho", "Milano");
        Location l2 = new Location("Piazza del Popolo", "Roma");

        locationDao.save(l1);
        locationDao.save(l2);

        e1.setLocation(l1);
        e2.setLocation(l2);


        eventoDao.save(e1);
        eventoDao.save(e2);

        Persona p1 = new Persona("Mario", "Rossi", "mrossi@gmail.com",
                LocalDate.of(2000,5,5), Sesso.M);

        Persona p2 = new Persona("Francesca", "Bianchi", "fbianchi@gmail.com",
                LocalDate.of(2002,6,5), Sesso.F);

        personaDao.save(p1);
        personaDao.save(p2);

        Partecipazione part1 = new Partecipazione(Stato.CONFERMATA);
        Partecipazione part2 = new Partecipazione(Stato.CONFERMATA);

        partecipazioneDao.save(part1);
        partecipazioneDao.save(part2);

        part1.setEvento(e1);
        part2.setEvento(e2);
        part1.setPersona(p1);
        part2.setPersona(p2);

        partecipazioneDao.save(part1);
        partecipazioneDao.save(part2);
    }
}