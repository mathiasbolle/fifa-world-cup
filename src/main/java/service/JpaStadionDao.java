package service;

import domain.Stadion;
import org.springframework.stereotype.Repository;

@Repository
public class JpaStadionDao extends GenericDaoJpa implements GenericDao{
    public JpaStadionDao() {
        super(Stadion.class);

    }
}
