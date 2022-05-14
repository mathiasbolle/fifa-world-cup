package service;

import domain.Stadion;
import org.springframework.stereotype.Repository;

@Repository("stadionDao")
public class JpaStadionDao extends GenericDaoJpa implements GenericDao{
    public JpaStadionDao() {
        super(Stadion.class);
    }
}
