package domain;

import javax.persistence.*;

@Entity
@Table(name = "wedstrijd_tickets")
public class WedstrijdTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wedstrijd_ticket_id;

    @ManyToOne
    private Wedstrijd wedstrijd;

    private int tickets; //aantal tickets beschikbaar

    public WedstrijdTicket() {
    }

    public void setWedstrijd(Wedstrijd wedstrijd) {
        //this.wedstrijd = wedstrijd;
    }

    public WedstrijdTicket(Wedstrijd wedstrijd, int tickets) {
        this.wedstrijd = wedstrijd;
        this.tickets = tickets;
    }

    public int getTickets() {
        return tickets;
    }

    public Wedstrijd getWedstrijd() {
        return wedstrijd;
    }

    //We willen 'aantal' tickets kopen
    public int ticketsKopen(int aantal) {
        if (aantal <= 0) {
            return -1;
        }

        //Nog voldoende tickets
        if (tickets >= aantal) {
            tickets -= aantal;
            return aantal;
        }

        //Niet meer voldoende tickets
        int gekocht = tickets;
        tickets = 0;
        return gekocht;
    }

    public boolean uitverkocht() {
        return tickets == 0;
    }
}
