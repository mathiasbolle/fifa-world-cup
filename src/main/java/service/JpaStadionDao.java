package service;

import domain.Stadion;
import domain.WedstrijdTicket;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class JpaStadionDao extends GenericDaoJpa<Stadion> implements StadionDao{
    public JpaStadionDao() {
        super(Stadion.class);

    }

    @Override
    public String stadionNameByMatchId(int id) {
        TypedQuery<Stadion> queryWedstrijdTicket =
                em.createNamedQuery("Stadion.stadionNameByMatchId", Stadion.class);
        queryWedstrijdTicket.setParameter("id", id);
        return queryWedstrijdTicket.getSingleResult().getName();
    }
}
