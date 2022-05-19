package service;

import domain.WedstrijdTicket;

import java.util.List;

public interface WedstrijdTicketDao extends GenericDao<WedstrijdTicket> {

    List<WedstrijdTicket> getWedstrijdenByStadion(String name);

    WedstrijdTicket getTicketsOfWedstrijdById(Integer id);


}
