package service;

import domain.Stadion;

public interface StadionDao extends GenericDao<Stadion> {
    String stadionNameByMatchId(int id);
}
