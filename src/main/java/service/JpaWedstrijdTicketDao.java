package service;

import domain.WedstrijdTicket;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository("wedstrijdTicketDao")
public class JpaWedstrijdTicketDao extends GenericDaoJpa<WedstrijdTicket> implements WedstrijdTicketDao{

    public JpaWedstrijdTicketDao() {
        super(WedstrijdTicket.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WedstrijdTicket> getWedstrijdenByStadion(String name) {
        TypedQuery<WedstrijdTicket> queryWedstrijdTicket =
                em.createNamedQuery("WedstrijdTicket.getWedstrijdenByStadions", WedstrijdTicket.class);
        return queryWedstrijdTicket.getResultList();
    }
}
