package domain;

import javax.persistence.*;

@Entity
@Table(name = "wedstrijd_tickets")
//original query: SELECT t FROM WedstrijdTicket t JOIN t.wedstrijd w JOIN w.stadion s WHERE :name = s.name
@NamedQueries({
        @NamedQuery(name="WedstrijdTicket.getWedstrijdenByStadions",
                query="SELECT t FROM WedstrijdTicket t JOIN t.wed w JOIN w.s sta WHERE :name = sta.name"),
})
public class WedstrijdTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wedstrijd_ticket_id;

    @OneToOne
    @JoinColumn(name = "wedstrijd_id")
    private Wedstrijd wed;

    private int tickets; //aantal tickets beschikbaar

    public WedstrijdTicket() {
    }

    public void setWedstrijd(Wedstrijd wedstrijd) {
        //this.wedstrijd = wedstrijd;
    }

    public WedstrijdTicket(Wedstrijd wedstrijd, int tickets) {
        this.wed = wedstrijd;
        this.tickets = tickets;
    }

    public int getTickets() {
        return tickets;
    }

    public Wedstrijd getWedstrijd() {
        return wed;
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
