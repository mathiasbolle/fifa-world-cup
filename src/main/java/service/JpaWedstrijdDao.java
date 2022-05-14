package service;

import domain.Wedstrijd;
import org.springframework.stereotype.Repository;

@Repository("wedstrijdDao")
public class JpaWedstrijdDao extends GenericDaoJpa implements GenericDao{

    public JpaWedstrijdDao() {
        super(Wedstrijd.class);
    }
}
