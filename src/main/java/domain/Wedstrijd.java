package domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "wedstrijden")
public class Wedstrijd {
    @Id
    @Column(name = "wedstrijd_id")
    private String id; //unieke sleutel


    //@OneToMany(mappedBy = "wedstrijd")
    //private List<WedstrijdTicket> w;

    private String land1;
    private String land2;

    private Date datum;

    private int uur; //uur van de wedstrijd

    @Transient
    private Calendar cal;

    public Wedstrijd() {
    }

    public Wedstrijd(String id, String[] landen, int dag, int maand, int uur) {
        this.id = id;
        land1 = landen[0];
        land2 = landen[1];
        this.datum = new GregorianCalendar(2022, maand, dag).getTime();
        this.uur = uur;
        cal = Calendar.getInstance();
        cal.setTime(datum);
    }

    public String getId() {
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
