package service;

import domain.WedstrijdTicket;

import java.util.List;

public interface WedstrijdTicketDao extends GenericDao<WedstrijdTicket> {

    public List<WedstrijdTicket> getWedstrijdenByStadion(String name);
}
