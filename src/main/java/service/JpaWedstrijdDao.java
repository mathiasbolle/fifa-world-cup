package service;

import domain.Wedstrijd;
import domain.WedstrijdTicket;
import org.springframework.stereotype.Repository;

@Repository("wedstrijdDao")
public class JpaWedstrijdDao extends GenericDaoJpa<Wedstrijd> implements GenericDao<Wedstrijd>{

    public JpaWedstrijdDao() {
        super(Wedstrijd.class);
    }
}
