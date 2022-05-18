package domain;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

@Entity
@Table(name = "wedstrijden")
public class Wedstrijd {
    @Id
    @Column(name = "wedstrijd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //unieke sleutel

    @OneToOne(mappedBy = "wed")
    private WedstrijdTicket wedstrijdTicket;

    @ManyToOne
    @JoinColumn(name = "stadion_id")
    private Stadion s;


    private String land1;
    private String land2;

    private Date datum;

    private int uur; //uur van de wedstrijd

    @Transient
    private Calendar cal;

    @OneToOne(orphanRemoval = true)
    @JoinTable(name = "wedstrijden_wedstrijd",
            joinColumns = @JoinColumn(name = "wedstrijd_1_wedstrijd_id"),
            inverseJoinColumns = @JoinColumn(name = "wedstrijd_2_wedstrijd_id"))
    private Wedstrijd wedstrijd;

    public Wedstrijd getWedstrijd() {
        return wedstrijd;
    }

    public void setWedstrijd(Wedstrijd wedstrijd) {
        this.wedstrijd = wedstrijd;
    }


    public Stadion getStadion() {
        return s;
    }

    public void setStadion(Stadion s) {
        this.s = s;
    }


    public Wedstrijd() {
    }

    public Wedstrijd(String[] landen, int dag, int maand, int uur, Stadion stadion ) {
        land1 = landen[0];
        land2 = landen[1];
        this.datum = new GregorianCalendar(2022, maand, dag).getTime();
        this.uur = uur;
        cal = Calendar.getInstance();
        cal.setTime(datum);
        this.s = stadion;
    }

    public int getId() {
        return id;
    }

    public String[] getLanden() {
        return new String[] {land1, land2};
    }

    public Date getDatum() {
        return datum;
    }

    public int getUur() {
        return this.uur;
    }

    @Override
    public String toString()
    {
        return String.format("%s vs %s op %d-%d", land1, land2, cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH));
    }
}
